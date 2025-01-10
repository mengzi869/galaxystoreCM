package com.clean888.cleansuper.cleaner.utils;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.service.BAAU;

import java.util.List;

/* loaded from: classes2.dex */
public class yi {
    public static final void a(BAAU.MyEngine aVar, Canvas canvas) {
        int length;
        int width = canvas.getWidth();
        aVar.a = aVar.d;
        canvas.drawColor(aVar.F);
        aVar.r.setShader(aVar.O);
        canvas.drawRect(0.0f, canvas.getHeight() - aVar.N, canvas.getWidth(), canvas.getHeight(), aVar.r);
        if (aVar.i == 1) {
            canvas.save();
            canvas.translate(width - vh0.b(40), aVar.h.getHeight() + vh0.b(88));
            canvas.rotate(180.0f);
            canvas.drawBitmap(aVar.h, 0.0f, 0.0f, aVar.G);
            canvas.restore();
        } else {
            canvas.save();
            canvas.translate(aVar.h.getWidth() + vh0.b(40), aVar.h.getHeight() + vh0.b(88));
            canvas.rotate(180.0f);
            canvas.drawBitmap(aVar.h, 0.0f, 0.0f, aVar.G);
            canvas.restore();
        }
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
        aVar.G.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        String[] split = aVar.J.split("\n");
        if (split == null || (length = split.length - 1) < 0) {
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
            if (i2 > length) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final void b(BAAU.MyEngine aVar) {
        List<Bitmap> list = aVar.z;
        if (list != null) {
            aVar.u.left = (int) (aVar.t - (list.get(0).getWidth() * 0.6666667f));
            aVar.u.top = (int) (((aVar.s - 0) * 0.6f) - (list.get(0).getHeight() / 2));
            Rect rect = aVar.u;
            rect.right = list.get(0).getWidth() + rect.left;
            Rect rect2 = aVar.u;
            rect2.bottom = list.get(0).getHeight() + rect2.top;
            vi.a = aVar.u.top;
        }
    }
}