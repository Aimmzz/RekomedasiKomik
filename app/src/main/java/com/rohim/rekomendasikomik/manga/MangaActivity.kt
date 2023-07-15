package com.rohim.rekomendasikomik.manga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rohim.rekomendasikomik.HomeActivity
import com.rohim.rekomendasikomik.R
import com.rohim.rekomendasikomik.databinding.ActivityMangaBinding

class MangaActivity : AppCompatActivity() {
    lateinit var binding3: ActivityMangaBinding
    private val listManga = ArrayList<DataManga>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3 = ActivityMangaBinding.inflate(layoutInflater)
        setContentView(binding3.root)

        binding3.backToHome.setOnClickListener {
            onBackPressed()
        }

        binding3.rvManga.setHasFixedSize(true)
        listManga.addAll(getListManga())
        showRecyclerList()
    }


    private fun getListManga(): ArrayList<DataManga> {
        val dataMangaTitle = resources.getStringArray(R.array.name_title)
        val dataNameMangaka = resources.getStringArray(R.array.name_mangaka)
        val dataMangaImg = resources.obtainTypedArray(R.array.manga_list_photo)
        val dataSinopsisManga = resources.getStringArray(R.array.sinopsis_manga)
        val listManga = ArrayList<DataManga>()
        for (i in dataMangaTitle.indices) {
            val manga = DataManga(
                dataMangaImg.getResourceId(i, - 1),
                dataMangaTitle[i],
                dataNameMangaka[i],
                dataSinopsisManga[i]
            )
            listManga.add(manga)
        }
        return listManga
    }
    private fun showRecyclerList() {
        binding3.rvManga.layoutManager = LinearLayoutManager(this)
        val listMangaAdapter = ListMangaAdapter(listManga)
        binding3.rvManga.adapter = listMangaAdapter
    }
}