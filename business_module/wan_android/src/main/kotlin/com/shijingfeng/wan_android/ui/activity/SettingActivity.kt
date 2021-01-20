package com.shijingfeng.wan_android.ui.activity

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.util.SparseArray
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SETTING
import com.shijingfeng.base.common.constant.SELECTED
import com.shijingfeng.base.util.LOG_WAN_ANDROID_SKIN
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.skin_changer.listener.SkinChangingListener
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.ThemeColorAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.common.constant.WAN_ANDROID_SKIN_FILE
import com.shijingfeng.wan_android.common.constant.WAN_ANDROID_SKIN_PACKAGE
import com.shijingfeng.wan_android.common.global.skinChangerManager
import com.shijingfeng.wan_android.common.global.themeColorList
import com.shijingfeng.wan_android.common.global.themeColorNameList
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSettingBinding
import com.shijingfeng.wan_android.entity.adapter.ThemeColorItem
import com.shijingfeng.wan_android.entity.event.ThemeEvent
import com.shijingfeng.wan_android.utils.ThemeUtil
import com.shijingfeng.wan_android.view_model.SettingViewModel
import org.greenrobot.eventbus.EventBus

/**
 * Function: 系统设置 Activity
 * Date: 2020/5/30 23:01
 * Description:
 * Author: ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_SETTING)
internal class SettingActivity : WanAndroidBaseActivity<ActivityWanAndroidSettingBinding, SettingViewModel>() {

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(SettingViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.settingViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_setting

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.系统设置)
        mDataBinding.civThemeColor.setImageDrawable(ColorDrawable().apply {
            color = ThemeUtil.curThemeColor
        })
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mDataBinding.llThemeColor.setOnClickListener {
            if (themeColorNameList.isNotEmpty()) {
                showChooseThemeColorDialog()
            } else {
                ToastUtils.showShort(getStringById(R.string.暂无主题可供选择))
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun showChooseThemeColorDialog() {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_wan_android_choose_theme_color, null)
        val rvThemeColor = view.findViewById<RecyclerView>(R.id.rv_theme_color)
        val tvCancel = view.findViewById<TextView>(R.id.tv_cancel)
        val tvEnsure = view.findViewById<TextView>(R.id.tv_ensure)
        var preChoosePosition = -1
        val dataList = themeColorList.mapIndexed { index, color ->
            var isSelected = false

            if (!isSelected) {
                if (ThemeUtil.curThemeColor == color) {
                    isSelected = true
                    preChoosePosition = index
                }
            }
            ThemeColorItem(
                color = color,
                isSelected = isSelected
            )
        }
        val themeColorAdapter = ThemeColorAdapter(
            context = this,
            dataList = dataList,
            preChoosePosition = preChoosePosition
        )

        rvThemeColor.adapter = themeColorAdapter
        rvThemeColor.layoutManager = GridLayoutManager(this, 4)

        val chooseThemeColorDialog = CommonDialog.Builder(this)
            .setContentView(view)
            .setWindowWidth(WRAP_CONTENT)
            .setWindowHeight(WRAP_CONTENT)
            .setGravity(Gravity.CENTER, 0, 0)
            .setBackgroundDrawable(R.drawable.shape_website_edit_bg)
            .setWindowOutsideAlpha(0.7F)
            .setAnimStyle(R.style.center_dialog_anim)
            .setCancelable(true)
            .show()

        themeColorAdapter.onItemEvent = { _, data, position, flag ->
            when (flag) {
                // 单选选择
                SELECTED -> {
                    val themeColorItem = data as ThemeColorItem

                    mViewModel?.mCurThemeColor = themeColorItem.color
                    mViewModel?.mCurThemeColorNamePosition = position
                }
                else -> {}
            }
        }
        // 取消
        tvCancel.setOnClickListener {
            chooseThemeColorDialog?.hide()
        }
        // 确认
        tvEnsure.setOnClickListener {
            chooseThemeColorDialog?.hide()
            ThemeUtil.curThemeColor = mViewModel!!.mCurThemeColor
            ThemeUtil.curThemeName = themeColorNameList[mViewModel!!.mCurThemeColorNamePosition]
            mDataBinding.civThemeColor.setImageDrawable(ColorDrawable().apply {
                color = ThemeUtil.curThemeColor
            })
            skinChangerManager.changeSkinByPlugin(
                skinSuffix = ThemeUtil.curThemeName,
                skinPluginPath = WAN_ANDROID_SKIN_FILE,
                skinPluginPackageName = WAN_ANDROID_SKIN_PACKAGE,
                skinChangingCallback = object : SkinChangingListener {
                    override fun onStart() {
                        super.onStart()
                        d(LOG_WAN_ANDROID_SKIN, "插件式更换皮肤开始")
                    }

                    override fun onError(e: Throwable?) {
                        super.onError(e)
                        if (e != null) {
                            d(LOG_WAN_ANDROID_SKIN, "插件式更换皮肤失败:  msg: ${e.message}  cause: ${e.cause}")
                        } else {
                            d(LOG_WAN_ANDROID_SKIN, "插件式更换皮肤失败")
                        }
                    }

                    override fun onCompleted() {
                        super.onCompleted()
                        d(LOG_WAN_ANDROID_SKIN, "插件式更换皮肤成功")
                    }
                }
            )
            // AndroidChangeSkin切换主题有缺陷性: 只能切换静态的部分 和 不会延时加载的部分
            // 对于其他情况只能使用 EventBus 通知更新UI了
            EventBus.getDefault().post(ThemeEvent())
        }
    }

}