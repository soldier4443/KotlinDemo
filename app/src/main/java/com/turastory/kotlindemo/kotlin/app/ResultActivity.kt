package com.turastory.kotlindemo.kotlin.app

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.turastory.kotlindemo.R
import com.turastory.kotlindemo.stub.ResultViewPageAdapter

/**
 * Activity - android extensions in ViewHolder
 */
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_activity_result)

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.menu_result)
        }

        toolbar.apply {
            setTitleTextColor(Color.BLACK)
            if (applicationContext.isTablet())
                setTitleTextAppearance(applicationContext, R.style.ToolbarStyleBlack_xlarge)
        }

        view_pager.apply {
            adapter = ResultViewPageAdapter(supportFragmentManager)
            tab_layout.setupWithViewPager(this)
        }
    }

    // support toolbar setting
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
