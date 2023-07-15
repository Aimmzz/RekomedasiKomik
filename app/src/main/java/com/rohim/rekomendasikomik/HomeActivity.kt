package com.rohim.rekomendasikomik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rohim.rekomendasikomik.databinding.ActivityHomeBinding
import com.rohim.rekomendasikomik.databinding.ActivityMainBinding
import com.rohim.rekomendasikomik.manga.MangaActivity
import com.rohim.rekomendasikomik.manhwa.ManhwaActivity

class HomeActivity : AppCompatActivity() {
    lateinit var binding2: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        binding2.backToMain2.setOnClickListener {
            onBackPressed()
        }

        binding2.rekomendasiManga.setOnClickListener(View.OnClickListener {
            val intentManga = Intent(this@HomeActivity,MangaActivity::class.java)
            startActivity(intentManga)
        })
        binding2.rekomendasiManhwa.setOnClickListener(View.OnClickListener {
            val intentManhwa = Intent(this@HomeActivity,ManhwaActivity::class.java)
            startActivity(intentManhwa)
        })
    }
}