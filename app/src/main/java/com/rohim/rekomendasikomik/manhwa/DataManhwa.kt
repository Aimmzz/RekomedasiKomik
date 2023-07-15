package com.rohim.rekomendasikomik.manhwa
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataManhwa(
    val manhwaImage: Int,
    val manhwaTitle: String,
    val author: String,
    val sinopsisManhwa: String
): Parcelable