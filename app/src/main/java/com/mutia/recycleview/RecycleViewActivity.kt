package com.mutia.recycleview


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mutia.recycleview.adapter.BukuAdapter
import com.mutia.recycleview.model.ModelBuku


class RecycleViewActivity : AppCompatActivity() {
    //view group = bisa menampung data lebih cepat dn bnyk
    //recycle load data yg d layar aj

    private lateinit var rv_buku: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)

        rv_buku = findViewById(R.id.rv_data)
        val listBuku = listOf(
            ModelBuku(title = "Buku Android kotlin 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android kotlin 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android kotlin 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android kotlin 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android kotlin 2024", penulis = "Rizki Syaputra"),
        )

        val nBukuAdapter = BukuAdapter(listBuku)
        rv_buku.apply {

            layoutManager = LinearLayoutManager(this@RecycleViewActivity)
            adapter = nBukuAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}