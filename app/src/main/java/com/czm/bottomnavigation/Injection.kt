
package com.czm.bottomnavigation

import com.czm.bottomnavigation.database.AppDataSource
import com.czm.bottomnavigation.datasource.AppDatabase
import com.czm.bottomnavigation.viewmodel.ViewModelFactory
import me.bakumon.moneykeeper.datasource.LocalAppDataSource

/**
 * @author Bakumon https://bakumon.me
 */
object Injection {
    fun provideUserDataSource(): AppDataSource {
        val database = AppDatabase.instance!!
        return LocalAppDataSource(database)
    }

    fun provideViewModelFactory(): ViewModelFactory {
        val dataSource = provideUserDataSource()
        return ViewModelFactory(dataSource)
    }
}
