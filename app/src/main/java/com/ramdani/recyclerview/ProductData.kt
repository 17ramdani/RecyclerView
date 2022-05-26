package com.ramdani.recyclerview

import java.util.*
object ProductData {
    private val productNames = arrayOf(
        "Keyboard ",
        "Mouse",
        "VR",
        "Headset",
        "Stik USB",
        "Monitor",
        "Gamepad",
        "Laptop",
        "USB Adapter",
        "Kamera")
    private val productDetails = arrayOf("Keterangan Keyboard.",
        "Keterangan Mouse.",
        "Keterangan VR.",
        "Keterangan Headset.",
        "Keterangan Stik USB.",
        "Keterangan Monitor.",
        "Keterangan Gamepad.",
        "Keterangan Laptop.",
        "Keterangan USB Adapter.",
        "Keterangan Kamera.")
    private val productImages = intArrayOf(
        R.drawable.gbr01,
        R.drawable.gbr02,
        R.drawable.gbr03,
        R.drawable.gbr04,
        R.drawable.gbr05,
        R.drawable.gbr06,
        R.drawable.gbr07,
        R.drawable.gbr08,
        R.drawable.gbr09,
        R.drawable.gbr10)
    val listData: ArrayList<Product>
        get() {
            val list = arrayListOf<Product>()
            for (position in productNames.indices) {
                val product = Product()
                product.name = productNames[position]
                product.detail = productDetails[position]
                product.photo = productImages[position]
                list.add(product)
            }
            return list
        }
}