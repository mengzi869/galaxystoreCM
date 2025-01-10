package com.clean888.cleansuper.cleaner.ui.adapter;

import android.os.Handler;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.mr0;
import com.clean888.cleansuper.cleaner.bean.RunningAppBean;
import com.clean888.cleansuper.cleaner.bean.BoostSelectItemBean;

public class BoostSelectAdapter extends BaseQuickAdapter<BoostSelectItemBean, BaseViewHolder> {
    private BoostSelectLinstener<BoostSelectItemBean> call;

    public interface BoostSelectLinstener<T> {
        void a(T t, boolean z);
    }

    public BoostSelectAdapter(int i) {
        super(i);
    }

    private void checkChangedConvert(RunningAppBean runningBackgrdAppsBeanVar, AppCompatCheckBox appCompatCheckBox, BoostSelectItemBean boostSelectItemBeanVar, AppCompatCheckBox appCompatCheckBox2, CompoundButton compoundButton, boolean z) {
        if (!runningBackgrdAppsBeanVar.equals(appCompatCheckBox.getTag()) || appCompatCheckBox.isChecked() == boostSelectItemBeanVar.a()) {
            return;
        }
        boostSelectItemBeanVar.b(appCompatCheckBox.isChecked());
        BoostSelectLinstener<BoostSelectItemBean> boostSelectLinstener = this.call;
        if (boostSelectLinstener != null && !boostSelectItemBeanVar.b) {
            boostSelectLinstener.a(boostSelectItemBeanVar, appCompatCheckBox.isChecked());
        }
        if (appCompatCheckBox2 != null) {
            appCompatCheckBox2.setChecked(appCompatCheckBox.isChecked());
        }
        new Handler().post(new Runnable() {
            @Override
            public final void run() {
                try {
                    notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setCall(BoostSelectLinstener<BoostSelectItemBean> aVar) {
        this.call = aVar;
    }

    @Override
    public void convert(@NonNull BaseViewHolder baseViewHolder, final BoostSelectItemBean boostSelectItemBeanVar) {
        final RunningAppBean runningBackgrdAppsBeanVar = boostSelectItemBeanVar.runningBean;
        if (runningBackgrdAppsBeanVar != null) {
            baseViewHolder.setText(R.id.title, runningBackgrdAppsBeanVar.getAppName());
            baseViewHolder.setText(R.id.tv_size, mr0.a((float) runningBackgrdAppsBeanVar.getAppMemoryInfo(), 2));
            baseViewHolder.setImageDrawable(R.id.iv_icon, runningBackgrdAppsBeanVar.getAppIcon());
            final AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) baseViewHolder.getView(R.id.box);
            if (appCompatCheckBox != null) {
                baseViewHolder.setVisible(R.id.progress, boostSelectItemBeanVar.b);
                baseViewHolder.setVisible(R.id.box, !boostSelectItemBeanVar.b);
                final AppCompatCheckBox appCompatCheckBox2 = (AppCompatCheckBox) baseViewHolder.getView(R.id.box_show);
                appCompatCheckBox.setTag(runningBackgrdAppsBeanVar);
                appCompatCheckBox.setChecked(boostSelectItemBeanVar.a());
                appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        checkChangedConvert(runningBackgrdAppsBeanVar, appCompatCheckBox, boostSelectItemBeanVar, appCompatCheckBox2, compoundButton, z);
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
