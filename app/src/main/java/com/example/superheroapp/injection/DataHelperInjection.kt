
package com.example.superheroapp.injection

import com.example.superheroapp.data.generateEnemies
import com.example.superheroapp.data.generateLocations
import com.example.superheroapp.data.generatePowers
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.models.Enemy
import com.example.superheroapp.data.models.Location
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.data.models.Superhero
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataHelperInjection {

    @Provides
    @Singleton
    fun provideSuperheroes(): List<Superhero> {
        return generateSuperheroes()
    }

    @Provides
    @Singleton
    fun provideEnemies(): List<Enemy> {
        return generateEnemies()
    }

    @Provides
    @Singleton
    fun provideLocations(): List<Location> {
        return generateLocations()
    }

    @Provides
    @Singleton
    fun providePowers(): List<Power> {
        return generatePowers()
    }
}