package com.sawczuk.cryptomarket.model

import jakarta.persistence.*


@Entity
data class Custom_User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val firstName: String = "",
    val lastName: String = "",
    @OneToOne(cascade = [CascadeType.ALL]) val wallet: Wallet = Wallet()
)







