package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.unity3d.player.StringFog;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
@SuppressLint("RestrictedApi")
public final class fp2 implements ep2 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<dp2> b;

    /* loaded from: classes4.dex */
    class a extends EntityInsertionAdapter<dp2> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, dp2 dp2Var) {
            supportSQLiteStatement.bindLong(1, dp2Var.a);
            String str = dp2Var.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            String str2 = dp2Var.c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            supportSQLiteStatement.bindLong(4, dp2Var.d);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return StringFog.decrypt("Hh0UJzcjETw1dxoALColdFMuGQcIQgUUUVNPNzojAkkXUxNLNzAnTgUTUVpHARILNyAkEVsJIj8rCwNfDl9HZ3prXUlIHUxO");
        }
    }

    public fp2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // defpackage.ep2
    public void a(List<dp2> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // defpackage.ep2
    public Cursor b() {
        StringFog.decrypt("BBYLJyYjERFLNH8jQiMlfj5HNA==");
        return this.a.query(RoomSQLiteQuery.acquire(StringFog.decrypt("BBYLJyYjERFLNH8jQiMlfj5HNA=="), 0));
    }
}
