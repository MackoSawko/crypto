package com.sawczuk.cryptomarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
class CryptoMarketApplication

fun main(args: Array<String>) {
    runApplication<CryptoMarketApplication>(*args)
}
