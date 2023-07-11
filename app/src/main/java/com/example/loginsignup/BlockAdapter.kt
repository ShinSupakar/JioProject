package com.example.loginsignup

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.loginsignup.databinding.ItemBlockBinding

class BlockAdapter(
    private val blockList: List<String>,
    private val onItemClick: (position: Int) -> Unit
//    private val dataSet: List<String>,
//    private val onBlockClickListener: (BlockData) -> Unit
) : RecyclerView.Adapter<BlockAdapter.BlockViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBlockBinding.inflate(inflater, parent, false)
        return BlockViewHolder(binding)
    }
//    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
//        val block = dataSet[position]
//        holder.bind(block)
//        holder.itemView.setOnClickListener {
//            onBlockClickListener.invoke(block)
//        }
//
//        holder.blockButton.text = "Block ${block.blockNumber}"
//
//        holder.blockButton.setOnClickListener {
//            onBlockClickListener.invoke(block)
//        }
//    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        val block = blockList[position]

        holder.bind(block)

        holder.itemView.setOnClickListener {
            onItemClick(position)
            val imageView = holder.itemView.findViewById<ImageView>(R.id.imageView4)
            when (block) {
                blockList[1] -> imageView.setImageResource(R.drawable.check1)

            }
        }
    }

//        val option = dataSet[position]
//
//        holder.optionButton.text = option
//
//        holder.optionButton.setOnClickListener {
//            // Set the image based on the option clicked
//            val imageView = holder.itemView.findViewById<ImageView>(R.id.imageView)
//            when (option) {
//                "Option 1" -> imageView.setImageResource(R.drawable.image1)
//                "Option 2" -> imageView.setImageResource(R.drawable.image2)
//                // Handle other options as needed
//            }
//        }


    override fun getItemCount(): Int = blockList.size

    class BlockViewHolder(private val binding: ItemBlockBinding) :
        ViewHolder(binding.root) {

        fun bind(block: String) {
            binding.blockTextView.text = block
        }
    }


}