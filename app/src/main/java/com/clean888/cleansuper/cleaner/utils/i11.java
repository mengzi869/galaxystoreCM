package com.clean888.cleansuper.cleaner.utils;

import android.database.Cursor;
import androidx.annotation.WorkerThread;
import java.util.List;

/* loaded from: classes2.dex */
public interface i11 extends j11 {
    @WorkerThread
    Cursor c(List<Long> list);

    @WorkerThread
    Cursor d(Long l);

    @WorkerThread
    Cursor g(List<Long> list);
}
