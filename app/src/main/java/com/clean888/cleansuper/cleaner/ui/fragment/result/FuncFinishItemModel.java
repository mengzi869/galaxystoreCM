package com.clean888.cleansuper.cleaner.ui.fragment.result;

import com.clean888.cleansuper.cleaner.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FuncFinishItemModel {
    public static final FuncFinishItemModel JunkClean;
    public static final FuncFinishItemModel PhoneBoot;

    public static final FuncFinishItemModel LargeFile;
    public static final FuncFinishItemModel Security;
    public static final FuncFinishItemModel CpuCooler;
    public static final FuncFinishItemModel BaeetrySaver;
    public static final FuncFinishItemModel BaeetrySaver2;
    private static final List<FuncFinishItemModel> mFuncList;
    public int name;
    public int des;
    public int btn;
    public int icon;

    static {
        JunkClean = new FuncFinishItemModel(R.string.finish_page_title_clean, R.string.finish_page_msg_clean, R.string.finish_page_action_clean, R.mipmap.icon_clean);
       
        PhoneBoot = new FuncFinishItemModel(R.string.finish_page_title_boost, R.string.finish_page_msg_boost, R.string.finish_page_action_boost, R.mipmap.icon_boost);
    
        LargeFile = new FuncFinishItemModel(R.string.finish_page_title_large_file, R.string.finish_page_msg_large_file, R.string.finish_page_action_large_file, R.mipmap.icon_large_file);
        
        Security = new FuncFinishItemModel(R.string.finish_page_title_antivirus, R.string.finish_page_msg_antivirus, R.string.finish_page_action_antivirus, R.mipmap.icon_security);
       
        CpuCooler = new FuncFinishItemModel(R.string.finish_page_title_cpu, R.string.finish_page_msg_cpu, R.string.finish_page_action_cpu, R.mipmap.icon_cooling);
       
        BaeetrySaver = new FuncFinishItemModel(R.string.finish_page_title_battery, R.string.finish_page_msg_battery, R.string.finish_page_action_battery, R.mipmap.icon_battery);

        BaeetrySaver2 = new FuncFinishItemModel(R.string.finish_page_title_battery, R.string.finish_page_msg_battery, R.string.finish_page_action_battery, R.mipmap.icon_notification);
      
        ArrayList arrayList = new ArrayList();
        mFuncList = arrayList;
        arrayList.add(JunkClean);
        arrayList.add(PhoneBoot);
        arrayList.add(LargeFile);
        arrayList.add(CpuCooler);
        arrayList.add(BaeetrySaver);
        arrayList.add(BaeetrySaver2);
    }

    private FuncFinishItemModel(int name, int des, int btn, int icon) {
        this.name = name;
        this.des = des;
        this.btn = btn;
        this.icon = icon;
    }

    public static List<FuncFinishItemModel> a(FuncFinishTitleModel ufVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(mFuncList);
        if (ufVar == FuncFinishTitleModel.Antivirus) {
            arrayList.remove(Security);
        } else if (ufVar == FuncFinishTitleModel.BatterySaver) {
            arrayList.remove(BaeetrySaver);
        } else if (ufVar == FuncFinishTitleModel.PhoneBoost) {
            arrayList.remove(PhoneBoot);
        } else if (ufVar == FuncFinishTitleModel.JunkClean) {
            arrayList.remove(JunkClean);
        } else if (ufVar == FuncFinishTitleModel.CpuCooler) {
            arrayList.remove(CpuCooler);
        } else if (ufVar == FuncFinishTitleModel.LargeFileClean) {
            arrayList.remove(LargeFile);
        }
        arrayList.remove(BaeetrySaver2);
        ArrayList arrayList2 = new ArrayList();
        Random random = new Random();
        arrayList2.add((FuncFinishItemModel) arrayList.remove(random.nextInt(arrayList.size())));
        arrayList2.add((FuncFinishItemModel) arrayList.remove(random.nextInt(arrayList.size())));
        arrayList2.add((FuncFinishItemModel) arrayList.remove(random.nextInt(arrayList.size())));
        return arrayList2;
    }
}