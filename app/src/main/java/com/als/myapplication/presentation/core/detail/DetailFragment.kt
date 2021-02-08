package com.als.myapplication.presentation.core.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.als.myapplication.R
import com.als.myapplication.domain.dto.WorkerDetail
import com.als.myapplication.presentation.Constants
import com.als.myapplication.presentation.app.App
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.view.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class DetailFragment: MvpAppCompatFragment(), DetailView {

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_detail, container, false)
        val workerId = arguments?.getLong(Constants.WORKER_ID)
        if (savedInstanceState == null) presenter.getWorker(workerId!!)
        return view
    }

    override fun showWorker(worker: WorkerDetail) {
        Glide.with(context!!)
            .load(worker.url)
            .centerInside()
            .into(view!!.ivPhoto)

        view!!.tvName.text = worker.fio
        view!!.tvBirthday.text = worker.dr
        view!!.tvSpecs.text = worker.specs
    }
}