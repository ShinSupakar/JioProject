package com.example.loginsignup


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginsignup.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(){

    private lateinit var navigationView: NavigationView

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //neww
        navigationView = findViewById(R.id.navView)
        val logoutMenuItem = navigationView.menu.findItem(R.id.nav_logout)
        logoutMenuItem.setOnMenuItemClickListener {
            val intent = Intent(this,LoginActivity2::class.java)
            startActivity(intent)
            true
        }
        setUpViews()



        val blockList = listOf(
            "BLOCK 1" +
                    "                                                >", "BLOCK 2 " +
                    "                                               >", "BLOCK 3 " +
                    "                                               >", "BLOCK 4 " +
                    "                                               >", "BLOCK 5 " +
                    "                                               >"
        )

        //       val adapter1 = BlockAdapter(blockList) { position ->
        //         val intent = Intent(this, NextActivity::class.java)
        //           intent.putExtra("blockNumber", position + 1)
        //           startActivity(intent)
        //       }

        val adapter1 = BlockAdapter(blockList,
            onItemClick = { position ->
                val intent = Intent(this, NextActivity::class.java)
                intent.putExtra("blockNumber", position)
                startActivity(intent)
            },
            listener = { position ->
                // Handle the listener function here if needed
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter1

        //       val adapter2 = BlockAdapter(blockList) { position ->
        //          val firstFragment = FirstFragment()
//            val bundle = Bundle()
//            bundle.putInt("blockNumber", position + 1)
//            firstFragment.arguments = bundle

//        }

        val adapter2 = BlockAdapter(blockList,
            onItemClick = { position ->
                val firstFragment = FirstFragment()
                val bundle = Bundle()
                bundle.putInt("blockNumber", position)
                firstFragment.arguments = bundle
                // Handle the click event for FirstFragment if needed
            },
            listener = { position ->
                // Handle the listener function here if needed
            }
        )



        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter2
//        val navView = findViewById<NavigationView>(R.id.navView)
//        navView.setNavigationItemSelectedListener{
//            when(it.itemId){
//
//
//            }
//        }
    }


    //new
//    private fun logout(){
//
//        session.endLoginSession()
//    }

    fun setUpViews() {
        setUpDrawerLayout()
    }

    fun setUpDrawerLayout() {
        val mainDrawer = findViewById<DrawerLayout>(R.id.mainDrawer)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, mainDrawer, R.string.open_nav, R.string.close_nav)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.nav_settings -> supportFragmentManager.beginTransaction()
//                .replace()
//        }
//
//    }
}


//    class BlockBillViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val imageView: ImageView = itemView.findViewById(R.id.imageBill)
//
//
//    }
//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.nav_home
//        }









