package com.example.todoapp.ui.main.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.R
import com.example.todoapp.dao.UserDao
import com.example.todoapp.ui.main.data.SettingItem

class SettingViewModel(val userDao: UserDao) : ViewModel() {

    private val _destination = MutableLiveData<Int>()
    val destination: LiveData<Int>
        get() = _destination

    private val _callDialogFlg = MutableLiveData<Boolean>()
    val callDialogFlg :LiveData<Boolean>
        get() = _callDialogFlg

    val settingItemList = listOf(
        SettingItem(id= 0, name = "계정", description = "계정", image = R.drawable.setting_item_account,value = null),
        SettingItem(id= 1, name = "화면", description = "화면", image = R.drawable.setting_item_screen,value = null),
        SettingItem(id= 2, name = "알림", description = "알림", image = R.drawable.setting_item_alert,value = null),
        SettingItem(id= 3, name = "공지사항", description = "공지사항", image = R.drawable.setting_item_notice,value = null),
        SettingItem(id= 4, name = "Premium", description = "Premium", image = R.drawable.setting_item_premium,value = null),
        SettingItem(id= 5, name = "정보", description = "정보", image = R.drawable.setting_item_info,value = null),
        SettingItem(id= 6, name = "문의하기", description = "문의하기", image = R.drawable.setting_item_inquiry,value = null)
    )

    val settingInfoItemList = listOf(
        SettingItem(id= 101, name = "버전", value = "1.0.0", description = "버전",image = null),
        SettingItem(id= 102, name = "로그아웃", value = "", description = "로그아웃",image = null)
    )

    fun goDirection(item: SettingItem) {
        when(item.name) {
            "계정" -> _destination.postValue(SettingDestination.setting)
            "화면" -> _destination.postValue(SettingDestination.setting)
            "알림" -> _destination.postValue(SettingDestination.setting)
            "공지사항" -> _destination.postValue(SettingDestination.setting)
            "Premium" -> _destination.postValue(SettingDestination.setting)
            "정보" -> _destination.postValue(SettingDestination.setting)
            "문의하기" -> _destination.postValue(SettingDestination.setting)
            "버전" -> return
            "로그아웃" -> setCallFlg(callDialogFlg=true)
        }
    }

    fun setCallFlg(callDialogFlg:Boolean) {
        _callDialogFlg.postValue(callDialogFlg)
    }
}