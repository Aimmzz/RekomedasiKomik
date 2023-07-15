package com.rohim.rekomendasikomik.manga

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohim.rekomendasikomik.databinding.MangaItemBinding

class ListMangaAdapter(private val mangaList: ArrayList<DataManga>): RecyclerView.Adapter<ListMangaAdapter.ListViewHolder>() {
    class ListViewHolder(var mangaBinding : MangaItemBinding) : RecyclerView.ViewHolder(mangaBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val bindingManga = MangaItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(bindingManga)
    }

    override fun getItemCount(): Int = mangaList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (mangaPhoto,title,mangaka) = mangaList[position]
        holder.mangaBinding.tvManga.text = title.toString()
        holder.mangaBinding.tvNameMangaka.text = mangaka.toString()
        holder.mangaBinding.ivManga.setImageResource(mangaPhoto)

        holder.itemView.setOnClickListener{
            val detailManga = Intent(holder.itemView.context, DetailManga::class.java)
            detailManga.putExtra("detail_manga", mangaList[holder.adapterPosition])
            holder.itemView.context.startActivity(detailManga)
        }
    }
}