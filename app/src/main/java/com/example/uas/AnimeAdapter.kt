package com.example.uas
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.anime_list.view.*
import com.example.uas.R.*

class AnimeAdapter (val animeList: List<AnimeData>, val clickListener: (AnimeData) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = from(parent.context)
        val view = inflater.inflate(layout.anime_list, parent, false)

        return PartViewHolder(view)

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as  PartViewHolder).bind(animeList[position],clickListener)
    }

    override fun getItemCount()=animeList.size

    //mengasih nilai
    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(uas: AnimeData, clickListener: (AnimeData) -> Unit){

            itemView.tv_part_item_name.text= uas.detailDiskripsi
            itemView.tv_part_id.text= uas.tempat.toString()
            Picasso.get().load(uas.image).resize(100,100).into(itemView.iv_contact_list)
            itemView.drawableState
            itemView.setOnClickListener({ clickListener(uas)})
        }
    }
}