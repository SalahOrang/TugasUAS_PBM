package com.example.uas
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.anime_detail.*
import com.example.uas.R.*

class   AnimeDetailActivity: AppCompatActivity() {

    private lateinit var kembali : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.anime_detail)

        kembali = findViewById(id.kembali)

        kembali.setOnClickListener {
            val  kembali = Intent(this, MainActivity::class.java)
            startActivity(kembali)
        }


        var intentData = getIntent()
        if(intentData.hasExtra("data")){
            val data = intentData.getSerializableExtra("data") as AnimeData
            tv_item_id.text = data.detailDiskripsi
            tv_item_id1.text = data.tempat.toString()

        }
    }
}