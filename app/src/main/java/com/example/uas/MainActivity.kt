package com.example.uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTontonActivity: Button = findViewById(R.id.btnTonton)
        btnTontonActivity.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnTonton -> {
                val moveInten = Intent(this@MainActivity, MoveOnePiece::class.java)
                startActivity(moveInten)
            }
        }
    }
}
