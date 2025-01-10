package com.clean888.cleansuper.cleaner.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public abstract class FinishItemBaseBean implements MultiItemEntity {
    @Override
    public int getItemType() {
        return getType();
    }
    public abstract int getType();
}
