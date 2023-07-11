package com.example.loginsignup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val imageView = view?.findViewById<ImageView>(R.id.imageView4)
//        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
//        val blockList = listOf("BLOCK 1" +
//                "                                                >", "BLOCK 2 " +
//                "                                               >", "BLOCK 3 " +
//                "                                               >", "BLOCK 4 " +
//                "                                               >", "BLOCK 5 " +
//                "                                               >")

//        recyclerView?.layoutManager = LinearLayoutManager(context)
//        recyclerView?.adapter = BlockAdapter(blockList)
//        val dataSet = listOf(
//            BlockData(1, R.drawable.check1),
//            BlockData(2, R.drawable.check1),
//            BlockData(3, R.drawable.check1),
//            BlockData(4, R.drawable.check1),
//            BlockData(5, R.drawable.check1)
//        )

//        BlockAdapter(blockList){
//
//        imageView?.setImageResource(R.drawable.check1)
//        }

//        BlockAdapter(dataSet) { block ->
//            // Set the image based on the block clicked
//            imageView?.setImageResource(block.imageResId)
//        }
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false)



    }



}
