package com.target.sendhil.deals.viewmodel

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.target.sendhil.deals.model.Data
import com.target.sendhil.deals.model.Response
import com.target.sendhil.deals.network.ApiInterface
import org.junit.Before
import org.junit.Test
import rx.Observable
import rx.schedulers.TestScheduler

class ProductListViewModelTest{
    lateinit var mViewModel: ProductListViewModel
    lateinit var testScheduler: TestScheduler
    lateinit var apiService: ApiInterface

    @Before
    @Throws(Exception::class)
    fun setUp() {
        testScheduler = TestScheduler()
    }

    @Test
    fun fetchDeals() {
        val response = Response("testId", mutableListOf(Data("id","","","","",1,"","","")),"testType")
        apiService = mock { on { getDeals() } doReturn Observable.just(response) }

        mViewModel = ProductListViewModel(testScheduler, testScheduler,apiService)

        mViewModel.fetchDeals()
        verify(apiService).getDeals()

    }
}