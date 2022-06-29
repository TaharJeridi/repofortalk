package it.wakala.talkrepo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ComicsTable::class], version = 1, exportSchema = false)
abstract class MarvelDataBase: RoomDatabase() {

    abstract fun marvelDAO():MarvelDao

    companion object{

        private  val DATABASE_NAME = MarvelDataBase::class.java.name


        @Volatile
        private var instance: MarvelDataBase? = null

        fun getDatabaseInstance(context: Context): MarvelDataBase {
            if (instance == null) {
                synchronized(MarvelDataBase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            MarvelDataBase::class.java, DATABASE_NAME
                        ).build()
                    }
                }
            }
            return instance!!
        }
    }




}