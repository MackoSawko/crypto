package com.sawczuk.cryptomarket.controller

import com.sawczuk.cryptomarket.CryptoFacade
import com.sawczuk.cryptomarket.model.Custom_User
import com.sawczuk.cryptomarket.model.Wallet
import com.sawczuk.cryptomarket.repository.UserRepository
import com.sawczuk.cryptomarket.repository.WalletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
class CryptoController {

    @Autowired
    lateinit var cryptoFacade: CryptoFacade

    @GetMapping("/users")
    fun getUser(): List<Custom_User>{
        return cryptoFacade.getUsers()
    }

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id:Long): Optional<Custom_User> {
        return cryptoFacade
            .findById(id)
    }

    @PostMapping("/user")
    fun addUser(@RequestParam ("firstName") firstName: String,
                @RequestParam ("lastName") lastName: String) :Custom_User {

        val wallet = Wallet(btc = 5.0, usd = 1250.0)

        val user = Custom_User(firstName = firstName, lastName = lastName, wallet = wallet)
        cryptoFacade.save(user)
        return user
    }

    @PostMapping("/user/{id}/sell/btc")
    fun sellBtc(@PathVariable id: Long,
               @RequestParam("amount") amount: Double): Wallet {
        return cryptoFacade.sellBtc(id,amount
        )
    }

    @PostMapping("/user/{id}/buy/btc")
    fun buyBtc(@PathVariable id: Long,
                @RequestParam("amount") amount: Double): Wallet {
        return cryptoFacade.buyBtc(id,amount)

    }


}