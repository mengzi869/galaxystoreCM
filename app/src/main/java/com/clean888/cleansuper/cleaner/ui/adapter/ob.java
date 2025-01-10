package com.clean888.cleansuper.cleaner.ui.adapter;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.h91;
import com.clean888.cleansuper.cleaner.utils.mr0;
import com.clean888.cleansuper.cleaner.utils.tb;
import com.clean888.cleansuper.cleaner.utils.gm;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ob extends BaseNodeProvider {
    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint("NotifyDataSetChanged")
    public /* synthetic */ void x() {
        try {
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(tb tbVar, AppCompatCheckBox appCompatCheckBox, AppCompatCheckBox appCompatCheckBox2, CompoundButton compoundButton, boolean z) {
        if (!tbVar.equals(appCompatCheckBox.getTag()) || appCompatCheckBox.isChecked() == tbVar.c.a()) {
            return;
        }
        tbVar.c.b(appCompatCheckBox.isChecked());
        tbVar.e();
        Iterator<? extends gm> it = tbVar.c.c.iterator();
        while (it.hasNext()) {
            it.next().j(tbVar.c.a());
        }
        h91.Q().e();
        if (appCompatCheckBox2 != null) {
            appCompatCheckBox2.setChecked(appCompatCheckBox.isChecked());
        }
        new Handler().post(new Runnable() { // from class: nb
            @Override // java.lang.Runnable
            public final void run() {
                ob.this.x();
            }
        });
    }


    @Override // defpackage.fm
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void convert(@NonNull BaseViewHolder baseViewHolder, BaseNode qmVar) {
        final tb tbVar = (tb)qmVar;
        if (tbVar != null) {
            int i = tbVar.c.d;
            if (i != 100) {
                switch (i) {
                    case 1001:
                        baseViewHolder.setText(R.id.title, R.string.clean_type_title6);
                        break;
                    case 1002:
                        baseViewHolder.setText(R.id.title, R.string.clean_type_title5);
                        break;
                    case 1003:
                        baseViewHolder.setText(R.id.title, R.string.clean_type_title4);
                        break;
                    case 1004:
                        baseViewHolder.setText(R.id.title, R.string.clean_type_title2);
                        break;
                    case 1005:
                        baseViewHolder.setText(R.id.title, R.string.clean_type_title1);
                        break;
                    case 1006:
                        baseViewHolder.setText(R.id.title, R.string.clean_type_title3);
                        break;
                    default:
                        baseViewHolder.setText(R.id.title, "--");
                        break;
                }
            } else {
                baseViewHolder.setText(R.id.title, R.string.clean_type_title7);
            }
            baseViewHolder.setText(R.id.tv_size, mr0.a((float) tbVar.c.a, 2));
            Log.d("ob", "获取tbVar.getA() 1" + tbVar.getA());
            baseViewHolder.getView(R.id.iv_arr).setRotation(tbVar.getA() ? 0.0f : 180.0f);
            final AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) baseViewHolder.getView(R.id.box);
            if (appCompatCheckBox != null) {
                final AppCompatCheckBox appCompatCheckBox2 = (AppCompatCheckBox) baseViewHolder.getView(R.id.box_show);
                appCompatCheckBox.setTag(tbVar);
                appCompatCheckBox.setChecked(tbVar.c.a());
                appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: mb
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        Log.d("ob", "获取boolean z 2: " + z);
                        ob.this.y(tbVar, appCompatCheckBox, appCompatCheckBox2, compoundButton, z);
                    }
                });
                if (appCompatCheckBox2 != null) {
                    appCompatCheckBox2.setChecked(appCompatCheckBox.isChecked());
                }
            }
        }
    }

    @Override // defpackage.fm
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onClick(@NonNull BaseViewHolder baseViewHolder, @NonNull View view, BaseNode qmVar, int i) {
        if (getAdapter() != null) {
            try {
                getAdapter().expandOrCollapse(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_clean_group_root;
    }
}
