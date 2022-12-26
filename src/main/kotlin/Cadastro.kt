import Planos.*
import MenuPLanos.*

var cliente = ClienteClass(nome = "", sobrenome = "", cpf = "", senha = "", plano = SEM_PLANO)

class Cadastro {

    init {
        println("Bem Vindo ao Banco Kotlin!!")
        cadastroNome()
        cadastroSobrenome()
        cadastroCpf()
        cadastroSenha()
        escolhaPlano()
    }

    private fun cadastroNome() {
        println("Qual seu nome: ")
        cliente.nome = validarVazio(readln(), "nome")
        cliente.nome = "João"
    }

    private fun cadastroSobrenome() {
        println("Qual seu sobrenome: ")
        cliente.sobrenome = validarVazio(readln(), "sobrenome")
        cliente.sobrenome = "Aredes"
    }

    private fun cadastroCpf() {
        println("Qual seu Cpf: ")
        cliente.cpf = validarDigitosCPF(readln(), "cpf")

        //Formatando CPF
        val padraoEsperado: Regex = "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})".toRegex()
        val padraoFormatado = "$1.$2.$3-$4"

        cliente.cpf = cliente.cpf.replace(padraoEsperado, padraoFormatado)
    }

    private fun cadastroSenha() {
        println("Cadastre sua senha de 8 digitos!! (Senha para transações)")
        cliente.senha = validarDigitosSenha(readln(), "senha")
    }

    private fun escolhaPlano() {

        println(Plano.menu)

        when (readln().toInt()) {
            NORMAL.id -> cliente.plano = NORMAL
            DIGITAL.id -> cliente.plano = DIGITAL
            PREMIUM.id -> cliente.plano = PREMIUM
            0 -> return
            else -> {
                println("Opção inválida!!")
                escolhaPlano()
            }
        }
    }
}

fun validarVazio(stringParaValidar: String?, variavelValidada: String): String {

    var validar = stringParaValidar

    return if (validar.isNullOrEmpty() || validar.isBlank()) {
        println("Entrada inválida!!")
        println("Entre com seu $variavelValidada: ")
        validar = readln()
        validarVazio(validar, variavelValidada)
    } else {
        return validar
    }
}

fun validarDigitosCPF(stringParaValidar: String, variavelValidada: String): String {

    val validar = try {
        stringParaValidar
    } catch (e: NumberFormatException) {
        println("Entrada inválida!")
        validarDigitosCPF(readln(), "cpf")
    }.toString()

    return if (validar.length != 11) {
        println("Entrada inválida!! Necessário 11 dígitos!!")
        println("Entre com seu $variavelValidada: ")
        validarDigitosCPF(readln(), "cpf")
    } else {
        return validar
    }
}

fun validarDigitosSenha(stringParaValidar: String, variavelValidada: String): String {

    val validar = try {
        stringParaValidar
    } catch (e: NumberFormatException) {
        println("Entrada inválida!")
        validarDigitosSenha(readln(), "senha")
    }.toString()

    return if (validar.length != 8) {
        println("Entrada inválida!! Necessário 8 dígitos!!")
        println("Entre com seu $variavelValidada: ")
        validarDigitosSenha(readln(), "senha")
    } else {
        return validar
    }
}