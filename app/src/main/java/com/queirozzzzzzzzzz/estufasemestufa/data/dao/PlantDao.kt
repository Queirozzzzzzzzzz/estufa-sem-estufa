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
    suspend fun getPlantsByEnvironmentId(environmentId: Int): List<Plant>

    @Query("SELECT * FROM plant WHERE id = :id;")
    suspend fun getPlantById(id: Int): Plant?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlant(plant: Plant)

    @Query(
        "UPDATE plant SET name = :name, humidity = :humidity, ph = :ph, light_intensity = :lightIntensity, light_duration = :lightDuration, soil_conductivity = :soilConductivity, soil_salinity = :soilSalinity, temperature = :temperature WHERE id = :id;",
    )
    suspend fun updatePlant(
        id: Int,
        name: String,
        humidity: String?,
        ph: Int?,
        lightIntensity: String?,
        lightDuration: Int?,
        soilConductivity: Double?,
        soilSalinity: Double?,
        temperature: Int?,
    )

    @Query("DELETE FROM plant WHERE id = :id;")
    suspend fun deletePlantById(id: Int)

    @Query("DELETE FROM plant WHERE environment_id = :environmentId;")
    suspend fun deletePlantsByEnvironmentId(environmentId: Int)
}
