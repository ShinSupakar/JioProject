package com.example.loginsignup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loginsignup.databinding.ItemBlockBinding

class BlockAdapter(
    private val blockList: List<String>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<BlockAdapter.BlockViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBlockBinding.inflate(inflater, parent, false)
        return BlockViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        val block = blockList[position]
        holder.bind(block)

        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int = blockList.size

    class BlockViewHolder(private val binding: ItemBlockBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(block: String) {
            binding.blockTextView.text = block
        }
    }
}