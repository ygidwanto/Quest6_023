package com.example.latihan8.ui.view.viewmodel

import android.R
import com.example.latihan8.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel {
    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsStatusUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String){
        _krsState.update { stateMK -> stateMK.copy(namaMk = mkPilihan) }
    }
    fun setKelas(kelasPilihan: String){
        _krsState.update { stateKelas -> stateKelas.copy(namaMk = kelasPilihan) }
    }
    fun saveDataKRS(ls: MutableList<String>){
        _krsState.update { status -> status.copy(
            namaMk = ls[0],
            kelas = ls[1]
        )
        }
    }
}