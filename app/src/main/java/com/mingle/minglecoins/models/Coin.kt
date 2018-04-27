package com.mingle.minglecoins.models
import com.google.gson.annotations.SerializedName
import com.mingle.minglecoins.models.repository.Price

data class Coin(
    @field:SerializedName("Symbol")
    val symbol: String? = null,









    @field:SerializedName("ImageUrl")
    val imageUrl: String? = null,

    @field:SerializedName("SortOrder")
    val sortOrder: String? = null,

    @field:SerializedName("TotalCoinSupply")
    val totalCoinSupply: String? = null,

    @field:SerializedName("Algorithm")
    val algorithm: String? = null,

    @field:SerializedName("Url")
    val url: String? = null,

    @field:SerializedName("Name")
    val name: String? = null,

    @field:SerializedName("ProofType")
    val proofType: String? = null,

    @field:SerializedName("PreMinedValue")
    val preMinedValue: String? = null,

    @field:SerializedName("FullName")
    val fullName: String? = null,

    @field:SerializedName("TotalCoinsFreeFloat")
    val totalCoinsFreeFloat: String? = null,

    @field:SerializedName("Id")
    val id: String? = null,

    @field:SerializedName("FullyPremined")
    val fullyPremined: String? = null,

    @field:SerializedName("Sponsored")
    val sponsored: Boolean? = null,

    @field:SerializedName("CoinName")
    val coinName: String? = null,

    var price: Price? = null
)


