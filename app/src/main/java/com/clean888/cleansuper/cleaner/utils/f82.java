package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.content.res.Resources;

import kotlin.jvm.internal.Intrinsics;
//import okhttp3.internal.connection.A;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class f82 {

    @NotNull
    public static final f82 a = new f82();

    private f82() {
    }

    public final int a(@NotNull Context context, @Nullable String name, @NotNull String defType) {
        Intrinsics.checkNotNullParameter(context, AA.a("UVteTVdIRg=="));
        Intrinsics.checkNotNullParameter(defType, AA.a("VlFWbUtAVw=="));
        Resources resources = context.getResources();
        if (resources != null) {
            return resources.getIdentifier(name, defType, context.getPackageName());
        }
        return 0;
    }
}