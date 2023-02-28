package com.sawczuk.cryptomarket.repository

import com.sawczuk.cryptomarket.model.Custom_User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<Custom_User, Long> {
}