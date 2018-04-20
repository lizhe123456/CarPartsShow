package com.whmnrc.carpartsshow.ui.classify.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.BaseFragment;
import com.whmnrc.carpartsshow.eventbus.CarClassifyBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;
import com.whmnrc.carpartsshow.ui.MainActivity;
import com.whmnrc.carpartsshow.ui.classify.adapter.brand.BrandAdapter;
import com.whmnrc.carpartsshow.ui.classify.adapter.brand.BrandComparator;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.whmnrc.carpartsshow.ui.shopping.ShoppingCartActivity;
import com.whmnrc.carpartsshow.util.DensityUtils;
import com.whmnrc.carpartsshow.util.PinyinUtils;
import com.whmnrc.carpartsshow.view.SideBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

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
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private BrandAdapter mAdapter;

    private List<ClassificationBean.ListBrandBean> mListBrandBeans;

    public static BrandFragment newInstance(List<ClassificationBean.ListBrandBean> list) {
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
        EventBus.getDefault().register(this);
        Bundle bundle = getArguments();
        mListBrandBeans = bundle.getParcelableArrayList("list");

    }

    @Override
    protected void setData() {
        if (mListBrandBeans != null && mListBrandBeans.size() != 0){
            filledData(mListBrandBeans);
            rightSide.setTextView(tvDialog);
            mAdapter = new BrandAdapter(getContext(), mListBrandBeans);
            Collections.sort(mListBrandBeans, new BrandComparator());
            listView.setAdapter(mAdapter);
            View view = new View(getContext());
            view.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, DensityUtils.dip2px(getContext(), 60)));
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
                        EventBus.getDefault().post(new CarClassifyBean("brand", mAdapter.getItem(position).getName()));
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("brand", mAdapter.getItem(position).getName());
                        intent.setClass(getContext(), GoodsSearchActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }else {
            showEmpty();
            listView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        }
    }

    private List<ClassificationBean.ListBrandBean> filledData(@Nullable List<ClassificationBean.ListBrandBean> date) {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateBrand(List<ClassificationBean.ListBrandBean> listBrandBeans) {
        if (listBrandBeans != null && listBrandBeans.size() != 0) {
            mListBrandBeans = listBrandBeans;
            filledData(mListBrandBeans);
            rightSide.setTextView(tvDialog);
            Collections.sort(mListBrandBeans, new BrandComparator());
            mAdapter.updateListView(mListBrandBeans);
            vsEmpty.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }else {
            showEmpty();
            listView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_empty_msg);
            imageView.setImageResource(R.drawable.order_empty);
            textView.setText("暂无更多数据~");
        }
    }
}
