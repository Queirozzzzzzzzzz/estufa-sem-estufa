package com.queirozzzzzzzzzz.estufasemestufa.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.queirozzzzzzzzzz.estufasemestufa.models.tables.Plant

@Dao
interface PlantDao {
    @Query("SELECT * FROM plant;")
    suspend fun getAllPlants(): List<Plant>

    @Query("SELECT * FROM plant WHERE environment_id = :environmentId;")
    suspend fun getPlantById(environmentId: Int): Plant?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlant(plant: Plant)
}