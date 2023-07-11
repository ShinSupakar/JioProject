package com.example.loginsignup


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginsignup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var blockBillList:ArrayList<BlockBill>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val blockList = listOf("BLOCK 1" +
                "                                                >", "BLOCK 2 " +
                "                                               >", "BLOCK 3 " +
                "                                               >", "BLOCK 4 " +
                "                                               >", "BLOCK 5 " +
                "                                               >")

        val adapter = BlockAdapter(blockList) { position ->
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("blockNumber", position + 1)
            startActivity(intent)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
//        blockBillList = ArrayList()
//        blockBillList.add(BlockBill(R.drawable.check1))

    }

//    class BlockBillViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val imageView: ImageView = itemView.findViewById(R.id.imageBill)
//
//
//    }
}