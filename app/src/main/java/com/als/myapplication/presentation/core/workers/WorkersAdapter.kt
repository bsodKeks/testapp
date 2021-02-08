package com.als.myapplication.presentation.core.workers

import com.als.myapplication.R
import com.als.myapplication.domain.dto.WorkerShort
import com.als.myapplication.presentation.app.App
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder


class WorkersAdapter(data: MutableList<WorkerShort>?) :
    BaseQuickAdapter<WorkerShort, BaseViewHolder>(R.layout.item_worker, data) {
    override fun convert(holder: BaseViewHolder, item: WorkerShort) {
        val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).circleCrop()

        Glide.with(App.instance.applicationContext)
            .load(item.url)
            .apply(requestOptions)
            .into(holder.getView(R.id.ivAvatar))

        holder.setText(R.id.tvName, item.fio)
            .setText(R.id.tvAge, item.vozrast)
    }
}