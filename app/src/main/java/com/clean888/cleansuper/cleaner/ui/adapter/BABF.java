package com.clean888.cleansuper.cleaner.ui.adapter;

import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;

/* loaded from: classes2.dex */
public class BABF extends BaseQuickAdapter<pb, BaseViewHolder> {
    public BABF(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseViewHolder baseViewHolder, pb pbVar) {
        int a = pbVar.a();
        if (a == 10) {
            baseViewHolder.setText(R.id.title, R.string.clean_type_title1);
            baseViewHolder.setImageResource(R.id.leftIcon, R.mipmap.ic_item_cache);
        } else if (a == 20) {
            baseViewHolder.setText(R.id.title, R.string.clean_type_title2);
            baseViewHolder.setImageResource(R.id.leftIcon, R.mipmap.ic_item_residual);
        } else if (a == 30) {
            baseViewHolder.setText(R.id.title, R.string.clean_type_title6);
            baseViewHolder.setImageResource(R.id.leftIcon, R.mipmap.ic_item_ad);
        } else if (a == 40) {
            baseViewHolder.setText(R.id.title, R.string.clean_type_title3);
            baseViewHolder.setImageResource(R.id.leftIcon, R.mipmap.ic_item_apk);
        } else if (a == 50) {
            baseViewHolder.setText(R.id.title, R.string.clean_type_title4);
            baseViewHolder.setImageResource(R.id.leftIcon, R.mipmap.ic_item_temp);
        } else if (a == 60) {
            baseViewHolder.setText(R.id.title, R.string.clean_type_title5);
            baseViewHolder.setImageResource(R.id.leftIcon, R.mipmap.ic_item_log);
        } else if (a == 70) {
            baseViewHolder.setText(R.id.title, R.string.clean_type_title7);
            baseViewHolder.setImageResource(R.id.leftIcon, R.mipmap.ic_item_sys_cache);
        }
        baseViewHolder.setVisible(R.id.statusBottom, !pbVar.b());
        baseViewHolder.setVisible(R.id.statusIcon, pbVar.b());
    }
}
