package com.clean888.cleansuper.cleaner.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.ViewDownListSmallBinding;
import com.clean888.cleansuper.cleaner.ui.adapter.SortPopAdapter;
import com.clean888.cleansuper.cleaner.ui.adapter.ac;

import java.util.ArrayList;
import java.util.List;

// BABY
public class SortPopView extends ConstraintLayout {
    private SortPopAdapter adapter;
    private ViewDownListSmallBinding binding;
    private b call;
    private List<ac> datas;
    private View targetView;
    private View.OnAttachStateChangeListener targetViewAttach;

    /* loaded from: classes2.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            SortPopView.this.refreshLayout();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b(ac acVar);
    }

    public SortPopView(@NonNull Context context) {
        super(context);
        this.targetViewAttach = new a();
        initView();
    }

    private void SetCheck(ac acVar) {
        if (acVar != null) {
            for (ac acVar2 : this.datas) {
                if (acVar2 != acVar) {
                    acVar2.d(false);
                }
            }
            acVar.d(true);
            this.adapter.notifyDataSetChanged();
            b bVar = this.call;
            if (bVar != null) {
                bVar.b(acVar);
            }
        }
    }

    private int[] getViewScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    private void initView() {
        if (this.binding == null) {
            ViewDownListSmallBinding inflate = ViewDownListSmallBinding.inflate(LayoutInflater.from(getContext()));
            this.binding = inflate;
            addView(inflate.getRoot(), new ConstraintLayout.LayoutParams(-1, -1));
            this.binding.bg.setOnClickListener(new View.OnClickListener() { // from class: yb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SortPopView.this.lambda$initView$0(view);
                }
            });
            this.adapter = new SortPopAdapter(R.layout.item_larget_menu_select);
            this.binding.list.setLayoutManager(new LinearLayoutManager(getContext()));
            this.binding.list.setAdapter(this.adapter);
            this.adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(@NonNull BaseQuickAdapter<?, ?> baseQuickAdapter, @NonNull View view, int i) {
                    SortPopView.this.lambda$initView$1(baseQuickAdapter, view, i);
                }
            });
            ArrayList arrayList = new ArrayList();
            this.datas = arrayList;
            arrayList.add(new ac(1, true));
            this.datas.add(new ac(1, false));
            this.datas.add(new ac(2, true));
            this.datas.add(new ac(2, false));
            this.adapter.setNewInstance(this.datas);
            SetCheck(this.datas.get(0));
            refreshLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        b bVar = this.call;
        if (bVar != null) {
            bVar.a();
        }
    }


    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        SetCheck(this.datas.get(i));
    }


    public void DownOnView(View view) {
        View view2 = this.targetView;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this.targetViewAttach);
        }
        this.targetView = view;
        view.addOnAttachStateChangeListener(this.targetViewAttach);
        if (this.targetView.isAttachedToWindow()) {
            refreshLayout();
        }
    }

    public void ShowOnAnim(boolean z) {
        setVisibility(z ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshLayout();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    public void refreshLayout() {
        View view = this.targetView;
        if (view == null || this.binding == null) {
            return;
        }
        int height = ((getViewScreen(view)[1] + this.targetView.getHeight()) - getViewScreen(this.binding.topLine)[1]) + getViewScreen((View) this.binding.topLine.getParent())[1];
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.binding.topLine.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = height - ((ViewGroup.MarginLayoutParams) layoutParams).height;
        this.binding.topLine.setLayoutParams(layoutParams);
    }

    public void setCall(b bVar) {
        this.call = bVar;
    }

    public SortPopView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.targetViewAttach = new a();
        initView();
    }

    public SortPopView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.targetViewAttach = new a();
        initView();
    }
}
