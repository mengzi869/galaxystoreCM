package com.clean888.cleansuper.cleaner.utils;



import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qi {
    @NotNull
    public static final qi a = new qi();


    public final boolean a(@NotNull Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        NotificationManagerCompat v2 = NotificationManagerCompat.from(arg2);
        Intrinsics.checkNotNullExpressionValue(v2, "from(context)");
        return v2.areNotificationsEnabled();
    }
}


