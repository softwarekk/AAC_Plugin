package com.young.aac_plugin.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.young.aac.base.MvvmBaseFragment
import com.young.aac_plugin.BR
import com.young.aac_plugin.R
import com.young.aac_plugin.data.viewmodel.TestDataVM
import com.young.aac_plugin.databinding.ActivityTestBinding
import com.young.aac_plugin.ui.viewmodel.TestUIVM

class TestViewModelFragment :MvvmBaseFragment<ActivityTestBinding,TestUIVM,TestDataVM>() {
    //可以这么玩 用kTX 高效获得Viewmode （activity 共享级别的）
    private val model: TestUIVM by activityViewModels()//activity 级别的
    private val model2: TestUIVM by viewModels()//自己级别的


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //可以拿到同级的 打印为activity 设置的数据
        Log.e("viewmodel_data1",getUIViewModel().testData.value.toString())
        //只能拿到自己的 打印为null
        Log.e("viewmodel_data1",getDataViewModel()?.testDataVM?.value.toString())
        Log.e("viewmodel_data1","${model.testData.value}____${model2.testData.value}")
        getUIViewModel().testData.value=true
        getDataViewModel()?.testDataVM?.value=123
    }

    override val bindingVariable: Int
        get() =BR.br
    override val layoutId: Int
        get() = R.layout.activity_test

    override fun getUIViewModel(): TestUIVM {
        //只能自己玩
        return getFragmentViewModelProvider(this).get(TestUIVM::class.java)
    }

    override fun getDataViewModel(): TestDataVM? {
        //同级一块玩
        return getActivityViewModelProvider(requireActivity()).get(TestDataVM::class.java)!!
    }
}