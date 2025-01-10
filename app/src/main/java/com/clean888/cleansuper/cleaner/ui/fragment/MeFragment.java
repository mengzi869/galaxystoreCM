package com.clean888.cleansuper.cleaner.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentMeBinding;
import com.clean888.cleansuper.cleaner.utils.BAFC;
import com.clean888.cleansuper.cleaner.ui.ViewModel.MeViewModel;
import com.clean888.cleansuper.cleaner.ui.activity.SettingsActivity;
import com.clean888.cleansuper.cleaner.ui.activity.AboutUsActivity;

public class MeFragment extends BaseFragment implements View.OnClickListener {
    private FragmentMeBinding binding;
    private MeViewModel meViewModel;
    private BroadcastReceiver timeTickReceiver = new TimeTickReceiver();

    public class TimeTickReceiver extends BroadcastReceiver {
        TimeTickReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (MeFragment.this.getActivity() == null || MeFragment.this.getActivity().isFinishing() || MeFragment.this.isDetached() || MeFragment.this.isRemoving()) {
                return;
            }
            AppCompatTextView appCompatTextView = MeFragment.this.binding.days;
            appCompatTextView.post(new Runnable() {
                @Override
                public final void run() {
                    refreshDay();
                }
            });
        }
    }

    public void refreshDay() {
        if (checkFragmentAlive()) {
            int installDay = this.meViewModel.getInstallDay();
            String string = getContext().getString(R.string.main_me_has_protected_you_for);
            this.binding.days.setText(new BAFC().a(string).a(" " + installDay + " ").i(getContext().getResources().getColor(R.color.colorPrimary)).a(getContext().getString(R.string.main_me_days)).f());
        }
    }

    @Override
    public void onClick(View view) {
//        ol0 i = i4.a().i("c_me");
        FragmentMeBinding fragmentMeBinding = this.binding;
        if (view == fragmentMeBinding.cardPrivacyPolicy) {
            this.meViewModel.goPrivacyPolicy(getContext());
//            i.putEbKey1(1).commit();
//            i4.a().i("c_me_policy").commit();
            return;
        }
        if (view == fragmentMeBinding.cardTermsOfService) {
            this.meViewModel.goTermsOfService(getContext());
//            i.putEbKey1(2).commit();
//            i4.a().i("c_me_terms").commit();
        } else if (view == fragmentMeBinding.cardSettings) {
            startActivity(new Intent(getContext(), (Class<?>) SettingsActivity.class));
//            i.putEbKey1(3).commit();
//            i4.a().i("c_me_settings").commit();
        } else if (view == fragmentMeBinding.cardAbout) {
            startActivity(new Intent(getContext(), (Class<?>) AboutUsActivity.class));
//            i.putEbKey1(4).commit();
//            i4.a().i("c_me_about").commit();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.meViewModel = (MeViewModel) new ViewModelProvider(this).get(MeViewModel.class);
        FragmentMeBinding inflate = FragmentMeBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        inflate.cardPrivacyPolicy.setOnClickListener(this);
        this.binding.cardTermsOfService.setOnClickListener(this);
        this.binding.cardSettings.setOnClickListener(this);
        this.binding.cardAbout.setOnClickListener(this);
//        i4.a().i("s_me").commit();
        if (Build.VERSION.SDK_INT >= 26) {
            getContext().registerReceiver(this.timeTickReceiver, new IntentFilter("android.intent.action.TIME_TICK"), Context.RECEIVER_EXPORTED);
        } else {
            getContext().registerReceiver(this.timeTickReceiver, new IntentFilter("android.intent.action.TIME_TICK"));
        }
        refreshDay();
        return this.binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
        getContext().unregisterReceiver(this.timeTickReceiver);
    }

    @Override
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
//        i4.a().i("s_me").commit();
    }


}
