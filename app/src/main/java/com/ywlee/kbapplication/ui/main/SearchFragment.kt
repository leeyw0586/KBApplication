package com.ywlee.kbapplication.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ywlee.kbapplication.R
import com.ywlee.kbapplication.data.ImageModel
import com.ywlee.kbapplication.databinding.FragmentSearchBinding
import com.ywlee.kbapplication.ui.adapter.SearchAdapter

class SearchFragment : Fragment() {

    private lateinit var searchAdapter: SearchAdapter
    private lateinit var searchViewModel: SearchViewModel
    private var _searchBinding: FragmentSearchBinding? = null
    private val binding get() = _searchBinding!!

    private var searchView: SearchView? = null


    companion object {
        @JvmStatic
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        searchView = view?.findViewById<SearchView>(R.id.searchView)
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                Log.d("asdf", p0.toString())
                searchViewModel.getImageList().observe(viewLifecycleOwner) { result ->
                    initView(result)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                Log.d("asdf", p0.toString())
                return true
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _searchBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _searchBinding = null
    }

    fun initView(result: ImageModel) {

        searchAdapter = SearchAdapter(this.requireContext())
        binding.rvSearch.adapter = searchAdapter
        binding.rvSearch.layoutManager =
            LinearLayoutManager(this.requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvSearch.addItemDecoration(
            DividerItemDecoration(
                this.requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )
        searchAdapter.data = result.documents
        searchAdapter.notifyDataSetChanged()
    }
}
