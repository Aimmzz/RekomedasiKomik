package com.rohim.rekomendasikomik.manhwa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.rekomendasikomik.databinding.ActivityDetailManhwaBinding

class DetailManhwa : AppCompatActivity() {
    lateinit var binding6: ActivityDetailManhwaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding6 = ActivityDetailManhwaBinding.inflate(layoutInflater)
        setContentView(binding6.root)

        val detailManhwa = intent.extras?.getParcelable<DataManhwa>("detail_manhwa")
        detailManhwa?.let {
            binding6.detailImageManhwa.setImageResource(it.manhwaImage)
            binding6.detailTitleManhwa.text = it.manhwaTitle
            binding6.detailNameAuthor.text = it.author
            binding6.sinopsisManhwa.text = it.sinopsisManhwa
        }

        binding6.tempatBacaManhwa.setOnClickListener {
            val tempatManhwa = Intent(Intent.ACTION_VIEW, Uri.parse("https://shinigami.id/"))
            startActivity(tempatManhwa)
        }

        binding6.backToListManhwa.setOnClickListener {
            onBackPressed()
        }

        binding6.shareManhwa.setOnClickListener {
            val shareManhwa = Intent(Intent.ACTION_SEND)
            shareManhwa.type = "text/plain"
            val mangaContent = "Ini adalah manhwa favorit saya!!\n\n1. Solo Leveling\n2. Return The Mad Demon\n3. Legend of Asura - Venom Dragon\n4. Kill The Her\n5. Legend of Northern Blade\n" +
                    "6. Nano Machine\n7. Castle\n8. Return of Mount Hua Sect\n9. Leveling With Gods\n10. Maybe Meant to Be\n\n*baru text saja yang bisa dikirim dan belum spesifik."
            shareManhwa.putExtra(Intent.EXTRA_TEXT,mangaContent)
            startActivity(Intent.createChooser(shareManhwa,"Bagikan Ke:"))
        }

    }
}