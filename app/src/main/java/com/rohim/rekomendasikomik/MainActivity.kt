package com.rohim.rekomendasikomik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rohim.rekomendasikomik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aboutRohim.setOnClickListener {
            val about = Intent(this@MainActivity,AboutActivity::class.java)
            startActivity(about)
        }

        binding.btnLanjut.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
        })
    }
}