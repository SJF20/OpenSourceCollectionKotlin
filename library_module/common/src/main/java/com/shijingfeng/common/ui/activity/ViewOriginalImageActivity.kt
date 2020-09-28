package com.shijingfeng.common.ui.activity

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.provider.Settings
import android.util.SparseArray
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.annotation.WorkerThread
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.reflect.TypeToken
import com.shijingfeng.common.adapter.ViewOriginalImageAdapter
import com.shijingfeng.base.annotation.NeedPermissions
import com.shijingfeng.base.arouter.ACTIVITY_COMMON_VIEW_ORIGINAL_IMAGE
import com.shijingfeng.base.mvvm.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.common.entity.ViewOriginalImageItem
import com.shijingfeng.common.source.network.getViewOriginalImageNetworkSourceInstance
import com.shijingfeng.common.source.repository.getViewOriginalImageRepositoryInstance
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.common.viewmodel.ViewOriginalImageViewModel
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.base.widget.dialog.LoadingDialog
import com.shijingfeng.common.BR
import com.shijingfeng.common.R
import com.shijingfeng.common.base.CommonBaseActivity
import com.shijingfeng.common.databinding.ActivityCommonViewOriginalImageBinding
import kotlinx.android.synthetic.main.activity_common_view_original_image.*
import kotlinx.android.synthetic.main.dialog_common_view_original_image_long_click.view.*
import java.io.IOException
import java.io.InputStream

/**
 * Function: 查看原图 Activity
 * Date: 2020/1/29 9:40
 * Description:
 * @author ShiJingFeng
 */
@NeedPermissions
@Route(path = ACTIVITY_COMMON_VIEW_ORIGINAL_IMAGE)
internal class ViewOriginalImageActivity : CommonBaseActivity<ActivityCommonViewOriginalImageBinding, ViewOriginalImageViewModel>() {

    /** ViewPager 适配器  */
    private lateinit var mViewOriginalImageAdapter: ViewOriginalImageAdapter
    /** 长按弹框  */
    private var mLongClickDialog: CommonDialog? = null

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_common_view_original_image

    /**
     * 获取ViewModel
     *
     * @return ViewModel
     */
    override fun getViewModel(): ViewOriginalImageViewModel? {
        val viewOriginalImageRepository = getViewOriginalImageRepositoryInstance(
            networkSource = getViewOriginalImageNetworkSourceInstance()
        )
        val viewOriginalViewModelFactory =
            createCommonViewModelFactory(
                repository = viewOriginalImageRepository
            )

        return createViewModel(ViewOriginalImageViewModel::class.java, viewOriginalViewModelFactory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     *
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.viewOriginalImageViewModel, mViewModel)
    }

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            mViewModel?.mFromName = getString(FROM_ACTIVITY_NAME, "")
            mViewModel?.mDataList = deserialize(
                getString(DATA, EMPTY_ARRAY),
                object : TypeToken<List<ViewOriginalImageItem>>() {}.type
            )
            mViewModel?.mCurrentPosition = getInt(CURRENT_POSITION, 0)
        }
    }

    /**
     * 初始化数据
     */
    @SuppressLint("SetTextI18n")
    override fun initData() {
        super.initData()
        mViewModel?.let { viewModel ->
            if (viewModel.mDataList.isEmpty()) {
                tv_count.visibility = View.GONE
            } else {
                tv_count.text = "${viewModel.mCurrentPosition + 1} / ${viewModel.mDataList.size}"
            }
            vp_image.adapter = ViewOriginalImageAdapter(
                this,
                viewModel.mDataList
            ).also { mViewOriginalImageAdapter = it }
            vp_image.setCurrentItem(viewModel.mCurrentPosition, false)
        }

        registerLoadingView(
            hintText = getStringById(R.string.保存中)
        )
    }

    /**
     * 初始化事件
     */
    @SuppressLint("DefaultLocale")
    override fun initAction() {
        super.initAction()
        mViewOriginalImageAdapter.setOnItemEventListener { _, data, _, flag ->
            when (flag) {
                // 点击查看大图
                CLICK -> finish(0, R.anim.anim_activity_close_exit_view_original_image)
                // 长按选择操作
                LONG_CLICK -> {
                    val imagePath = (data as ViewOriginalImageItem).imagePath
                    val protocol = if (imagePath.length > 8) imagePath.substring(0, 8).toLowerCase() else ""

                    if (protocol.startsWith(PROTOCOL_HTTP, true) || protocol.startsWith(PROTOCOL_HTTPS, true)) {
                        showLongClickDialog()
                    }
                }
                else -> {
                }
            }
        }
        vp_image.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mViewModel?.mCurrentPosition = position
                tv_count.text = "${position + 1} / ${mViewModel?.mDataList?.size}"
            }

        })
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        mViewModel?.mSaveImageLiveEvent?.observe(this, Observer { responseBody ->
            if (responseBody == null || !saveImage(responseBody.byteStream())) {
                runOnUiThread {
                    hideLoadingView()
                    ToastUtils.showShort(getStringById(R.string.保存失败))
                }
            } else {
                runOnUiThread {
                    hideLoadingView()
                    ToastUtils.showShort(getStringById(R.string.保存成功))
                }
            }
        })
    }

    /**
     * 显示长按 Dialog
     */
    @SuppressLint("InflateParams")
    private fun showLongClickDialog() {
        mLongClickDialog.let { longClickDialog ->
            if (longClickDialog != null) {
                if (!longClickDialog.isShowing) {
                    longClickDialog.show()
                }
                return
            }
        }

        val contentView = LayoutInflater.from(this).inflate(R.layout.dialog_common_view_original_image_long_click, null)

        mLongClickDialog = CommonDialog.Builder(this)
            .setContentView(contentView)
            .setWindowWidth(MATCH_PARENT)
            .setGravity(Gravity.BOTTOM, 0, 0)
            .setWindowOutsideAlpha(0.7F)
            .setAnimStyle(R.style.bottom_dialog_anim)
            .setCancelable(true)
            .show()

        //下载图片
        contentView.tv_download_img.setOnClickListener {
            val data = mViewModel?.mDataList?.get(mViewModel?.mCurrentPosition ?: 0)
            val imageUrl = data?.imagePath ?: ""

            mLongClickDialog?.hide()
            addDisposable(
                mRxPermissions!!
                    .requestEach(WRITE_EXTERNAL_STORAGE)
                    .subscribe { permission ->
                        when {
                            permission.granted -> {
                                //下载图片
                                mViewModel?.downloadImage(imageUrl)
                            }
                            permission.shouldShowRequestPermissionRationale -> {
                                ToastUtils.showShort(getStringById(R.string.外部存储权限授予失败))
                            }
                            else -> {
                                AlertDialog.Builder(this)
                                    .setMessage(getStringById(R.string.设置页面开启外部存储权限))
                                    .setPositiveButton(
                                        getStringById(R.string.去设置)
                                    ) { _: DialogInterface?, _: Int ->
                                        val settingIntent = Intent()
                                        settingIntent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                                        settingIntent.data = Uri.fromParts(
                                            "package",
                                            packageName,
                                            null
                                        )
                                        settingIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                        startActivity(settingIntent)
                                    }
                                    .setOnDismissListener(null)
                                    .setCancelable(false)
                                    .show()
                            }
                        }
                    }
            )
        }
        //取消
        contentView.tv_cancel.setOnClickListener {
            mLongClickDialog?.hide()
        }
    }

    /**
     * 保存图片 (API 29 以后保存文件需要 MediaStore 或 SAF)
     * @param inputStream InputStream 输入流
     * @return true 保存成功  false 保存失败
     */
    @WorkerThread
    private fun saveImage(inputStream: InputStream?): Boolean {
        val imageExternal = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val resolver: ContentResolver = contentResolver
        val values = ContentValues()

        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png")

        val insertUri = resolver.insert(imageExternal, values)

        if (insertUri != null) {
            try {
                inputStream?.use { input ->
                    resolver.openOutputStream(insertUri).use { outputStream ->
                        if (outputStream != null) {
                            val bytes = ByteArray(1024)
                            var length: Int

                            while (input.read(bytes).also { length = it } != -1) {
                                outputStream.write(bytes, 0, length)
                            }
                        } else {
                            return false
                        }
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
                return false
            }
        } else {
            return false
        }
        return true
    }

    /**
     * Activity 销毁回调
     */
    override fun onDestroy() {
        super.onDestroy()
        mLongClickDialog?.hide()
        mLongClickDialog = null
    }
}