package com.clean888.cleansuper.cleaner.ui.fragment.lamp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentLampBinding;
import com.clean888.cleansuper.cleaner.ui.activity.BAAE;
import com.clean888.cleansuper.cleaner.ui.activity.BAFT;
import com.clean888.cleansuper.cleaner.ui.fragment.BaseFragment;

/* loaded from: classes2.dex */
public class BAFL extends BaseFragment {
    private FragmentLampBinding binding;
    private boolean isOpenLamp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
//            i4.a().i("c_flashlight_back").commit();
            BAFL.this.finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BAFL.this.requestPermission(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements BAFT.b {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFT.b
        public void a() {
            if (this.a) {
                BAFL.this.isOpenLamp = true;
                BAFL.this.lampOn();
                BAAE.isLamp = true;
                return;
            }
            if (BAFL.this.isOpenLamp) {
                BAFL.this.lampOff();
                BAAE.isLamp = false;
            } else {
                BAFL.this.lampOn();
                BAAE.isLamp = true;
            }
            BAFL bafl = BAFL.this;
            bafl.isOpenLamp = true ^ bafl.isOpenLamp;
        }

        @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFT.b
        public void b(int[] iArr) {
        }
    }

    private void bindData() {
        this.binding.back.setOnClickListener(new a());
        this.binding.ivLamp.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lampOff() {
        zc.a().d(false);
        this.binding.ivLamp.setImageResource(R.mipmap.img_lamp_off);
//        i4.a().i("c_flashlight_turnoff").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lampOn() {
        zc.a().d(true);
        this.binding.ivLamp.setImageResource(R.mipmap.img_lamp_on);
//        i4.a().i("c_flashlight_turnon").commit();
    }

    public static BAFL newInstance() {
        return new BAFL();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.binding = FragmentLampBinding.inflate(layoutInflater, viewGroup, false);
        statusBarTextDarkLight(false);
        bindData();
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        zc.a().c();
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
//            i4.a().i("c_flashlight_back").commit();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        zc.a().b(getContext());
        requestPermission(true);
    }

    public void requestPermission(boolean z) {
        ((BAAE) requireActivity()).performRequestPermissions(getString(R.string.permission_content), new String[]{"android.permission.CAMERA"}, 1, new c(z));
    }
}
