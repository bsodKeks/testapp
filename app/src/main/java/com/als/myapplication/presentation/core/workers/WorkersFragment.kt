package com.als.myapplication.presentation.core.workers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.als.myapplication.R
import com.als.myapplication.domain.dto.WorkerShort
import com.als.myapplication.presentation.Constants
import kotlinx.android.synthetic.main.fragment_workers.view.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class WorkersFragment : MvpAppCompatFragment(), WorkersView {
    @InjectPresenter
    lateinit var presenter: WorkersPresenter
    private val adapter = WorkersAdapter(null)
    private lateinit var title: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_workers, container, false)
        val specId = arguments?.getInt(Constants.SPEC_ID)
        title = arguments?.getString(Constants.TITLE).toString()

        initView(view)
        if (savedInstanceState == null) presenter.getWorkers(specId)
        return view
    }

    private fun initView(view: View) {
        initAdapter(view)
        view.rvWorkers.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.rvWorkers.adapter = adapter
        view.tvTitle.text = title
    }

    private fun initAdapter(view: View) {
        adapter.setOnItemClickListener { _, _, position ->
            presenter.onWorkerClick(adapter.data[position].workerId)
        }
    }

    override fun showWorkers(workers: List<WorkerShort>) {
        adapter.setList(workers)
    }
}