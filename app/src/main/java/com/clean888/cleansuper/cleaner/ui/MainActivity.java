package com.clean888.cleansuper.cleaner.ui;

import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.databinding.ActivityMainBinding;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.mc;
import com.clean888.cleansuper.cleaner.ui.activity.CpuCoolerActivity;
import com.clean888.cleansuper.cleaner.ui.activity.BatterySaverActivity;
import com.clean888.cleansuper.cleaner.ui.activity.BAAD;
import com.clean888.cleansuper.cleaner.ui.activity.BAAE;
import com.clean888.cleansuper.cleaner.ui.activity.BAAX;
import com.clean888.cleansuper.cleaner.ui.activity.BAAY;
import com.clean888.cleansuper.cleaner.ui.activity.BAFR;
import com.clean888.cleansuper.cleaner.ui.activity.ZZT;
import com.clean888.cleansuper.cleaner.ui.activity.LargeFileCleanActivity;
import com.clean888.cleansuper.cleaner.ui.activity.PhoneBoostActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.HomeFragment;
import com.clean888.cleansuper.cleaner.ui.fragment.MeFragment;
import com.clean888.cleansuper.cleaner.ui.fragment.MoreFragment;
import com.clean888.cleansuper.cleaner.utils.a_NotificationUtils;
import com.clean888.cleansuper.cleaner.utils.pj;
import com.clean888.cleansuper.cleaner.utils.lc;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fl;
import com.clean888.cleansuper.cleaner.service.BAAH;
import com.clean888.cleansuper.cleaner.service.BAAU;
import com.clean888.overseas.topon.InterstitialAdHelper;
import com.google.android.material.navigation.NavigationBarView;
import com.tencent.mmkv.MMKV;
import com.unity3d.player.StringFog;

import java.util.Map;

// ZZP
public class MainActivity extends BAFR implements NavigationBarView.OnItemSelectedListener {

    private static final String TAG = "MainActivityLog";
    public static final int ANTIVIRUS = 3;
    public static final int BATTERY = 5;
    public static final int BOOSTER = 2;
    public static final int CLEAN = 1;
    public static final int COOLER = 4;
    public static final String FROM = "from";
    public static final int FROM_1 = 1;
    public static final int FROM_2 = 2;
    public static final int FROM_3 = 3;
    public static final int FROM_4 = 4;
    public static final int FROM_5 = 5;
    public static final int FROM_6 = 6;
    public static final int FROM_7 = 7;
    public static final int FROM_8 = 8;
    public static final int INSTALL = 8;
    public static final String IS_INSTALL = "is_install";
    public static final int LAMP = 9;
    public static final int LARGEFILE = 7;
    public static final int NOTIFICATION = 10;
    public static final String PACKAGE = "package";
    public static final String PAGE = "page";
    public static final int SETTING = 6;
    public static final String VALUE = "value";
    public static int nResume = 0;
    private String analyRearch;
    private ActivityMainBinding binding;
    private Intent checkSDPerJumpIntent;
//    private cg dialog;
    private FragmentManager fragmentManager;
    private int goPage;
    private boolean hadNotificationPermission;
    private HomeFragment homeFragment;
    private Fragment lastFragment;
    private ActivityResultLauncher<String[]> launcher;
    private MeFragment meFragment;
    private MoreFragment moreFragment;
    private String packgeName;
    private String sceneType;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable = new Runnable() { // from class: t43
        @Override // java.lang.Runnable
        public final void run() {
            MainActivity.this.lambda$new$0();
        }
    };
    private final ActivityResultCallback<Map<String, Boolean>> resultCallback = new ActivityResultCallback() { // from class: s43
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainActivity.this.lambda$new$1((Map) obj);
        }
    };

    private void clearNavToast() {
        try {
            ViewGroup viewGroup = (ViewGroup) this.binding.navView.getChildAt(0);
            Menu menu = this.binding.navView.getMenu();
            for (int i = 0; i < menu.size(); i++) {
                viewGroup.getChildAt(i).findViewById(menu.getItem(i).getItemId()).setOnLongClickListener(new View.OnLongClickListener() { // from class: r43
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean lambda$clearNavToast$2;
                        lambda$clearNavToast$2 = MainActivity.lambda$clearNavToast$2(view);
                        return lambda$clearNavToast$2;
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @SuppressLint("WrongConstant")
    private void createPinnedShortcuts() {
        ShortcutManager shortcutManager;
        PendingIntent broadcast;
        int i = Build.VERSION.SDK_INT;
        if (i < 26 || (shortcutManager = (ShortcutManager) getSystemService(ShortcutManager.class)) == null || !shortcutManager.isRequestPinShortcutSupported()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra(PAGE, 2);
        intent.putExtra(FROM, 6);
        intent.setAction("android.intent.action.VIEW");
        intent.setPackage(getPackageName());
        ShortcutInfo build = new ShortcutInfo.Builder(this, "my-shortcut").setShortLabel(getString(R.string.wallpaper_boost)).setLongLabel(getString(R.string.wallpaper_boost)).setIcon(Icon.createWithResource(this, R.mipmap.icon_quick_clean)).setIntent(intent).build();
        Intent createShortcutResultIntent = shortcutManager.createShortcutResultIntent(build);
        if (i >= 34) {
            broadcast = PendingIntent.getBroadcast(this, 0, createShortcutResultIntent, 50331648);
        } else {
            broadcast = PendingIntent.getBroadcast(this, 0, createShortcutResultIntent, 33554432);
        }
        shortcutManager.requestPinShortcut(build, broadcast.getIntentSender());
    }

    private boolean goPage(Intent intent) {
        Intent intent2 = null;
        this.checkSDPerJumpIntent = null;
        this.goPage = intent.getIntExtra(PAGE, 0);
        this.packgeName = intent.getStringExtra(PACKAGE);
        this.analyRearch = intent.getStringExtra("analy_rearch");
        this.sceneType = intent.getStringExtra("scene_type");
        int intExtra = intent.getIntExtra(FROM, 0);
        int i = this.goPage;
        if (i != 0) {
            if (i == 1) {
                if (mc.o(this)) {
                    intent2 = new Intent(this, (Class<?>) ZZT.class);
                    intent2.putExtra(FROM, intExtra);
                } else {
                    this.checkSDPerJumpIntent = intent;
                    checkStoragePermissionDialog(2, null, true);
                    return true;
                }
            } else if (i == 2) {
                intent2 = new Intent(this, (Class<?>) PhoneBoostActivity.class);
                intent2.putExtra(FROM, intExtra);
            } else if (i != 3) {
                if (i == 4) {
                    intent2 = new Intent(this, (Class<?>) CpuCoolerActivity.class);
                } else if (i == 5) {
                    intent2 = new Intent(this, (Class<?>) BatterySaverActivity.class);
                } else if (i == 6) {
                    this.binding.navView.setSelectedItemId(R.id.menu_me);
                } else if (i == 7) {
                    if (mc.o(this)) {
                        intent2 = new Intent(this, (Class<?>) LargeFileCleanActivity.class);
                    } else {
                        this.checkSDPerJumpIntent = intent;
                        checkStoragePermissionDialog(2, null, true);
                        return true;
                    }
                } else if (i == 8) {
                    intent2 = new Intent(this, (Class<?>) BAAD.class);
                    intent2.putExtra(PACKAGE, this.packgeName);
                } else if (i == 9) {
                    intent2 = new Intent(this, (Class<?>) BAAE.class);
                } else if (i == 10) {
                    if (a_NotificationUtils.isEnable(SuperApplication.getContext())) {
                        intent2 = new Intent(this, (Class<?>) BAAX.class);
                    } else {
                        intent2 = new Intent(this, (Class<?>) BAAY.class);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.analyRearch)) {
//                i4.a().i(this.analyRearch).putEbKey1(this.sceneType).commit();
            }
            if (intent2 != null) {
                intent2.putExtras(intent);
                startActivity(intent2);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$clearNavToast$2(View view) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (a_mmkv.h().w()) {
            if (!MMKV.mmkvWithID("main").getBoolean("is_wallpaper_set", false)) {
                MMKV.mmkvWithID("main").putBoolean("is_wallpaper_set", true);
                BAAU.d(this, "1");
                return;
            } else {
                if (MMKV.mmkvWithID("main").getBoolean("is_laucher_set", false)) {
                    return;
                }
                MMKV.mmkvWithID("main").putBoolean("is_laucher_set", true);
                createPinnedShortcuts();
                return;
            }
        }
        MMKV.mmkvWithID("main").putBoolean("is_wallpaper_set", true);
        if (MMKV.mmkvWithID("main").getBoolean("is_laucher_set", false)) {
            return;
        }
        MMKV.mmkvWithID("main").putBoolean("is_laucher_set", true);
        createPinnedShortcuts();
    }


    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Map map) {
        if (checkFinish()) {
            return;
        }
//        i4.a().i(mc.m(this, mc.a(lc.a)) ? "c_sd_allow" : "c_sd_deny").putEbKey1(2).commit();
    }

    private void showForegroundNotificaton() {
        if (pj.b()) {
            return;
        }
        pj.d(true);
    }

    private boolean showNotificationTipIfNeed() {
        return bj.d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFR, bfj.ckdk.wazpqdu.cjzk.nysf.BAFS, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView(inflate.getRoot());
        sh.i(getIntent(), 2);
        sh.c(getIntent());
//        rh.b(this, 2);
//        rh.d(getIntent());
        fl.o(this);
//        n.a.h();
        this.launcher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), this.resultCallback);
        this.binding.navView.setOnItemSelectedListener(this);
        this.fragmentManager = getSupportFragmentManager();
        this.binding.navView.setSelectedItemId(R.id.menu_home);
        boolean goPage = goPage(getIntent());
        boolean showNotificationTipIfNeed = showNotificationTipIfNeed();
        showForegroundNotificaton();
        BAAH.f(this);
        if (!showNotificationTipIfNeed && !goPage) {
            String[] strArr = lc.a;
            if (!mc.m(this, mc.a(strArr)) && !mc.r(this, mc.a(strArr))) {
                this.launcher.launch(strArr);
//                i4.a().i("s_sd").putEbKey1(2).commit();
            }
        }
        clearNavToast();

        Log.e("sfsfsdg", StringFog.decrypt("eCM1DQZYFBdIND4jDgwZVA=="));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
//        t4 a = i4.a();
//        ol0 i = a.i("c_index");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_home) {
            if (this.homeFragment == null) {
                HomeFragment zzg = new HomeFragment();
                this.homeFragment = zzg;
                beginTransaction.add(R.id.fragment_container, zzg);
            }
            fragment = this.homeFragment;
//            i.putEbKey1(5);
//            a.i("c_home_tab").commit();
        } else if (itemId == R.id.menu_more) {
            if (this.moreFragment == null) {
                MoreFragment zzq = new MoreFragment();
                this.moreFragment = zzq;
                beginTransaction.add(R.id.fragment_container, zzq);
            }
            fragment = this.moreFragment;
//            i.putEbKey1(6);
//            a.i("c_moretools_tab").commit();
        } else if (itemId == R.id.menu_me) {
            if (this.meFragment == null) {
                MeFragment zzd = new MeFragment();
                this.meFragment = zzd;
                beginTransaction.add(R.id.fragment_container, zzd);
            }
            fragment = this.meFragment;
//            i.putEbKey1(7);
//            a.i("c_me_tab").commit();
        } else {
            fragment = null;
        }
        HomeFragment zzg2 = this.homeFragment;
        if (zzg2 != null && zzg2 != fragment) {
            beginTransaction.hide(zzg2);
        }
        MoreFragment zzq2 = this.moreFragment;
        if (zzq2 != null && zzq2 != fragment) {
            beginTransaction.hide(zzq2);
        }
        MeFragment zzd2 = this.meFragment;
        if (zzd2 != null && zzd2 != fragment) {
            beginTransaction.hide(zzd2);
        }
        if (fragment == null) {
            return false;
        }
        beginTransaction.show(fragment).commitAllowingStateLoss();
        if (this.lastFragment == fragment) {
            return true;
        }
        this.lastFragment = fragment;
//        i.commit();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        goPage(intent);
        sh.i(getIntent(), 2);
        sh.c(getIntent());
//        rh.b(this, 2);
//        rh.d(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFR
    public void onPerRequestBack(boolean z) {
        super.onPerRequestBack(z);
        if (!z) {
            this.checkSDPerJumpIntent = null;
            return;
        }
        Intent intent = this.checkSDPerJumpIntent;
        if (intent != null) {
            goPage(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int i = 2;
        sh.i(getIntent(), 2);
        sh.c(getIntent());
//        rh.b(this, 2);
//        rh.d(getIntent());
        if (this.hadNotificationPermission != bj.d(this)) {
            this.hadNotificationPermission = bj.d(this);
            BAAH.f(this);
        }

        nResume++;
        Log.e("showad","mainActivity onResume " + nResume);
        if(nResume >= 3){
            if(InterstitialAdHelper.getInstance().showInterstitialAd(this,null)){
                Log.e("showad","mainActivity onResume showad");
                nResume = 0;
            }
        }
//        xh.e(false);
//        boolean m = rc.m(this);
//        boolean d = bj.d(this);
//        if (m && d) {
//            i = 3;
//        } else if (!m) {
//            i = d ? 1 : -1;
//        }
//        if (i != -1) {
//            i4.a().i("push_yes").putEbKey1(Integer.valueOf(i)).commit();
//        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.handler.postDelayed(this.runnable, 10L);
        } else {
            this.handler.removeCallbacks(this.runnable);
        }
    }
}
