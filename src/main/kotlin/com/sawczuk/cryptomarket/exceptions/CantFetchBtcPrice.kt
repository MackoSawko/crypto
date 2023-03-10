package com.sawczuk.cryptomarket.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class CantFetchBtcPrice(msg: String) : RuntimeException(msg) {

}
