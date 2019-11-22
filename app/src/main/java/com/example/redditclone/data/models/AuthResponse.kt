package com.example.redditclone.data.models

data class AuthResponse(
    val access_token:String,
    val token_type: String,
    val expires_in: Long,
    val scope: String,
    val refresh_token: String
)

