package com.clean888.cleansuper.cleaner.ui.fragment.result;

import com.clean888.cleansuper.cleaner.R;

public class FuncFinishTitleModel {
    public static final FuncFinishTitleModel JunkClean = new FuncFinishTitleModel(1, R.string.clean_finish_title, R.string.clean_finish_state, R.string.clean_finish_msg);
    public static final FuncFinishTitleModel PhoneBoost = new FuncFinishTitleModel(2, R.string.boost_finish_title, R.string.boost_finish_state, R.string.boost_finish_msg);
    public static final FuncFinishTitleModel LargeFileClean = new FuncFinishTitleModel(3, R.string.large_file_finish_title, R.string.large_file_finish_state, R.string.large_file_finish_msg);
    public static final FuncFinishTitleModel Antivirus = new FuncFinishTitleModel(4, R.string.antivirus_finish_title, R.string.antivirus_finish_state, R.string.antivirus_finish_msg);
    public static final FuncFinishTitleModel CpuCooler = new FuncFinishTitleModel(5, R.string.cpu_cool_finish_title, R.string.cpu_cool_finish_state, R.string.cpu_cool_finish_msg);
    public static final FuncFinishTitleModel BatterySaver = new FuncFinishTitleModel(6, R.string.battery_finish_title, R.string.battery_finish_state, R.string.battery_finish_msg);
    public static final FuncFinishTitleModel AppScan = new FuncFinishTitleModel(7, R.string.app_scan_finish_title, R.string.app_scan_finish_state, R.string.app_scan_finish_msg);
    public static final FuncFinishTitleModel NotificationClean = new FuncFinishTitleModel(9, R.string.title_notification_clean, R.string.notification_clean_finish_tap, R.string.notification_clean_finish_msg);
    public int Id;
    public int TitleResId;
    public int StateResId;
    public int MsgResId;
    private Object[] Extras;

    private FuncFinishTitleModel(int id, int titleResId, int stateResId, int msgResId) {
        this.Id = id;
        this.TitleResId = titleResId;
        this.StateResId = stateResId;
        this.MsgResId = msgResId;
    }

    public FuncFinishTitleModel setExtras(Object... objArr) {
        this.Extras = objArr;
        return this;
    }

    public Object[] getExtras(){
        return this.Extras;
    }
}
