import Planos.*
import kotlin.random.Random
import MenuPLanos.*

var cliente = dcCliente(nome = "", sobrenome = "", cpf = "", senha = "", plano = SEM_PLANO)

class Cadastro {

    init {
//        println("Bem Vindo ao Banco Kotlin!!")

        cadastroNome()
        cadastroSobrenome()
        cadastroCpf()
        cadastroSenha()
        escolhaPlano()
//        geradorDeSenha()
//        println(cliente)
    }

    private fun cadastroNome() {
//        println("Qual seu nome: ")
//        cliente.nome = validarVazio(readln(),"nome")
        cliente.nome = "João"
    }

    private fun cadastroSobrenome() {
//        println("Qual seu sobrenome: ")
//        cliente.sobrenome = validarVazio(readln(),"sobrenome")
        cliente.sobrenome = "Aredes"
    }

    private fun cadastroCpf() {
//        println("Qual seu Cpf: ")
//        cliente.cpf = validarVazio(readln(),"cpf")
        cliente.cpf = "12345678911"

        //Formatando CPF
        val padraoEsperado: Regex = "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})".toRegex()
        val padraoFormatado = "$1.$2.$3-$4"

        cliente.cpf = cliente.cpf.replace(padraoEsperado,padraoFormatado)
    }

    private fun cadastroSenha(){
//        println("Cadastre sua senha!!")
//        cliente.senha = validarVazio(readln(),"senha")
        cliente.senha = "1234"
    }

    private fun geradorDeSenha(){
        var senhaAleatoria = ""
        repeat(10) {
            val nextValues = Random.nextInt(0, 10)
            senhaAleatoria += nextValues
        }
        cliente.senha = senhaAleatoria
    }

    private fun escolhaPlano() {

//        println(Plano.menu)

//        when (readln().toInt()) {
//            NORMAL.id -> cliente.plano = NORMAL
//            DIGITAL.id -> cliente.plano = DIGITAL
//            PREMIUM.id -> cliente.plano = PREMIUM
//            0 -> return
//            else -> {
//                println("Opção inválida!!")
//                escolhaPlano()
//            }
//        }
      cliente.plano = PREMIUM
    }
}


