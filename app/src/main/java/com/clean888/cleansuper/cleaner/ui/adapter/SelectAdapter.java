package com.clean888.cleansuper.cleaner.ui.adapter;

import android.os.Handler;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.i81;
import com.clean888.cleansuper.cleaner.utils.mr0;
import com.clean888.cleansuper.cleaner.utils.bc;

// BABJ
public class SelectAdapter extends BaseQuickAdapter<bc, BaseViewHolder> {
    private a<bc> call;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void a(T t, boolean z);
    }

    public SelectAdapter(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convert$0() {
        try {
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convert$1(i81 i81Var, AppCompatCheckBox appCompatCheckBox, bc bcVar, AppCompatCheckBox appCompatCheckBox2, CompoundButton compoundButton, boolean z) {
        if (!i81Var.equals(appCompatCheckBox.getTag()) || appCompatCheckBox.isChecked() == i81Var.i()) {
            return;
        }
        i81Var.j(appCompatCheckBox.isChecked());
        if (!bcVar.c) {
            bcVar.a();
            a<bc> aVar = this.call;
            if (aVar != null) {
                aVar.a(bcVar, appCompatCheckBox.isChecked());
            }
        }
        if (appCompatCheckBox2 != null) {
            appCompatCheckBox2.setChecked(appCompatCheckBox.isChecked());
        }
        new Handler().post(new Runnable() { // from class: gb
            @Override // java.lang.Runnable
            public final void run() {
                SelectAdapter.this.lambda$convert$0();
            }
        });
    }

    public void setCall(a<bc> aVar) {
        this.call = aVar;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, final bc bcVar) {
        Integer valueOf;
        final i81 i81Var = (i81) bcVar.a;
        if (i81Var != null) {
            baseViewHolder.setText(R.id.title, i81Var.a());
            baseViewHolder.setText(R.id.tv_size, mr0.a((float) i81Var.c(), 2));
            switch (i81Var.f) {
                case 101:
                    valueOf = Integer.valueOf(R.mipmap.ico_file_music);
                    break;
                case 102:
                    valueOf = Integer.valueOf(R.mipmap.ico_file_photo);
                    break;
                case 103:
                    valueOf = Integer.valueOf(R.mipmap.ico_file_video);
                    break;
                case 104:
                    valueOf = Integer.valueOf(R.mipmap.ico_file_document);
                    break;
                case 105:
                    valueOf = Integer.valueOf(R.mipmap.ico_file_apk);
                    break;
                case 106:
                    valueOf = Integer.valueOf(R.mipmap.ico_file_rar);
                    break;
                default:
                    valueOf = Integer.valueOf(R.mipmap.ico_file_unkown);
                    break;
            }
            if (valueOf != null && valueOf.intValue() > 0) {
                baseViewHolder.setImageResource(R.id.iv_icon, valueOf.intValue());
            }
            final AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) baseViewHolder.getView(R.id.box);
            if (appCompatCheckBox != null) {
                baseViewHolder.setVisible(R.id.progress, bcVar.c);
                baseViewHolder.setVisible(R.id.box, !bcVar.c);
                final AppCompatCheckBox appCompatCheckBox2 = (AppCompatCheckBox) baseViewHolder.getView(R.id.box_show);
                appCompatCheckBox.setTag(i81Var);
                appCompatCheckBox.setChecked(i81Var.i());
                appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: fb
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        SelectAdapter.this.lambda$convert$1(i81Var, appCompatCheckBox, bcVar, appCompatCheckBox2, compoundButton, z);
                    }
                });
                if (appCompatCheckBox2 != null) {
                    appCompatCheckBox2.setChecked(appCompatCheckBox.isChecked());
                    appCompatCheckBox2.setVisibility(appCompatCheckBox.getVisibility());
                }
            }
        }
    }
}
