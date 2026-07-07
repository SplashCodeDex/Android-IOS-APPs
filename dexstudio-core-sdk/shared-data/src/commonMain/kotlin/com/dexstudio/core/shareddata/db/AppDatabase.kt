package com.dexstudio.core.shareddata.db

import androidx.room3.ConstructedBy
import androidx.room3.Database
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import androidx.room3.RoomDatabase
import androidx.room3.RoomDatabaseConstructor
import androidx.room3.Dao
import androidx.room3.Query
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy

@Entity(tableName = "app_config")
data class AppConfigEntity(
    @PrimaryKey
    val id: String,
    val configData: String
)

@Dao
interface AppConfigDao {
    @Query("SELECT * FROM app_config")
    suspend fun getAllConfigs(): List<AppConfigEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConfig(config: AppConfigEntity)
}

@Database(entities = [AppConfigEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appConfigDao(): AppConfigDao
}

// Room compiler generates the actual implementation for this expect declaration.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}
