
package com.czm.bottomnavigation.database

import io.reactivex.Completable
/**
 * 数据源
 *
 * @author Bakumon https://bakumon.me
 */
interface AppDataSource {

    /**
     * 初始化默认的记账类型
     */
    fun initRecordTypes(): Completable

    /**
     * 获取类型表记录数
     */
    fun getRecordTypeCount(): Long

}
