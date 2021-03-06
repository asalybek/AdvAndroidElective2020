package com.example.mvvmemployeeapp.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmemployeeapp.databinding.FragmentEmployeeListBinding
import com.example.mvvmemployeeapp.view.adapter.EmployeeListAdapter
import com.example.mvvmemployeeapp.viewmodel.EmployeeListViewModel
import kotlinx.android.synthetic.main.fragment_employee_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmployeeListFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentEmployeeListBinding
    private lateinit var adapter: EmployeeListAdapter
    private val repoListViewModel: EmployeeListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = FragmentEmployeeListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        viewDataBinding.viewmodel = repoListViewModel
        return viewDataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchEmployeeList()

        setupAdapter()
        setObservers()
    }


    private fun setObservers() {
        viewDataBinding.viewmodel?.fetchEmployeeList()?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = EmployeeListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            viewEmployees.layoutManager = layoutManager
            viewEmployees.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            viewEmployees.adapter = adapter
        }
    }

}