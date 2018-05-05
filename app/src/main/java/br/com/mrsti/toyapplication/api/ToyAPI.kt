package br.com.mrsti.toyapplication.api

import br.com.mrsti.toyapi.entity.User
import retrofit2.Call
import retrofit2.http.*

interface ToyAPI {

    @GET("/user/login/{login}")
    fun findByLogin(@Path("login") login: String): Call<User>

    @PUT("/user")
    fun salvar(@Body user: User): Call<Void>

}