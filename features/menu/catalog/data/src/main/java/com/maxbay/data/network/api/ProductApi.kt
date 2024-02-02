package com.maxbay.data.network.api

import com.maxbay.data.network.models.ProductsNetwork
import retrofit2.http.GET

interface ProductApi {
    @GET("97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getAllProducts(): ProductsNetwork
}