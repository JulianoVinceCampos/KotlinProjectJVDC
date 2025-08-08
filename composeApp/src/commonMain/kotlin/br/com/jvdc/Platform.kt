package br.com.jvdc

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform