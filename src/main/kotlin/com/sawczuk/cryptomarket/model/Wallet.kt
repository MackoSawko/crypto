package com.sawczuk.cryptomarket.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Wallet(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val btc: Double = 0.0,
    val usd: Double = 0.0
)
