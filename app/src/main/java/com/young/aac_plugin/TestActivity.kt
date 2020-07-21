package com.young.aac_plugin

import com.young.aac.base.MvvmBaseActivity
import com.young.aac_plugin.data.viewmodel.TestDataVM
import com.young.aac_plugin.databinding.ActivityTestBinding
import com.young.aac_plugin.ui.viewmodel.TestUIVM

class TestActivity : MvvmBaseActivity<ActivityTestBinding, TestUIVM, TestDataVM>() {


    override fun getDataViewModel(): TestDataVM? {
        return null
    }

    override fun getUIViewModel(): TestUIVM {
        return getActivityViewModelProvider(this).get(TestUIVM::class.java)
    }
    override val bindingVariable: Int
        get() = BR.br
    override val layoutId: Int
        get() =R.layout.activity_test
}
