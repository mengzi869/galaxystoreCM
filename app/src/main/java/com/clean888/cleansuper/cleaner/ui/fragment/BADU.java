package com.clean888.cleansuper.cleaner.ui.fragment;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentNotificationCleanBinding;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.ui.activity.BAAZ;
import com.clean888.cleansuper.cleaner.ui.adapter.BABN;
import com.clean888.cleansuper.cleaner.bean.cc;
import com.clean888.cleansuper.cleaner.utils.hb_NotificationListUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;

import java.util.ArrayList;


/* loaded from: classes2.dex */
public class BADU extends BaseFragment implements View.OnClickListener {
    private BABN adapter;
    private FragmentNotificationCleanBinding binding;
    private String cleanNum = "0";
    private boolean mIsClearNotification;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Integer> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num != null) {
                ArrayList<cc> e = hb_NotificationListUtils.getInstance().getList();
                BADU.this.adapter.setNewInstance(e);
                BADU.this.adapter.notifyDataSetChanged();
                if (BADU.this.adapter != null && BADU.this.adapter.getData().size() > 0) {
                    BADU.this.binding.tvNum.setVisibility(View.VISIBLE);
                    BADU.this.binding.tvClean.setVisibility(View.VISIBLE);
                    BADU.this.cleanNum = e.size() + "";
                    BADU.this.binding.tvNum.setText(BADU.this.getString(R.string.junk_notification_num, e.size() + ""));
                    return;
                }
                BADU.this.binding.tvNum.setVisibility(View.GONE);
                BADU.this.binding.tvClean.setVisibility(View.GONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null || bool.booleanValue()) {
                return;
            }
            BADU.this.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements OnItemChildClickListener {

        /* loaded from: classes2.dex */
        class a implements Runnable {
            final /* synthetic */ cc a;

            a(cc ccVar) {
                this.a = ccVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                hb_NotificationListUtils.getInstance().i(this.a);
            }
        }


        @Override // defpackage.cy1
        public void onItemChildClick(@NonNull BaseQuickAdapter<?, ?> baseQuickAdapter, @NonNull View view, int i) {
            if (view.getId() == R.id.cl_item) {
//                i4.a().i("c_ncleaner_list").commit();
                cc ccVar = (cc) baseQuickAdapter.getData().get(i);
                if (ccVar != null) {
                    try {
                        PendingIntent pendingIntent = ccVar.pendingIntent;
                        if (pendingIntent != null) {
                            pendingIntent.send();
                            BADU.this.binding.rvNotification.postDelayed(new a(ccVar), 300L);
                        }
                    } catch (PendingIntent.CanceledException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void bindData() {
        LiveEventBus.get("notification_clean_event", Integer.class).observe(this, new a());
        LiveEventBus.get("notification_set_event", Boolean.class).observe(this, new b());
        this.adapter = new BABN(R.layout.item_notification_clean);
        this.binding.rvNotification.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<cc> e = hb_NotificationListUtils.getInstance().getList();

        L.e("Notification-BADU", "bindData e.size=" + e.size());

        this.adapter.setNewInstance(e);
        this.adapter.setEmptyView(View.inflate(getContext(), R.layout.layout_empty_notification, null));
        this.binding.rvNotification.setAdapter(this.adapter);
        if (e != null && e.size() > 0) {
            this.binding.tvNum.setVisibility(View.VISIBLE);
            this.binding.tvNum.setText(getString(R.string.junk_notification_num, e.size() + ""));
            this.binding.tvClean.setVisibility(View.VISIBLE);
        } else {
            this.binding.tvNum.setVisibility(View.GONE);
            this.binding.tvClean.setVisibility(View.GONE);
        }
        this.adapter.addChildClickViewIds(R.id.cl_item);
        this.adapter.setOnItemChildClickListener((OnItemChildClickListener) new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        hb_NotificationListUtils.getInstance().clear();
        LiveEventBus.get("resident_update_event").post(Boolean.TRUE);
        this.adapter.getData().clear();
        this.adapter.notifyDataSetChanged();
        ArrayList<cc> e = hb_NotificationListUtils.getInstance().getList();
        BABN babn = this.adapter;
        if (babn != null && babn.getData().size() > 0) {
            this.binding.tvNum.setVisibility(View.VISIBLE);
            this.binding.tvNum.setText(getString(R.string.junk_notification_num, e.size() + ""));
            this.binding.tvClean.setVisibility(View.VISIBLE);
            return;
        }
        this.binding.tvNum.setVisibility(View.GONE);
        this.binding.tvClean.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Fragment lambda$onClick$0() {
        return BAEY.newInstance(FuncFinishTitleModel.NotificationClean.setExtras(this.cleanNum));
    }

    public static BADU newInstance() {
        return new BADU();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentNotificationCleanBinding fragmentNotificationCleanBinding = this.binding;
        if (view == fragmentNotificationCleanBinding.icBack) {
//            i4.a().i("c_ncleaner_list_back").commit();
            finishActivity();
            return;
        }
        if (view == fragmentNotificationCleanBinding.tvClean) {
//            i4.a().i("c_ncleaner_list_clean").commit();
//            i4.a().i("s_ncleaner_list_clean_animation").commit();
            this.mIsClearNotification = true;
            clean();
            replaceFragment(new JunCleanAnimFragment.b().b(new JunCleanAnimFragment.b.a() { // from class: cf
                @Override // bfj.ckdk.wazpqdu.cjzk.vpfgiz.sosrd.BADL.b.a
                public final Object a() {
                    Fragment lambda$onClick$0;
                    lambda$onClick$0 = BADU.this.lambda$onClick$0();
                    return lambda$onClick$0;
                }
            }).a());
            return;
        }
        if (view == fragmentNotificationCleanBinding.ivSetting) {
//            i4.a().i("c_ncleaner_list_setting").commit();
            startActivity(new Intent(getContext(), (Class<?>) BAAZ.class));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        this.binding = FragmentNotificationCleanBinding.inflate(layoutInflater, viewGroup, false);
//        i4.a().i("s_ncleaner_list").commit();
        this.binding.icBack.setOnClickListener(this);
        this.binding.tvClean.setOnClickListener(this);
        this.binding.ivSetting.setOnClickListener(this);
        bindData();
//        qh.c();
        return this.binding.getRoot();
    }
}