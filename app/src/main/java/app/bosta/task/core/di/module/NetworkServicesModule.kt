package app.bosta.task.core.di.module

import app.bosta.task.data.users.data_source.remote.UsersServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {

  @Provides
  @Singleton
  fun provideSearchServices(retrofit: Retrofit): UsersServices =
    retrofit.create(UsersServices::class.java)


}