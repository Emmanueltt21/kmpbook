package com.kottland.bookappkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform