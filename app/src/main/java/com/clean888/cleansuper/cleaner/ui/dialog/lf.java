package com.clean888.cleansuper.cleaner.ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.clean888.cleansuper.cleaner.databinding.DialogHomeMoreBinding;
import com.clean888.cleansuper.cleaner.ui.activity.BAAF;

public class lf extends PopupWindow implements View.OnClickListener {
    private Context a;
    private DialogHomeMoreBinding b;

    public lf(Context context) {
        super(context);
        this.a = context;
        this.b = DialogHomeMoreBinding.inflate(LayoutInflater.from(context));
        setWidth(-1);
        setHeight(-2);
        setContentView(this.b.getRoot());
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        this.b.clRoot.setOnClickListener(this);
//        i4.a().i("s_home_widget_mask").commit();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.clRoot) {
//            i4.a().i("c_home_widget_mask").commit();
            this.a.startActivity(new Intent(this.a, (Class<?>) BAAF.class));
            dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        super.showAsDropDown(view);
    }
}
