package com.clean888.cleansuper.cleaner.bean;

import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishItemModel;

public class FinishItemFuncBean extends FinishItemBaseBean {

    public FuncFinishItemModel aFunc;

    public FinishItemFuncBean(FuncFinishItemModel aVar) {
        this.aFunc = aVar;
    }

    @Override
    public int getType() {
        return 1;
    }
}
