package br.com.mrsti.toyapplication.api

import br.com.mrsti.toyapplication.model.LoginRequest
import br.com.mrsti.toyapplication.model.LoginResponse
import br.com.mrsti.toyapplication.model.Toy
import retrofit2.Call
import retrofit2.http.*

interface ToyAPI {

    @POST("/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("/toy")
    fun findAll() : Call<List<Toy>>

    @POST("/toy")
    fun save(@Body toy: Toy) : Call<Void>

}