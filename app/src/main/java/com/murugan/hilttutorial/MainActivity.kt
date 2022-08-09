package com.murugan.hilttutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

import com.murugan.hilttutorial.database.DatabaseAdapter
import com.murugan.hilttutorial.database.DatabaseService
import com.murugan.hilttutorial.hilt.ResponseInterceptor
import com.murugan.hilttutorial.network.NetworkService
import com.murugan.hilttutorial.stats.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var databaseAdapter: DatabaseAdapter

    /*get the instance through interface by @Binds*/
    //@Inject lateinit var networkAdapter: NetworkAdapter

    /*get the instance through Module by @Provides */
   // @CallInterceptor
    @ResponseInterceptor @Inject lateinit var networkService1: NetworkService
    @ResponseInterceptor @Inject lateinit var networkService2: NetworkService
    @ResponseInterceptor @Inject lateinit var networkService3: NetworkService

    private val statsViewModel: StatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "databaseAdapter:$databaseAdapter")
        databaseAdapter.log("Hello Hilt")

        // networkAdapter.log("Interface Binding!")

        networkService1.performNetworkCall()
        networkService2.performNetworkCall()
        networkService3.performNetworkCall()

        statsViewModel.statsLiveData.observe(this) { stats -> Log.d(TAG, "New stat coming in: $stats")}
        statsViewModel.startStatsCollection()
    }

    @Inject
    fun directToDatabase(databaseService: DatabaseService) {
        databaseService.log("Hello From Method Injection")
    }
}