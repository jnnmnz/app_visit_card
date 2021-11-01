package com.example.businnesscard

import android.app.Application
import com.example.businnesscard.data.AppDatabase
import com.example.businnesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}