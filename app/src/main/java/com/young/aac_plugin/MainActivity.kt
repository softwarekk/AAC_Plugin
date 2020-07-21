package com.young.aac_plugin

import android.os.Bundle
import android.util.Log
import com.young.aac.base.MvvmBaseActivity
import com.young.aac_plugin.data.viewmodel.TestDataVM
import com.young.aac_plugin.databinding.MainActivityBinding
import com.young.aac_plugin.ui.fragment.TestViewModelFragment
import com.young.aac_plugin.ui.fragment.TestViewModelFragment2
import com.young.aac_plugin.ui.viewmodel.TestUIVM

class MainActivity : MvvmBaseActivity<MainActivityBinding,TestUIVM,TestDataVM>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getUIViewModel().testData.value=false
        getDataViewModel()?.testDataVM?.value=1
        Log.e("viewmodel_data",getUIViewModel().testData.value.toString())
        Log.e("viewmodel_data",getDataViewModel()?.testDataVM?.value.toString())

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container,
                    TestViewModelFragment()
                )
                .add(R.id.container,
                    TestViewModelFragment2()
                )
                .commitNow()
        }
    }

    override fun getDataViewModel(): TestDataVM? {
        //自己和fragment 一块玩
        return getActivityViewModelProvider(this).get(TestDataVM::class.java)!!
    }

    override fun getUIViewModel(): TestUIVM {
        //自己和fragment 一块玩
        return getActivityViewModelProvider(this).get(TestUIVM::class.java)
        //整个app一块玩
//        return getAppViewModelProvider()?.get(TestUIVM::class.java)!!
    }

    override val bindingVariable: Int
        get() = BR.activity
    override val layoutId: Int
        get() = R.layout.main_activity
}
