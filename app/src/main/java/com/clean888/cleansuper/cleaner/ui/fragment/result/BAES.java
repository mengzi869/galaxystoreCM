package com.clean888.cleansuper.cleaner.ui.fragment.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.databinding.FragmentFinishPermissionBinding;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAEX;
import com.clean888.cleansuper.cleaner.ui.fragment.BaseFragment;
import com.clean888.cleansuper.cleaner.utils.a_NotificationUtils;
import com.clean888.cleansuper.cleaner.ui.dialog.pf;

public class BAES extends BaseFragment implements View.OnClickListener {
    private FragmentFinishPermissionBinding binding;
    private int pageFrom;
    private boolean showEvaluate;
    private FuncFinishTitleModel type;
    private BAEX vm;

    private BAES(FuncFinishTitleModel ufVar) {
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
        this.binding.button.setOnClickListener(this);
        this.binding.back.setOnClickListener(this);
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
//        } else {
//            i = ufVar == uf.l ? a.i("app_scan_done") : null;
//        }
//        if (i != null) {
//            i.putEbKey1(Integer.valueOf(this.pageFrom)).commit();
//        }
    }

    public static BAES newInstance(FuncFinishTitleModel ufVar) {
        return new BAES(ufVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentFinishPermissionBinding fragmentFinishPermissionBinding = this.binding;
        if (view == fragmentFinishPermissionBinding.back) {
            finishActivity();
        } else if (view == fragmentFinishPermissionBinding.button) {
            a_NotificationUtils.e(getContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FuncFinishTitleModel ufVar;
        this.vm = (BAEX) new ViewModelProvider(this).get(BAEX.class);
        statusBarTextDarkLight(false);
        this.binding = FragmentFinishPermissionBinding.inflate(layoutInflater);
        if (this.type == null && (ufVar = this.vm.type) != null) {
            this.type = ufVar;
        }
        BAEX baex = this.vm;
        FuncFinishTitleModel ufVar2 = this.type;
        baex.type = ufVar2;
        if (ufVar2 != null) {
            BindVM();
            analy();
            this.vm.finish(getContext(), this.type);
            this.vm.canShow(this.pageFrom);
            if (this.showEvaluate) {
                pf.j(getContext(), this.type.Id);
            }
        } else {
            finishActivity();
        }
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (a_NotificationUtils.isEnable(getContext())) {
            finishActivity();
        }
    }

    public void setShowEvaluate(boolean z) {
        this.showEvaluate = z;
    }

    public BAES() {
    }
}
