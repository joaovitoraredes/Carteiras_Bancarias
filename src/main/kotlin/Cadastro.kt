import Planos.*
import kotlin.random.Random
import MenuPLanos.*

var cliente = dc_Cliente(nome = "", sobrenome = "", cpf = "", senha = "", plano = SEM_PLANO)

class Cadastro {

    init {
        cadastroNome()
        cadastroSobrenome()
        cadastroCpf()
//        cadastroSenha()
        escolhaPlano()
        geradorDeSenha()
//        println(cliente)
    }

    private fun cadastroNome() {
//        println("Qual seu nome: ")
//        cliente.nome = readln()
        cliente.nome = "João"
    }

    private fun cadastroSobrenome() {
//        println("Qual seu sobrenome: ")
//        cliente.sobrenome = readln()
        cliente.sobrenome = "Aredes"
    }

    private fun cadastroCpf() {
//        println("Qual seu Cpf: ")
//        cliente.cpf = readln()
        cliente.cpf = "15226364910"

        //Formatando CPF
        val padraoEsperado: Regex = "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})".toRegex()
        val padraoFormatado = "$1.$2.$3-$4"

        cliente.cpf = cliente.cpf.replace(padraoEsperado,padraoFormatado)
    }

//    private fun cadastroSenha() {
//        println("Digite uma senha: ")
//        usuario.senha = readln()
//    }

/*  Acrescentar caracteres*/
    private fun geradorDeSenha(){
        var senhaAleatoria = ""
        repeat(10) {
            val nextValues = Random.nextInt(0, 10)
            senhaAleatoria += nextValues
        }
        cliente.senha = senhaAleatoria
    }

    private fun escolhaPlano() {

        println(Plano.menu)

        when (readln().toInt()) {
            NORMAL.id -> cliente.plano = NORMAL
            DIGITAL.id -> cliente.plano = DIGITAL
            PREMIUM.id -> cliente.plano = PREMIUM
        }
    }
}