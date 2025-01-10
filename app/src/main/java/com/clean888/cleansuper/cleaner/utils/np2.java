package com.clean888.cleansuper.cleaner.utils;

import android.database.Cursor;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
/* loaded from: classes4.dex */
public interface np2 {
    @Insert(onConflict = 5)
    void a(List<mp2> list);

    @Query("SELECT id, a FROM f WHERE id IN (:list)")
    Cursor b(List<Long> list);
}
