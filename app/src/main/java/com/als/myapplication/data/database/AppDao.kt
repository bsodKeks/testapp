package com.als.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.data.database.dto.WorkerSpecDb
import com.als.myapplication.data.network.dto.Speciality

@Dao
interface AppDao {

    @Insert
    fun insertSpecs(specs: List<SpecialityDb>)

    @Insert
    fun insertWorker(workerDb: WorkerDb): Long

    @Insert
    fun insertWorkerSpec(workerSpecDb: WorkerSpecDb)

    @Query("SELECT * FROM SpecialityDb")
    fun getSpecs(): List<SpecialityDb>

    @Query("SELECT * FROM SpecialityDb WHERE specialityId in (SELECT specId FROM WorkerSpecDb WHERE workerId =:workerId)")
    fun getSpecsByWorker(workerId: Long): List<SpecialityDb>

    @Query("SELECT * FROM WorkerDb WHERE workerId in (SELECT WorkerId FROM WorkerSpecDb WHERE specId = :specId)")
    fun getWorkers(specId: Int): List<WorkerDb>

    @Query("SELECT * FROM WorkerDb WHERE workerId =:workerId")
    fun getWorker(workerId: Long): WorkerDb
}