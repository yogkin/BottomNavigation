/*
 * Copyright 2018 Bakumon. https://github.com/Bakumon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package me.bakumon.moneykeeper.datasource

import android.icu.text.AlphabeticIndex
import android.text.TextUtils
import android.text.format.DateUtils
import androidx.lifecycle.LiveData

import com.czm.bottomnavigation.App
import com.czm.bottomnavigation.DefaultSPHelper
import com.czm.bottomnavigation.R
import com.czm.bottomnavigation.database.AppDataSource
import com.czm.bottomnavigation.datasource.AppDatabase
import io.reactivex.Completable
import java.math.BigDecimal
import java.util.*

/**
 * 数据源本地实现类
 *
 * @author Bakumon https://bakumon.me
 */
class LocalAppDataSource(private val mAppDatabase: AppDatabase) : AppDataSource {
    override fun getRecordTypeCount(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initRecordTypes(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
