package com.example.todoapp.ui.main.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.databinding.SettingFragmentBinding
import com.example.todoapp.databinding.SettingListItemBinding
import com.example.todoapp.ui.main.data.SettingItem

class SettingItemAdapter(
    val viewModel: SettingViewModel
    ) : RecyclerView.Adapter<SettingItemAdapter.SettingItemViewHolder>() {
    private val dataSet: List<SettingItem> = viewModel.settingItemList
    private var _binding: SettingListItemBinding? = null
    private val binding get() = _binding!!

    class SettingItemViewHolder(binding: SettingListItemBinding,
                                viewModel: SettingViewModel)
        : RecyclerView.ViewHolder(binding.root)  {

        private val settingTextView: TextView = binding.settingMenuName
        private val settingImageView: ImageView = binding.settingMenuIcon
        private var currentItem : SettingItem? = null

        init {
            binding.root.setOnClickListener {
                currentItem?.let {
                    viewModel.goSettingMenu(it.name)
                }
            }
        }

        fun bind(settingItem : SettingItem) {
            currentItem = settingItem

            settingTextView.text = settingItem.name
            settingImageView.contentDescription = settingItem.description

            settingImageView.setImageResource(settingItem.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingItemViewHolder {
        _binding = SettingListItemBinding.inflate(LayoutInflater.from(parent.context));

        return SettingItemViewHolder(binding = binding,viewModel = viewModel)
    }

    override fun onBindViewHolder(holder: SettingItemViewHolder, position: Int) {
        val settingItem:SettingItem = dataSet[position]
        holder.bind(settingItem = settingItem)
    }
    override fun getItemCount(): Int = dataSet.size

}