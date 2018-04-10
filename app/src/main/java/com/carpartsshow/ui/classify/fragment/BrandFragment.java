package com.carpartsshow.ui.classify.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.eventbus.CarClassifyBean;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.ui.classify.adapter.brand.BrandAdapter;
import com.carpartsshow.ui.classify.adapter.brand.BrandComparator;
import com.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.carpartsshow.util.DensityUtils;
import com.carpartsshow.util.PinyinUtils;
import com.carpartsshow.util.SystemUtil;
import com.carpartsshow.view.SideBar;
import com.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lizhe on 2018/3/27.
 * 分类-品牌
 */

public class BrandFragment extends BaseFragment {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.right_side)
    SideBar rightSide;
    @BindView(R.id.dialog)
    TextView tvDialog;

    private BrandAdapter mAdapter;

    private List<ClassificationBean.ListBrandBean> mListBrandBeans;

    public static BrandFragment newInstance(List<ClassificationBean.ListBrandBean> list){
        BrandFragment myFragment = new BrandFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) list);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_brand;
    }

    @Override
    protected void init() {
        Bundle bundle = getArguments();
        mListBrandBeans = bundle.getParcelableArrayList("list");
        filledData(mListBrandBeans);
        rightSide.setTextView(tvDialog);
    }

    @Override
    protected void setData() {
        mAdapter = new BrandAdapter(getContext(), mListBrandBeans);
        Collections.sort(mListBrandBeans,new BrandComparator());
        listView.setAdapter(mAdapter);
        View view = new View(getContext());
        view.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, DensityUtils.dip2px(getContext(),60)));
        listView.addFooterView(view);
        //设置右侧触摸监听
        rightSide.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = mAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    listView.setSelection(position);
                }
            }
        });

        //ListView的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                mTvTitle.setText(((ContactSortModel) adapter.getItem(position - 1)).getName());
//                CPSToast.showText(getContext().getApplicationContext(),mAdapter.getItem(position).getCompany_FirstWord());
                if (getActivity() instanceof GoodsSearchActivity) {
                    EventBus.getDefault().post(new CarClassifyBean("brand",mAdapter.getItem(position).getName()));
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("brand", mAdapter.getItem(position).getName());
                    intent.setClass(getContext(), GoodsSearchActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private List<ClassificationBean.ListBrandBean> filledData(List<ClassificationBean.ListBrandBean> date) {
        List<ClassificationBean.ListBrandBean> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            ClassificationBean.ListBrandBean sortModel = new ClassificationBean.ListBrandBean();
            String pinyin = PinyinUtils.getPingYin(date.get(i).getCompany_FirstWord());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setCompany_FirstWord(sortString.toUpperCase());
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


}
