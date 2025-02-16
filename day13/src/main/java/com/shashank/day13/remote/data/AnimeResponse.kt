package com.shashank.day13.remote.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeResponse(
    @SerializedName("data") var data: List<AnimeItem> = arrayListOf()
)

@Serializable
data class AnimeItem(
    @SerializedName("title_english") var titleEnglish: String? = "",
    @SerializedName("synopsis") var synopsis: String? = "",
    @SerializedName("duration") var duration: String? = "",
    @SerializedName("images") var images: Images? = Images(),
)

@Serializable
data class Images(
    @SerializedName("jpg") var jpg: Jpg? = Jpg(),
)

@Serializable
data class Jpg(
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("small_image_url") var smallImageUrl: String? = null,
    @SerializedName("large_image_url") var largeImageUrl: String? = null
)