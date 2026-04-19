package ru.vafeen.test2

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import ru.vafeen.test1.Interface

@Module
@InstallIn(SingletonComponent::class)
internal class Test2Module {
    @Provides
    @IntoSet
    fun provide(partSet1: PartSet1): Interface = partSet1

    @Provides
    @IntoMap
    @ClassKey(PartSet1::class)
    fun provide2(partSet1: PartSet1): Interface = partSet1
}