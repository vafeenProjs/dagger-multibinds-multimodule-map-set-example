package ru.vafeen.testmultibindings

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
internal interface AppModule {
    companion object {
        @Provides
        @IntoSet
        fun provide(partSet2: PartSet2): Interface = partSet2

        @Provides
        @IntoMap
        @ClassKey(PartSet2::class)
        fun provide2(partSet2: PartSet2): Interface = partSet2
    }

//    @Multibinds
//    fun set(): @JvmSuppressWildcards Set<Interface>
//
//    @Multibinds
//    fun map(): @JvmSuppressWildcards Map<Class<*>, Interface>
}