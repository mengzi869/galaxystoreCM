package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

import com.clean888.cleansuper.cleaner.utils.bb2;
import com.clean888.cleansuper.cleaner.bean.RunningAppBean;
import com.clean888.cleansuper.cleaner.ui.listener.ScanRunningAppListener;
import com.clean888.cleansuper.cleaner.ui.fragment.BADJ;

public class CpuCoolerViewModel extends ViewModel {
    private List<RunningAppBean> appInfoList = new ArrayList();

    class ScanListener implements ScanRunningAppListener {
        ScanListener() {
        }

        @Override
        public void onApp(RunningAppBean app) {
            CpuCoolerViewModel.this.appInfoList.add(app);
        }

        @Override
        public void onAppList(List<RunningAppBean> appList) {
        }

        @Override
        public void onStart() {
        }
    }

    public void doScan(Context context) {
        new bb2(context).scan(new ScanListener());
    }

    public List<BADJ.c> getAnimShowInfo() {
        ArrayList arrayList = new ArrayList();
        List<RunningAppBean> list = this.appInfoList;
        if (list != null && list.size() > 0) {
            for (RunningAppBean runningBackgrdAppsBeanVar : this.appInfoList) {
                BADJ.c cVar = new BADJ.c();
                cVar.a = runningBackgrdAppsBeanVar.getAppIcon();
                cVar.b = runningBackgrdAppsBeanVar.getAppName();
                cVar.c = runningBackgrdAppsBeanVar.getAppPackageName();
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }
}