package com.shijingfeng.wan_android.ui.activity

import android.annotation.SuppressLint
import android.util.SparseArray
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.AppUtils
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_ABOUT_US
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.skin_changer.constant.SRC
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidAboutUsBinding
import com.shijingfeng.wan_android.view_model.AboutUsViewModel

/**
 * Function: 主页 -> 侧边栏 -> 关于我们 Activity
 * Date: 20-4-6 下午11:00
 * Description:
 * @author shijingfeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_ABOUT_US)
internal class AboutUsActivity : WanAndroidBaseActivity<ActivityWanAndroidAboutUsBinding, AboutUsViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_about_us

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(AboutUsViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.aboutUsViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    @SuppressLint("SetTextI18n")
    override fun initData() {
        super.initData()
        mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.关于我们)
        mDataBinding.tvVersionName.text = getStringById(R.string.wan_android_name) + " v" + AppUtils.getAppVersionName()
        mDataBinding.tvContent.run {
            richText = getStringById(R.string.about_us_content)
        }
    }

    /**
     * 获取资源 (用于切换主题的资源)
     */
    override fun getResource() = mutableMapOf<View, List<SkinAttribute>>().apply {
        this[mDataBinding.civLogo] = listOf(
            SkinAttribute(
                name = SRC,
                data = getStringById(R.string.drawable_id_ic_wan_android_launcher_round)
            )
        )
    }

}