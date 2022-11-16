package com.celestar.models

import java.util.UUID

data class Creature(
    val _id: String = UUID.randomUUID().toString(),
    val name: String,
    var ac: Int,
    val hp: Int,
    val attacks: List<Attack>?,
    val meta: Any?
)