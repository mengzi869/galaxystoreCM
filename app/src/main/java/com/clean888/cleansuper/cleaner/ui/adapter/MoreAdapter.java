package com.clean888.cleansuper.cleaner.ui.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;

public class MoreAdapter extends BaseQuickAdapter<adapterItem, BaseViewHolder> {


    public MoreAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, adapterItem adapterItem) {
        baseViewHolder.setText(R.id.title, adapterItem.c);
        baseViewHolder.setImageResource(R.id.icon, adapterItem.b);
    }
}

