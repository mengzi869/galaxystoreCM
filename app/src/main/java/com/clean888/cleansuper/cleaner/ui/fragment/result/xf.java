package com.clean888.cleansuper.cleaner.ui.fragment.result;

import android.content.Context;
import android.content.Intent;

import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.ui.activity.CpuCoolerActivity;
import com.clean888.cleansuper.cleaner.ui.activity.BatterySaverActivity;
import com.clean888.cleansuper.cleaner.ui.activity.PhoneBoostActivity;

/* loaded from: classes2.dex */
public class xf {
    public static void a(int i, Context context, FuncFinishItemModel aVar, FuncFinishTitleModel ufVar) {
        L.d("BAEU","xf start FinishFunc:"+aVar.name+" uf:"+ufVar.Id);
        Intent intent = null;
        Intent intent2 = null;
//        t4 a = i4.a();
//        ol0 ol0Var = null;
        if (FuncFinishItemModel.CpuCooler == aVar) {
            L.d("BAEU","xf CpuCooler");
//            ol0Var = a.i("c_cpucooler_button");
            intent = new Intent(context, (Class<?>) CpuCoolerActivity.class);
        } else if (FuncFinishItemModel.BaeetrySaver == aVar) {
            L.d("BAEU","xf BaeetrySaver");
//            ol0Var = a.i("c_batterysaver_button");
            intent = new Intent(context, (Class<?>) BatterySaverActivity.class);
        } else if (FuncFinishItemModel.PhoneBoot == aVar) {
            L.d("BAEU","xf PhoneBoot");
//            ol0Var = a.i("c_phoneboost_button");
            intent = new Intent(context, (Class<?>) PhoneBoostActivity.class);
        } else {
            if (FuncFinishItemModel.Security != aVar) {
                L.d("BAEU","xf Security != aVar("+aVar.name+")");
                if (FuncFinishItemModel.JunkClean == aVar) {
                    L.d("BAEU","xf JunkClean");
//                    ol0Var = a.i("c_clean_button");
                    intent2 = new Intent(context, (Class<?>) MainActivity.class);
                    intent2.putExtra(MainActivity.PAGE, 1);
                } else if (FuncFinishItemModel.LargeFile == aVar) {
                    L.d("BAEU","xf LargeFile");
//                    ol0Var = a.i("c_largefile_button");
                    intent2 = new Intent(context, (Class<?>) MainActivity.class);
                    intent2.putExtra(MainActivity.PAGE, 7);
                }
                intent = intent2;
            }else {
                L.d("BAEU","xf Security == aVar");
            }

        }
//        if (ol0Var != null) {
//            ol0Var.putEbKey1(Integer.valueOf(ufVar.a)).commit();
//        }
        if (intent != null) {
            intent.putExtra(MainActivity.FROM, 4);
            context.startActivity(intent);
        }
    }
}