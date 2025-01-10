package com.clean888.cleansuper.cleaner.utils;


import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.clean888.cleansuper.cleaner.ui.activity.BAAV;
import com.clean888.cleansuper.cleaner.service.BAAU;

/* loaded from: classes2.dex */
public class xi {

    public static void a(BAAU.MyEngine aVar, MotionEvent motionEvent) {
        Canvas lockCanvas;
        if (aVar.isPreview()) {
            return;
        }
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            boolean c2 = aVar.c(motionEvent);
            aVar.w = c2;
            if (c2) {
                motionEvent.getX();
                aVar.o = motionEvent.getY();
                aVar.p = motionEvent.getY();
                return;
            }
            return;
        }
        if (motionEvent.getAction() == MotionEvent.ACTION_MOVE && aVar.w) {
            aVar.x = true;
            float y = motionEvent.getY() - aVar.o;
            int height = aVar.u.height();
            Rect rect = aVar.u;
            int i = (int) y;
            int i2 = rect.top + i;
            rect.top = i2;
            rect.bottom += i;
            int i3 = aVar.m;
            if (i2 <= i3) {
                rect.top = i3;
                rect.bottom = i3 + height;
            }
            int i4 = rect.bottom;
            int i5 = aVar.n;
            if (i4 > i5) {
                rect.bottom = i5;
                rect.top = i5 - height;
            }
            vi.a = rect.top;
            SurfaceHolder surfaceHolder = aVar.getSurfaceHolder();
            if (surfaceHolder != null && (lockCanvas = surfaceHolder.lockCanvas()) != null) {
                aVar.b(lockCanvas);
                aVar.getSurfaceHolder().unlockCanvasAndPost(lockCanvas);
            }
            aVar.o = motionEvent.getY();
            motionEvent.getX();
        }
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            aVar.o = 0.0f;
            if (aVar.w && aVar.c(motionEvent) && (!aVar.x || Math.abs(motionEvent.getY() - aVar.p) < aVar.b)) {
//                        i4.a().i("c_quickboost_desktop").commit();
                Intent intent = new Intent(aVar.q.getApplicationContext(), (Class<?>) BAAV.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    PendingIntent.getActivity(aVar.q.getApplicationContext(), 100099, intent, y41.a(1245)).send();
                } catch (Exception unused) {
                    aVar.q.getApplicationContext().startActivity(intent);
                }
            }
            aVar.p = 0.0f;
            aVar.x = false;
            aVar.w = false;
        }
    }

}
