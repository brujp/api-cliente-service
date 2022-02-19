package br.com.curso.controller

import br.com.curso.model.Cliente
import br.com.curso.service.ClienteService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/clientes")
class ClienteController(
    private val clienteService: ClienteService
) {
    @Post
    fun create(@Body cliente: Cliente): HttpResponse<Cliente> { //Informação do cliente vai no corpo da requisição
        val clienteDB = clienteService.create(cliente)
        return HttpResponse.created(cliente)
    }

    @Get
    fun findAll(): List<Cliente>{
        return clienteService.findAll()
    }

    @Get("{id}")
    fun findById(@PathVariable id: Long): Cliente {
        return clienteService.findById(id)
    }

    @Delete("{id}")
    fun delete(@PathVariable id: Long): HttpResponse<Unit> {
        val clienteDB = clienteService.delete(id)
        return HttpResponse.noContent()
    }

    @Put("{id}")
    fun update(@PathVariable id: Long, @Body cliente: Cliente) {
        clienteService.update(id, cliente) //Salvando o cliente que está com os dados atualizados
    }
}