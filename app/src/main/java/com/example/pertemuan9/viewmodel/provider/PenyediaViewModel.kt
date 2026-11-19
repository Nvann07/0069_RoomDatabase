package com.example.pertemuan9.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan9.viewmodel.DetailViewModel
import com.example.pertemuan9.viewmodel.EditViewModel
import com.example.pertemuan9.viewmodel.EntryViewModel
import com.example.pertemuan9.viewmodel.aplikasiSiswa

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            DetailViewModel(this.cretaeSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa)
        }

        initializer {
            EditViewModel(this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa)
        }
    }
}