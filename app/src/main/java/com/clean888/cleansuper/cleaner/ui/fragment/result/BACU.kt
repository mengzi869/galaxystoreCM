package com.clean888.cleansuper.cleaner.ui.fragment.result

import android.app.Activity
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.clean888.cleansuper.cleaner.R
import com.clean888.cleansuper.cleaner.bean.FinishItemBaseBean
import com.clean888.cleansuper.cleaner.bean.FinishItemFuncBean

class BACU(
    activity: Activity,
    ufVar: FuncFinishTitleModel
) : BaseMultiItemQuickAdapter<FinishItemBaseBean, BaseViewHolder>(null) {

    private var adHolder: BaseViewHolder? = null
    private var hasShowAd = false
    private var map: MutableMap<String, String> = HashMap()
    var type: FuncFinishTitleModel = ufVar
    var hasAnaly: MutableList<FuncFinishItemModel> = ArrayList()
    private var hidden = true

    init {
        if (ufVar == FuncFinishTitleModel.NotificationClean) {
            map["ext_key1"] = "na_4"
        } else {
            map["ext_key1"] = "na_1"
        }
        addItemType(1, R.layout.finish_item)
        addItemType(2, R.layout.finish_item_ad)
        addChildClickViewIds(R.id.button)
    }

    override fun onCreateDefViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        return if (viewType == 2) {
            adHolder ?: super.onCreateDefViewHolder(viewGroup, viewType).also {
                adHolder = it
            }
        } else {
            super.onCreateDefViewHolder(viewGroup, viewType)
        }
    }

    fun onDestroy() {
        // Do nothing
    }

    fun onHiddenChanged(z: Boolean) {
        hidden = z
    }

    override fun convert(baseViewHolder: BaseViewHolder, dfVar: FinishItemBaseBean) {
        if (baseViewHolder.itemViewType != 1) {
            return
        }
        val aVar = (dfVar as FinishItemFuncBean).aFunc
        baseViewHolder.setText(R.id.title, aVar.name)
        baseViewHolder.setText(R.id.text, aVar.des)
        baseViewHolder.setText(R.id.button, aVar.btn)
        baseViewHolder.setImageResource(R.id.icon, aVar.icon)
        if (!hasAnaly.contains(aVar)) {
            hasAnaly.add(aVar)
        }
    }
}
