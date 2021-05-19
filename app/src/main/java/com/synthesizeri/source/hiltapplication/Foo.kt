package com.synthesizeri.source.hiltapplication

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named

interface Item{ fun info():String }
class Weapon @Inject constructor(): Item{ override fun info() = "Weapon" }
class Armor @Inject constructor(): Item{ override fun info() = "Armor" }
class Shield @Inject constructor(): Item{ override fun info() = "Shield" }
class Player @Inject constructor(
    @Named("Nickname") private val name: String,
    private val weapon: Weapon,
    private val armor: Armor,
    private val shield: Shield) {

    fun print() = Log.d("Player",
        "$name's Inventory --> ${weapon.info()}," +
                " ${armor.info()}" +
                " and ${shield.info()}")
}


@InstallIn(SingletonComponent::class)
@Module
object AppModule{
    @Provides
    fun provideName() = "Player"

    @Named("Nickname")
    @Provides
    fun provideNickname() = "Awesome Player"
}
