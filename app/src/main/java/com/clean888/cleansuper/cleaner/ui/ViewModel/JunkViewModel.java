package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
//import android.support.v4.media.session.PlaybackStateCompat;

import com.clean888.cleansuper.cleaner.utils.h91;
import com.clean888.cleansuper.cleaner.utils.l81;
import com.clean888.cleansuper.cleaner.utils.mr0;
import com.clean888.cleansuper.cleaner.utils.nr1;
import com.clean888.cleansuper.cleaner.utils.va2;
import com.clean888.cleansuper.cleaner.utils.md;
import com.clean888.cleansuper.cleaner.utils.ag;
import com.clean888.cleansuper.cleaner.utils.wa2;
import com.clean888.cleansuper.cleaner.utils.gm;
import com.clean888.cleansuper.cleaner.utils.b91;

import com.jeremyliao.liveeventbus.LiveEventBus;


public class JunkViewModel extends AndroidViewModel {

    private Observer<Integer> hotCall;
    private md junSizeAnim;
    private long junSizeStateFull;
    private nr1.b memorycall;
    private va2 scanBigFile;
    private va2 scanJunk;
    private md.c sizeJunkAnimCall;

    public MutableLiveData<String> v_junkSize;
    public MutableLiveData<String> v_junkSizeUnit;
    public MutableLiveData<Boolean> v_junkStateFull;
    public MutableLiveData<String> v_largeFileSize;
    public MutableLiveData<Boolean> v_large_file_hot;
    public MutableLiveData<String> v_memSize;
    public MutableLiveData<Boolean> v_memSizeHigh;

    class a extends wa2 {
        a() {
        }

        @Override // defpackage.wa2, defpackage.va2
        public void a() {
            super.a();
            JunkViewModel.this.postBigFileSize();
        }

        @Override // defpackage.wa2, defpackage.va2
        public void e(int i, gm gmVar) {
            super.e(i, gmVar);
            JunkViewModel.this.postBigFileSize();
        }

        @Override // defpackage.wa2, defpackage.va2
        public void f(b91... b91VarArr) {
            super.f(b91VarArr);
            JunkViewModel.this.postBigFileSize();
        }

        @Override // defpackage.wa2, defpackage.va2
        public void g(b91 b91Var) {
            super.g(b91Var);
            JunkViewModel.this.postBigFileSize();
        }
    }

    /* loaded from: classes2.dex */
    class b extends wa2 {
        b() {
        }

        @Override // defpackage.wa2, defpackage.va2
        public void h(long j) {
            super.h(j);
            JunkViewModel.this.postJunkSize();
        }
    }

    /* loaded from: classes2.dex */
    class c implements Observer<Integer> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num != null) {
                JunkViewModel.this.checkHot(num.intValue());
            }
        }
    }

    public JunkViewModel(@NonNull Application application) {
        super(application);

        this.v_memSize = new MutableLiveData<>();
        this.v_largeFileSize = new MutableLiveData<>();
        this.v_memSizeHigh = new MutableLiveData<>();
        this.v_junkStateFull = new MutableLiveData<>();
        this.v_junkSize = new MutableLiveData<>();
        this.v_junkSizeUnit = new MutableLiveData<>();
        this.v_large_file_hot = new MutableLiveData<>();
        this.junSizeStateFull = 1048576;//PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        this.memorycall = new nr1.b() { // from class: oh
            @Override // nr1.b
            public final void a(nr1.d dVar) {
                JunkViewModel.this.lambda$new$0(dVar);
            }
        };
        this.scanBigFile = new a();
        this.scanJunk = new b();
        this.sizeJunkAnimCall = new md.c() { // from class: lh
            @Override // md.c
            public final void OnSizeAnimUIUpdate(long j, long j2, long j3) {
                JunkViewModel.this.lambda$new$3(j, j2, j3);
            }
        };
        this.hotCall = new c();
        nr1.k().i(this.memorycall);
        this.junSizeAnim = new md.b().e(500L).d(this.sizeJunkAnimCall);
        LiveEventBus.get("ModuleUsedRecord_EVENT_USD_CHANGE", Integer.class).observeForever(this.hotCall);

    }

    public /* synthetic */ void lambda$new$3(final long j, long j2, long j3) {
        try {
            mr0.b((float) j, 2, new mr0.a() { // from class: nh
                @Override // mr0.a
                public final void a(String str, String str2, String str3) {
                    JunkViewModel.this.lambda$new$2(j, str, str2, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public /* synthetic */ void lambda$new$2(long j, String str, String str2, String str3) {
        this.v_junkSize.postValue(str2);
        this.v_junkSizeUnit.postValue(str3);
        this.v_junkStateFull.postValue(Boolean.valueOf(j >= this.junSizeStateFull));
    }

    public /* synthetic */ void lambda$new$0(nr1.d dVar) {
        if (dVar != null) {
            this.v_memSize.postValue(dVar.d + "%");
            this.v_memSizeHigh.postValue(Boolean.valueOf(dVar.d >= 70));
        }
    }
    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        nr1.k().r(this.memorycall);
        l81.y().h(this.scanBigFile);
        h91.Q().j(this.scanJunk);
        this.junSizeAnim.e();
        LiveEventBus.get("ModuleUsedRecord_EVENT_USD_CHANGE", Integer.class).removeObserver(this.hotCall);
    }

    public void onCreate() {
        nr1.k().g(this.memorycall);
        postBigFileSize(true);
        l81.y().c(this.scanBigFile);
        postJunkSize(true);
        h91.Q().c(this.scanJunk);
        checkHot(1001);
    }
    public void checkHot(int i) {
        if (1001 == i) {
            this.v_large_file_hot.postValue(Boolean.valueOf(ag.b(1001) == 0));
        }
    }

    public void postJunkSize() {
        postJunkSize(false);
    }

    private void postJunkSize(boolean z) {
        long T = h91.Q().T();
        if (z) {
            long R = h91.Q().R();
            if (R > 0) {
                T = R;
            }
        }
        if (h91.Q().X()) {
            T = h91.Q().V();
        }
        md mdVar = this.junSizeAnim;
        if (mdVar != null) {
            mdVar.c(T);
        }
    }

    public void postBigFileSize() {
        postBigFileSize(false);
    }

    private void postBigFileSize(boolean z) {
        Log.d("largeFile","postBigFileSize begin");

        long B = l81.y().B();
        if (z) {
            long z2 = l81.y().z();
            if (z2 > 0) {
                B = z2;
            }
        }
        if (B <= 0) {
            Log.d("largeFile","postBigFileSize B < 0");
            this.v_largeFileSize.postValue(" ? GB ");
        } else {
            mr0.b((float) B, 2, new mr0.a() { // from class: mh
                @Override // mr0.a
                public final void a(String str, String str2, String str3) {
                    Log.d("largeFile",str + " " + str2 + " " + str3);
                    JunkViewModel.this.lambda$postBigFileSize$1(str, str2, str3);
                }
            });
        }
    }

    public /* synthetic */ void lambda$postBigFileSize$1(String str, String str2, String str3) {
        this.v_largeFileSize.postValue(str2 + " " + str3);
    }

}
