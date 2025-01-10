package com.clean888.cleansuper.cleaner.utils;


import android.database.Cursor;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
/* loaded from: classes4.dex */
public interface kp2 {
    @Insert(onConflict = 5)
    void a(List<jp2> list);

    @Query("SELECT  b, c FROM e WHERE a IN (:list)")
    Cursor b(List<Long> list);
}