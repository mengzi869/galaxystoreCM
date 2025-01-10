package com.clean888.cleansuper.cleaner.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.clean888.cleansuper.cleaner.databinding.FragmentNotificationCleanIntroBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.ui.activity.BAAX;
import com.clean888.cleansuper.cleaner.utils.jc;
import com.clean888.cleansuper.cleaner.utils.a_NotificationUtils;


/* loaded from: classes2.dex */
public class BADV extends BaseFragment implements View.OnClickListener {
    private FragmentNotificationCleanIntroBinding binding;

    public static BADV newInstance() {
        return new BADV();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentNotificationCleanIntroBinding fragmentNotificationCleanIntroBinding = this.binding;
        if (view == fragmentNotificationCleanIntroBinding.icBack) {
//            i4.a().i("c_ncleaner_back").commit();
            finishActivity();
        } else if (view == fragmentNotificationCleanIntroBinding.tvClean) {
//            i4.a().i("c_ncleaner_clean").commit();
            a_NotificationUtils.e(getContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        this.binding = FragmentNotificationCleanIntroBinding.inflate(layoutInflater, viewGroup, false);
//        i4.a().i("s_ncleaner_intro").commit();
        this.binding.icBack.setOnClickListener(this);
        this.binding.tvClean.setOnClickListener(this);
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (jc.b()) {
            a_mmkv.h().F(true);
            Intent intent = new Intent(getContext(), (Class<?>) BAAX.class);
            intent.putExtra(MainActivity.FROM, MainActivity.FROM_8);
            startActivity(intent);
            finishActivity();
        }
    }
}