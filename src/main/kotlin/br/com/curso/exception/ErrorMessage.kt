package br.com.curso.exception

import java.time.LocalDateTime

data class ErrorMessage (

    val dataHoraErro: String = LocalDateTime.now().toString(),
    val mensagemErro: String?
)