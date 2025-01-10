package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;

import com.clean888.cleansuper.cleaner.service.BAAH;
import com.tencent.mmkv.MMKV;


/* loaded from: classes2.dex */
public class BAEX extends AndroidViewModel {
    private static final String FINISH_TIMES_ = "finish_times_";
    public static final String FIRST_CLEAN_FINISH = "first_clean_finish";
    private static final String LAST_ENTER_TIME_ = "last_enter_time_";
    private static final String LAST_FINISH_TIME_ = "last_finish_time_";
    public FuncFinishTitleModel type;

    public BAEX(@NonNull Application application) {
        super(application);
    }

    public void canShow(int i) {
        if (i == 1 || i == 4) {
            return;
        }
        MMKV.defaultMMKV().putInt(FIRST_CLEAN_FINISH, getFirstCleanFinish() + 1);
    }

    public void enter(Context context, FuncFinishTitleModel ufVar) {
        MMKV.defaultMMKV().putLong(LAST_ENTER_TIME_ + ufVar.Id, System.currentTimeMillis());
        BAAH.f(context);
    }

    public void finish(Context context, FuncFinishTitleModel ufVar) {
        MMKV h = MMKV.defaultMMKV();
        h.putInt(FINISH_TIMES_ + ufVar.Id, getFinishTimes(ufVar) + 1);
        h.putLong(LAST_FINISH_TIME_ + ufVar.Id, System.currentTimeMillis());
        BAAH.f(context);
    }

    public int getFinishTimes(FuncFinishTitleModel ufVar) {
        return MMKV.defaultMMKV().getInt(FINISH_TIMES_ + ufVar.Id, 0);
    }

    public int getFirstCleanFinish() {
        return MMKV.defaultMMKV().getInt(FIRST_CLEAN_FINISH, 0);
    }

    public long getLastEnterTime(FuncFinishTitleModel ufVar) {
        return MMKV.defaultMMKV().getLong(LAST_ENTER_TIME_ + ufVar.Id, 0L);
    }

    public long getLastFinishTime(FuncFinishTitleModel ufVar) {
        return MMKV.defaultMMKV().getLong(LAST_FINISH_TIME_ + ufVar.Id, 0L);
    }

    public boolean isFirstFinish(FuncFinishTitleModel ufVar) {
        return getFinishTimes(ufVar) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }
}