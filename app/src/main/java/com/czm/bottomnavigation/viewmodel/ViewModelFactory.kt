
package com.czm.bottomnavigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.czm.bottomnavigation.database.AppDataSource

/**
 * ViewModel 工厂
 *
 * @author Bakumon https://bakumon.me
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val mDataSource: AppDataSource) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
//            modelClass.isAssignableFrom(AddRecordViewModel::class.java) -> AddRecordViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(RecordTypeViewModel::class.java) -> RecordTypeViewModel(
//                mDataSource
//            ) as T
//            modelClass.isAssignableFrom(TransferAssetsViewModel::class.java) -> TransferAssetsViewModel(
//                mDataSource
//            ) as T
//            modelClass.isAssignableFrom(OptionViewModel::class.java) -> OptionViewModel(
//                mDataSource
//            ) as T
//            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(TypeManageViewModel::class.java) -> TypeManageViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(TypeSortViewModel::class.java) -> TypeSortViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(AddTypeViewModel::class.java) -> AddTypeViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(BillViewModel::class.java) -> BillViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(ReportsViewModel::class.java) -> ReportsViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(TypeRecordsViewModel::class.java) -> TypeRecordsViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(ReviewViewModel::class.java) -> ReviewViewModel(mDataSource) as T
////            modelClass.isAssignableFrom(SettingViewModel::class.java) -> SettingViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(OtherSettingsViewModel::class.java) -> OtherSettingsViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(BackupViewModel::class.java) -> BackupViewModel(mDataSource) as T
////            modelClass.isAssignableFrom(BackupViewModel::class.java) -> BackupViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(AssetsViewModel::class.java) -> AssetsViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(AddAssetsViewModel::class.java) -> AddAssetsViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(AssetsDetailViewModel::class.java) -> AssetsDetailViewModel(mDataSource) as T
////            modelClass.isAssignableFrom(TransferViewModel::class.java) -> TransferViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(ModifyListViewModel::class.java) -> ModifyListViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(TransferRecordViewModel::class.java) -> TransferRecordViewModel(mDataSource) as T
//            modelClass.isAssignableFrom(OrderListViewModel::class.java) -> OrderListViewModel(mDataSource) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
