package com.clean888.cleansuper.cleaner.ui.listener;

import com.clean888.cleansuper.cleaner.bean.RunningAppBean;

import java.util.List;

public interface ScanRunningAppListener {
    void onApp(RunningAppBean app);

    void onAppList(List<RunningAppBean> appList);

    void onStart();
}
