package br.com.mrsti.toyapi.entity

data class User(var id: String?,
                var login: String,
                var name: String,
                var password: String,
                var token: String?)