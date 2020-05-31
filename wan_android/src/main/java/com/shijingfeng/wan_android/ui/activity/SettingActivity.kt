package com.shijingfeng.wan_android.ui.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.SparseArray
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SETTING
import com.shijingfeng.base.common.constant.SELECTED
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.ThemeColorAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.common.global.themeColorNameList
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSettingBinding
import com.shijingfeng.wan_android.entity.adapter.ThemeColorItem
import com.shijingfeng.wan_android.utils.ThemeUtil
import com.shijingfeng.wan_android.view_model.SettingViewModel
import skin.support.SkinCompatManager

/**
 * Function: 系统设置 Activity
 * Date: 2020/5/30 23:01
 * Description:
 * @author ShiJingFeng
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
            color = Color.parseColor(ThemeUtil.curThemeColor)
        })
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mDataBinding.llThemeColor.setOnClickListener {
            showChooseThemeColorDialog()
        }
    }

    @SuppressLint("InflateParams")
    private fun showChooseThemeColorDialog() {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_wan_android_choose_theme_color, null)
        val rvThemeColor = view.findViewById<RecyclerView>(R.id.rv_theme_color)
        val tvCancel = view.findViewById<TextView>(R.id.tv_cancel)
        val tvEnsure = view.findViewById<TextView>(R.id.tv_ensure)

        val themeColorAdapter = ThemeColorAdapter(this)

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

        themeColorAdapter.setOnItemEventListener { _, data, position, flag ->
            when (flag) {
                // 单选选择
                SELECTED -> {
                    val themeColorItem = data as ThemeColorItem

                    mViewModel?.mCurThemeRGBColorStr = themeColorItem.rgbColor
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
            ThemeUtil.curThemeColor = mViewModel!!.mCurThemeRGBColorStr
            mDataBinding.civThemeColor.setImageDrawable(ColorDrawable().apply {
                color = Color.parseColor(ThemeUtil.curThemeColor)
            })
            // 取消换肤, 目前已知: TabLayout shape标签 无法换肤
            // 后缀加载皮肤
//            SkinCompatManager.getInstance().loadSkin(themeColorNameList[mViewModel!!.mCurThemeColorNamePosition], SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN)
        }
    }
}