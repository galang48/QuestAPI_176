package com.example.questapi.model.data

import com.example.questapi.model.data.DataSiswa
import com.example.questapi.model.data.UiStateSiswa

fun DataSiswa.toUiStateSiswa(isEntryValid: Boolean = false): UiStateSiswa = UiStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)