package com.example.questapi.repositori

import android.app.Application
import com.example.questapi.repositori.container.ContainerApp
import com.example.questapi.repositori.container.DefaultContainerApp

class AplikasiDataSiswa : Application() {
    lateinit var container : ContainerApp
    override fun onCreate() {
        super.onCreate()
        this.container = DefaultContainerApp()
    }
}