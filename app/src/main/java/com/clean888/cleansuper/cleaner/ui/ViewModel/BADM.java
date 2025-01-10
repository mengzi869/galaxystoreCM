package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.clean888.cleansuper.cleaner.utils.b91;
import com.clean888.cleansuper.cleaner.utils.h91;
//import com.clean888.cleansuper.cleaner.ui.Utils.qm;
import com.clean888.cleansuper.cleaner.utils.va2;
import com.clean888.cleansuper.cleaner.utils.wa2;
import com.clean888.cleansuper.cleaner.utils.tb;
import com.clean888.cleansuper.cleaner.ui.adapter.pb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class BADM extends AndroidViewModel {
    private List<pb> cleanTypeList;
    private va2 scanListener;
    private List<BaseNode> selectGroupList;
    private pb type_junkAD;
    private pb type_junkApk;
    private pb type_junkCache;
    private pb type_junkLog;
    private pb type_junkResidual;
    private pb type_junkSystemCache;
    private pb type_junkTemp;
    public MutableLiveData<Integer> v_cleanState;
    public MutableLiveData<List<pb>> v_cleanTypeList;
    public MutableLiveData<Long> v_junkSize;
    public MutableLiveData<List<BaseNode>> v_selectGroupList;
    public MutableLiveData<Boolean> v_zroAutoJumpFinish;

    /* loaded from: classes2.dex */
    class a extends wa2 {
        a() {
        }

        @Override // defpackage.wa2, defpackage.va2
        public void d(long j) {
            BADM.this.v_junkSize.postValue(Long.valueOf(j));
        }

        @Override // defpackage.wa2, defpackage.va2
        public void f(b91... b91VarArr) {
            BADM.this.selectGroupList = new ArrayList();
            List<b91> S = h91.Q().S();
            long T = h91.Q().T();
            if (S != null) {
                for (b91 b91Var : S) {
                    if (b91Var != null && b91Var.a > 0) {
                        BADM.this.selectGroupList.add(new tb(b91Var));
                    }
                }
            }
            if (T > 0 && !BADM.this.selectGroupList.isEmpty()) {
                BADM.this.v_cleanState.postValue(1);
                BADM badm = BADM.this;
                badm.v_selectGroupList.postValue(badm.selectGroupList);
                return;
            }
            BADM.this.v_zroAutoJumpFinish.postValue(Boolean.TRUE);
        }

        @Override // defpackage.wa2, defpackage.va2
        public void h(long j) {
            super.h(j);
            BADM.this.v_junkSize.postValue(Long.valueOf(j));
        }

        @Override // defpackage.wa2, defpackage.va2
        public void i() {
            BADM.this.v_cleanState.postValue(0);
            BADM.this.v_junkSize.postValue(0L);
        }

        @Override // defpackage.wa2, defpackage.va2
        public void j(int i, b91 b91Var) {
            if (i != 100) {
                switch (i) {
                    case 1001:
                        BADM.this.type_junkAD.c(true);
                        break;
                    case 1002:
                        BADM.this.type_junkLog.c(true);
                        break;
                    case 1003:
                        BADM.this.type_junkTemp.c(true);
                        break;
                    case 1004:
                        BADM.this.type_junkResidual.c(true);
                        break;
                    case 1005:
                        BADM.this.type_junkCache.c(true);
                        break;
                    case 1006:
                        BADM.this.type_junkApk.c(true);
                        break;
                }
            } else {
                BADM.this.type_junkSystemCache.c(true);
            }
            BADM badm = BADM.this;
            badm.v_cleanTypeList.postValue(badm.cleanTypeList);
        }
    }

    public BADM(@NonNull Application application) {
        super(application);
        this.v_junkSize = new MutableLiveData<>();
        this.v_cleanState = new MutableLiveData<>();
        this.v_zroAutoJumpFinish = new MutableLiveData<>();
        this.v_cleanTypeList = new MutableLiveData<>();
        this.cleanTypeList = new ArrayList();
        this.v_selectGroupList = new MutableLiveData<>();
        this.selectGroupList = new ArrayList();
        this.type_junkCache = new pb(10);
        this.type_junkResidual = new pb(20);
        this.type_junkAD = new pb(30);
        this.type_junkApk = new pb(40);
        this.type_junkTemp = new pb(50);
        this.type_junkLog = new pb(60);
        this.type_junkSystemCache = new pb(70);
        this.scanListener = new a();
    }

    private void InitCleanTypeList() {
        this.cleanTypeList.clear();
        this.cleanTypeList.add(this.type_junkSystemCache);
        this.cleanTypeList.add(this.type_junkCache);
        this.cleanTypeList.add(this.type_junkResidual);
        this.cleanTypeList.add(this.type_junkAD);
        this.cleanTypeList.add(this.type_junkApk);
        this.cleanTypeList.add(this.type_junkTemp);
        this.cleanTypeList.add(this.type_junkLog);
        Iterator<pb> it = this.cleanTypeList.iterator();
        while (it.hasNext()) {
            it.next().c(false);
        }
    }

    private void ShowCleanType() {
        this.v_cleanTypeList.setValue(this.cleanTypeList);
    }

    public void doCleanJunk() {
        h91.Q().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        h91.Q().j(this.scanListener);
        h91.Q().n();
    }

    public void onCreate() {
        InitCleanTypeList();
        ShowCleanType();
        this.v_junkSize.postValue(0L);
        h91.Q().c(this.scanListener);
        h91.Q().m();
    }
}