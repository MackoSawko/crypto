package com.sawczuk.cryptomarket

import com.sawczuk.cryptomarket.exceptions.NotEnoughMoneyException
import com.sawczuk.cryptomarket.model.Custom_User
import com.sawczuk.cryptomarket.model.Wallet
import com.sawczuk.cryptomarket.repository.UserRepository
import com.sawczuk.cryptomarket.repository.WalletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

interface CryptoFacade {

    fun getUsers(): List<Custom_User>
    fun findById(id: Long): Optional<Custom_User>
    fun save(user: Custom_User)
    fun sellBtc(id: Long, amount: Double): Wallet

}

@Service
class CryptoFacadeImpl: CryptoFacade {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var walletRepository: WalletRepository



    override fun getUsers(): List<Custom_User> { return userRepository.findAll() }

    override fun findById(id: Long): Optional<Custom_User> { return userRepository.findById(id) }

    override fun save(user: Custom_User) { userRepository.save(user) }

    override fun sellBtc(id: Long, amount: Double): Wallet {
        val user = userRepository.findById(id)
        val btcAmount = user.get().wallet.btc

        if (btcAmount >= amount) {
            user.get().wallet.btc -= amount
            user.get().wallet.usd += amount * BTC_PRICE
            userRepository.save(user.get())
        } else {
            throw NotEnoughMoneyException("you have not enough Bitcoins")
        }

        return user.get().wallet
    }

    companion object {
        const val BTC_PRICE = 5000.0
    }
}