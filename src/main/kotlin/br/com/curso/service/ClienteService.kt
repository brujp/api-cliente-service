package br.com.curso.service

import br.com.curso.exception.RegistroNaoEncontradoException
import br.com.curso.model.Cliente
import br.com.curso.repository.ClienteRepository
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class ClienteService(
    private val clienteRepository: ClienteRepository //Injetando o repositório de dados que criamos
) {
    fun create(cliente: Cliente): Cliente { //Informação do cliente vai no corpo da requisição
        return clienteRepository.save(cliente)
    }

    fun findAll(): List<Cliente>{
        return clienteRepository.findAll()
    }

    fun findById(id: Long): Cliente {
        return clienteRepository.findById(id).orElseThrow {
            RegistroNaoEncontradoException("Registro não encontrado")
        }
    }

    fun delete(id: Long) {
        val clienteDB = findById(id)
        clienteRepository.delete(clienteDB)
    }

    @Transactional
    open fun update(id: Long, cliente: Cliente) {
        val clienteDB = findById(id)
        clienteDB.nome = cliente.nome
        clienteDB.documento = cliente.documento
        clienteDB.endereco = cliente.endereco
        clienteRepository.save(clienteDB) //Salvando o cliente que está com os dados atualizados
    }
}