package com.example.questapi.repositori

import com.example.questapi.api.service.ServiceApiSiswa
import com.example.questapi.model.data.DataSiswa

class NetworkRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
):RepositoryDataSiswa{
    override suspend fun getDataSiswa() : List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDataSiswa(dataSiswa : DataSiswa):retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
}