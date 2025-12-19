package com.example.questapi.model.data

import com.example.questapi.model.data.DataSiswa
import com.example.questapi.model.data.DetailSiswa

fun DetailSiswa.toDataSiswa(): DataSiswa = DataSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)