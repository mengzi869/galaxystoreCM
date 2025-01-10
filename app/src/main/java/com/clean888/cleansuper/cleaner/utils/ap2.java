package com.clean888.cleansuper.cleaner.utils;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "b")
/* loaded from: classes4.dex */
public class ap2 {
    public static final String e = StringFog.decrypt("NQ==");

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long a;

    @ColumnInfo(name = "p")
    public String b;

    @ColumnInfo(name = "c")
    public String c;

    @ColumnInfo(name = "u")
    public String d;
}
