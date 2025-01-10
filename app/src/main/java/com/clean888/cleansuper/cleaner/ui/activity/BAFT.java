package com.clean888.cleansuper.cleaner.ui.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.ui.dialog.sg;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class BAFT extends BaseFMActivity {
    private static final int WO_NIU_REQUEST = 65536;
    private b mListener;
    private int mRequestCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ sg a;
        final /* synthetic */ String[] b;
        final /* synthetic */ int c;

        a(sg sgVar, String[] strArr, int i) {
            this.a = sgVar;
            this.b = strArr;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            ActivityCompat.requestPermissions(BAFT.this.context, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b(int[] iArr);
    }

    private boolean checkEachPermissionsGranted(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEachSelfPermission(String[] strArr) {
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(this, str) != 0) {
                return true;
            }
        }
        return false;
    }

    public static String[] getPermissionList(String[] strArr, Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private void requestEachPermissions(String str, String[] strArr, int i) {
        if (!TextUtils.isEmpty(str) && shouldShowRequestPermissionRationale(strArr)) {
            showRationaleDialog(str, strArr, i);
        } else {
            ActivityCompat.requestPermissions(this.context, strArr, i);
        }
    }

    private boolean shouldShowRequestPermissionRationale(String[] strArr) {
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                return true;
            }
        }
        return false;
    }

    private void showRationaleDialog(String str, String[] strArr, int i) {
        sg sgVar = new sg(this.context);
        sgVar.show();
        sgVar.setCancelable(false);
        sgVar.c(str);
        sgVar.b(new a(sgVar, strArr, i));
    }

    @TargetApi(23)
    public boolean addPermission(ArrayList<String> arrayList, String str) {
        if (ContextCompat.checkSelfPermission(this.context, str) == 0 || shouldShowRequestPermissionRationale(str)) {
            return true;
        }
        arrayList.add(str);
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == this.mRequestCode) {
            if (checkEachPermissionsGranted(iArr)) {
                b bVar = this.mListener;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            b bVar2 = this.mListener;
            if (bVar2 != null) {
                bVar2.b(iArr);
            }
        }
    }

    public void performRequestPermissions(String str, String[] strArr, int i, b bVar) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        this.mRequestCode = i;
        this.mListener = bVar;
        if (Build.VERSION.SDK_INT < 23) {
            if (bVar != null) {
                bVar.a();
            }
        } else {
            if (checkEachSelfPermission(strArr)) {
                requestEachPermissions(str, strArr, i);
                return;
            }
            b bVar2 = this.mListener;
            if (bVar2 != null) {
                bVar2.a();
            }
        }
    }
}
