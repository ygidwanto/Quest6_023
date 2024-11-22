package com.example.latihan8.ui.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latihan8.model.Mahasiswa
import com.example.latihan8.model.RencanaStudi
import com.example.latihan8.R

@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    dataMhs: Mahasiswa,
    dataKrs: RencanaStudi,
    onBackButtonClicked: () -> Unit
){
    val listDataMhs = listOf(
        Pair("Nim", dataMhs.nim),
        Pair("Nama", dataMhs.nama),
        Pair("Email", dataMhs.email),
        Pair("MataKuliah", dataKrs.namaMk),
        Pair("Kelas", dataKrs.kelas),
    )

    Column (
        modifier = Modifier.fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Data Mahasiswa", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(10.dp))
        listDataMhs.forEach{ data ->
            DetailMhs(judul = data.first,
                isinya = data.second)

        }
        Spacer(modifier = Modifier.padding(20.dp))
        Button(modifier = Modifier.fillMaxWidth().background(color = colorResource( R.color.primary)), onClick = { onBackButtonClicked() }) {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun DetailMhs(
    judul: String, isinya: String
){
    Column (
        modifier = Modifier.fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Row (modifier = Modifier.fillMaxWidth().padding(top = 2.dp)){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.8f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }
    }
}