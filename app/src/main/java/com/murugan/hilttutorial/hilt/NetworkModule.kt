package com.murugan.hilttutorial.hilt

import com.murugan.hilttutorial.network.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ActivityComponent::class/*,SingletonComponent::class*/)
/*
abstract class NetworkModule {
    @Binds
    abstract fun bindMyNetworkAdapterImp(myNetworkAdapterImp: MyNetworkAdapterImp): NetworkAdapter
}*/
class NetworkModule {

    /* @Provides
     fun provideNetworkService(): NetworkService {
         return NetworkService
             .Builder()
             .host("google.com")
             .protocol("HTTPS")
             .path("Test")
            // .interceptor(CallInterceptorImp())
             //.interceptor(ResponseInterceptorImp())
             .build()
     }*/

    @ActivityScoped
    @CallInterceptor
    @Provides
    fun provideCallNetworkService(): NetworkService {
        return NetworkService
            .Builder()
            .host("google.com")
            .protocol("HTTPS")
            .path("Test")
            .interceptor(CallInterceptorImp())
            .build()
    }


    @ActivityScoped
    @ResponseInterceptor
    @Provides
    fun provideResponseNetworkService(): NetworkService {
        return NetworkService
            .Builder()
            .host("google.com")
            .protocol("HTTPS")
            .path("Test")
            .interceptor(ResponseInterceptorImp())
            .build()
    }
}
