package com.shijingfeng.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SPLASH
import com.shijingfeng.base.arouter.ARouterUtil.navigation
import kotlinx.android.synthetic.main.activity_app_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_main)
        btn_wan_android.setOnClickListener {
            navigation(this, ACTIVITY_WAN_ANDROID_SPLASH)
        }
    }
}
