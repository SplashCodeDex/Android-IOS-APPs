package com.dexstudio.core.shareddata.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy

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
