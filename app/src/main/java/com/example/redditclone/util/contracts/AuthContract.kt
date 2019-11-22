package com.example.redditclone.util.contracts

const val CLIENT_KEY = "ydorqgoqxx8G9g"
const val SCOPES = "identity edit flair history modconfig modflair modlog modposts modwiki mysubreddits privatemessages read report save submit subscribe vote wikiedit wikiread"
const val REDIRECT_URL = "cybertruck://www.example.com/my_redirect"
const val STRING_DATA = "OMEGALUL"
const val AUTH_URL = "https://www.reddit.com/api/v1/authorize.compact?client_id=$CLIENT_KEY&response_type=code&state=$STRING_DATA&redirect_uri=$REDIRECT_URL&duration=permanent&scope=$SCOPES"



