package com.clean888.cleansuper.cleaner.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.gc;
import com.clean888.cleansuper.cleaner.utils.kh;
import com.clean888.cleansuper.cleaner.bean.dc_packageInfo;
import com.clean888.cleansuper.cleaner.bean.ec;
import com.clean888.cleansuper.cleaner.databinding.FragmentNotificationCleanSettingBinding;
import com.clean888.cleansuper.cleaner.ui.adapter.BABM;
import com.jeremyliao.liveeventbus.LiveEventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BADW extends BaseFragment implements View.OnClickListener {
    private BABM allowAdapter;
    private FragmentNotificationCleanSettingBinding binding;
    private BABM blockAdapter;
    private List<ec> mAppList;
    private boolean isBlocked = true;
    private boolean isAllowed = true;
    private kh iconHelper = new kh(null);

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BADW.this.initView();
            BADW.this.prepareData();
            BADW.this.bindData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
//                i4.a().i("c_ncleaner_setting_on").commit();
                BADW.this.binding.tvAllowed.setClickable(true);
                BADW.this.binding.tvAllowed.setEnabled(true);
                BADW.this.binding.tvBlocked.setClickable(true);
                BADW.this.binding.tvBlocked.setEnabled(true);
                a_mmkv.h().F(true);
                return;
            }
//            i4.a().i("c_ncleaner_setting_off").commit();
            BADW.this.binding.rvAllowed.setVisibility(View.GONE);
            BADW.this.binding.rvBlocked.setVisibility(View.GONE);
            BADW.this.binding.tvAllowed.setClickable(false);
            BADW.this.binding.tvAllowed.setEnabled(false);
            BADW.this.binding.tvBlocked.setClickable(false);
            BADW.this.binding.tvBlocked.setEnabled(false);
            BADW.this.isBlocked = false;
            BADW.this.isAllowed = false;
            BADW.this.binding.ivBlocked.setImageResource(R.mipmap.icon_notification_down);
            BADW.this.binding.ivAllowed.setImageResource(R.mipmap.icon_notification_down);
            a_mmkv.h().F(false);
            LiveEventBus.get("notification_set_event").post(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindData() {
        if (a_mmkv.h().l()) {
            this.binding.switchEnable.setChecked(true);
            this.binding.rvAllowed.setVisibility(View.VISIBLE);
            this.binding.rvBlocked.setVisibility(View.VISIBLE);
            this.isBlocked = true;
            this.isAllowed = true;
            this.binding.ivBlocked.setImageResource(R.mipmap.icon_notification_up);
            this.binding.ivAllowed.setImageResource(R.mipmap.icon_notification_up);
            return;
        }
        this.binding.switchEnable.setChecked(false);
        this.binding.rvAllowed.setVisibility(View.GONE);
        this.binding.rvBlocked.setVisibility(View.GONE);
        this.isBlocked = false;
        this.isAllowed = false;
        this.binding.ivBlocked.setImageResource(R.mipmap.icon_notification_down);
        this.binding.ivAllowed.setImageResource(R.mipmap.icon_notification_down);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.binding.rvBlocked.setLayoutManager(new LinearLayoutManager(getContext()));
        this.binding.rvAllowed.setLayoutManager(new LinearLayoutManager(getContext()));
        this.blockAdapter = new BABM(R.layout.item_app_list, this.iconHelper);
        this.allowAdapter = new BABM(R.layout.item_app_list, this.iconHelper);
        this.binding.rvBlocked.setAdapter(this.blockAdapter);
        this.binding.rvAllowed.setAdapter(this.allowAdapter);
        this.binding.switchEnable.setOnCheckedChangeListener(new b());
    }

    public static BADW newInstance() {
        return new BADW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareData() {
        dc_packageInfo value;
        if (this.mAppList.size() == 0) {
            ConcurrentHashMap<String, dc_packageInfo> a2 = gc.a();

            Set<String> e = a_mmkv.h().e();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<String, dc_packageInfo> entry : a2.entrySet()) {
                if (entry != null && entry.getKey() != null && (value = entry.getValue()) != null) {
                    ec ecVar = new ec();
                    String key = entry.getKey();
                    ecVar.b_packageName = key;
                    ecVar.a_label = value.e_label;
                    boolean contains = e.contains(key);
                    ecVar.d = contains;
                    if (contains) {
                        ecVar.c_isChecked = false;
                        arrayList2.add(ecVar);
                    } else {
                        ecVar.c_isChecked = true;
                        arrayList.add(ecVar);
                    }
                }
            }
            this.allowAdapter.setNewInstance(arrayList2);
            this.blockAdapter.setNewInstance(arrayList);
            this.mAppList.addAll(arrayList2);
            this.mAppList.addAll(arrayList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentNotificationCleanSettingBinding fragmentNotificationCleanSettingBinding = this.binding;
        if (view == fragmentNotificationCleanSettingBinding.tvBlocked) {
            if (this.isBlocked) {
                fragmentNotificationCleanSettingBinding.ivBlocked.setImageResource(R.mipmap.icon_notification_down);
                this.binding.rvBlocked.setVisibility(View.GONE);
            } else {
                fragmentNotificationCleanSettingBinding.ivBlocked.setImageResource(R.mipmap.icon_notification_up);
                this.binding.rvBlocked.setVisibility(View.VISIBLE);
            }
            this.isBlocked = !this.isBlocked;
            return;
        }
        if (view == fragmentNotificationCleanSettingBinding.tvAllowed) {
            if (this.isAllowed) {
                fragmentNotificationCleanSettingBinding.ivAllowed.setImageResource(R.mipmap.icon_notification_down);
                this.binding.rvAllowed.setVisibility(View.GONE);
            } else {
                fragmentNotificationCleanSettingBinding.ivAllowed.setImageResource(R.mipmap.icon_notification_up);
                this.binding.rvAllowed.setVisibility(View.VISIBLE);
            }
            this.isAllowed = !this.isAllowed;
            return;
        }
        if (view == fragmentNotificationCleanSettingBinding.icBack) {
//            i4.a().i("c_ncleaner_setting_back").commit();
            finishActivity();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        this.binding = FragmentNotificationCleanSettingBinding.inflate(layoutInflater, viewGroup, false);
//        i4.a().i("s_ncleaner_setting").commit();
        this.mAppList = new ArrayList();
        this.binding.tvBlocked.setOnClickListener(this);
        this.binding.tvAllowed.setOnClickListener(this);
        this.binding.icBack.setOnClickListener(this);
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        kh khVar = this.iconHelper;
        if (khVar != null) {
            khVar.n();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        getActivity().getWindow().getDecorView().postDelayed(new a(), 100L);
    }
}