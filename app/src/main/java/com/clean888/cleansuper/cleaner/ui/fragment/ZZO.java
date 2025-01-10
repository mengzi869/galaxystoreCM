package com.clean888.cleansuper.cleaner.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.clean888.cleansuper.cleaner.databinding.FragmentScanResultBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.h91;
import com.clean888.cleansuper.cleaner.utils.mr0;

public class ZZO extends BaseFragment implements View.OnClickListener {
    private FragmentScanResultBinding binding;

    public /* synthetic */ void lambda$onCreateView$0(String str, String str2, String str3) {
        this.binding.size.setText(str2);
        this.binding.gb.setText(str3);
    }

    public static ZZO newInstance() {
        return new ZZO();
    }

    void goClean() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) MainActivity.class);
        intent.putExtra(MainActivity.FROM, 1);
        activity.startActivity(intent);
        activity.finish();
    }

    void goMain() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.startActivity(new Intent(activity, (Class<?>) MainActivity.class));
        activity.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentScanResultBinding fragmentScanResultBinding = this.binding;
        if (view == fragmentScanResultBinding.skip) {
            goMain();
//            i4.a().i("c_skipbutton").commit();
//            i4.a().i("c_first_scan_skip").commit();
        } else if (view == fragmentScanResultBinding.clean) {
            goClean();
//            i4.a().i("c_junkcleanbutton").commit();
//            i4.a().i("c_first_scan_clean").commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    @SuppressLint({"SetTextI18n"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        FragmentScanResultBinding inflate = FragmentScanResultBinding.inflate(layoutInflater);
        this.binding = inflate;
        inflate.skip.setOnClickListener(this);
        this.binding.clean.setOnClickListener(this);
        mr0.b((float) h91.Q().V(), 2, new mr0.a() { // from class: q43
            @Override // mr0.a
            public final void a(String str, String str2, String str3) {
                ZZO.this.lambda$onCreateView$0(str, str2, str3);
            }
        });
//        i4.a().i("s_first_scan_result").commit();
        return this.binding.getRoot();
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            goMain();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}