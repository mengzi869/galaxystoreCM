package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.SurfaceHolder;
import androidx.core.view.ViewCompat;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.service.BAAU;

/* loaded from: classes2.dex */
public class wi {
    public static void a(BAAU.MyEngine aVar, BAAU baau) {
        Canvas lockCanvas;
        try {
            if (aVar.getSurfaceHolder() == null || (lockCanvas = aVar.getSurfaceHolder().lockCanvas()) == null) {
                return;
            }
            if (aVar.isPreview()) {
                BAAU.f = false;
                int i = aVar.i;
                if (i == -1) {
                    c(aVar, lockCanvas);
                } else if (i > 1) {
                    b(aVar, lockCanvas);
                } else {
                    yi.a(aVar, lockCanvas);
                }
                if (aVar.y) {
                    aVar.getSurfaceHolder().unlockCanvasAndPost(lockCanvas);
                    return;
                }
                return;
            }
            BAAU.f = true;
            yi.b(aVar);
            SurfaceHolder surfaceHolder = aVar.getSurfaceHolder();
            aVar.b(lockCanvas);
            if (aVar.y) {
                surfaceHolder.unlockCanvasAndPost(lockCanvas);
            }
        } catch (Exception e) {
            Log.e("wallpaper", "error:e2:" + e.toString());
            e.printStackTrace();
        }
    }

    public static final void b(BAAU.MyEngine aVar, Canvas canvas) {
        int width = canvas.getWidth();
        aVar.a = aVar.d;
        canvas.drawColor(aVar.F);
        aVar.r.setShader(aVar.O);
        canvas.drawRect(0.0f, canvas.getHeight() - aVar.N, canvas.getWidth(), canvas.getHeight(), aVar.r);
        aVar.a += aVar.c.height() + aVar.f92g;
        aVar.G.setColor(BAAU.b(SuperApplication.getContext(), R.color.color_c8c8cd));
        aVar.G.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint = aVar.G;
        String str = aVar.I;
        paint.getTextBounds(str, 0, str.length(), aVar.H);
        String str2 = aVar.I;
        float f = width / 2.0f;
        float f2 = aVar.a;
        Rect rect = aVar.H;
        canvas.drawText(str2, f, f2 + (rect.bottom - rect.top), aVar.G);
        float f3 = aVar.a;
        Rect rect2 = aVar.H;
        aVar.a = f3 + (rect2.bottom - rect2.top) + aVar.f;
        aVar.G.setTextSize(aVar.L);
        aVar.G.setFakeBoldText(false);
        aVar.G.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        String[] split = aVar.J.split("\n");
        if (split != null) {
            int length = split.length - 1;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    aVar.G.getTextBounds(split[i], 0, split[i].length(), aVar.H);
                    String str3 = split[i];
                    float f4 = aVar.a;
                    Rect rect3 = aVar.H;
                    canvas.drawText(str3, f, f4 + (rect3.bottom - rect3.top), aVar.G);
                    float f5 = aVar.a;
                    Rect rect4 = aVar.H;
                    aVar.a = f5 + (rect4.bottom - rect4.top) + aVar.e;
                    if (i2 > length) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            aVar.a += aVar.f - aVar.e;
            canvas.save();
            canvas.translate(f, aVar.a);
//            canvas.drawBitmap(aVar.h, (-r0.getWidth()) / 2.0f, 0.0f, aVar.G);
            canvas.drawBitmap(aVar.h, (-aVar.h.getWidth()) / 2.0f, 0.0f, aVar.G);
            canvas.restore();
        }
    }

    @SuppressLint({"WrongConstant"})
    public static final void c(BAAU.MyEngine aVar, Canvas canvas) {
        int length;
        int width = canvas.getWidth();
        aVar.a = aVar.d;
        canvas.drawColor(aVar.F);
        aVar.r.setShader(aVar.O);
        canvas.drawRect(0.0f, canvas.getHeight() - aVar.N, canvas.getWidth(), canvas.getHeight(), aVar.r);
        aVar.a = aVar.c.bottom + aVar.f92g;
        aVar.G.setColor(BAAU.b(SuperApplication.getContext(), R.color.color_c8c8cd));
        aVar.G.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint = aVar.G;
        String str = aVar.I;
        paint.getTextBounds(str, 0, str.length(), aVar.H);
        String str2 = aVar.I;
        float f = width / 2.0f;
        float f2 = aVar.a;
        Rect rect = aVar.H;
        canvas.drawText(str2, f, f2 + (rect.bottom - rect.top), aVar.G);
        float f3 = aVar.a;
        Rect rect2 = aVar.H;
        aVar.a = f3 + (rect2.bottom - rect2.top) + aVar.f;
        aVar.G.setTextSize(aVar.L);
        aVar.G.setFakeBoldText(false);
        aVar.G.setTypeface(Typeface.defaultFromStyle(0));
        String[] split = aVar.J.split("\n");
        if (split == null || split.length - 1 < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            aVar.G.getTextBounds(split[i], 0, split[i].length(), aVar.H);
            String str3 = split[i];
            float f4 = aVar.a;
            Rect rect3 = aVar.H;
            canvas.drawText(str3, f, f4 + (rect3.bottom - rect3.top), aVar.G);
            float f5 = aVar.a;
            Rect rect4 = aVar.H;
            aVar.a = f5 + (rect4.bottom - rect4.top) + aVar.e;
            if (i2 > split.length) {
                return;
            } else {
                i = i2;
            }
        }
    }
}
