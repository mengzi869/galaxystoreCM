package com.clean888.cleansuper.cleaner.ui.adapter;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.h91;
import com.clean888.cleansuper.cleaner.utils.m81;
import com.clean888.cleansuper.cleaner.utils.mr0;
import com.clean888.cleansuper.cleaner.utils.gm;
import com.clean888.cleansuper.cleaner.utils.n81;
import com.clean888.cleansuper.cleaner.utils.kh;
import com.clean888.cleansuper.cleaner.utils.lb;

/* loaded from: classes2.dex */
public class sb extends BaseNodeProvider {
    private kh e;

    public sb(kh khVar) {
        this.e = khVar;
    }

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
    public /* synthetic */ void y(lb lbVar, AppCompatCheckBox appCompatCheckBox, AppCompatCheckBox appCompatCheckBox2, CompoundButton compoundButton, boolean z) {
        if (!lbVar.equals(appCompatCheckBox.getTag()) || appCompatCheckBox.isChecked() == lbVar.a.i()) {
            return;
        }
        lbVar.a.j(appCompatCheckBox.isChecked());
        lbVar.b.d(lbVar.a);
        h91.Q().e();
        if (appCompatCheckBox2 != null) {
            appCompatCheckBox2.setChecked(appCompatCheckBox.isChecked());
        }
        new Handler().post(new Runnable() { // from class: rb
            @Override // java.lang.Runnable
            public final void run() {
                sb.this.x();
            }
        });
    }

    @Override // defpackage.fm
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void convert(@NonNull BaseViewHolder baseViewHolder, BaseNode qmVar) {
        kh khVar;
        final lb lbVar = (lb) qmVar;
        if (lbVar != null) {
            baseViewHolder.setText(R.id.title, lbVar.a.a());
            baseViewHolder.setText(R.id.tv_size, mr0.a((float) lbVar.a.c(), 2));
            baseViewHolder.setImageDrawable(R.id.iv_icon, null);
            gm gmVar = lbVar.a;
            int i = gmVar.d;
            if (i != 100) {
                switch (i) {
                    case 1001:
                        baseViewHolder.setImageResource(R.id.iv_icon, R.mipmap.ic_item_sec_ad);
                        break;
                    case 1002:
                        baseViewHolder.setImageResource(R.id.iv_icon, R.mipmap.ic_item_sec_log);
                        break;
                    case 1003:
                        baseViewHolder.setImageResource(R.id.iv_icon, R.mipmap.ic_item_sec_temp);
                        break;
                    case 1004:
                        baseViewHolder.setImageResource(R.id.iv_icon, R.mipmap.ic_item_sec_residual);
                        break;
                    case 1005:
                        baseViewHolder.setText(R.id.title, ((m81) gmVar).k());
                        gm gmVar2 = lbVar.a;
                        if (gmVar2 instanceof n81) {
                            kh khVar2 = this.e;
                            if (khVar2 != null) {
                                khVar2.k((ImageView) baseViewHolder.getView(R.id.iv_icon), ((n81) lbVar.a).o());
                                break;
                            }
                        } else if ((gmVar2 instanceof m81) && (khVar = this.e) != null) {
                            khVar.k((ImageView) baseViewHolder.getView(R.id.iv_icon), ((m81) lbVar.a).o());
                            break;
                        }
                        break;
                    case 1006:
                        baseViewHolder.setImageResource(R.id.iv_icon, R.mipmap.ic_item_sec_apk);
                        break;
                }
            } else {
                baseViewHolder.setImageResource(R.id.iv_icon, R.mipmap.ic_item_sec_sys_cache);
            }
            final AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) baseViewHolder.getView(R.id.box);
            if (appCompatCheckBox != null) {
                final AppCompatCheckBox appCompatCheckBox2 = (AppCompatCheckBox) baseViewHolder.getView(R.id.box_show);
                appCompatCheckBox.setTag(lbVar);
                appCompatCheckBox.setChecked(lbVar.a.i());
                appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: qb
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        sb.this.y(lbVar, appCompatCheckBox, appCompatCheckBox2, compoundButton, z);
                    }
                });
                if (appCompatCheckBox2 != null) {
                    appCompatCheckBox2.setChecked(appCompatCheckBox.isChecked());
                }
            }
        }
    }

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_clean_group_item;
    }
}
