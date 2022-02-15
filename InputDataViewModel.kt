package com.example.aplikasitokoonline.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.aplikasitokoonline.database.DatabaseClient.Companion.getInstance
import com.example.aplikasitokoonline.database.dao.DatabaseDao
import com.example.aplikasitokoonline.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers



class InputDataViewModel(application: Application) : AndroidViewModel(application) {

    var databaseDao: DatabaseDao?

    fun addDataSampah(
        nama_pengguna: String,
        info_aplikasi: String,
        berat: Int,
        harga: Int,
        tanggal: String,
        alamat: String,
        catatan: String
    ) {
        Completable.fromAction {

        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    init {
        databaseDao = getInstance(application)?.appDatabase?.databaseDao()
    }

}