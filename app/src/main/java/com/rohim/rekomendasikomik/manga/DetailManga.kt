package com.rohim.rekomendasikomik.manga

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rohim.rekomendasikomik.databinding.ActivityDetailMangaBinding

class DetailManga : AppCompatActivity() {
    lateinit var binding5: ActivityDetailMangaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding5 = ActivityDetailMangaBinding.inflate(layoutInflater)
        setContentView(binding5.root)

        val detailManga = intent.extras?.getParcelable<DataManga>("detail_manga")
        detailManga?.let {
            binding5.detailImageManga.setImageResource(it.mangaImage)
            binding5.detailTitleManga.text = it.mangaTitle
            binding5.detailNameMangaka.text = it.mangaka
            binding5.sinopsisManga.text = it.sinopsisManga
        }

        binding5.tempatBacaManga.setOnClickListener {
            val tempatWeb = Intent(Intent.ACTION_VIEW, Uri.parse("https://mangatale.co/"))
            startActivity(tempatWeb)
        }
        binding5.backToListManga.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
        binding5.shareManga.setOnClickListener {
            val shareManga = Intent(Intent.ACTION_SEND)
            shareManga.type = "text/plain"
            val mangaContent = "Ini adalah manga favorit saya!!\n\n1. One Piece\n2. Berserk\n3. Kingdom\n4. Jujutsu Kaisen\n5. Bleach\n" +
                    "6. Black Clover\n7. Naruto\n8. Rebuild World\n9. Fairy Tail\n10. Fire Force\n\n*baru text saja yang bisa dikirim dan belum spesifik."
            shareManga.putExtra(Intent.EXTRA_TEXT,mangaContent)
            startActivity(Intent.createChooser(shareManga,"Bagikan Ke:"))
        }
    }
}