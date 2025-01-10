package com.clean888.cleansuper.cleaner.utils;


import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.service.BAAU;
import com.clean888.cleansuper.cleaner.ui.widget.BAGK;
//import com.tradplus.ads.common.serialization.asm.Opcodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public class aj {

    /* loaded from: classes2.dex */
    static class listener implements LottieListener<LottieComposition> {
        final /* synthetic */ BAAU.MyEngine a;

        listener(BAAU.MyEngine aVar) {
            this.a = aVar;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(LottieComposition lottieComposition) {
            BAAU.MyEngine aVar = this.a;
            aVar.a(aVar, lottieComposition);
        }
    }

    public static void a(BAAU.MyEngine aVar, BAAU baau) {
        int intValue;
        aVar.q = baau;
        aVar.A = BitmapFactory.decodeResource(baau.getApplicationContext().getResources(), R.mipmap.wallpap_default);
        Bitmap c = c(baau.getApplicationContext());
        if (c != null) {
            aVar.A = c;
        }
        aVar.A = b(aVar.A, baau.getApplicationContext());
        ArrayList arrayList = new ArrayList();
        aVar.z = arrayList;
        arrayList.add(BitmapFactory.decodeResource(baau.getApplicationContext().getResources(), R.mipmap.ic_wallpaper_back));
        aVar.z.add(BitmapFactory.decodeResource(baau.getApplicationContext().getResources(), R.mipmap.ic_wallpaper_fan));
        aVar.z.add(BitmapFactory.decodeResource(baau.getApplicationContext().getResources(), R.mipmap.ic_wallpaper_rocket));
        Point point = new Point();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            Object systemService = baau.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            if (systemService != null) {
                Rect bounds = ((WindowManager) systemService).getCurrentWindowMetrics().getBounds();
                point.x = bounds.width();
                point.y = bounds.height();
            }
        } else {
            Object systemService2 = baau.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            if (systemService2 != null) {
                ((WindowManager) systemService2).getDefaultDisplay().getRealSize(point);
            }
        }
        aVar.t = point.x;
        aVar.s = point.y;
        Paint paint = new Paint();
        aVar.r = paint;
        paint.setAntiAlias(true);
        aVar.K = vh0.b(24);
        aVar.L = vh0.b(16);
        aVar.F = BAAU.b(baau.getApplicationContext(), R.color.color_f5f5f5);
        Paint paint2 = new Paint();
        aVar.G = paint2;
        paint2.setColor(BAAU.b(baau.getApplicationContext(), R.color.black));
        aVar.G.setFakeBoldText(true);
        aVar.G.setTextSize(aVar.K);
        aVar.G.setTextAlign(Paint.Align.CENTER);
        aVar.G.setAntiAlias(true);
        aVar.H = new Rect();
        aVar.I = baau.getApplicationContext().getResources().getString(R.string.wallpaper_title);
        aVar.J = baau.getApplicationContext().getResources().getString(R.string.wallpaper_subtitle);
        float b = vh0.b(126);
        aVar.N = b;
        aVar.M = aVar.s - b;
        //aVar.O = new LinearGradient(0.0f, aVar.M, 0.0f, aVar.s, aVar.F, Color.argb(255, Opcodes.NEW, Opcodes.NEW, Opcodes.NEW), Shader.TileMode.CLAMP);
        aVar.O = new LinearGradient(0.0f, aVar.M, 0.0f, aVar.s, aVar.F, Color.argb(255, 187, 187, 187), Shader.TileMode.CLAMP);
        aVar.e = vh0.b(4);
        aVar.f = vh0.b(16);
        aVar.f92g = vh0.b(24);
        vh0.b(69);
        vh0.b(90);
        String lowerCase = Build.MANUFACTURER.toLowerCase(Locale.ROOT);
        HashMap<String, Integer> hashMap = ui.b;
        Integer num = hashMap.get(lowerCase);
        if (num != null) {
            intValue = num.intValue();
        } else if (i > 30) {
            Integer num2 = hashMap.get(lowerCase + "+");
            if (num2 != null) {
                intValue = num2.intValue();
            }
            intValue = 1;
        } else {
            if (hashMap.get(lowerCase + '-' + i) != null) {
                intValue = hashMap.get(lowerCase + '-' + i).intValue();
            } else {
                if (i < 26) {
                    Integer num3 = hashMap.get(lowerCase + "-");
                    if (num3 != null) {
                        intValue = num3.intValue();
                    }
                }
                intValue = 1;
            }
        }
        aVar.i = intValue;
        if (intValue != 0 && intValue != 1) {
            int b2 = vh0.b(116);
            aVar.d = b2;
            aVar.c = new Rect(0, b2, aVar.t, vh0.b(282) + b2);
        } else {
//            int b3 = vh0.b(Opcodes.ARETURN);
            int b3 = vh0.b(176);
            aVar.d = b3;
            aVar.c = new Rect(0, b3, aVar.t, vh0.b(282) + b3);
        }
        aVar.h = BitmapFactory.decodeResource(baau.getApplicationContext().getResources(), R.mipmap.wallpaper_arrow);
        LottieDrawable lottieDrawable = new LottieDrawable();
        lottieDrawable.setImagesAssetsFolder("lottie/wallpaper/images");
        lottieDrawable.setRepeatCount(-1);
        lottieDrawable.cancelAnimation();
        aVar.j = lottieDrawable;
        LottieTask<LottieComposition> fromAsset = LottieCompositionFactory.fromAsset(baau.getApplicationContext(), "lottie/wallpaper/data.json", null);
        aVar.k = new BAGK(aVar.q, null);
        fromAsset.addListener(new listener(aVar));
        double d = aVar.s;
        aVar.m = (int) (0.5d * d);
        aVar.n = (int) (d * 0.8d);
        aVar.b = vh0.b(5);
        aVar.l = new Rect(aVar.c);
    }

    private static Bitmap b(Bitmap bitmap, Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealSize(point);
        return (bitmap.getWidth() < point.x || bitmap.getHeight() < point.y) ? Bitmap.createScaledBitmap(bitmap, point.x, point.y, true) : bitmap;
    }

    private static Bitmap c(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return ((BitmapDrawable) WallpaperManager.getInstance(context).getDrawable()).getBitmap();
        }
        return null;
    }
}
