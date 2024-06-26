package com.ardrawing.sketchtrace.core.domain.model.app_data

data class RecommendedApp(
    val icon: String,
    val image: String,
    val name: String,
    val shortDescription: String,
    val urlOrPackage: String
)