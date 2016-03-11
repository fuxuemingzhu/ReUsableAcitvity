package com.fuxuemingzhu.reusableactivitytest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;

import com.fuxuemingzhu.reusableactivitytest.R;
import com.fuxuemingzhu.reusableactivitytest.app.BaseFragment;
import com.fuxuemingzhu.reusableactivitytest.app.BaseFragmentActivity;
import com.fuxuemingzhu.reusableactivitytest.fragment.TestFragment;

/**
 * 类描述：
 * 创建人：Administrator
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2015/9/5 22:17
 * <p/>
 * 修改人：Administrator
 * 修改时间：2015/9/5 22:17
 * 修改备注：
 *
 * @version 1.0
 */
public class ReUsableActivity extends BaseFragmentActivity {

    private LinearLayout ll_common;
    private Toolbar toolbar;
    private BaseFragment fragment;

    private String title;
    private int order;
    private int fragmentType;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reusable);

        fragmentManager = getSupportFragmentManager();


        // 获取启动该Result的Intent
        Intent intent = getIntent();
        // 获取该intent所携带的数据
        Bundle data = intent.getExtras();
        // 从Bundle包中取出数据
        fragmentType = data.getInt("fragmentType");
        order = fragmentType;
        title = data.getString("title");
        Log.i("fragmentType", "" + fragmentType);
        Log.i("title", title);
        switch (fragmentType) {
            case 0:
                title = "空白界面";
                fragment = new BaseFragment();
                break;
            default:
                /////////////////////////////////////////////////////////
                fragment = new TestFragment();

                fragment.setArguments(data);
                break;
        }


        initViews();
        initEvents();

        addFragment(fragment);
    }

    @Override
    protected void initViews() {
        ll_common = (LinearLayout) findViewById(R.id.ll_common);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @Override
    protected void initEvents() {
        toolbar.setTitle(title + " " + order);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void addFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //是rl 不是ll
        //好可恶啊，整了好久  就是因为这个搞错了
        fragmentTransaction.replace(R.id.rl_common, fragment);
        fragmentTransaction.commit();
    }

}
