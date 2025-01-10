package com.clean888.cleansuper.cleaner.ui.adapter;


import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.kc;
import com.clean888.cleansuper.cleaner.bean.cc;

/* loaded from: classes2.dex */
public class BABN extends BaseQuickAdapter<cc, BaseViewHolder> {
    public BABN(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseViewHolder baseViewHolder, cc ccVar) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) baseViewHolder.getView(R.id.iv_notification_clean_app_icon);
        AppCompatTextView appCompatTextView = (AppCompatTextView) baseViewHolder.getView(R.id.tv_notification_clean_title);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) baseViewHolder.getView(R.id.tv_notification_clean_content);
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) baseViewHolder.getView(R.id.tv_notification_clean_time);
        Bitmap bitmap = ccVar.bitmap;
        if (bitmap != null) {
            appCompatImageView.setImageBitmap(bitmap);
        } else {
            appCompatImageView.setImageResource(R.mipmap.img_notification_tag);
        }
        long j = ccVar.f112g;
        if (j > 0) {
            appCompatTextView3.setText(kc.a(j, System.currentTimeMillis()));
        } else {
            appCompatTextView3.setText("");
        }
        appCompatTextView.setText(ccVar.title);
        if (!TextUtils.isEmpty(ccVar.text)) {
            appCompatTextView2.setVisibility(View.VISIBLE);
            appCompatTextView2.setText(ccVar.text);
        } else {
            appCompatTextView2.setVisibility(View.GONE);
        }
        if (getItemPosition(ccVar) == getData().size() - 1) {
            baseViewHolder.getView(R.id.view).setVisibility(View.VISIBLE);
        } else {
            baseViewHolder.getView(R.id.view).setVisibility(View.GONE);
        }
    }
}