package com.carpartsshow.ui.classify.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.eventbus.CarClassifyBean;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.carpartsshow.ui.home.adapter.ClassifyGroupAdapter;
import com.carpartsshow.util.DensityUtils;
import com.carpartsshow.widgets.AnimatedExpandableListView;
import com.carpartsshow.widgets.CPSToast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


/**
 * Created by lizhe on 2018/3/27.
 * 分类-分类
 */

public class CarClassifyFragment extends BaseFragment {

    @BindView(R.id.expandable_lv)
    AnimatedExpandableListView expandableListView;

//    private CarClassifyAdapter mAdapter;
    private ClassifyGroupAdapter mAdapter;
    private ArrayList<ClassificationItemBean> list;
    private int type;

    public static CarClassifyFragment newInstance(List<ClassificationItemBean> list){
        CarClassifyFragment myFragment = new CarClassifyFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) list);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_car_classify;
    }

    @Override
    protected void init() {
        Bundle bundle = getArguments();
        list =  bundle.getParcelableArrayList("list");

    }

    @Override
    protected void setData() {
        mAdapter = new ClassifyGroupAdapter(getContext());
        expandableListView.setAdapter(mAdapter);
        mAdapter.loadData(list);
        mAdapter.setOnOpenListener(new ClassifyGroupAdapter.OnOpenListener() {
            @Override
            public void open(int groupPosition,boolean isOpen) {
                if (isOpen) {
                    expandableListView.collapseGroupWithAnimation(groupPosition);
                }else {
                    expandableListView.expandGroupWithAnimation(groupPosition);
                }
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });

        mAdapter.setOnItemListener(new ClassifyGroupAdapter.OnItemListener() {
            @Override
            public void OnGroupItemClick(ClassificationItemBean classificationItemBean) {
                if (getActivity() instanceof GoodsSearchActivity) {
                    EventBus.getDefault().post(new CarClassifyBean("classify",classificationItemBean.getName(),"1"));
                }else {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), GoodsSearchActivity.class);
                    intent.putExtra("classify", classificationItemBean.getName());
                    intent.putExtra("classifyStep", "1");
                    startActivity(intent);
                }
            }

            @Override
            public void OnSubItemClick(ClassificationItemBean.ClassificationItem2Bean classificationItem2Bean) {
                if (getActivity() instanceof GoodsSearchActivity) {
                    EventBus.getDefault().post(new CarClassifyBean("classify",classificationItem2Bean.getName(),"2"));
                }else {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), GoodsSearchActivity.class);
                    intent.putExtra("classify", classificationItem2Bean.getName());
                    intent.putExtra("classifyStep", "2");
                    startActivity(intent);
                }
            }
        });
        View view = new View(getContext());
        view.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, DensityUtils.dip2px(getContext(),60)));
        expandableListView.addFooterView(view);
    }


}
