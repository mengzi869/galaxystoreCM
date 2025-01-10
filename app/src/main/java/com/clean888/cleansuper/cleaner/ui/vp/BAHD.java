package com.clean888.cleansuper.cleaner.ui.vp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.clean888.cleansuper.cleaner.bean.RunningAppBean;

import com.clean888.cleansuper.cleaner.R;

import java.util.List;

/* loaded from: classes2.dex */
public class BAHD extends PagerAdapter {
    private List<RunningAppBean> mData;

    public BAHD(Context context, List<RunningAppBean> list) {
        this.mData = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (i < this.mData.size()) {
            return;
        }
        int size = i % this.mData.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mData.size() * 100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_app_card, viewGroup, false);
        viewGroup.addView(inflate);
        if (i >= this.mData.size()) {
            i %= this.mData.size();
        }
        ((AppCompatImageView) inflate.findViewById(R.id.icon)).setImageDrawable(this.mData.get(i).getAppIcon());
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
