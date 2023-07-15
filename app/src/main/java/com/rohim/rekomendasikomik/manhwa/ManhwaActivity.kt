package com.rohim.rekomendasikomik.manhwa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohim.rekomendasikomik.R
import com.rohim.rekomendasikomik.databinding.ActivityManhwaBinding
import com.rohim.rekomendasikomik.manga.DataManga

class ManhwaActivity : AppCompatActivity() {
    lateinit var binding4: ActivityManhwaBinding
    private val listManhwa = ArrayList<DataManhwa>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding4 = ActivityManhwaBinding.inflate(layoutInflater)
        setContentView(binding4.root)

        binding4.backToHome2.setOnClickListener {
            onBackPressed()
        }

        binding4.rvManhwa.setHasFixedSize(true)
        listManhwa.addAll(getListManhwa())
        showRecyclerList2()

    }

    private fun getListManhwa(): ArrayList<DataManhwa> {
        val dataManhwaTitle = resources.getStringArray(R.array.manhwa_titel)
        val dataNameAuthor = resources.getStringArray(R.array.pengarang_manhwa)
        val dataMaanhwaImg = resources.obtainTypedArray(R.array.manhwa_list_foto)
        val dataSinopsisManhwa = resources.getStringArray(R.array.sinopsis_manhwa)
        val listManhwa = ArrayList<DataManhwa>()
        for (i in dataManhwaTitle.indices) {
            val manhwa = DataManhwa(
                dataMaanhwaImg.getResourceId(i, - 1),
                dataManhwaTitle[i],
                dataNameAuthor[i],
                dataSinopsisManhwa[i]
            )
            listManhwa.add(manhwa)
        }
        return listManhwa
    }
    private fun showRecyclerList2() {
        binding4.rvManhwa.layoutManager = LinearLayoutManager(this)
        val listManhwaAdapter = ListManhwaAdapter(listManhwa)
        binding4.rvManhwa.adapter = listManhwaAdapter
    }
}