package com.clean888.cleansuper.cleaner.ui.adapter;

import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.clean888.cleansuper.cleaner.utils.kh;

import java.util.List;
import com.clean888.cleansuper.cleaner.utils.tb;
import com.clean888.cleansuper.cleaner.utils.lb;

/* loaded from: classes2.dex */
public class BABG extends BaseNodeAdapter {
    private kh iconHelper;

    public BABG(kh khVar) {
        this.iconHelper = khVar;
        addFullSpanNodeProvider(new ob());
        addNodeProvider(new sb(khVar));
    }

    @Override
    protected int getItemType(@NonNull List<? extends BaseNode> list, int i) {
        BaseNode qmVar = list.get(i);
        if (qmVar instanceof tb) {
            return 0;
        }
        return qmVar instanceof lb ? 1 : -1;

//        return 0;
    }
}
