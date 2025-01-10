package com.clean888.cleansuper.cleaner.utils;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "c")
/* loaded from: classes4.dex */
public class dp2 {
    public static final String e = StringFog.decrypt("NA==");

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long a;

    @ColumnInfo(name = "b")
    public String b;

    @ColumnInfo(name = "c")
    public String c;

    @ColumnInfo(name = "d")
    public long d;
}