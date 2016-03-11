package com.fuxuemingzhu.reusableactivitytest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fuxuemingzhu.reusableactivitytest.R;
import com.fuxuemingzhu.reusableactivitytest.activity.ReUsableActivity;
import com.fuxuemingzhu.reusableactivitytest.app.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class TestFragment extends BaseFragment {

    private View view;

    String show;
    TextView tv_show;
    Button btn_show;

    private int order = 0;

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_test, container, false);
        tv_show = (TextView) view.findViewById(R.id.tv_test);
        btn_show = (Button) view.findViewById(R.id.btn_test);
        Bundle data = getArguments();
        show = data.getString("title");
        order = data.getInt("fragmentType");

        tv_show.setText("This is fragment " + order);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("title", "ReUsableActivity");
                data.putInt("fragmentType", order + 1);
                Intent intent = new Intent();
                intent.setClass(TestFragment.this.getActivity(), ReUsableActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });

        return view;
    }


}
