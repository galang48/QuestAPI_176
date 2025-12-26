@file:OptIn(InternalSerializationApi::class)

package com.example.questapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questapi.model.data.DataSiswa
import com.example.questapi.repositori.RepositoryDataSiswa
import com.example.questapi.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import java.io.IOException
import retrofit2.HttpException

sealed interface StatusUIDetail {
    data class Success(
        val satuSiswa: DataSiswa,
    ) : StatusUIDetail

    object Error : StatusUIDetail

    object Loading : StatusUIDetail
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa,
) : ViewModel() {
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa() {
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading
            statusUIDetail =
                try {
                    StatusUIDetail.Success(satuSiswa = repositoryDataSiswa.getSatuSiswa(idSiswa))
                } catch (e: IOException) {
                    StatusUIDetail.Error
                } catch (e: HttpException) {
                    StatusUIDetail.Error
                }
        }
    }