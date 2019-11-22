package com.example.redditclone.data.services

import com.example.redditclone.data.models.AuthResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/access_token")
    @FormUrlEncoded
    suspend fun getAuthToken(
        @Field("grant_type") grant_type: String, @Field("code") code: String, @Field(
            "redirect_uri"
        ) uri: String,
        @Header("Authorization") key: String
    ): Response<AuthResponse>
}