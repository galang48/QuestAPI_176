package com.example.questapi.viewmodel.provider

import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questapi.viewmodel.DetailViewModel
import com.example.questapi.viewmodel.EditViewModel
import com.example.questapi.viewmodel.EntryViewModel
import com.example.questapi.viewmodel.HomeViewModel


object ProviderViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                aplikasiDataSiswa().container
                    .repositoryDataSiswa
            )
        }
        initializer {
            EntryViewModel(
                aplikasiDataSiswa().container
                    .repositoryDataSiswa
            )
        }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositoryDataSiswa,
            )
        }
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositoryDataSiswa,
            )
        }
    }
}