package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.clean888.cleansuper.cleaner.utils.b91;
import com.clean888.cleansuper.cleaner.utils.bc;
import com.clean888.cleansuper.cleaner.utils.gm;
import com.clean888.cleansuper.cleaner.utils.i81;
import com.clean888.cleansuper.cleaner.utils.l81;
import com.clean888.cleansuper.cleaner.utils.va2;
import com.clean888.cleansuper.cleaner.utils.wa2;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// BADS
public class LargeFileViewModel extends AndroidViewModel {
    private List<bc> listData;
    private Collator mCollator;
    private va2 scanListener;
    private boolean sortASC;
    private int sortFilterType;
    private int sortListType;
    private List<gm> tempItem;
    private long tempSize;
    public MutableLiveData<Integer> v_cleanState;
    public MutableLiveData<Long> v_junkSize;
    public MutableLiveData<List<bc>> v_listData;

    /* loaded from: classes2.dex */
    class a extends wa2 {
        a() {
        }

        @Override // defpackage.wa2, defpackage.va2
        public void d(long j) {
            LargeFileViewModel.this.v_junkSize.postValue(Long.valueOf(j));
        }

        @Override // defpackage.wa2, defpackage.va2
        public void e(int i, gm gmVar) {
            LargeFileViewModel.this.v_junkSize.postValue(Long.valueOf(l81.y().B()));
            LargeFileViewModel.access$114(LargeFileViewModel.this, gmVar.c());
            LargeFileViewModel.this.tempItem.add(gmVar);
            bc bcVar = new bc(gmVar, new b91(LargeFileViewModel.this.tempSize, LargeFileViewModel.this.tempItem, 1007));
            bcVar.c = true;
            LargeFileViewModel.this.listData.add(bcVar);
            LargeFileViewModel bads = LargeFileViewModel.this;
            bads.v_listData.postValue(bads.listData);
        }

        @Override // defpackage.wa2, defpackage.va2
        public void f(b91... b91VarArr) {
            List<? extends gm> list;
            LargeFileViewModel.this.listData = new ArrayList();
            List<b91> A = l81.y().A();
            if (A != null) {
                for (b91 b91Var : A) {
                    if (b91Var != null) {
                        long j = b91Var.a;
                        if (j > 0 && (list = b91Var.c) != null) {
                            b91Var.b = j;
                            Iterator<? extends gm> it = list.iterator();
                            while (it.hasNext()) {
                                LargeFileViewModel.this.listData.add(new bc(it.next(), b91Var));
                            }
                        }
                    }
                }
            }
            LargeFileViewModel.this.v_cleanState.postValue(1);
            LargeFileViewModel bads = LargeFileViewModel.this;
            bads.doSortList(bads.sortListType, LargeFileViewModel.this.sortASC, false);
            LargeFileViewModel bads2 = LargeFileViewModel.this;
            bads2.sortFilterAndPost(bads2.sortFilterType);
            LargeFileViewModel.this.v_junkSize.postValue(Long.valueOf(l81.y().B()));
        }

        @Override // defpackage.wa2, defpackage.va2
        public void i() {
            LargeFileViewModel.this.v_cleanState.postValue(0);
            LargeFileViewModel.this.v_junkSize.postValue(0L);
            LargeFileViewModel.this.tempItem = new ArrayList();
            LargeFileViewModel.this.tempSize = 0L;
            LargeFileViewModel.this.listData = new ArrayList();
            LargeFileViewModel bads = LargeFileViewModel.this;
            bads.v_listData.postValue(bads.listData);
        }
    }

    public LargeFileViewModel(@NonNull Application application) {
        super(application);
        this.v_junkSize = new MutableLiveData<>();
        this.v_cleanState = new MutableLiveData<>();
        this.v_listData = new MutableLiveData<>();
        this.listData = new ArrayList();
        this.tempItem = new ArrayList();
        this.sortFilterType = -1;
        this.sortListType = 1;
        this.sortASC = true;
        this.scanListener = new a();
    }

    static /* synthetic */ long access$114(LargeFileViewModel bads, long j) {
        long j2 = bads.tempSize + j;
        bads.tempSize = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSortList(int i, final boolean z, boolean z2) {
        if (i == 1) {
            if (z2 && i == this.sortListType && this.sortASC == z) {
                return;
            }
            this.sortListType = i;
            this.sortASC = z;
            try {
                List<bc> list = this.listData;
                if (list != null) {
                    synchronized (list) {
                        Collections.sort(this.listData, new Comparator() { // from class: we
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                int lambda$doSortList$0;
                                lambda$doSortList$0 = LargeFileViewModel.lambda$doSortList$0(z, (bc) obj, (bc) obj2);
                                return lambda$doSortList$0;
                            }
                        });
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (z2 && i == this.sortListType && this.sortASC == z) {
            return;
        }
        this.sortListType = i;
        this.sortASC = z;
        if (this.mCollator == null) {
            this.mCollator = Collator.getInstance();
        }
        List<bc> list2 = this.listData;
        if (list2 != null) {
            try {
                synchronized (list2) {
                    Collections.sort(this.listData, new Comparator() { // from class: ve
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int lambda$doSortList$1;
                            lambda$doSortList$1 = LargeFileViewModel.this.lambda$doSortList$1(z, (bc) obj, (bc) obj2);
                            return lambda$doSortList$1;
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$doSortList$0(boolean z, bc bcVar, bc bcVar2) {
        long c = bcVar2.a.c() - bcVar.a.c();
        if (c == 0) {
            return 0;
        }
        return (c <= 0 || !z) ? -1 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$doSortList$1(boolean z, bc bcVar, bc bcVar2) {
        try {
            return (z ? 1 : -1) * this.mCollator.compare(bcVar.a.a(), bcVar2.a.a());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void doCleanJunk() {
        l81.y().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        l81.y().h(this.scanListener);
        l81.y().l();
    }

    public void onCreate() {
        this.v_junkSize.postValue(0L);
        l81.y().c(this.scanListener);
        if (l81.y().D()) {
            return;
        }
        l81.y().i();
    }

    public void sortFilterAndPost(int i) {
        gm gmVar;
        gm gmVar2;
        if (this.listData != null) {
            this.sortFilterType = i;
            if (i < 0) {
                for (int i2 = 0; i2 < this.listData.size(); i2++) {
                    bc bcVar = this.listData.get(i2);
                    if (bcVar != null && (gmVar2 = bcVar.a) != null) {
                        gmVar2.j(true);
                        if (i2 == this.listData.size() - 1) {
                            bcVar.a();
                        }
                    }
                }
                this.v_listData.postValue(this.listData);
                l81.y().e();
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.listData.size(); i3++) {
                bc bcVar2 = this.listData.get(i3);
                if (bcVar2 != null && (gmVar = bcVar2.a) != null) {
                    gmVar.j(false);
                    if (i3 == this.listData.size() - 1) {
                        bcVar2.a();
                    }
                    if (i == ((i81) bcVar2.a).f) {
                        arrayList.add(bcVar2);
                    }
                }
            }
            this.v_listData.postValue(arrayList);
            l81.y().e();
        }
    }

    public void sortListAndPost(int i, boolean z) {
        doSortList(i, z, true);
        sortFilterAndPost(this.sortFilterType);
    }

}
