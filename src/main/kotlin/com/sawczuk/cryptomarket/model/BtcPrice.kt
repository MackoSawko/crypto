package com.sawczuk.cryptomarket.model

class BtcPrice {
    val ask: Double
    val bid: Double

    constructor(ask: Double, bid: Double) {
        this.ask = ask
        this.bid = bid
    }
}