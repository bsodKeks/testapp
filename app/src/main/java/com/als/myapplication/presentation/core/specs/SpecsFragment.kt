package com.als.myapplication.presentation.core.specs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.als.myapplication.R
import com.als.myapplication.data.network.dto.Speciality
import com.als.myapplication.domain.dto.SpecialityV
import kotlinx.android.synthetic.main.fragment_specs.view.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class SpecsFragment : MvpAppCompatFragment(), SpecsView {
    @InjectPresenter
    lateinit var presenter: SpecsPresenter
    private val adapter: SpecsAdapter = SpecsAdapter(null)
    private lateinit var loadingView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_specs, container, false)
        initView(view)
        if (savedInstanceState == null) presenter.getData()
        return view
    }

    private fun initView(view: View) {
        initAdapter(view)
        view.rvSpecs.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.rvSpecs.adapter = adapter
    }

    private fun initAdapter(view: View) {
        loadingView = layoutInflater.inflate(
            R.layout.view_loading,
            view.rvSpecs.parent as ViewGroup,
            false
        )
        adapter.setEmptyView(loadingView)
        adapter.setOnItemClickListener { _, _, position ->
            presenter.onSpecClick(adapter.data[position].specialityId, adapter.data[position].name)
        }
    }

    override fun showSpecs(specialtys: List<SpecialityV>) {
        adapter.setList(specialtys)
    }
}