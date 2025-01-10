package com.clean888.cleansuper.cleaner.utils;

import android.database.Cursor;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
/* loaded from: classes4.dex */
public interface bp2 {
    @Insert(onConflict = 5)
    void a(List<ap2> list);

    @Query("SELECT id,p,c,u FROM b WHERE p IN (:list)")
    Cursor b(List<String> list);
}
