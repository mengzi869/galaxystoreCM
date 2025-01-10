package com.clean888.cleansuper.cleaner.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.clean888.cleansuper.cleaner.databinding.FragmentAnimBoostBinding;
import java.util.List;

import com.clean888.cleansuper.cleaner.utils.bi;


/* loaded from: classes2.dex */
public class BADJ extends BaseFragment implements View.OnClickListener {
    private long INTERVAL_TIME;
    private FragmentAnimBoostBinding binding;
    protected b.a<b.InterfaceC0085b> finishCallback;
    private int index;
    protected List<c> infos;
    protected b.a<Fragment> nextFragment;
    protected b.a<Intent> nextIntent;
    private long showAllTime;
    private final long showAllTime_MAX;
    private bi updateAnim;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements bi.a {
        a() {
        }

        @Override // bi.a
        public void a() {
            BADJ.this.ChangeIcon();
        }

        @Override // bi.a
        public void b() {
            if (BADJ.this.isAdded() && BADJ.this.isVisible()) {
                BADJ.this.ChangeIcon();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        protected List<c> a;
        protected a<Fragment> b;
        protected a<Intent> c;
        protected a<InterfaceC0085b> d;
        protected long e = -1;

        /* loaded from: classes2.dex */
        public interface a<T> {
            T a();
        }

        /* renamed from: bfj.ckdk.wazpqdu.cjzk.vpfgiz.kxhzls.BADJ$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0085b {
            void a(Fragment fragment);
        }

        public BADJ a() {
            return new BADJ(this, null);
        }

        public b b(a<InterfaceC0085b> aVar) {
            this.d = aVar;
            return this;
        }

        public b c(a<Fragment> aVar) {
            this.b = aVar;
            return this;
        }

        public b d(List<c> list) {
            this.a = list;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public Drawable a;
        public String b;
        public String c;
    }

    /* synthetic */ BADJ(b bVar, a aVar) {
        this(bVar);
    }

    private void BindVM() {
        this.index = 0;
        List<c> list = this.infos;
        if (list != null && list.size() > 0) {
            bi biVar = new bi();
            this.updateAnim = biVar;
            biVar.b(new a());
            this.updateAnim.d(this.infos.size()).e(this.showAllTime).f(new LinearInterpolator()).c();
        }
        this.binding.getRoot().postDelayed(new Runnable() { // from class: nd
            @Override // java.lang.Runnable
            public final void run() {
                BADJ.this.OnAnimShowFinish();
            }
        }, this.showAllTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ChangeIcon() {
        this.binding.cenIcon.post(new Runnable() { // from class: od
            @Override // java.lang.Runnable
            public final void run() {
                BADJ.this.lambda$ChangeIcon$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnAnimShowFinish() {
        Intent a2;
        Fragment a3;
        b.InterfaceC0085b a4;
        if (checkFragmentAlive()) {
            b.a<b.InterfaceC0085b> aVar = this.finishCallback;
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

    private Drawable getNextDrawable() {
        try {
            List<c> list = this.infos;
            if (list == null || list.size() <= 0) {
                return null;
            }
            if (this.index >= this.infos.size()) {
                this.index = -1;
            }
            if (this.index < 0) {
                this.index = 0;
            }
            Drawable drawable = this.infos.get(this.index).a;
            this.index++;
            return drawable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ChangeIcon$0() {
        Drawable nextDrawable = getNextDrawable();
        if (nextDrawable != null) {
            this.binding.cenIcon.setImageDrawable(nextDrawable);
        }
    }

    private static BADJ newInstance(b bVar) {
        return new BADJ(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(false);
        this.binding = FragmentAnimBoostBinding.inflate(layoutInflater);
        BindVM();
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        bi biVar = this.updateAnim;
        if (biVar != null) {
            biVar.a();
        }
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private BADJ(b bVar) {
        this.index = -1;
        this.showAllTime_MAX = 3000L;
        this.showAllTime = 3000L;
        this.INTERVAL_TIME = 300L;
        if (bVar != null) {
            List<c> list = bVar.a;
            this.infos = list;
            this.nextFragment = bVar.b;
            this.nextIntent = bVar.c;
            this.finishCallback = bVar.d;
            if (list != null && list.size() > 0) {
                this.showAllTime = this.infos.size() * this.INTERVAL_TIME;
            }
            long j = bVar.e;
            if (j > 0) {
                this.showAllTime = j;
            }
        }
    }

    public BADJ() {
        this.index = -1;
        this.showAllTime_MAX = 3000L;
        this.showAllTime = 3000L;
        this.INTERVAL_TIME = 300L;
    }
}