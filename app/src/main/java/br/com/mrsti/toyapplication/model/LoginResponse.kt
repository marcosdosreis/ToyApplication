package br.com.mrsti.toyapplication.model

data class LoginResponse(var token: String?,
                         var errorMessage: String?
                         )