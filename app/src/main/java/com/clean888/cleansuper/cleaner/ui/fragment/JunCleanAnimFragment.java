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

import com.clean888.cleansuper.cleaner.databinding.FragmentJunCleanAnimBinding;

//BADL
public class JunCleanAnimFragment extends BaseFragment{
    private FragmentJunCleanAnimBinding binding;
    protected b.a<b.InterfaceC0086b> finishCallback;
    protected b.a<Fragment> nextFragment;
    protected b.a<Intent> nextIntent;
    private long showAllTime;
    private final long showAllTime_MAX;

    /* loaded from: classes2.dex */
    public static class b {
        protected a<Fragment> a;
        protected a<Intent> b;
        protected a<InterfaceC0086b> c;
        protected long d = -1;

        /* loaded from: classes2.dex */
        public interface a<T> {
            T a();
        }

        /* renamed from: bfj.ckdk.wazpqdu.cjzk.vpfgiz.sosrd.BADL$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0086b {
            void a(Fragment fragment);
        }

        public JunCleanAnimFragment a() {
            return new JunCleanAnimFragment(this);
        }

        public b b(a<Fragment> aVar) {
            this.a = aVar;
            return this;
        }
    }

    private void BindVM() {
        this.binding.getRoot().postDelayed(new Runnable() { // from class: qd
            @Override // java.lang.Runnable
            public final void run() {
                JunCleanAnimFragment.this.OnAnimShowFinish();
            }
        }, this.showAllTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnAnimShowFinish() {
        Intent a2;
        Fragment a3;
        b.InterfaceC0086b a4;
        if (checkFragmentAlive()) {
            b.a<b.InterfaceC0086b> aVar = this.finishCallback;
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
    }

    private static JunCleanAnimFragment newInstance(b bVar) {
        return new JunCleanAnimFragment(bVar);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(false);
        this.binding = FragmentJunCleanAnimBinding.inflate(layoutInflater);
        BindVM();
        return this.binding.getRoot();
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private JunCleanAnimFragment(b bVar) {
        this.showAllTime_MAX = 5000L;
        this.showAllTime = 5000L;
        if (bVar != null) {
            this.nextFragment = bVar.a;
            this.nextIntent = bVar.b;
            this.finishCallback = bVar.c;
            long j = bVar.d;
            if (j > 0) {
                this.showAllTime = j;
            }
        }
    }

    public JunCleanAnimFragment() {
        this.showAllTime_MAX = 5000L;
        this.showAllTime = 5000L;
    }
}