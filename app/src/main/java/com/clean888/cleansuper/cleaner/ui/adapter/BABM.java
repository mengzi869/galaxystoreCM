package com.clean888.cleansuper.cleaner.ui.adapter;

import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.bean.ec;
import com.clean888.cleansuper.cleaner.utils.kh;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;

public class BABM extends BaseQuickAdapter<ec, BaseViewHolder> {
    private kh iconHelper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ ec a;

        a(ec ecVar) {
            this.a = ecVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ec ecVar = this.a;
            boolean z2 = !ecVar.c_isChecked;
            ecVar.c_isChecked = z2;
            if (z2) {
                a_mmkv.h().C(this.a.b_packageName);
            } else {
                a_mmkv.h().c(this.a.b_packageName);
            }
        }
    }

    public BABM(int i, kh khVar) {
        super(i);
        this.iconHelper = khVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseViewHolder baseViewHolder, ec ecVar) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) baseViewHolder.getView(R.id.iv_notification_icon);
        SwitchCompat switchCompat = (SwitchCompat) baseViewHolder.getView(R.id.switch_notification);
        this.iconHelper.k(appCompatImageView, ecVar.b_packageName);
        baseViewHolder.setText(R.id.tv_notification_name, ecVar.a_label);
        switchCompat.setChecked(ecVar.c_isChecked);
        switchCompat.setOnCheckedChangeListener(new a(ecVar));
    }
}
