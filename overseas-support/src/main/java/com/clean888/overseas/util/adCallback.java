package com.clean888.overseas.util;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public interface adCallback {

    /* loaded from: classes2.dex */
    public static final class a {
        public static void a(@NotNull adCallback n1Var, int i) {
        }
    }

    void onAdClicked(@NotNull y3 y3Var);

    void onAdClose(@NotNull y3 y3Var);

    void onAdLoadFailed(@NotNull y3 y3Var);

    void onAdLoaded(@NotNull y3 y3Var);

    void onAdShow(@NotNull y3 y3Var);

    void onAdShowFailed(@NotNull y3 y3Var);

    void onLoadingClose(int i);
}
