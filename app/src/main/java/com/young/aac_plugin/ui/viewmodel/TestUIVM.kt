package com.young.aac_plugin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.young.aac.base.BaseUIViewModel

/**
 * Des
 * Created by VULCAN on 2020-07-20 20:53:46
 */
class TestUIVM : BaseUIViewModel{
    var testData=MutableLiveData<Boolean>()
    constructor() : super()
}