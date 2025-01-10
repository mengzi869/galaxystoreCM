package com.clean888.cleansuper.cleaner.ui.ViewModel;


import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
//import defpackage.bb2;
//import defpackage.e6;
//import defpackage.q6;
//import defpackage.ub;
import com.clean888.cleansuper.cleaner.ui.listener.ScanRunningAppListener;
import com.clean888.cleansuper.cleaner.bean.BoostSelectItemBean;
import com.clean888.cleansuper.cleaner.bean.RunningAppBean;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.bb2;
import java.util.ArrayList;
import java.util.List;
public class PhoneBoostViewModel extends AndroidViewModel {
    private long appCnt;
    private long curSelectSize;
    private ScanRunningAppListener scanCallback;
    private bb2 scanMemory;
    private List<BoostSelectItemBean> selectItems;
    public MutableLiveData<Boolean> v_allSelect;
    public MutableLiveData<Long> v_appCnt;
    public MutableLiveData<Long> v_curSize;
    public MutableLiveData<BoostSelectItemBean> v_progressInfo;
    public MutableLiveData<List<BoostSelectItemBean>> v_resultList;
    public MutableLiveData<Integer> v_uistate;

    class ScanListener implements ScanRunningAppListener {
        ScanListener() {
        }

        @Override
        public void onApp(RunningAppBean app) {
            if (app != null) {
                L.d("PhoneBoostViewModel","onApp "+app);
                PhoneBoostViewModel.getAppCnt(PhoneBoostViewModel.this);
                PhoneBoostViewModel vm = PhoneBoostViewModel.this;
                vm.v_appCnt.postValue(Long.valueOf(vm.appCnt));
                PhoneBoostViewModel.getCurSelectSize(PhoneBoostViewModel.this, app.getAppMemoryInfo());
                PhoneBoostViewModel vm2 = PhoneBoostViewModel.this;
                vm2.v_curSize.postValue(Long.valueOf(vm2.curSelectSize));
                BoostSelectItemBean ubVar = new BoostSelectItemBean(app);
                ubVar.b = true;
                PhoneBoostViewModel.this.v_progressInfo.postValue(ubVar);// 多次调用可能会导致数据丢失
//                PhoneBoostViewModel.this.v_progressInfo.setValue(ubVar);
            }
        }

        @Override
        public void onAppList(List<RunningAppBean> appList) {
            L.d("PhoneBoostViewModel","onAppList "+appList.size());
            PhoneBoostViewModel.this.v_uistate.postValue(1);
            PhoneBoostViewModel.this.curSelectSize = 0L;
            if (appList != null) {
                PhoneBoostViewModel.this.appCnt = appList.size();
                PhoneBoostViewModel vm = PhoneBoostViewModel.this;
                vm.v_appCnt.postValue(Long.valueOf(vm.appCnt));
                PhoneBoostViewModel.this.selectItems = new ArrayList();
                for (RunningAppBean runningBackgrdAppsBeanVar : appList) {
                    BoostSelectItemBean ubVar = new BoostSelectItemBean(runningBackgrdAppsBeanVar);
                    ubVar.b(true);
                    PhoneBoostViewModel.this.selectItems.add(ubVar);
                    if (ubVar.a()) {
                        PhoneBoostViewModel.getCurSelectSize(PhoneBoostViewModel.this, runningBackgrdAppsBeanVar.getAppMemoryInfo());
                    }
                }
                PhoneBoostViewModel phoneBoostViewModel2 = PhoneBoostViewModel.this;
                phoneBoostViewModel2.v_resultList.postValue(phoneBoostViewModel2.selectItems);
                PhoneBoostViewModel.this.v_allSelect.postValue(Boolean.TRUE);
            }
            PhoneBoostViewModel phoneBoostViewModel3 = PhoneBoostViewModel.this;
            phoneBoostViewModel3.v_curSize.postValue(Long.valueOf(phoneBoostViewModel3.curSelectSize));
        }

        @Override
        public void onStart() {
            L.d("PhoneBoostViewModel","onStart ");
            PhoneBoostViewModel.this.curSelectSize = 0L;
            PhoneBoostViewModel.this.appCnt = 0L;
            PhoneBoostViewModel.this.selectItems = new ArrayList();
            PhoneBoostViewModel.this.v_uistate.postValue(0);
            PhoneBoostViewModel.this.v_allSelect.postValue(Boolean.FALSE);
            PhoneBoostViewModel phoneBoostViewModel = PhoneBoostViewModel.this;
            phoneBoostViewModel.v_resultList.postValue(phoneBoostViewModel.selectItems);
            PhoneBoostViewModel phoneBoostViewModel2 = PhoneBoostViewModel.this;
            phoneBoostViewModel2.v_curSize.postValue(Long.valueOf(phoneBoostViewModel2.curSelectSize));
        }
    }

    public PhoneBoostViewModel(@NonNull Application application) {
        super(application);
        this.v_uistate = new MutableLiveData<>();
        this.v_curSize = new MutableLiveData<>();
        this.v_appCnt = new MutableLiveData<>();
        this.v_allSelect = new MutableLiveData<>();
        this.v_progressInfo = new MutableLiveData<>();
        this.v_resultList = new MutableLiveData<>();
        this.selectItems = new ArrayList();
        this.scanCallback = new ScanListener();
    }

    static long getCurSelectSize(PhoneBoostViewModel phoneBoostViewModel, long j) {
        long j2 = phoneBoostViewModel.curSelectSize + j;
        phoneBoostViewModel.curSelectSize = j2;
        return j2;
    }

    static long getAppCnt(PhoneBoostViewModel phoneBoostViewModel) {
        long j = phoneBoostViewModel.appCnt;
        phoneBoostViewModel.appCnt = 1 + j;
        return j;
    }

    public List<RunningAppBean> doClean() {
        RunningAppBean runningBackgrdAppsBeanVar;
        ArrayList arrayList = new ArrayList();
        List<BoostSelectItemBean> list = this.selectItems;
        if (list != null) {
            for (BoostSelectItemBean ubVar : list) {
                if (ubVar != null && (runningBackgrdAppsBeanVar = ubVar.runningBean) != null && !runningBackgrdAppsBeanVar.f()) {
                    arrayList.add(ubVar.runningBean);
                }
            }
        }
        return arrayList.size() > 0 ? this.scanMemory.g(arrayList) : arrayList;
    }

    public void onCreate() {
        bb2 bb2Var = new bb2(getApplication());
        this.scanMemory = bb2Var;
        bb2Var.h(this.scanCallback);
    }

    public void onSelectedCheckAll(boolean z) {
        if (this.selectItems != null) {
            this.curSelectSize = 0L;
            this.v_allSelect.postValue(Boolean.valueOf(z));
            for (BoostSelectItemBean ubVar : this.selectItems) {
                ubVar.b(z);
                if (ubVar.a()) {
                    this.curSelectSize += ubVar.runningBean.getAppMemoryInfo();
                }
            }
            this.v_resultList.postValue(this.selectItems);
            this.v_curSize.postValue(Long.valueOf(this.curSelectSize));
        }
    }

    public void onSelectedItem() {
        List<BoostSelectItemBean> list = this.selectItems;
        if (list != null) {
            this.curSelectSize = 0L;
            int i = 0;
            for (BoostSelectItemBean ubVar : list) {
                if (ubVar.a()) {
                    i++;
                    this.curSelectSize += ubVar.runningBean.getAppMemoryInfo();
                }
            }
            if (i == this.selectItems.size()) {
                this.v_allSelect.postValue(Boolean.TRUE);
            } else {
                this.v_allSelect.postValue(Boolean.FALSE);
            }
            this.v_resultList.postValue(this.selectItems);
            this.v_curSize.postValue(Long.valueOf(this.curSelectSize));
        }
    }
}
