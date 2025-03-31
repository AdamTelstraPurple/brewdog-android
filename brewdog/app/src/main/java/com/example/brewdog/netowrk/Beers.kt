package com.example.brewdog.netowrk

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val first_brewed: String,
    val description: String,
    val image: String,
    val abv: Double,
    val ibu: Int,
    val target_fg: Int,
    val target_og: Int,
    val ebc: Int,
    val srm: Int,
    val ph: Double,
    val attenuation_level: Int,
    val volume: Volume,
    val boil_volume: Volume,
    val method: Method,
    val ingredients: Ingredients,
    val food_pairing: List<String>,
    val brewers_tips: String,
    val contributed_by: String
)

data class Volume(
    val value: Double,
    val unit: String
)

data class Method(
    val mash_temp: List<MashTemp>,
    val fermentation: Temperature,
    val twist: String
)

data class MashTemp(
    val temp: Temperature,
    val duration: Int
)

data class Temperature(
    val value: Double,
    val unit: String
)

data class Ingredients(
    val malt: List<Malt>,
    val hops: List<Hop>,
    val yeast: String
)

data class Malt(
    val name: String,
    val amount: Amount
)

data class Amount(
    val value: Double,
    val unit: String
)

data class Hop(
    val name: String,
    val amount: Amount,
    val add: String,
    val attribute: String
)