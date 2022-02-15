package com.example.aplikasitokoonline.database.dao

import androidx.room.Dao
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aplikasitokoonline.model.ModelDatabase



@Dao
interface DatabaseDao {

    @Query("SELECT * FROM tbl_tokoonline")
    fun getAll(): LiveData<List<ModelDatabase>>

    @Query("SELECT SUM(harga) FROM tbl_tokoonline")
    fun getSaldo(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(modelDatabases: ModelDatabase)

    @Query("DELETE FROM tbl_tokoonline WHERE uid= :uid")
    fun deleteSingleData(uid: Int)

}