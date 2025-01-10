package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.unity3d.player.StringFog;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class cp2 implements bp2 {
    private final RoomDatabase a;
    @SuppressLint("RestrictedApi")
    private final EntityInsertionAdapter<ap2> b;

    /* loaded from: classes4.dex */
    @SuppressLint("RestrictedApi")
    class a extends EntityInsertionAdapter<ap2> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ap2 ap2Var) {
            supportSQLiteStatement.bindLong(1, ap2Var.a);
            String str = ap2Var.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            String str2 = ap2Var.c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = ap2Var.d;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
        }

        @SuppressLint("RestrictedApi")
        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return StringFog.decrypt("Hh0UJzcjETw1dxoALColdFMuGQcIQgUVUVNPNzojAkkXQRNLNzAnTgUCUVpHARILNyAkEVsJIj8rCwNfDl9HZ3prXUlIHUxO");
        }
    }

    public cp2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @SuppressLint("RestrictedApi")
    @Override // defpackage.bp2
    public void a(List<ap2> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @SuppressLint("RestrictedApi")
    @Override // defpackage.bp2
    public Cursor b(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append(StringFog.decrypt("BBYLJyYjERoDeyNrAUkCETU1GB5nAEUgeTY1EnM3Qiw5EVs="));
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(StringFog.decrypt("fg=="));
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        return this.a.query(acquire);
    }
}