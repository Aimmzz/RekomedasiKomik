package com.rohim.rekomendasikomik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.rekomendasikomik.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    lateinit var binding7: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding7 = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding7.root)

        binding7.backToMain1.setOnClickListener {
            onBackPressed()
        }

    }
}