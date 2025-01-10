package com.clean888.cleansuper.cleaner.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.utils.a_NotificationUtils;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.md;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;
import com.clean888.cleansuper.cleaner.databinding.FragmentHomeBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAEX;
import com.clean888.cleansuper.cleaner.ui.ViewModel.JunkViewModel;
import com.clean888.cleansuper.cleaner.ui.activity.BAAF;
import com.clean888.cleansuper.cleaner.ui.activity.BAAX;
import com.clean888.cleansuper.cleaner.ui.activity.BAAY;
import com.clean888.cleansuper.cleaner.ui.activity.ZZT;
import com.clean888.cleansuper.cleaner.ui.activity.LargeFileCleanActivity;
import com.clean888.cleansuper.cleaner.ui.activity.PhoneBoostActivity;
import com.clean888.cleansuper.cleaner.service.BAAU;
//import com.clean888.overseas.topon.InterstitialAdHelper;
//import com.clean888.overseas.topon.RewardAdHelper;
import com.tencent.mmkv.MMKV;
import com.clean888.cleansuper.cleaner.ui.dialog.lf;

import java.util.HashMap;

// ZZG
public class HomeFragment extends BAFU implements View.OnClickListener{
    private FragmentHomeBinding binding;
    private BAEX functionVm;
    private JunkViewModel vm;
    private boolean inMemHighUI;
    private int checkAndGo = 0;
    private md fullAnim;


    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new lf(HomeFragment.this.getContext()).showAsDropDown(HomeFragment.this.binding.ivMore);
            MMKV h = MMKV.defaultMMKV();
            int firstCleanFinish = HomeFragment.this.functionVm.getFirstCleanFinish();
            BAEX unused = HomeFragment.this.functionVm;
            h.putInt(BAEX.FIRST_CLEAN_FINISH, firstCleanFinish + 1);
        }
    }

    private md.c fullAnimCall = new md.c() { // from class: d43
        @Override // md.c
        public final void OnSizeAnimUIUpdate(long j, long j2, long j3) {
            HomeFragment.this.lambda$new$6(j, j2, j3);
        }
    };

//    @SuppressLint("WrongConstant")
    public /* synthetic */ void lambda$new$6(long j, long j2, long j3) {
        float f = ((float) j) / 100.0f;
        float f2 = 1.0f - f;
        if (getActivity() == null || getActivity().isFinishing() || isDetached() || isRemoving()) {
            return;
        }
        try {
            this.binding.cleanAnimY.setAlpha(f);
            this.binding.cleanBtnY.setAlpha(f);
            this.binding.bg2.setAlpha(f);
            this.binding.cleanAnimB.setAlpha(f2);
            this.binding.cleanBtn.setAlpha(f2);
            this.binding.bg1.setAlpha(f2);
            int i = 4;
            this.binding.cleanAnimY.setVisibility(f == 0.0f ? View.INVISIBLE : View.VISIBLE);
            this.binding.cleanBtnY.setVisibility(f == 0.0f ? View.INVISIBLE : View.VISIBLE);
            this.binding.bg2.setVisibility(f == 0.0f ? View.INVISIBLE : View.VISIBLE);
            this.binding.cleanAnimB.setVisibility(f2 == 0.0f ? View.INVISIBLE : View.VISIBLE);
            this.binding.cleanBtn.setVisibility(f2 == 0.0f ? View.INVISIBLE : View.VISIBLE);
            AppCompatImageView appCompatImageView = this.binding.bg1;
            if (f2 != 0.0f) {
                i = 0;
            }
            appCompatImageView.setVisibility(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.checkAndGo = 0;
//        t4 a2 = i4.a();
//        ol0 i = a2.i("c_index");
        FragmentHomeBinding fragmentHomeBinding = this.binding;
        if (view != fragmentHomeBinding.cleanBtn && view != fragmentHomeBinding.cleanBtnY && view != fragmentHomeBinding.sizeTopClick) {
            if (view == fragmentHomeBinding.cardClean) {
//                i.putEbKey1(3).commit();
                this.checkAndGo = 2;
                checkPerSDToGo(true);
//                a2.i("c_home_largefile").commit();
                return;
            }
            if (view == fragmentHomeBinding.cardBoost) {
//                i.putEbKey1(2).commit();
                Intent intent = new Intent(getActivity(), (Class<?>) PhoneBoostActivity.class);
                intent.putExtra(MainActivity.FROM, 2);
                startActivity(intent);
//                a2.i("c_home_boost").commit();
                return;
            }
            if (view == fragmentHomeBinding.cardWallpaper) {
//                i4.a().i("c_home_quickboost").commit();
                BAAU.c(getActivity(), "2");
                return;
            }
            if (view == fragmentHomeBinding.ivMore) {
//                i4.a().i("c_home_widget").commit();
                startActivity(new Intent(getContext(), (Class<?>) BAAF.class));
                return;
            }
            if (view == fragmentHomeBinding.ivNotification) {
//                i4.a().i("c_moretools_ncleaner").commit();
                if (a_NotificationUtils.isEnable(SuperApplication.getContext())) {
                    Intent intent2 = new Intent(getContext(), (Class<?>) BAAX.class);
                    intent2.putExtra(MainActivity.FROM, MainActivity.FROM_8);
                    startActivity(intent2);
                    return;
                } else {
                    Intent intent3 = new Intent(getContext(), (Class<?>) BAAY.class);
                    intent3.putExtra(MainActivity.FROM, MainActivity.FROM_8);
                    startActivity(intent3);
                    return;
                }
            }
            return;
        }
//        i.putEbKey1(1).commit();
        this.checkAndGo = 1;
        checkPerSDToGo(true);
//        a2.i(view == this.binding.sizeTopClick ? "c_home_ball" : "c_home_clean").commit();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        this.vm = (JunkViewModel) viewModelProvider.get(JunkViewModel.class);
        this.functionVm = (BAEX) viewModelProvider.get(BAEX.class);
        statusBarTextDarkLight(true);
        this.binding = FragmentHomeBinding.inflate(layoutInflater, viewGroup, false);
//        i4.a().i("s_index").commit();
        BindVM();
        return this.binding.getRoot();
    }

    private void BindVM() {
        md d = new md.b().e(500L).d(this.fullAnimCall);
        this.fullAnim = d;
        d.d(0L);

        this.binding.cardWallpaper.setVisibility(View.INVISIBLE);
        this.binding.cleanBtn.setOnClickListener(this);
        this.binding.cleanBtn.setSelected(false);
        this.binding.cleanBtnY.setOnClickListener(this);
        this.binding.cleanBtnY.setSelected(true);
        this.binding.cardClean.setOnClickListener(this);
        this.binding.cardBoost.setOnClickListener(this);
        this.binding.sizeTopClick.setOnClickListener(this);
        this.binding.cardWallpaper.setOnClickListener(this);
        this.binding.ivMore.setOnClickListener(this);
        this.binding.ivNotification.setOnClickListener(this);

        this.vm.v_memSize.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String str) {
                HomeFragment.this.binding.cardBoostT2.setText(str);
            }
        });

        this.vm.v_largeFileSize.observe(getViewLifecycleOwner(), new Observer() { // from class: i43
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.binding.cardCleanT2.setText((String)obj);
                HomeFragment.this.binding.cardCleanT3.setVisibility(View.VISIBLE);
            }
        });


        this.vm.v_memSizeHigh.observe(getViewLifecycleOwner(), new Observer() { // from class: g43
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                Boolean bool = (Boolean)obj;
                if (!bool.booleanValue() || HomeFragment.this.inMemHighUI) {
                    bool.booleanValue();
                }
                HomeFragment.this.inMemHighUI = bool.booleanValue();
                HomeFragment.this.binding.cardBoostT2.setTextColor(getResources().getColor(bool.booleanValue() ? R.color.boost_home_high : R.color.boost_home_normal));

            }
        });
        this.vm.v_junkSize.observe(getViewLifecycleOwner(), new Observer() { // from class: j43
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.binding.size.setText((String) obj);
            }
        });
        this.vm.v_junkSizeUnit.observe(getViewLifecycleOwner(), new Observer() { // from class: k43
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.binding.sizeUnit.setText((String) obj);
            }
        });
        this.vm.v_junkStateFull.observe(getViewLifecycleOwner(), new Observer() { // from class: e43
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.changeJunkFullUI(((Boolean) obj).booleanValue());
            }
        });
        this.vm.v_large_file_hot.observe(getViewLifecycleOwner(), new Observer() { // from class: f43
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.this.changeHot(((Boolean) obj).booleanValue());
            }
        });
        HomeFragment.this.vm.onCreate();
    }

    public void changeJunkFullUI(boolean z) {
        if (checkFragmentAlive()) {
            this.fullAnim.c(z ? 100L : 0L);
        }
    }

    public void changeHot(boolean z) {
        if (checkFragmentAlive()) {
            this.binding.cardCleanPoint.setVisibility(z ? View.VISIBLE : View.GONE);
        }
    }

    private void checkPerSDToGo(boolean z) {
        checkStoragePermissionDialog(2, new Runnable() { // from class: l43
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.this.checkPerSDToGoImpl();
            }
        }, z);
    }

    public /* synthetic */ void checkPerSDToGoImpl() {
        int i = this.checkAndGo;
        if (i == 1) {
            Intent intent = new Intent(getActivity(), (Class<?>) ZZT.class);
            intent.putExtra(MainActivity.FROM, 2);
            startActivity(intent);
            this.checkAndGo = 0;
            return;
        }
        if (i == 2) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) LargeFileCleanActivity.class);
            intent2.putExtra(MainActivity.FROM, 2);
            startActivity(intent2);
            this.checkAndGo = 0;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshRedDot();
        if (this.functionVm.getFirstCleanFinish() == 1) {
            showWidgetDialog();
        }
    }

    private void refreshRedDot() {
        Math.abs(System.currentTimeMillis() - this.functionVm.getLastFinishTime(FuncFinishTitleModel.Antivirus));
    }

    private void showWidgetDialog() {
        AppCompatImageView appCompatImageView;
        if (getActivity() == null || (appCompatImageView = this.binding.ivMore) == null) {
            return;
        }
        appCompatImageView.postDelayed(new a(), 200L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        HashMap hashMap = new HashMap();
        hashMap.put("ext_key1", "na_5");
//        ai.f(ni.a().f(), false, this.binding.flContainer, hashMap, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFU
    public void onPerRequestBack(boolean z) {
        super.onPerRequestBack(z);
        if (!z) {
            this.checkAndGo = 0;
        } else {
            checkPerSDToGo(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
//        i4.a().i("s_index").commit();
        refreshRedDot();
        this.binding.cardWallpaper.setVisibility(a_mmkv.h().w() ? View.VISIBLE : View.GONE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
        md mdVar = this.fullAnim;
        if (mdVar != null) {
            mdVar.e();
        }
    }


    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
//        ai.a.b(ni.a().f());
    }



}
