package com.example.tschakkaduschaffstdas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tschakkaduschaffstdas.data.model.Info
import com.example.tschakkaduschaffstdas.databinding.ListItemBinding

class ItemAdapter(private var dataset: List<Info>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun newData(data: List<Info>) {
        dataset = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val content = dataset[position]

        holder.binding.headlineMTV.text = content.headline
        holder.binding.contentLineMTV.text = content.contentLine
    }
}