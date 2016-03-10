/**
 * com.hmammon.campuscalendar.app
 * BaseFragment.java
 */
package com.fuxuemingzhu.reusableactivitytest.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * BaseFragment
 *
 * @version 1.0.0
 */
public class BaseFragment extends Fragment {

    /**
     * 创建一个新的实例 BaseFragment.
     */
    public BaseFragment() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
    }


    /**
     * Debug输出Log日志 *
     */
    protected void showLogDebug(String tag, String msg) {
        Log.d(tag, msg);
    }

    /**
     * Error输出Log日志 *
     */
    protected void showLogError(String tag, String msg) {
        Log.e(tag, msg);
    }


}
