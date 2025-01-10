package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class ay {

    @Nullable
    private static JSONObject e;

    @NotNull
    private static final String c = AA.a("QFVH");

    @NotNull
    private static final String d = AA.a("VENb");

    @NotNull
    public static final ay a = new ay();

    @NotNull
    private static final HashMap<String, JSONObject> b = new HashMap<>();

    private ay() {
    }

    private final void a(Context context) {
        if (e == null) {
            e(context);
        }
    }

    private final JSONObject f(Context context, String fileName) {
//        if (StringsKt__StringsJVMKt.isBlank(fileName)) {
//            return null;
//        }
        HashMap<String, JSONObject> hashMap = b;
        JSONObject jSONObject = hashMap.get(fileName);
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            InputStream open = context.getAssets().open(fileName);
            Intrinsics.checkNotNullExpressionValue(open, AA.a("UVteTVdIRhpRSkFVRkceVkJVXBxWUF5VfFVdXBs="));
            jSONObject = i(open);
            if (jSONObject != null) {
                hashMap.put(fileName, jSONObject);
            }
        } catch (Exception e2) {
//            id1.a.b(AA.a("cFVDXF9VXEB5eHM="), AA.a("XltRXXNDQVFESnBJfFVdXBI=") + xk0.a(e2));
        }
        return jSONObject;
    }

    private final synchronized JSONObject i(InputStream inputStream) {
        String readUtf8 = "";
        JSONObject jSONObject = null;
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(inputStream));
            try {
                readUtf8 = buffer.readUtf8();
                buffer.close();
//                CloseableKt.closeFinally(buffer, null);

            } finally {
            }
        } catch (IOException e2) {
//            id1.a.b(AA.a("cFVDXF9VXEB5eHM="), AA.a("QlVCSlcQ") + xk0.a(e2));
        }
        if (TextUtils.isEmpty(readUtf8)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(readUtf8);
        } catch (JSONException e3) {
         /*   String a2 = jj2.a(readUtf8);
            Intrinsics.checkNotNullExpressionValue(a2, AA.a("VEZfVHpVShxTVlxEV1pEEA=="));
            try {
                jSONObject = new JSONObject(a2);
            } catch (JSONException e4) {
                id1.a.b(A.a("cFVDXF9VXEB5eHM="), A.a("QlVCSlcQ") + xk0.a(e3));
                e4.printStackTrace();
            }*/
        }
        return jSONObject;
    }

    @NotNull
    public final String b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, AA.a("UVteTVdIRg=="));
        a(context);
        JSONObject jSONObject = e;
        String optString = jSONObject != null ? jSONObject.optString(AA.a("W1VRZlpfQUA=")) : null;
        return optString == null ? "" : optString;
    }

    public final int c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, AA.a("UVteTVdIRg=="));
        a(context);
        JSONObject jSONObject = e;
        if (jSONObject != null) {
            return jSONObject.optInt(AA.a("QkZfXUdTRmtZXQ=="));
        }
        return -1;
    }

    public final int d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, AA.a("UVteTVdIRg=="));
        a(context);
        JSONObject jSONObject = e;
        if (jSONObject != null) {
            return jSONObject.optInt(AA.a("QFFcXFNDV2tAS11UR1dEZltU"));
        }
        return -1;
    }

    @Nullable
    public final JSONObject e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, AA.a("UVteTVdIRg=="));
        JSONObject jSONObject = e;
        if (jSONObject != null) {
            return jSONObject;
        }
        String string = "";//context.getResources().getString(R.string.a);
        Intrinsics.checkNotNullExpressionValue(string, AA.a("UVteTVdIRhpXXEZiV0dfTEBTV0cYEBxX0LSWZl9VXEFvTVNSbUdYVkBEUUFEZl5RUFFcEA=="));
        if (string.length() == 0) {
            string = d;
        }
        JSONObject g2 = g(context, string);
        e = g2;
        return g2;
    }

    @Nullable
    public final synchronized JSONObject g(@NotNull Context context, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(context, AA.a("UVteTVdIRg=="));
        Intrinsics.checkNotNullParameter(fileName, AA.a("VF1cXHxRX1E="));
        JSONObject h = h(context, f82.a.a(context, fileName, c));
        if (h != null) {
            return h;
        }
        return f(context, fileName);
    }

    @Nullable
    public final JSONObject h(@NotNull Context context, int rawId) {
        Intrinsics.checkNotNullParameter(context, AA.a("UVteTVdIRg=="));
        if (rawId == 0) {
            return null;
        }
        HashMap<String, JSONObject> hashMap = b;
        JSONObject jSONObject = hashMap.get(String.valueOf(rawId));
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            InputStream openRawResource = context.getResources().openRawResource(rawId);
            Intrinsics.checkNotNullExpressionValue(openRawResource, AA.a("UVteTVdIRhpCXEFfR0ZTXEEeXURVV2BRRWZVSl1FQFdVEUBRRX1UEA=="));
            jSONObject = i(openRawResource);
            if (jSONObject != null) {
                hashMap.put(String.valueOf(rawId), jSONObject);
            }
        } catch (Exception e2) {
//            id1.a.b(AA.a("cFVDXF9VXEB5eHM="), AA.a("XltRXWBRRXZJcFYQ") + xk0.a(e2));
        }
        return jSONObject;
    }
}