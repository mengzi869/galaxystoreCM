package com.clean888.cleansuper.cleaner.utils;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "d")
/* loaded from: classes4.dex */
public class gp2 {
    public static final String e = StringFog.decrypt("Mw==");

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long a;

    @ColumnInfo(name = "b")
    public long b;

    @ColumnInfo(name = "c")
    public long c;

    @ColumnInfo(name = "d")
    public String d;
}