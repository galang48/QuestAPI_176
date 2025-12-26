@file:OptIn(InternalSerializationApi::class)

package com.example.questapi.viewmodel

import com.example.questapi.model.data.DataSiswa

sealed interface StatusUIDetail {
    data class Success(
        val satuSiswa: DataSiswa,
    ) : StatusUIDetail

    object Error : StatusUIDetail

    object Loading : StatusUIDetail
}