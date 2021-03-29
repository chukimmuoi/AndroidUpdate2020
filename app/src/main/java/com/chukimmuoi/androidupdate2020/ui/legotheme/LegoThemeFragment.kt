package com.chukimmuoi.androidupdate2020.ui.legotheme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chukimmuoi.androidupdate2020.R
import com.chukimmuoi.androidupdate2020.databinding.FragmentThemesBinding
import com.chukimmuoi.androidupdate2020.domain.api.Result
import com.chukimmuoi.androidupdate2020.extensions.hide
import com.chukimmuoi.androidupdate2020.extensions.injectViewModel
import com.chukimmuoi.androidupdate2020.extensions.show
import com.chukimmuoi.androidupdate2020.injection.Injectable
import com.chukimmuoi.androidupdate2020.ui.legotheme.adapter.LegoThemeAdapter
import com.chukimmuoi.androidupdate2020.utils.view.VerticalItemDecoration
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
class LegoThemeFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: LegoThemeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        val binding = FragmentThemesBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = LegoThemeAdapter()
        binding.recyclerView.addItemDecoration(
            VerticalItemDecoration(
                resources.getDimension(R.dimen.margin_normal).toInt(),
                true
            )
        )
        binding.recyclerView.adapter = adapter

        subscribeUi(binding, adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(binding: FragmentThemesBinding, adapter: LegoThemeAdapter) {
        viewModel.legoThemes.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    result.data?.let { adapter.submitList(it) }
                }
                Result.Status.LOADING -> binding.progressBar.show()
                Result.Status.ERROR -> {
                    binding.progressBar.hide()
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }
}