package com.example.loginsignup

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class GadgetInfoActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseRef: DatabaseReference
//    var blockNumberTextView: TextView = findViewById(R.id.blockNumberTextView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_gadget_info)
    database = FirebaseDatabase.getInstance()
    databaseRef = database.getReference("blocks")
    val showButton = findViewById<Button>(R.id.showButton)

    showButton.setOnClickListener {
        val roomNumberEditText = findViewById<EditText>(R.id.etFloorRooms)
        val roomNumber = roomNumberEditText.text.toString()
        retrieveData(roomNumber)
    }

    }
    private fun retrieveData(roomNumber: String) {
        databaseRef.child(roomNumber).get().addOnSuccessListener { dataSnapshot ->
            if (dataSnapshot.exists()) {
                val person1 = dataSnapshot.child("person1").getValue(String::class.java)
                val person2 = dataSnapshot.child("person2").getValue(String::class.java)
                val gadgets1 = dataSnapshot.child("gadgets1").getValue(Int::class.java)
                val gadgets2 = dataSnapshot.child("gadgets2").getValue(Int::class.java)
                val id1 = dataSnapshot.child("id1").getValue(Int::class.java)
                val id2 = dataSnapshot.child("id2").getValue(Int::class.java)

                // Display retrieved data
                displayData(person1, person2, gadgets1, gadgets2, id1, id2)
            } else {
                // Data does not exist
                displayData("N/A", "N/A", 0, 0, 0, 0)
            }
        }.addOnFailureListener {
            // Error occurred while retrieving data
            displayData("Error", "Error", 0, 0, 0, 0)
        }
    }
   private fun displayData(person1: String?, person2: String?, gadgets1: Int?, gadgets2: Int?, id1: Int?, id2: Int?) {
        // Display the data in your UI elements (e.g., TextViews)
        val person1TextView = findViewById<TextView>(R.id.person1TextView)
        val person2TextView = findViewById<TextView>(R.id.person2TextView)
        val gadgets1TextView = findViewById<TextView>(R.id.gadgets1TextView)
        val gadgets2TextView = findViewById<TextView>(R.id.gadgets2TextView)
        val id1TextView = findViewById<TextView>(R.id.id1TextView)
        val id2TextView = findViewById<TextView>(R.id.id2TextView)

        person1TextView.text = person1
        person2TextView.text = person2
        gadgets1TextView.text = gadgets1.toString()
        gadgets2TextView.text = gadgets2.toString()
        id1TextView.text = id1.toString()
        id2TextView.text = id2.toString()
    }
}
