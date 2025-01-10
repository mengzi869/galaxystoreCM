package com.clean888.cleansuper.cleaner.ui.adapter;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;

// BABK
public class SortPopAdapter extends BaseQuickAdapter<ac, BaseViewHolder> {

    public SortPopAdapter(int i) {
        super(i);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ac acVar) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.title);
        int a = acVar.a();
        if (a == 1) {
            textView.setText(acVar.b() ? R.string.large_file_me_sort_1 : R.string.large_file_me_sort_1_d);
        } else if (a != 2) {
            textView.setText("--");
        } else {
            textView.setText(acVar.b() ? R.string.large_file_me_sort_2 : R.string.large_file_me_sort_2_d);
        }
        textView.setTypeface(acVar.c() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        ((AppCompatCheckBox) baseViewHolder.getView(R.id.box_show)).setChecked(acVar.c());
    }

}
