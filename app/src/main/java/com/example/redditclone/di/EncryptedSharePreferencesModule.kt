package com.example.redditclone.di

import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.redditclone.util.contracts.AUTH_PREF
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object EncryptedSharePreferencesModule {
    @Provides
    @JvmStatic
    @Singleton
    fun getSharedPreferences(application: Application): SharedPreferences {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            AUTH_PREF,
            masterKeyAlias,
            application,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    }
    @Provides
    @JvmStatic
    @Singleton
    fun getSharedPreferencesEditor(sharedPreferences: SharedPreferences) : SharedPreferences.Editor = sharedPreferences.edit()
}