package com.example.uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.example.uas.R.*
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTontonActivity: Button = findViewById(R.id.btnTonton)
        btnTontonActivity.setOnClickListener(this)
        val testData = createPhoneDate()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = AnimeAdapter(testData, { wisataItem : AnimeData->phoneItemClicked(wisataItem)})
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnTonton -> {
                val moveInten = Intent(this@MainActivity, MoveOnePiece::class.java)
                startActivity(moveInten)
            }
        }
    }
    private fun phoneItemClicked(animeItem: AnimeData) {
        val  showDetailActivityIntent = Intent(this, AnimeDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, animeItem.tempat.toString())
        showDetailActivityIntent.putExtra("data",animeItem)
        startActivity(showDetailActivityIntent)
    }

    private fun createPhoneDate(): List<AnimeData> {
        val partList = ArrayList<AnimeData>()
        partList.add(AnimeData(
            "BORUTO : NARUTO NEXT GENERATION",
            "Uzumaki Boruto sering menjadi pusat perhatian sebagai anak Hokage Ketujuh. Meskipun memiliki warisan nakal dan keras kepala dari Naruto, Boruto dianggap sebagai anak ajaib dan mampu melepaskan potensinya dengan bantuan teman dan keluarga yang mendukungnya. Sayang, ini hanya memperburuk arogansi dan keinginannya untuk mengalahkan Naruto, seiring dengan gaya hidup ayahnya yang sibuk, telah membuat hubungan mereka berantakan. Namun, kekuatan jahat di dalam desa bisa mengancam kehidupan Boruto yang damai.",
            "https://dw9to29mmj727.cloudfront.net/properties/2016/1363-SeriesThumbnail_BorutoAnime_400x320_v2.jpg"
            )
        )
        partList.add(AnimeData(
            "DRAGON BALL ",
            "KONTOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLlll",
            "https://upload.wikimedia.org/wikipedia/en/thumb/7/74/Dragon_Ball_Super_Key_visual.jpg/220px-Dragon_Ball_Super_Key_visual.jpg"
            )
        )
        partList.add(AnimeData(
            "NARUTO",
            "KONTOLLLLLLLLLLLLLLLLLLLLLLLL",
            "https://m.media-amazon.com/images/M/MV5BZmQ5NGFiNWEtMmMyMC00MDdiLTg4YjktOGY5Yzc2MDUxMTE1XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY268_CR0,0,182,268_AL_.jpg"
        )
        )
        return partList
    }
}