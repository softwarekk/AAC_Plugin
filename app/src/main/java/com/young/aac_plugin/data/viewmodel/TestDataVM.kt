package com.young.aac_plugin.data.viewmodel

import androidx.lifecycle.MutableLiveData
import com.young.aac.base.BaseDataViewModel

/**
 * Des
 * Created by VULCAN on 2020-07-20 20:53:46
 */
class TestDataVM : BaseDataViewModel{
    var testDataVM= MutableLiveData<Int>()
    constructor() : super()
}