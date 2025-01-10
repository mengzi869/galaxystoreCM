package com.clean888.cleansuper.cleaner.ui.fragment.result;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentFinishBinding;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAEX;
import com.clean888.cleansuper.cleaner.ui.fragment.BaseFragment;
import com.clean888.cleansuper.cleaner.bean.FinishItemAdBean;
import com.clean888.cleansuper.cleaner.bean.FinishItemFuncBean;
import com.clean888.cleansuper.cleaner.bean.FinishItemBaseBean;
import com.clean888.cleansuper.cleaner.ui.dialog.pf;

import java.util.ArrayList;
import java.util.Iterator;

public class BAEU extends BaseFragment implements View.OnClickListener, OnItemChildClickListener {
    private BACU adapter;
    private FragmentFinishBinding binding;
    private int pageFrom;
    private boolean showEvaluate;
    private FuncFinishTitleModel type;
    private BAEX vm;

    private BAEU(FuncFinishTitleModel ufVar) {
        this.type = ufVar;
    }

    private void BindVM() {
        this.binding.title.setText(this.type.TitleResId);
        this.binding.text1.setText(this.type.StateResId);
        FuncFinishTitleModel ufVar = this.type;
        if (ufVar.getExtras() != null) {
            this.binding.text2.setText(String.format(getString(ufVar.MsgResId), this.type.getExtras()));
        } else {
            this.binding.text2.setText(ufVar.MsgResId);
        }
        this.binding.back.setOnClickListener(this);
        BACU bacu = new BACU(getActivity(), this.type);
        this.adapter = bacu;
        bacu.setAnimationEnable(true);
        this.adapter.setAdapterAnimation(new uc());
        this.binding.list.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.binding.list.setAdapter(this.adapter);
        this.adapter.setOnItemChildClickListener(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FinishItemAdBean());
        Iterator<FuncFinishItemModel> it = FuncFinishItemModel.a(this.type).iterator();
        while (it.hasNext()) {
            arrayList.add(new FinishItemFuncBean(it.next()));
        }
        this.adapter.setNewInstance(arrayList);
        this.binding.list.postDelayed(new Runnable() { // from class: vf
            @Override // java.lang.Runnable
            public final void run() {
                BAEU.this.lambda$BindVM$0();
            }
        }, 1000L);
    }

    private void analy() {
//        ol0 i;
//        this.pageFrom = getActivity().getIntent().getIntExtra(MainActivity.FROM, 0);
//        t4 a = i4.a();
//        uf ufVar = this.type;
//        if (ufVar == uf.f) {
//            i = a.i("junkclean_done");
//        } else if (ufVar == uf.f2215g) {
//            i = a.i("phoneboost_done");
//        } else if (ufVar == uf.h) {
//            i = a.i("largefile_done");
//        } else if (ufVar == uf.k) {
//            i = a.i("batterysaver_done");
//        } else if (ufVar == uf.j) {
//            i = a.i("cpucooler_done");
//        } else if (ufVar == uf.i) {
//            i = a.i("security_done");
//        } else if (ufVar == uf.l) {
//            i = a.i("app_scan_done");
//        } else {
//            i = ufVar == uf.m ? a.i("s_ncleaner_done") : null;
//        }
//        if (i != null) {
//            i.putEbKey1(Integer.valueOf(this.pageFrom)).commit();
//        }
//        if (this.pageFrom == 1) {
//            i4.a().i("s_first_realscan_finish").commit();
//        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$BindVM$0() {
        this.adapter.setAnimationEnable(false);
    }

    public static BAEU newInstance(FuncFinishTitleModel ufVar) {
        return new BAEU(ufVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.binding.back) {
            if (this.pageFrom == 1) {
//                i4.a().i("c_first_realscan_finish_back").commit();
            }
            finishActivity();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FuncFinishTitleModel ufVar;
        this.vm = (BAEX) new ViewModelProvider(this).get(BAEX.class);
        statusBarTextDarkLight(false);
        this.binding = FragmentFinishBinding.inflate(layoutInflater);
        if (this.type == null && (ufVar = this.vm.type) != null) {
            this.type = ufVar;
        }
        BAEX baex = this.vm;
        FuncFinishTitleModel ufVar2 = this.type;
        baex.type = ufVar2;
        if (ufVar2 != null) {
            BindVM();
            if (this.showEvaluate) {
                pf.j(getContext(), this.type.Id);
            }
            analy();
            this.vm.finish(getContext(), this.type);
            this.vm.canShow(this.pageFrom);
        } else {
            finishActivity();
        }
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BACU bacu = this.adapter;
        if (bacu != null) {
            bacu.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        BACU bacu = this.adapter;
        if (bacu != null) {
            bacu.onHiddenChanged(z);
        }
    }

    @Override // defpackage.cy1
    public void onItemChildClick(@NonNull BaseQuickAdapter<?, ?> baseQuickAdapter, @NonNull View view, int i) {
        FuncFinishItemModel aVar = null;
        FinishItemBaseBean dfVar = (FinishItemBaseBean) baseQuickAdapter.getItem(i);
        if (dfVar == null || dfVar.getItemType() != 1 || (aVar = ((FinishItemFuncBean) dfVar).aFunc) == null || view.getId() != R.id.button) {
            L.e("BAEU","onItemChildClick return  dfVar.type"+dfVar.getItemType()+" aVar:"+aVar.name);
            return;
        }
        finishActivity();
        L.e("BAEU","onItemChildClick exe xf.a");
        xf.a(this.pageFrom, view.getContext(), aVar, this.type);
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.pageFrom == 1) {
//            i4.a().i("c_first_realscan_finish_back").commit();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BACU bacu = this.adapter;
        if (bacu != null) {
            bacu.onHiddenChanged(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BACU bacu = this.adapter;
        if (bacu != null) {
            bacu.onHiddenChanged(isHidden());
        }
    }

    public void setShowEvaluate(boolean z) {
        L.d("ZZR", "评分引导，setShowEvaluate:"+z);
        this.showEvaluate = z;
    }

    public BAEU() {
    }


}
