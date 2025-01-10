package com.clean888.cleansuper.cleaner.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.databinding.FragmentMoreBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.ViewModel.MoreViewModel;
import com.clean888.cleansuper.cleaner.ui.activity.BAAX;
import com.clean888.cleansuper.cleaner.ui.activity.BAAY;
import com.clean888.cleansuper.cleaner.ui.activity.ZZT;
import com.clean888.cleansuper.cleaner.ui.activity.LargeFileCleanActivity;
import com.clean888.cleansuper.cleaner.ui.activity.PhoneBoostActivity;
import com.clean888.cleansuper.cleaner.ui.adapter.MoreAdapter;
import com.clean888.cleansuper.cleaner.ui.adapter.adapterItem;
import com.clean888.cleansuper.cleaner.ui.activity.BatterySaverActivity;
import com.clean888.cleansuper.cleaner.ui.activity.CpuCoolerActivity;
import com.clean888.cleansuper.cleaner.utils.a_NotificationUtils;

import java.util.ArrayList;
import java.util.List;

// ZZQ
public class MoreFragment extends BAFU{
    private FragmentMoreBinding binding;
    private int checkAndGo = 0;
    private boolean isAdLoaded;
    private MoreViewModel vm;


    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        statusBarTextDarkLight(false);
        this.vm = (MoreViewModel) new ViewModelProvider(this).get(MoreViewModel.class);
        this.binding = FragmentMoreBinding.inflate(layoutInflater, viewGroup, false);
        BindVM();
//        i4.a().i("s_moretools").commit();
        return this.binding.getRoot();
    }


    private void BindVM() {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new adapterItem(3, R.mipmap.icon_notification, R.string.title_notification_clean));
        arrayList.add(new adapterItem(1, R.mipmap.icon_cooling, R.string.main_more_cpu_cool));
        arrayList.add(new adapterItem(2, R.mipmap.icon_battery, R.string.main_more_battery_saver));
        MoreAdapter bafx = new MoreAdapter(R.layout.item_more_item);
        this.binding.listHot.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.binding.listHot.setAdapter(bafx);

        bafx.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> baseQuickAdapter, @NonNull View view, int i) {
                MoreFragment.this.lambda$BindVM$0(arrayList, baseQuickAdapter, view, i);
            }
        });
        bafx.setNewInstance(arrayList);
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new adapterItem(100, R.mipmap.icon_clean, R.string.main_more_junk_clean));
        arrayList2.add(new adapterItem(101, R.mipmap.icon_large_file, R.string.main_more_large_file_cleaner));
        arrayList2.add(new adapterItem(102, R.mipmap.icon_boost, R.string.main_more_phone_boost));
        MoreAdapter bafx2 = new MoreAdapter(R.layout.item_more_item);
        this.binding.listOptimize.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.binding.listOptimize.setAdapter(bafx2);
        bafx2.setOnItemClickListener(new OnItemClickListener() { // from class: u43
            @Override // defpackage.ey1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MoreFragment.this.lambda$BindVM$1(arrayList2, baseQuickAdapter, view, i);
            }
        });
        bafx2.setNewInstance(arrayList2);
        this.vm.onCreate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
//        setAdAutoRefresh(false);
    }

    public /* synthetic */ void lambda$BindVM$0(List list, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        adapterItem aVar;
        try {
            aVar = (adapterItem) list.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            onItemClick(aVar);
        }
    }

    public /* synthetic */ void lambda$BindVM$1(List list, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        adapterItem aVar;
        try {
            aVar = (adapterItem) list.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            onItemClick(aVar);
        }
    }
    private void checkPerSDToGo(boolean z) {
        checkStoragePermissionDialog(2, new Runnable() { // from class: w43
            @Override // java.lang.Runnable
            public final void run() {
                MoreFragment.this.lambda$checkPerSDToGo$2();
            }
        }, z);
    }

    public /* synthetic */ void lambda$checkPerSDToGo$2() {
        int i = this.checkAndGo;
        if (i == 1) {
            Intent intent = new Intent(getActivity(), (Class<?>) ZZT.class);
            intent.putExtra(MainActivity.FROM, 3);
            startActivity(intent);
            this.checkAndGo = 0;
            return;
        }
        if (i == 2) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) LargeFileCleanActivity.class);
            intent2.putExtra(MainActivity.FROM, 3);
            startActivity(intent2);
            this.checkAndGo = 0;
        }
    }

    public void onItemClick(adapterItem aVar) {
        if (aVar != null) {
//            ol0 i = i4.a().i("c_moretools");
            int i2 = aVar.a;
            if (i2 == 1) {
                Intent intent = new Intent(getActivity(), (Class<?>) CpuCoolerActivity.class);
                intent.putExtra(MainActivity.FROM, 3);
                startActivity(intent);
//                i.putEbKey1(1).commit();
//                i4.a().i("c_moretools_cpucooler").commit();
                return;
            }
            if (i2 == 2) {
                Intent intent2 = new Intent(getActivity(), (Class<?>) BatterySaverActivity.class);
                intent2.putExtra(MainActivity.FROM, 3);
                startActivity(intent2);
//                i.putEbKey1(2).commit();
//                i4.a().i("c_moretools_battery").commit();
                return;
            }
            if (i2 != 3) {
                switch (i2) {
                    case 100:
                        this.checkAndGo = 1;
                        checkPerSDToGo(true);
//                        i.putEbKey1(4).commit();
//                        i4.a().i("c_moretools_junkclean").commit();
                        return;
                    case 101:
                        this.checkAndGo = 2;
                        checkPerSDToGo(true);
//                        i.putEbKey1(5).commit();
//                        i4.a().i("c_moretools_largefile").commit();
                        return;
                    case 102:
                        Intent intent3 = new Intent(getActivity(), (Class<?>) PhoneBoostActivity.class);
                        intent3.putExtra(MainActivity.FROM, 3);
                        startActivity(intent3);
//                        i.putEbKey1(6).commit();
//                        i4.a().i("c_moretools_phoneboost").commit();
                        return;
                    default:
                        return;
                }
            }
//            i4.a().i("c_moretools_ncleaner").commit();

            if (a_NotificationUtils.isEnable(SuperApplication.getContext())) {
                Intent intent4 = new Intent(getContext(), (Class<?>) BAAX.class);
                intent4.putExtra(MainActivity.FROM, MainActivity.FROM_8);
                startActivity(intent4);
            } else {
                Intent intent5 = new Intent(getContext(), (Class<?>) BAAY.class);
                intent5.putExtra(MainActivity.FROM, MainActivity.FROM_8);
                startActivity(intent5);
            }
        }
    }
}
