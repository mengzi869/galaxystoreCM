package com.clean888.cleansuper.cleaner.ui.fragment;

import android.view.View;

import com.clean888.cleansuper.cleaner.databinding.FragmentJunkScanSelectBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.BAFC;
import com.clean888.cleansuper.cleaner.utils.kh;
import com.clean888.cleansuper.cleaner.utils.md;
import com.clean888.cleansuper.cleaner.utils.mr0;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;
import com.clean888.cleansuper.cleaner.utils.AppInfoUtil;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BADM;
import com.clean888.cleansuper.cleaner.ui.adapter.BABF;
import com.clean888.cleansuper.cleaner.ui.adapter.BABG;
import com.clean888.cleansuper.cleaner.ui.dialog.StopDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.ViewListEmptyBinding;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAEX;

import java.util.List;


//BADN
public class JunkScanSelectFragment extends BaseFragment implements View.OnClickListener {
    FragmentJunkScanSelectBinding binding;
    private long cleanSize;
    private BABF cleanTypeAdapter;
    private md colorAnim;
    private StopDialog dialog;
    private BABG junkGroupAdapter;
    private boolean scanFinish;
    private md sizeAnim;
    private int uiState;
    BADM vm;
    private kh iconHelper = new kh(null);
    private int pageFrom = 0;
    private md.c sizeAnimCall = new md.c() { // from class: ud
        @Override // md.c
        public final void OnSizeAnimUIUpdate(long j, long j2, long j3) {
            JunkScanSelectFragment.this.lambda$new$8(j, j2, j3);
        }
    };
    private md.c colorAnimCall = new md.c() { // from class: rd
        @Override // md.c
        public final void OnSizeAnimUIUpdate(long j, long j2, long j3) {
            JunkScanSelectFragment.this.lambda$new$9(j, j2, j3);
        }
    };

    private void BindVM() {
        this.uiState = 0;
        md d = new md.b().e(500L).f(new AccelerateInterpolator()).d(this.colorAnimCall);
        this.colorAnim = d;
        d.d(255L);
        ChangeTopColor(false);
        this.sizeAnim = new md.b().d(this.sizeAnimCall);
        this.binding.bgTop.setImageAlpha(1);
        this.binding.btnBottom.setEnabled(false);
        this.binding.icBack.setOnClickListener(this);
        this.binding.btnBottom.setOnClickListener(this);
        this.vm.v_junkSize.observe(getViewLifecycleOwner(), new Observer() { // from class: yd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JunkScanSelectFragment.this.lambda$BindVM$0((Long) obj);
            }
        });
        this.cleanTypeAdapter = new BABF(R.layout.item_clean_type);
        BABG babg = new BABG(this.iconHelper);
        this.junkGroupAdapter = babg;
        babg.setEmptyView(ViewListEmptyBinding.inflate(getLayoutInflater()).getRoot());
        this.binding.list.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.binding.list.setAdapter(this.cleanTypeAdapter);
        this.vm.v_cleanTypeList.observe(getViewLifecycleOwner(), new Observer() { // from class: zd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JunkScanSelectFragment.this.lambda$BindVM$1((List) obj);
            }
        });
        this.vm.v_selectGroupList.observe(getViewLifecycleOwner(), new Observer() { // from class: ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JunkScanSelectFragment.this.lambda$BindVM$2((List) obj);
            }
        });
        this.vm.v_zroAutoJumpFinish.observe(getViewLifecycleOwner(), new Observer() { // from class: wd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JunkScanSelectFragment.this.lambda$BindVM$4((Boolean) obj);
            }
        });
        this.vm.v_cleanState.observe(getViewLifecycleOwner(), new Observer() { // from class: xd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JunkScanSelectFragment.this.OnStateChange(((Integer) obj).intValue());
            }
        });
    }

    private void ChangeTopColor(boolean z) {
        this.colorAnim.c(z ? 0L : 255L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnStateChange(int i) {
        if (checkFragmentAlive()) {
            if (i == 0) {
                this.scanFinish = false;
                this.uiState = i;
                ChangeTopColor(false);
                this.binding.btnBottom.setEnabled(false);
                this.binding.tvProgressStatus.setText(R.string.clean_progress_scan);
                this.binding.list.setAdapter(this.cleanTypeAdapter);
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.uiState = i;
                this.binding.btnBottom.setEnabled(false);
                return;
            }
//            i4.a().i("s_junkclean").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
            this.scanFinish = true;
            this.uiState = i;
            ChangeTopColor(true);
            this.binding.btnBottom.setEnabled(true);
            BAFC.m(this.binding.tvProgressStatus).b(R.mipmap.ic_clean_warning).a("  ").a(String.format(getString(R.string.clean_progress_ready_clean), AppInfoUtil.getAppName(getActivity(), getActivity().getPackageName()))).f();
            this.binding.list.setAdapter(this.junkGroupAdapter);
        }
    }

    private void checkBack() {
        if (this.uiState == 1) {
            quit();
            return;
        }
        if (this.dialog == null) {
            this.dialog = new StopDialog(getActivity(), new Runnable() { // from class: td
                @Override // java.lang.Runnable
                public final void run() {
                    JunkScanSelectFragment.this.quit();
                }
            }, new Runnable() { // from class: ce
                @Override // java.lang.Runnable
                public final void run() {
                    JunkScanSelectFragment.this.lambda$checkBack$6();
                }
            });
        }
        this.dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$BindVM$0(Long l) {
        this.cleanSize = l.longValue();
        if (this.uiState == 1) {
            this.binding.btnBottom.setEnabled(l.longValue() > 0);
        }
        md mdVar = this.sizeAnim;
        if (mdVar != null) {
            mdVar.c(l.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$BindVM$1(List list) {
        RecyclerView.Adapter adapter = this.binding.list.getAdapter();
        BABF babf = this.cleanTypeAdapter;
        if (adapter != babf) {
            this.binding.list.setAdapter(babf);
        }
        this.cleanTypeAdapter.setNewInstance(list);
        this.cleanTypeAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$BindVM$2(List list) {
        RecyclerView.Adapter adapter = this.binding.list.getAdapter();
        BABG babg = this.junkGroupAdapter;
        if (adapter != babg) {
            this.binding.list.setAdapter(babg);
        }
        this.junkGroupAdapter.setNewInstance(list);
        this.junkGroupAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$BindVM$3() {
        if (getActivity() == null || getActivity().isFinishing() || isDetached() || isRemoving()) {
            return;
        }
//        i4.a().i("c_junkclean_auto").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
        replaceFragment(BAEY.newInstance(FuncFinishTitleModel.JunkClean.setExtras("")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$BindVM$4(Boolean bool) {
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        this.binding.getRoot().postDelayed(new Runnable() { // from class: sd
            @Override // java.lang.Runnable
            public final void run() {
                JunkScanSelectFragment.this.lambda$BindVM$3();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkBack$6() {
        checkFragmentAlive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(String str, String str2, String str3) {
        BAFC.m(this.binding.tvSizeSum).a(str2).a(" ").h(20, true).a(str3).h(20, true).f();
        this.binding.btnBottom.setText(new BAFC().a(getString(R.string.clean_btn_op_del)).a(" (").a(str).a(")").f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$8(long j, long j2, long j3) {
        if (getActivity() == null || getActivity().isFinishing() || isDetached() || isRemoving()) {
            return;
        }
        try {
            mr0.b((float) j, 2, new mr0.a() { // from class: vd
                @Override // mr0.a
                public final void a(String str, String str2, String str3) {
                    JunkScanSelectFragment.this.lambda$new$7(str, str2, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(long j, long j2, long j3) {
        if (getActivity() == null || getActivity().isFinishing() || isDetached() || isRemoving()) {
            return;
        }
        try {
            this.binding.bgTop.setImageAlpha((int) j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Fragment lambda$onClick$5(long j) {
        return BAEY.newInstance(FuncFinishTitleModel.JunkClean.setExtras(mr0.a((float) j, 2)));
    }

    public static JunkScanSelectFragment newInstance() {
        return new JunkScanSelectFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quit() {
        if (checkFragmentAlive()) {
//            i4.a().i(this.scanFinish ? "c_junkclean_back" : "c_junkscan_back").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
            finishActivity();
        }
    }

    @Override
    public void onClick(View view) {
        FragmentJunkScanSelectBinding fragmentJunkScanSelectBinding = this.binding;
        if (view == fragmentJunkScanSelectBinding.icBack) {
            if (this.pageFrom == 1) {
//                i4.a().i("c_first_realscan_back").commit();
            }
            checkBack();
        } else if (view == fragmentJunkScanSelectBinding.btnBottom) {
            if (this.pageFrom == 1) {
//                i4.a().i("c_first_realscan_clean").commit();
            }
//            i4.a().i("c_junkclean_clean").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
            final long j = this.cleanSize;
            this.vm.doCleanJunk();
            replaceFragment(new JunCleanAnimFragment.b().b(new JunCleanAnimFragment.b.a() { // from class: be
                @Override // bfj.ckdk.wazpqdu.cjzk.vpfgiz.sosrd.BADL.b.a
                public final Object a() {
                    Fragment lambda$onClick$5;
                    lambda$onClick$5 = JunkScanSelectFragment.lambda$onClick$5(j);
                    return lambda$onClick$5;
                }
            }).a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        BAEX baex = (BAEX) new ViewModelProvider(this).get(BAEX.class);
        statusBarTextDarkLight(false);
        this.vm = (BADM) new ViewModelProvider(this).get(BADM.class);
        this.binding = FragmentJunkScanSelectBinding.inflate(getLayoutInflater());
        this.pageFrom = getActivity().getIntent().getIntExtra(MainActivity.FROM, 0);
//        i4.a().i("s_junkscan").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
        BindVM();
        this.vm.onCreate();
        if (this.pageFrom == 1) {
//            i4.a().i("s_first_realscan_result").commit();
        }
        baex.enter(viewGroup.getContext(), FuncFinishTitleModel.JunkClean);
//        qh.c();
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        md mdVar = this.sizeAnim;
        if (mdVar != null) {
            mdVar.e();
        }
        md mdVar2 = this.colorAnim;
        if (mdVar2 != null) {
            mdVar2.e();
        }
        kh khVar = this.iconHelper;
        if (khVar != null) {
            khVar.n();
        }
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            checkBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

}
