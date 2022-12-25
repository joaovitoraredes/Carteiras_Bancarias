import MenuFuncionalidades.*
import Planos.*
import Carteiras.*
import enPaineis.*
import java.text.NumberFormat
import java.util.*

var escolha: Int = 1

var minhaCarteiraFisica = CarteiraFisica()
var minhaCarteiraDigital = CarteiraDigital()

val currencyFormatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

class Banco {

    init {
        when (cliente.plano) {
            SEM_PLANO -> println("Você ainda não é nosso cliente")
            NORMAL -> clienteNormal()
            DIGITAL -> clienteDigital()
            PREMIUM -> seletorCarteira()
        }
    }

    //CLIENTES
    private fun clienteNormal() {
        println(PainelClienteNormal.menu)

        when (readln().toInt()) {
            1 -> if (validacaoSenha()) carteiraFisica()
            2 -> if (validacaoSenha()) printarDados()
            0 -> return println("Fechando Banco...")
        }
    }

    private fun clienteDigital() {
        println(PainelClienteDigital.menu)

        when (readln().toInt()) {
            1 -> if (validacaoSenha()) carteiraDigital()
            2 -> if (validacaoSenha()) printarDados()
            0 -> return println("Fechando Banco...")
        }
    }

    //CARTEIRAS
    private fun carteiraFisica() {

        println(CarteiraFisicaMenu.menu)
        escolha = readln().toInt()

        do {
            when (escolha) {
                1 -> minhaCarteiraFisica.monstrarSaldo()
                2 -> minhaCarteiraFisica.deposito()
                3 -> minhaCarteiraFisica.saque()
//              4 -> minhaCarteiraFisica.pagarBoleto()
                5 -> minhaCarteiraFisica.mostrarExtrato()
                0 -> clienteNormal()
                else -> println(NenhumaSelecaoAceitavelVoltarMenu.menu)
            }
            manterPainel()
        } while (escolha != 0)
    }

    private fun carteiraDigital() {

        println(CarteiraDigitalMenu.menu)
        escolha = readln().toInt()

        do {
            when (escolha) {
                1 -> minhaCarteiraDigital.monstrarSaldo()
                2 -> minhaCarteiraDigital.transferenciaPix()
//              3 -> minhaCarteiraDigital.pagarBoleto()
                4 -> minhaCarteiraDigital.investir()
                5 -> minhaCarteiraDigital.guardar()
                6 -> minhaCarteiraDigital.mostrarExtrato()
                0 -> clienteDigital()
                else -> println(NenhumaSelecaoAceitavelVoltarMenu.menu)
            }
            voltarMenuPrincipal()
        } while (escolha != 0)


    }


    private fun seletorCarteira() {

        println(MostrarCarteiras.menu)
        when (readln().toInt()) {
            CARTEIRA_FISICA.id -> carteiraFisica()
            CARTEIRA_DIGITAL.id -> carteiraDigital()
        }
    }


    //TODOS DEVEM TER WHEN VALIDO PARA A CARTEIRA QUE PRECISA

    private fun printarDados() {
        println(cliente)

        while (readln().toInt() != 0) {
            println("Entrada inválida!! \nPRESSIONE \"0\" PARA VOLTAR AO MENU PRINCIPAL")
        }
        when (cliente.plano) {
            NORMAL -> clienteNormal()
            DIGITAL -> clienteDigital()
//          PREMIUM
            else -> {}
        }
    }

    private fun manterPainel() {
        var voltar = readln().toInt()
        while (voltar != 0) {
            println("Entrada inválida!!")
            voltar = readln().toInt()
        }

        when (cliente.plano) {
            NORMAL -> carteiraFisica()
            DIGITAL -> carteiraDigital()
            //         PREMIUM
            else -> {}
        }
        carteiraFisica()
    }

    //FIM
}


fun voltarMenuPrincipal() {
    when (readln().toInt()) {
        0 -> {
            when (cliente.plano) {
                NORMAL -> {
                    println(CarteiraFisicaMenu.menu)
                    escolha = readln().toInt()
                }

                DIGITAL -> {
                    println(CarteiraDigitalMenu.menu)
                    escolha = readln().toInt()
                }
                //          PREMIUM
                else -> {}
            }
        }

        else -> {
            println("Entrada inválida!!")
            voltarMenuPrincipal()
        }
    }
}

fun voltarMenuPrincipalDireto() {

    when (cliente.plano) {
        NORMAL -> {
            println(CarteiraFisicaMenu.menu)
            escolha = readln().toInt()
        }

        DIGITAL -> {
            println(CarteiraDigitalMenu.menu)
            escolha = readln().toInt()
        }
        //          PREMIUM
        else -> {}
    }
}


// Jogar essa função para uma classe a parte
fun validacaoSenha(): Boolean {
    println("Entre com a sua senha: ")
    val senhaParaValidar = readln()

    return if (senhaParaValidar == cliente.senha) {
        true
    } else {
        println("Senha inválida:")
        validacaoSenha()
    }
}