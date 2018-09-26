package com.turastory.kotlindemo.todo.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.turastory.kotlindemo.R;
import com.turastory.kotlindemo.stub.ResultViewPageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity - android extensions in ViewHolder
 */
public class ResultActivity extends AppCompatActivity {
    
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_result);
        ButterKnife.bind(this);
        
        setSupportActionBar(toolbar);
        
        assert getSupportActionBar() != null;
        
        // show back arrow
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.menu_result);
        
        toolbar.setTitleTextColor(Color.BLACK);
        if (DeviceConfiguration.isTablet(getApplicationContext())) {
            toolbar.setTitleTextAppearance(getApplicationContext(), R.style.ToolbarStyleBlack_xlarge);
        }
        
        viewPager.setAdapter(new ResultViewPageAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
    
    // support toolbar setting
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
