package com.berkerdgn.isparkapp.data.dependincyinjection

import com.berkerdgn.isparkapp.data.remote.ParkAPI
import com.berkerdgn.isparkapp.data.repository.IsparkRepositoryImpl
import com.berkerdgn.isparkapp.domain.repository.IsparkRepository
import com.berkerdgn.isparkapp.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideParkAPI(): ParkAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ParkAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideIsparkRepository(api: ParkAPI): IsparkRepository{
        return IsparkRepositoryImpl(parkAPI = api)
    }



}