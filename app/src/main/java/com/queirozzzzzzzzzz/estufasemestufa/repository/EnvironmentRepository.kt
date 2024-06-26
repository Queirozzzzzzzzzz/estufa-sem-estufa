package com.queirozzzzzzzzzz.estufasemestufa.repository

import android.app.Application
import com.queirozzzzzzzzzz.estufasemestufa.data.dao.EnvironmentDao
import com.queirozzzzzzzzzz.estufasemestufa.data.db.LocalDatabase
import com.queirozzzzzzzzzz.estufasemestufa.models.tables.Environment
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EnvironmentRepository
    @Inject
    constructor(app: Application) {
        private var environmentDao: EnvironmentDao

        init {
            val db = LocalDatabase.getInstance(app)
            environmentDao = db.environmentDao()
        }

        suspend fun getAllEnvironments(): List<Environment> {
            return environmentDao.getAllEnvironments()
        }

        suspend fun getEnvironmentById(environmentId: Int): Environment? {
            return environmentDao.getEnvironmentById(environmentId)
        }

        suspend fun insertEnvironment(environment: Environment): Long {
            return environmentDao.insertEnvironment(environment)
        }

        suspend fun updateEnvironment(environment: Environment) {
            val id = environment.id
            val name = environment.name
            val closed = environment.closed
            val biome = environment.biome
            val goals = environment.goals

            environmentDao.updateEnvironment(id, name, closed, biome, goals)
        }

        suspend fun deleteEnvironmentById(environmentId: Int) {
            environmentDao.deleteEnvironmentById(environmentId)
        }
    }
