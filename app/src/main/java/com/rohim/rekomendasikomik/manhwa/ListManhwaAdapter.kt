package com.rohim.rekomendasikomik.manhwa

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohim.rekomendasikomik.databinding.ManhwaItemBinding

class ListManhwaAdapter(private val manhwaList : ArrayList<DataManhwa>) : RecyclerView.Adapter<ListManhwaAdapter.ListViewHolder2>() {
    class ListViewHolder2(var manhwaBinding: ManhwaItemBinding) : RecyclerView.ViewHolder(manhwaBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder2 {
        val bindingManhwa = ManhwaItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder2(bindingManhwa)
    }

    override fun getItemCount(): Int = manhwaList.size

    override fun onBindViewHolder(holder: ListViewHolder2, position: Int) {
        val (manhwaPhoto,manhwaTitle,manhwaAuthor) = manhwaList[position]
        holder.manhwaBinding.ivManhwa.setImageResource(manhwaPhoto)
        holder.manhwaBinding.tvManhwa.text = manhwaTitle
        holder.manhwaBinding.tvNameAuthor.text = manhwaAuthor

        holder.itemView.setOnClickListener{
            val detailManhwa = Intent(holder.itemView.context,DetailManhwa::class.java)
            detailManhwa.putExtra("detail_manhwa", manhwaList[holder.adapterPosition])
            holder.itemView.context.startActivity(detailManhwa)
        }
    }
}