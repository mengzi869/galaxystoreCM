package com.clean888.cleansuper.cleaner.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentLargeFileBinding;
import com.clean888.cleansuper.cleaner.databinding.ViewListEmptyBinding;
import com.clean888.cleansuper.cleaner.utils.BAFC;
import com.clean888.cleansuper.cleaner.utils.StringFog;
import com.clean888.cleansuper.cleaner.utils.l81;
import com.clean888.cleansuper.cleaner.utils.md;
import com.clean888.cleansuper.cleaner.utils.mr0;
import com.clean888.cleansuper.cleaner.ui.ViewModel.LargeFileViewModel;
import com.clean888.cleansuper.cleaner.ui.adapter.SelectAdapter;
import com.clean888.cleansuper.cleaner.ui.adapter.TypePopAdapter;
import com.clean888.cleansuper.cleaner.ui.adapter.ac;
import com.clean888.cleansuper.cleaner.ui.adapter.zb;
import com.clean888.cleansuper.cleaner.ui.widget.SortPopView;
import com.clean888.cleansuper.cleaner.ui.widget.TypePopView;
import com.clean888.cleansuper.cleaner.utils.bc;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;
import java.util.List;

// BADT
public class LargeFileFragment extends BaseFragment implements View.OnClickListener, md.c {
    private FragmentLargeFileBinding binding;
    private long cleanSize;
    private boolean isSortPopShow;
    private boolean isTypePopShow;
    private String nowTypeStr;
    private int pageFrom = 0;
    private SelectAdapter selectAdapter;
    private md sizeAnim;
    private SortPopView sortPopView;
    private TypePopView typePopView;
    private int uiState;
    private LargeFileViewModel vm;


    /* loaded from: classes2.dex */
    public class a implements TypePopView.b {
        a() {
        }

        @Override // bfj.ckdk.wazpqdu.cjzk.vpfgiz.ujyip.dchm.BABX.b
        public void a() {
            LargeFileFragment.this.ShowPopType(false);
        }

        @Override // bfj.ckdk.wazpqdu.cjzk.vpfgiz.ujyip.dchm.BABX.b
        public void b(zb zbVar) {
            LargeFileFragment badt = LargeFileFragment.this;
            badt.nowTypeStr = TypePopAdapter.getTypeText(badt.getActivity(), zbVar);
            LargeFileFragment.this.ShowPopType(false);
            LargeFileFragment.this.vm.sortFilterAndPost(zbVar.b() ? -1 : zbVar.a());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SortPopView.b {
        b() {
        }

        @Override // bfj.ckdk.wazpqdu.cjzk.vpfgiz.ujyip.dchm.BABY.b
        public void a() {
            LargeFileFragment.this.ShowPopSort(false);
        }

        @Override // bfj.ckdk.wazpqdu.cjzk.vpfgiz.ujyip.dchm.BABY.b
        public void b(ac acVar) {
            LargeFileFragment.this.ShowPopSort(false);
            LargeFileFragment.this.vm.sortListAndPost(acVar.a(), acVar.b());
        }
    }

    private void BindVM() {
        this.uiState = 0;
        if (this.vm != null) {
            this.sizeAnim = new md.b().d(this);
            this.binding.icBack.setOnClickListener(this);
            this.binding.btnBottom.setOnClickListener(this);
            this.binding.menType.setOnClickListener(this);
            this.binding.icMenu.setOnClickListener(this);
            this.vm.v_cleanState.observe(getViewLifecycleOwner(), new Observer() { // from class: ye
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LargeFileFragment.this.OnStateChange(((Integer) obj).intValue());
                }
            });
            this.vm.v_junkSize.observe(getViewLifecycleOwner(), new Observer() { // from class: ze
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LargeFileFragment.this.lambda$BindVM$0((Long) obj);
                }
            });
            SelectAdapter babj = new SelectAdapter(R.layout.item_big_file_select);
            this.selectAdapter = babj;
            babj.setCall(new SelectAdapter.a() { // from class: bf
                @Override // bfj.ckdk.wazpqdu.cjzk.vpfgiz.ujyip.yokzvro.BABJ.a
                public final void a(Object obj, boolean z) {
                    LargeFileFragment.lambda$BindVM$1((bc) obj, z);
                }
            });
            this.binding.list.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.binding.list.setAdapter(this.selectAdapter);
            this.selectAdapter.setEmptyView(ViewListEmptyBinding.inflate(getLayoutInflater()).getRoot());
            this.vm.v_listData.observe(getViewLifecycleOwner(), new Observer() { // from class: af
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LargeFileFragment.this.lambda$BindVM$2((List) obj);
                }
            });
        }
        this.nowTypeStr = TypePopAdapter.getTypeText(getActivity(), new zb());
        UpdateTypeTitle(this.isTypePopShow);
    }

    public void OnStateChange(int i) {
        if (checkFragmentAlive()) {
            if (i == 0) {
                this.uiState = i;
                this.binding.btnBottom.setEnabled(false);
            } else if (i == 1) {
                this.uiState = i;
                this.binding.btnBottom.setEnabled(l81.y().B() > 0);
            } else {
                if (i != 2) {
                    return;
                }
                this.uiState = i;
                this.binding.btnBottom.setEnabled(false);
            }
        }
    }

    public void ShowPopSort(boolean z) {
        if (this.sortPopView == null) {
            this.sortPopView = new SortPopView(getActivity());
            ((ViewGroup) getActivity().getWindow().getDecorView()).addView(this.sortPopView, new ViewGroup.LayoutParams(-1, -1));
            this.sortPopView.setVisibility(View.GONE);
            this.sortPopView.setCall(new b());
            this.sortPopView.DownOnView(this.binding.line1);
        }
        this.isSortPopShow = z;
        this.sortPopView.ShowOnAnim(z);
        UpdateTypeTitle(this.isSortPopShow);
    }

    public void ShowPopType(boolean z) {
        if (this.typePopView == null) {
            this.typePopView = new TypePopView(getActivity());
            ((ViewGroup) getActivity().getWindow().getDecorView()).addView(this.typePopView, new ViewGroup.LayoutParams(-1, -1));
            this.typePopView.setVisibility(View.GONE);
            this.typePopView.setCall(new a());
            this.typePopView.DownOnView(this.binding.line2);
        }
        this.isTypePopShow = z;
        this.typePopView.ShowOnAnim(z);
        UpdateTypeTitle(this.isTypePopShow);
    }

    private void UpdateTypeTitle(boolean z) {
        String string;
        AppCompatTextView appCompatTextView = this.binding.expTitle;
        if (z) {
            string = getActivity().getString(R.string.large_file_me_type2);
        } else {
            string = TextUtils.isEmpty(this.nowTypeStr) ? getActivity().getString(R.string.large_file_me_type2) : this.nowTypeStr;
        }
        appCompatTextView.setText(string);
        this.binding.menTypeArr.setRotation(z ? 180.0f : 0.0f);
    }

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

    public static /* synthetic */ void lambda$BindVM$1(bc bcVar, boolean z) {
        l81.y().e();
    }

    public /* synthetic */ void lambda$BindVM$2(List list) {
        RecyclerView.Adapter adapter = this.binding.list.getAdapter();
        SelectAdapter babj = this.selectAdapter;
        if (adapter != babj) {
            this.binding.list.setAdapter(babj);
        }
        this.selectAdapter.setNewInstance(list);
        this.selectAdapter.notifyDataSetChanged();
    }

    public /* synthetic */ void lambda$OnSizeAnimUIUpdate$3(String str, String str2, String str3) {
        this.binding.btnBottom.setText(new BAFC().a(getString(R.string.large_file_op_del)).a(" (").a(str).a(")").f());
    }

    public static LargeFileFragment newInstance() {
        return new LargeFileFragment();
    }

    @Override // md.c
    public void OnSizeAnimUIUpdate(long j, long j2, long j3) {
        if (getActivity() == null || getActivity().isFinishing() || isDetached() || isRemoving()) {
            return;
        }
        try {
            mr0.b((float) j, 2, new mr0.a() { // from class: xe
                @Override // mr0.a
                public final void a(String str, String str2, String str3) {
                    LargeFileFragment.this.lambda$OnSizeAnimUIUpdate$3(str, str2, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG", "Error:", e);
        }
    }



    @Override
    public void onClick(View view) {
        FragmentLargeFileBinding fragmentLargeFileBinding = this.binding;
        if (view == fragmentLargeFileBinding.icBack) {
//            i4.a().i("c_largefile_back").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
            finishActivity();
            return;
        }
        if (view == fragmentLargeFileBinding.btnBottom) {
//            i4.a().i("c_largefile_clean").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
            long j = this.cleanSize;
            this.vm.doCleanJunk();
            replaceFragment(BAEY.newInstance(FuncFinishTitleModel.LargeFileClean.setExtras(mr0.a((float) j, 2))));
            return;
        }
        if (view == fragmentLargeFileBinding.menType) {
            if (this.isSortPopShow) {
                ShowPopSort(false);
                return;
            } else {
                ShowPopType(!this.isTypePopShow);
                return;
            }
        }
        if (view == fragmentLargeFileBinding.icMenu) {
            if (this.isTypePopShow) {
                ShowPopType(false);
            } else {
                ShowPopSort(!this.isSortPopShow);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        this.vm = (LargeFileViewModel) new ViewModelProvider(this).get(LargeFileViewModel.class);
        this.binding = FragmentLargeFileBinding.inflate(getLayoutInflater());
//        this.pageFrom = getActivity().getIntent().getIntExtra(ZZP.FROM, 0);
//        i4.a().i("s_largefile").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
        BindVM();
        this.vm.onCreate();
//        qh.c();


        Log.d("LargeFileFragment", StringFog.decrypt("Ozwg"));//-

        return this.binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        md mdVar = this.sizeAnim;
        if (mdVar != null) {
            mdVar.e();
        }
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            boolean z = (this.isSortPopShow || this.isTypePopShow) ? false : true;
            ShowPopType(false);
            ShowPopSort(false);
            if (z) {
//                i4.a().i("c_largefile_back").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
                finishActivity();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

}
