package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.clean888.cleansuper.cleaner.utils.b91;
import com.clean888.cleansuper.cleaner.utils.bc;
import com.clean888.cleansuper.cleaner.utils.gm;
import com.clean888.cleansuper.cleaner.utils.l81;
import com.clean888.cleansuper.cleaner.utils.va2;
import com.clean888.cleansuper.cleaner.utils.wa2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LargeFileAnimScanVM extends AndroidViewModel {
    private List<bc> listData;
    private boolean reScan;
    private va2 scanListener;
    private List<gm> tempItem;
    private long tempSize;
    public MutableLiveData<Integer> v_cleanState;
    public MutableLiveData<Long> v_junkSize;
    public MutableLiveData<List<bc>> v_listData;
    public MutableLiveData<Boolean> v_zroAutoJumpFinish;

    /* loaded from: classes2.dex */
    class a extends wa2 {
        a() {
        }

        @Override // defpackage.wa2, defpackage.va2
        public void d(long j) {
            LargeFileAnimScanVM.this.v_junkSize.postValue(Long.valueOf(j));
        }

        @Override // defpackage.wa2, defpackage.va2
        public void e(int i, gm gmVar) {
            LargeFileAnimScanVM.this.v_junkSize.postValue(Long.valueOf(l81.y().B()));
            LargeFileAnimScanVM.access$114(LargeFileAnimScanVM.this, gmVar.c());
            LargeFileAnimScanVM.this.tempItem.add(gmVar);
            bc bcVar = new bc(gmVar, new b91(LargeFileAnimScanVM.this.tempSize, LargeFileAnimScanVM.this.tempItem, 1007));
            bcVar.c = true;
            LargeFileAnimScanVM.this.listData.add(bcVar);
            LargeFileAnimScanVM largeFileAnimScanVM = LargeFileAnimScanVM.this;
            largeFileAnimScanVM.v_listData.postValue(largeFileAnimScanVM.listData);
        }

        @Override // defpackage.wa2, defpackage.va2
        public void f(b91... b91VarArr) {
            List<? extends gm> list;
            LargeFileAnimScanVM.this.listData = new ArrayList();
            List<b91> A = l81.y().A();
            long B = l81.y().B();
            if (A != null) {
                for (b91 b91Var : A) {
                    if (b91Var != null) {
                        long j = b91Var.a;
                        if (j > 0 && (list = b91Var.c) != null) {
                            b91Var.b = j;
                            Iterator<? extends gm> it = list.iterator();
                            while (it.hasNext()) {
                                LargeFileAnimScanVM.this.listData.add(new bc(it.next(), b91Var));
                            }
                        }
                    }
                }
            }
            if (B > 0 && LargeFileAnimScanVM.this.listData.size() > 0) {
                LargeFileAnimScanVM.this.v_cleanState.postValue(1);
                LargeFileAnimScanVM largeFileAnimScanVM = LargeFileAnimScanVM.this;
                largeFileAnimScanVM.v_listData.postValue(largeFileAnimScanVM.listData);
                return;
            }
            LargeFileAnimScanVM.this.v_zroAutoJumpFinish.postValue(Boolean.TRUE);
        }

        @Override // defpackage.wa2, defpackage.va2
        public void i() {
            LargeFileAnimScanVM.this.v_cleanState.postValue(0);
            LargeFileAnimScanVM.this.v_junkSize.postValue(0L);
            LargeFileAnimScanVM.this.tempItem = new ArrayList();
            LargeFileAnimScanVM.this.tempSize = 0L;
            LargeFileAnimScanVM.this.listData = new ArrayList();
            LargeFileAnimScanVM largeFileAnimScanVM = LargeFileAnimScanVM.this;
            largeFileAnimScanVM.v_listData.postValue(largeFileAnimScanVM.listData);
        }
    }

    public LargeFileAnimScanVM(@NonNull Application application) {
        super(application);
        this.v_junkSize = new MutableLiveData<>();
        this.v_cleanState = new MutableLiveData<>();
        this.v_zroAutoJumpFinish = new MutableLiveData<>();
        this.v_listData = new MutableLiveData<>();
        this.listData = new ArrayList();
        this.tempItem = new ArrayList();
        this.scanListener = new a();
    }

    static /* synthetic */ long access$114(LargeFileAnimScanVM largeFileAnimScanVM, long j) {
        long j2 = largeFileAnimScanVM.tempSize + j;
        largeFileAnimScanVM.tempSize = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        l81.y().h(this.scanListener);
        l81.y().l();
    }

    public void onCreate(boolean z) {
//        ag.a(1001);
        this.reScan = z;
        this.v_junkSize.postValue(0L);
        if (z) {
            l81.y().d(this.scanListener, false);
            l81.y().k();
        } else {
            l81.y().d(this.scanListener, true);
            if (l81.y().D()) {
                return;
            }
            l81.y().i();
        }
    }

}
