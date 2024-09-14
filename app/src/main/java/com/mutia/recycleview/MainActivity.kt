package com.mutia.recycleview



import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var btnRvBuku: Button
    private lateinit var btnRecycleView: Button
    private lateinit var btnCardMovie: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnRvBuku = findViewById<Button>(R.id.btnReciclyView)
        val btnRecycleView= findViewById<Button>(R.id.btnReciclyBuah)
        val btnCardMovie= findViewById<Button>(R.id.btnCardMovie)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnRvBuku.setOnClickListener() {
            startActivity(Intent(this,RecycleViewActivity::class.java))

        }
        btnRecycleView.setOnClickListener() {
            startActivity(Intent(this,CustomeImageRecycleView::class.java))

        }
        btnCardMovie.setOnClickListener() {
            startActivity(Intent(this,RecycleViewCardMovie::class.java))

        }
    }
}