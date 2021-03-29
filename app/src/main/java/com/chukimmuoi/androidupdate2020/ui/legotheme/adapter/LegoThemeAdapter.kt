package com.chukimmuoi.androidupdate2020.ui.legotheme.adapter

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chukimmuoi.androidupdate2020.databinding.ListItemThemeBinding
import com.chukimmuoi.androidupdate2020.domain.model.LegoTheme
import com.chukimmuoi.androidupdate2020.ui.legotheme.LegoThemeFragmentDirections

/**
 * Adapter for the [RecyclerView] in [LegoThemeFragment].
 */
class LegoThemeAdapter : ListAdapter<LegoTheme, LegoThemeAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val legoTheme = getItem(position)
        holder.apply {
            bind(createOnClickListener(legoTheme.id, legoTheme.name), legoTheme)
            itemView.tag = legoTheme
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemThemeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    private fun createOnClickListener(id: Int, name: String): View.OnClickListener {
        return View.OnClickListener {
            val direction =
                LegoThemeFragmentDirections.actionThemeFragmentToSetsFragment(
                    id,
                    name
                )
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(private val binding: ListItemThemeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: LegoTheme) {
            binding.apply {
                clickListener = listener
                legoTheme = item
                executePendingBindings()
            }
        }
    }
}

// https://blog.mindorks.com/the-powerful-tool-diff-util-in-recyclerview-android-tutorial
private class DiffCallback : DiffUtil.ItemCallback<LegoTheme>() {

    override fun areItemsTheSame(oldItem: LegoTheme, newItem: LegoTheme): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LegoTheme, newItem: LegoTheme): Boolean {
        return oldItem == newItem
    }
}