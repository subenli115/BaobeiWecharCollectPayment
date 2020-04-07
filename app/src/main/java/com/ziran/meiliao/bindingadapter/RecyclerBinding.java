package com.ziran.meiliao.bindingadapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;

import com.ziran.meiliao.adapter.CommonAdapter;
import com.ziran.meiliao.adapter.MultiTypeAdapter;

import java.util.List;


/**
 * RecyclerView 在布局文件中使用的自定义属性值
 *
 * @author fengwl
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class RecyclerBinding {

    @BindingAdapter("app:data")
    public static void setRecyclerInfo(RecyclerView recyclerView , List datas){
        CommonAdapter mAdapter = (CommonAdapter) recyclerView.getAdapter();
        mAdapter.setData(datas);
    }

    @BindingAdapter({"app:data", "app:layoutMapping"})
    public static void setRecyclerInfo(RecyclerView recyclerView , List data, SparseIntArray mapping){
        MultiTypeAdapter mAdapter = (MultiTypeAdapter) recyclerView.getAdapter();
        mAdapter.setData(data, mapping);
    }
}
