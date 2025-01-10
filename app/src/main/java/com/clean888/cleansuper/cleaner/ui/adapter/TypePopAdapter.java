package com.clean888.cleansuper.cleaner.ui.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;

// BABI
public class TypePopAdapter extends BaseQuickAdapter<zb, BaseViewHolder> {
    public TypePopAdapter(int i) {
        super(i);
    }

    public static String getTypeText(Context context, zb zbVar) {
        int a = zbVar.a();
        if (a != 0) {
            switch (a) {
                case 101:
                    return context.getString(R.string.large_file_me_type_audio);
                case 102:
                    return context.getString(R.string.large_file_me_type_image);
                case 103:
                    return context.getString(R.string.large_file_me_type_video);
                case 104:
                    return context.getString(R.string.large_file_me_type_doc);
                case 105:
                    return context.getString(R.string.large_file_me_type_apk);
                case 106:
                    return context.getString(R.string.large_file_me_type_zip);
                default:
                    return zbVar.b() ? context.getString(R.string.large_file_me_type_all) : "--";
            }
        }
        return context.getString(R.string.large_file_me_type_other);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, zb zbVar) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.title);
        textView.setText(getTypeText(textView.getContext(), zbVar));
        textView.setTypeface(zbVar.c() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        ((AppCompatCheckBox) baseViewHolder.getView(R.id.box_show)).setChecked(zbVar.c());
    }

}
