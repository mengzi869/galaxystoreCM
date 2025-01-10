package com.clean888.cleansuper.cleaner.utils;


import android.database.Cursor;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
/* loaded from: classes4.dex */
public interface ep2 {
    @Insert(onConflict = 5)
    void a(List<dp2> list);

    @Query("SELECT b,c,d FROM c")
    Cursor b();
}