package com.ardrawing.sketchtrace.my_creation.di

import com.ardrawing.sketchtrace.my_creation.data.repository.MyCreationRepositoryImpl
import com.ardrawing.sketchtrace.my_creation.domian.repository.CreationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Ahmed Guedmioui
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MyCreationRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindACreationRepository(
        myCreationRepositoryImpl: MyCreationRepositoryImpl
    ): CreationRepository

}












