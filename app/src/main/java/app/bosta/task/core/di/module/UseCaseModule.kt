package app.bosta.task.core.di.module

import app.bosta.task.domain.user.repository.UsersRepository
import app.bosta.task.domain.user.use_case.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

  @Provides
  @Singleton
  fun provideSettingsUseCase(
    usersRepository: UsersRepository
  ): UsersUseCase = UsersUseCase(usersRepository)
}