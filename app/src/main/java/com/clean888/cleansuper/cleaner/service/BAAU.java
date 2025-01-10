package com.clean888.cleansuper.cleaner.service;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.Toast;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.SuperApplication;

import com.clean888.cleansuper.cleaner.utils.vh0;
import com.clean888.cleansuper.cleaner.utils.aj;
import com.clean888.cleansuper.cleaner.utils.xi;
import com.clean888.cleansuper.cleaner.utils.wi;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.ui.activity.BAAW;
import com.clean888.cleansuper.cleaner.ui.widget.BAGK;

import java.lang.ref.WeakReference;
import java.util.List;

public final class BAAU extends WallpaperService {
    public static String TAG = "BAAU";
    public static final int c = vh0.b(8);
    public static WeakReference<Activity> d;
    public static boolean f;

    /* renamed from: g, reason: collision with root package name */
    public static String f91g;
    public WeakReference<MyEngine> a = new WeakReference<>(null);
    public final Handler b = new Handler(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public final class MyEngine extends WallpaperService.Engine {
        public Bitmap A;
        public float D;
        public float E;
        public int F;
        public Paint G;
        public Rect H;
        public String I;
        public String J;
        public float K;
        public float L;
        public float M;
        public float N;
        public LinearGradient O;
        public float a;
        public int b;
        public Rect c;
        public int d;
        public int e;
        public int f;

        /* renamed from: g, reason: collision with root package name */
        public int f92g;
        public Bitmap h;
        public int i;
        public LottieDrawable j;
        public BAGK k;
        public Rect l;
        public int m;
        public int n;
        public float o;
        public float p;
        public BAAU q;
        public Paint r;
        public int s;
        public int t;
        public Rect u;
        public Rect v;
        public boolean w;
        public boolean x;
        public boolean y;
        public List<Bitmap> z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: bfj.cuskky.qoz.rdwl.BAAU$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0087a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ MyEngine a;

            C0087a(MyEngine aVar) {
                this.a = aVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyEngine aVar = this.a;
                aVar.d(aVar, valueAnimator);
            }
        }

        public MyEngine(BAAU baau) {
            //super(BAAU.this);
            super();
            this.u = new Rect();
            this.D = 1.0f;
            aj.a(this, baau);
        }

        public void a(MyEngine aVar, LottieComposition lottieComposition) {
            aVar.j.setComposition(lottieComposition);
            aVar.j.setCallback(aVar.k);
            aVar.j.addAnimatorUpdateListener(new C0087a(aVar));
        }

        public final void b(Canvas canvas) {
            Bitmap bitmap = this.A;
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPaint(paint);
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.r);
            } else {
                this.r.setColor(this.F);
                canvas.drawRect(0.0f, 0.0f, this.t, this.s, this.r);
            }
            List<Bitmap> list = this.z;
            if (list != null) {
                Rect rect = this.u;
                rect.right = list.get(0).getWidth() + rect.left;
                Rect rect2 = this.u;
                canvas.drawBitmap(list.get(0), rect2.left, rect2.top, this.r);
                canvas.save();
                canvas.translate(this.u.centerX(), this.u.centerY());
                canvas.rotate(this.E);
                canvas.drawBitmap(list.get(1), (-list.get(1).getWidth()) / 2.0f, (-list.get(1).getHeight()) / 2.0f, this.r);
                canvas.restore();
                canvas.save();
                canvas.translate(this.u.centerX(), this.u.centerY());
                float f = this.D;
                canvas.scale(f, f);
                canvas.drawBitmap(list.get(2), (-list.get(2).getWidth()) / 2.0f, (-list.get(2).getHeight()) / 2.0f, this.r);
                canvas.restore();
            }
        }

        public final boolean c(MotionEvent motionEvent) {
            float y = motionEvent.getY();
            int i = this.u.top;
            int i2 = BAAU.c;
            return y >= ((float) (i - i2)) && motionEvent.getY() <= ((float) (this.u.bottom + i2)) && motionEvent.getX() >= ((float) (this.u.left - i2)) && motionEvent.getX() <= ((float) (this.u.right + i2));
        }

        public final void d(MyEngine aVar, ValueAnimator valueAnimator) {
            try {
                SurfaceHolder surfaceHolder = aVar.getSurfaceHolder();
                if (surfaceHolder != null) {
                    aVar.l.set(aVar.c);
                    Canvas lockCanvas = surfaceHolder.lockCanvas(aVar.l);
                    lockCanvas.save();
                    if (aVar.j.getIntrinsicHeight() > aVar.c.height()) {
                        lockCanvas.translate(0.0f, aVar.c.top);
                        float height = (float) aVar.c.height() / (float)aVar.j.getIntrinsicHeight();
                        lockCanvas.scale(height, height);
                        if ((float) aVar.j.getIntrinsicWidth() < (float) aVar.c.width() / height) {
                            float dx1 = ((float)aVar.c.width() / height) - (float) aVar.j.getIntrinsicWidth();
                            lockCanvas.translate(dx1 / 2.0f, 0.0f);
                        }
                    } else {
                        float dx2 = (float) aVar.c.width() - (float) aVar.j.getIntrinsicWidth();
                        lockCanvas.translate((dx2) / 2.0f, aVar.c.top);
                    }
                    lockCanvas.drawColor(aVar.F);
                    aVar.j.draw(lockCanvas);
                    lockCanvas.restore();
                    surfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void e(MyEngine aVar, ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() != null) {
                // aVar.E = ((Integer) r2).intValue();
                aVar.E = (Integer) valueAnimator.getAnimatedValue();//获取动画的值
                aVar.h();
            }
        }

        public final void f(MyEngine aVar) {
            if (aVar.isPreview()) {
                return;
            }
            aVar.D = 1.0f;
            aVar.E = 0.0f;
            try {
                aVar.h();
            } catch (Exception unused) {
            }
        }

        public final void g(MyEngine aVar, ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                aVar.D = 1.0f - (((Float) animatedValue).floatValue() * 0.36f);
                aVar.h();
            }
        }

        public final void h() {
            Canvas lockCanvas;
            SurfaceHolder surfaceHolder = getSurfaceHolder();
            if (this.v == null) {
                this.v = this.u;
            }
            if (surfaceHolder == null || (lockCanvas = surfaceHolder.lockCanvas(this.v)) == null || this.z == null) {
                return;
            }
            b(lockCanvas);
            if (this.y) {
                surfaceHolder.unlockCanvasAndPost(lockCanvas);
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onDestroy() {
            super.onDestroy();
            if (isPreview()) {
                if (BAAU.f) {
//                    i4.a().i("r_quickboost_set").putEbKey1(BAAU.f91g).commit();
                    Toast.makeText(SuperApplication.getContext(), SuperApplication.getContext().getResources().getString(R.string.wallpaper_ready), Toast.LENGTH_SHORT).show();
                } else {
//                    i4.a().i("r_quickboost_notset").putEbKey1(BAAU.f91g).commit();
                }
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
            super.onSurfaceCreated(surfaceHolder);
            this.y = true;
            wi.a(this, BAAU.this);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
            super.onSurfaceDestroyed(surfaceHolder);
            this.y = false;
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            xi.a(this, motionEvent);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onVisibilityChanged(boolean z) {
            super.onVisibilityChanged(z);
            if (!z) {
                if (!isPreview()) {
                    this.D = 1.0f;
                    this.E = 0.0f;
                    try {
                        h();
                    } catch (Exception unused) {
                    }
                } else {
                    this.j.cancelAnimation();
                }
            } else if (isPreview()) {
                this.j.playAnimation();
            }
            BAAU baau = BAAU.this;
            if (BAAU.f && z && !bj.n(baau.getApplicationContext())) {
//                i4.a().i("s_quickboost_desktop").commit();
            }
        }
    }

    public static final void a(Animator animator) {
        if (animator != null) {
            animator.removeAllListeners();
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).removeAllUpdateListeners();
            }
            animator.cancel();
        }
    }

    public static int b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    public static void c(Activity activity, String str) {
        if (f) {
            activity.startActivity(new Intent(activity, (Class<?>) BAAW.class));
        } else {
            d(activity, str);
        }
    }

    public static final boolean d(Activity activity, String str) {
        f91g = str;
        d = new WeakReference<>(activity);
        PackageManager packageManager = activity.getPackageManager();
        Intent intent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
        intent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(activity, (Class<?>) BAAU.class));
        if (intent.resolveActivity(packageManager) != null) {
            try {
                activity.startActivity(intent);
//                i4.a().i("s_quickboost_intro").putEbKey1(f91g).commit();
                return true;
            } catch (Exception unused) {
                Toast.makeText(SuperApplication.getContext(), SuperApplication.getContext().getResources().getString(R.string.string_not_supported), Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        Toast.makeText(SuperApplication.getContext(), SuperApplication.getContext().getResources().getString(R.string.string_not_supported), Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.service.wallpaper.WallpaperService
    public WallpaperService.Engine onCreateEngine() {
        MyEngine aVar = new MyEngine(this);
        this.a = new WeakReference<>(aVar);
        return aVar;
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f = false;
    }
}
