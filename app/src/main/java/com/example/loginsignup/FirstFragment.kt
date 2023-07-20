package com.example.loginsignup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.loginsignup.databinding.FragmentFirstBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseRef: DatabaseReference

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

        //       return inflater.inflate(R.layout.fragment_first, container, false)
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = FirebaseDatabase.getInstance()
        databaseRef = database.getReference("blocks")

        val blockNumber = arguments?.getInt("blockNumber") ?: 1
        fetchBlockInfo(blockNumber)
    }

    private fun fetchBlockInfo(blockNumber: Int) {
        val blockRef = databaseRef.orderByChild("roomNumber")
            .startAt("$blockNumber-01-01").endAt("$blockNumber-03-03")

        blockRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var totalStudents = 0
                var totalGadgets = 0
                var max = 0
                var totalAmount = 0

                for (blockSnapshot in dataSnapshot.children) {
                    val blockData = blockSnapshot.value as? Map<String, Any>
                    blockData?.let {
                        val person1 = it["person1"] as String
                        val person2 = it["person2"] as String
                        val gadgets1 = it["gadgets1"] as Int
                        val gadgets2 = it["gadgets2"] as Int

                        if (!person1.isNullOrEmpty()) totalStudents++
                        if (!person2.isNullOrEmpty()) totalStudents++

                        totalGadgets += gadgets1 + gadgets2

                        max = (totalGadgets * 0.1).toInt()
                        totalAmount = max * 5


                    }
                }


                binding.studentsTextView.text = "Students Residing : $totalStudents"
                binding.devicesTextView.text = "Total Gadgets : $totalGadgets"
                binding.consumptionTextView.text = "Max Consumption : $max kWh"
                binding.amountTextView.text = "Total Amount : Rs $totalAmount"

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
                val errorMessage = "Database Error: ${databaseError.message}"
                binding.studentsTextView.text = errorMessage
                binding.devicesTextView.text = errorMessage
                binding.consumptionTextView.text = errorMessage
                binding.amountTextView.text = errorMessage
            }

        })


    }
}






