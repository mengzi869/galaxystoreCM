package com.clean888.cleansuper.cleaner.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.clean888.cleansuper.cleaner.databinding.FragmentDeepCleanGuideBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;

//BAFY
public class DeepCleanGuideFragment extends BaseFragment implements View.OnClickListener {
    private FragmentDeepCleanGuideBinding binding;
    protected b.a<b.InterfaceC0083b> finishCallback;
    protected b.a<Fragment> nextFragment;
    protected b.a<Intent> nextIntent;
    private int pageFrom;

    /* loaded from: classes2.dex */
    public static class b {
        protected a<Fragment> a;
        protected a<Intent> b;
        protected a<InterfaceC0083b> c;

        /* loaded from: classes2.dex */
        public interface a<T> {
            T a();
        }

        /* renamed from: bfj.ckdk.wazpqdu.cjzk.bvmp.BAFY$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0083b {
            void a(Fragment fragment);
        }

        public DeepCleanGuideFragment a() {
            return new DeepCleanGuideFragment(this);
        }

        public b b(a<Fragment> aVar) {
            this.a = aVar;
            return this;
        }
    }

    void goNext() {
        Intent a2;
        Fragment a3;
        b.InterfaceC0083b a4;
        b.a<b.InterfaceC0083b> aVar = this.finishCallback;
        if (aVar != null && (a4 = aVar.a()) != null) {
            try {
                a4.a(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        b.a<Fragment> aVar2 = this.nextFragment;
        if (aVar2 != null && (a3 = aVar2.a()) != null) {
            replaceFragment(a3);
            return;
        }
        b.a<Intent> aVar3 = this.nextIntent;
        if (aVar3 != null && (a2 = aVar3.a()) != null) {
            startActivity(a2);
            finishActivity();
        } else {
            finishActivity();
        }
    }

    @Override
    public void onClick(View view) {
        FragmentDeepCleanGuideBinding fragmentDeepCleanGuideBinding = this.binding;
        if (view == fragmentDeepCleanGuideBinding.close) {
            if (this.pageFrom == 1) {
//                i4.a().i("c_first_scan_permission_n").commit();
            } else {
//                i4.a().i("c_scan_permission_n").commit();
            }
            finishActivity();
            return;
        }
        if (view == fragmentDeepCleanGuideBinding.button) {
            if (this.pageFrom == 1) {
//                i4.a().i("c_first_scan_permission_y").commit();
            } else {
//                i4.a().i("c_scan_permission_y").commit();
            }
            if (com.clean888.cleansuper.cleaner.utils.b.b()) {
                goNext();
            } else {
                com.clean888.cleansuper.cleaner.utils.b.a(getContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        FragmentDeepCleanGuideBinding inflate = FragmentDeepCleanGuideBinding.inflate(layoutInflater);
        this.binding = inflate;
        inflate.close.setOnClickListener(this);
        this.binding.button.setOnClickListener(this);
        int intExtra = getActivity().getIntent().getIntExtra(MainActivity.FROM, 0);
        this.pageFrom = intExtra;
        if (intExtra == 1) {
//            i4.a().i("s_first_scan_permission").commit();
        } else {
//            i4.a().i("s_scan_permission").commit();
        }
        return this.binding.getRoot();
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.pageFrom == 1) {
//                i4.a().i("c_first_scan_permission_n").commit();
            } else {
//                i4.a().i("c_scan_permission_n").commit();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
       /* if (z && bfj.ckdk.wazpqdu.cjzk.mhiggthrrh.b.b()) {
            goNext();
        }*/
    }

    private DeepCleanGuideFragment(b bVar) {
        if (bVar != null) {
            this.nextFragment = bVar.a;
            this.nextIntent = bVar.b;
            this.finishCallback = bVar.c;
        }
    }

    public DeepCleanGuideFragment() {
    }
}
