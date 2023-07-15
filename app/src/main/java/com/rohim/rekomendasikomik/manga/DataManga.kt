package com.rohim.rekomendasikomik.manga
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataManga(
    val mangaImage: Int,
    val mangaTitle: String,
    val mangaka: String,
    val sinopsisManga: String
    ): Parcelable