package com.sawczuk.cryptomarket.repository

import com.sawczuk.cryptomarket.model.Wallet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletRepository: JpaRepository<Wallet, Long> {
}