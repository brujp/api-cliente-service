package br.com.curso.repository

import br.com.curso.model.Cliente
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Long> { //O Long é o tipo da nossa chave primária (id)
}