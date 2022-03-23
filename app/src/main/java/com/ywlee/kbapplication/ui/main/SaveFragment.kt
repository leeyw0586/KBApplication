package com.ywlee.kbapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ywlee.kbapplication.databinding.FragmentSaveBinding

class SaveFragment : Fragment() {

    private lateinit var saveViewModel: SaveViewModel
    private var _saveBinding: FragmentSaveBinding? = null
    private val binding get() = _saveBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saveViewModel = ViewModelProvider(this).get(SaveViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _saveBinding = FragmentSaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(): SaveFragment {
            return SaveFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _saveBinding = null
    }
}