package app.bosta.task.core.di.module

import app.bosta.task.data.users.data_source.remote.UsersRemoteDataSource
import app.bosta.task.data.users.repository.UsersRepositoryImpl
import app.bosta.task.domain.user.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  @Provides
  @Singleton
  fun provideUsersRepository(
    remoteDataSource: UsersRemoteDataSource
  ): UsersRepository = UsersRepositoryImpl(remoteDataSource)

}