package com.als.myapplication.presentation.core.specs

import com.als.myapplication.R
import com.als.myapplication.domain.dto.SpecialityV
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class SpecsAdapter(data: MutableList<SpecialityV>?) :
    BaseQuickAdapter<SpecialityV, BaseViewHolder>(R.layout.item_spec, data){
    override fun convert(holder: BaseViewHolder, item: SpecialityV) {
        holder.setText(R.id.tvSpecName, item.name)
    }
}