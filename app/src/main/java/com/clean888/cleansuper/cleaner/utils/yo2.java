package com.clean888.cleansuper.cleaner.utils;

import android.database.Cursor;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
/* loaded from: classes4.dex */
public interface yo2 {
    @Insert(onConflict = 5)
    void a(List<xo2> list);

    @Query("SELECT n , q FROM a WHERE q IN (:list)")
    Cursor b(List<String> list);
}
