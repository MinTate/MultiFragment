package com.min.multifragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;


public class LeftListFragment extends ListFragment {
    String arrays[] = {"星期一","星期二","星期三","星期四","星期五","星期六"};

    public LayoutInflater mInflater;

    public static final String LeftListFragmentTag = "leftListFragmentTag";
    public static LeftListFragment newInstance(String str){
        LeftListFragment leftListFragment = new LeftListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(LeftListFragmentTag,str);
        leftListFragment.setArguments(bundle);
        return leftListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInflater = getActivity().getLayoutInflater();
        this.setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrays));//为LeftListFragment设置适配器，其中LeftListFragment中的listview的每一项的布局使用系统自带布局android.R.layout.simple_list_item_1(里面只有个textview)
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = mInflater.inflate(R.layout.layout_leftfragment,container,false);//解析LeftListFragment的布局文件
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        RightListFragment  rightListFragment = (RightListFragment) getFragmentManager().findFragmentByTag("rightListFragment");//当点击LeftListFragment中listview的某一项时，会触发此方法。通过tag找到rightListFragment，MainActivity中add Fragment时设置的此tag，然后调用次Fragment中的refreshData()方法刷新数据，此方法会从新设置adapter
        rightListFragment.refreshData(position);

    }
}
