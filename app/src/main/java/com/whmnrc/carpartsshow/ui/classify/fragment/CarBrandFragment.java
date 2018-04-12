package com.whmnrc.carpartsshow.ui.classify.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.BaseFragment;
import com.whmnrc.carpartsshow.eventbus.CarClassifyBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;
import com.whmnrc.carpartsshow.ui.classify.activity.CarBrandDetailsActivity;
import com.whmnrc.carpartsshow.ui.classify.adapter.CarBrandAdapterV2;
import com.whmnrc.carpartsshow.ui.classify.adapter.brand.CarBrandComparator;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.whmnrc.carpartsshow.util.DensityUtils;
import com.whmnrc.carpartsshow.util.PinyinUtils;
import com.whmnrc.carpartsshow.view.SideBar;
import com.whmnrc.carpartsshow.widgets.AnimatedExpandableListView;
import org.greenrobot.eventbus.EventBus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/27.
 * 分类-车型
 */

public class CarBrandFragment extends BaseFragment {


    @BindView(R.id.expandable_lv)
    AnimatedExpandableListView expandableListView;
    @BindView(R.id.right_side)
    SideBar rightSide;
    @BindView(R.id.dialog)
    TextView dialog;

    private ArrayList<ClassificationBean.ListCarBrandBean> list;
    private CarBrandAdapterV2 mAdapter;
    private boolean flag;
    private int requestCode = 1;

    public static CarBrandFragment newInstance(ArrayList<ClassificationBean.ListCarBrandBean> list) {
        CarBrandFragment myFragment = new CarBrandFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", list);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_car_brand;
    }

    @Override
    protected void init() {
        Bundle bundle = getArguments();
        list = bundle.getParcelableArrayList("list");
        filledData(list);
        rightSide.setTextView(dialog);
    }

    @Override
    protected void setData() {
        mAdapter = new CarBrandAdapterV2(getContext());
        Collections.sort(list,new CarBrandComparator());
        expandableListView.setAdapter(mAdapter);
        mAdapter.loadMore(list);
        //设置右侧触摸监听
        rightSide.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = mAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    expandableListView.setSelectedGroup(position);
                }
            }
        });
        mAdapter.setOnOpenListener(new CarBrandAdapterV2.OnOpenListener() {
            @Override
            public void open(ClassificationBean.ListCarBrandBean listCarBrandBean,int groupPosition) {
                if (listCarBrandBean.isOpen()){
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

        mAdapter.setOnItemListener(new CarBrandAdapterV2.OnItemListener() {
            @Override
            public void OnGroupItemClick(ClassificationBean.ListCarBrandBean listCarBrandBean) {
//                CPSToast.showText(getContext(),listCarBrandBean.getName());
            }

            @Override
            public void OnSubItemClick(ClassificationBean.ListCarBrandBean listCarBrandBean,ClassificationBean.VCJListBean vcjListBean) {
                Intent intent = new Intent();
                intent.setClass(getContext(), CarBrandDetailsActivity.class);
                intent.putExtra("group", listCarBrandBean.getCarBrand_Name() + "," + vcjListBean.getName());
                startActivityForResult(intent, requestCode);
            }

        });

        View view = new View(getContext());
        view.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, DensityUtils.dip2px(getContext(),60)));
        expandableListView.addFooterView(view);
    }

    private List<ClassificationBean.ListCarBrandBean> filledData(List<ClassificationBean.ListCarBrandBean> date) {
        List<ClassificationBean.ListCarBrandBean> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            ClassificationBean.ListCarBrandBean sortModel = new ClassificationBean.ListCarBrandBean();
            String pinyin = PinyinUtils.getPingYin(date.get(i).getCarBrand_FirstCode());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setCarBrand_FirstCode(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }
            mSortList.add(sortModel);
        }
        Collections.sort(indexString);
        rightSide.setIndexText(indexString);
        return mSortList;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.requestCode){
            if (resultCode == 1){
                int cid = data.getIntExtra("cid",-1);
                String name = data.getStringExtra("label");
                if (getActivity() instanceof GoodsSearchActivity) {
                    EventBus.getDefault().post(new CarClassifyBean("carBrand",name,cid));
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("carBrand", name);
                    intent.putExtra("cid",cid);
                    intent.setClass(getContext(), GoodsSearchActivity.class);
                    startActivity(intent);
                }
            }
        }
    }
}
