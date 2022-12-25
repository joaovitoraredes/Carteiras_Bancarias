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
            PREMIUM -> clientePremium()
        }
    }

    //CLIENTES
    private fun clienteNormal() {
        println(PainelClienteNormal.menu)

        try {
            escolha = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            clienteNormal()
        }

        when (escolha) {
            1 -> if (validacaoSenha()) carteiraFisica()
            2 -> if (validacaoSenha()) printarDados()
            0 -> return println("Fechando Banco...")
            else -> {
                println("Entrada inválida!!")
                clienteNormal()
            }
        }
    }

    private fun clienteDigital() {
        println(PainelClienteDigital.menu)

        try {
            escolha = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            clienteDigital()
        }

        when (escolha) {
            1 -> if (validacaoSenha()) carteiraDigital()
            2 -> if (validacaoSenha()) printarDados()
            0 -> return println("Fechando Banco...")
            else -> {
                println("Entrada inválida!!")
                clienteDigital()
            }
        }
    }

    private fun clientePremium() {
        println(PainelClientePremium.menu)

        try {
            escolha = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            clientePremium()
        }

        when (escolha) {
            1 -> if (validacaoSenha()) carteiraFisica()
            2 -> if (validacaoSenha()) carteiraDigital()
            3 -> if (validacaoSenha()) printarDados()
            0 -> {
                return println("Fechando Banco...")
            }

            else -> {
                println("Entrada inválida!!")
                clientePremium()
            }
        }
    }

    //CARTEIRAS
    private fun carteiraFisica() {

        println(CarteiraFisicaMenu.menu)

        try {
            escolha = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            carteiraFisica()
        }

        do {
            when (escolha) {
                1 -> minhaCarteiraFisica.monstrarSaldo()
                2 -> minhaCarteiraFisica.deposito()
                3 -> minhaCarteiraFisica.saque()
//              4 -> minhaCarteiraFisica.pagarBoleto()
                5 -> minhaCarteiraFisica.mostrarExtrato()
                0 -> return
                else -> println(NenhumaSelecaoAceitavelVoltarMenu.menu)
            }
            manterPainelMF()
        } while (escolha != 0)

        if (cliente.plano == PREMIUM) {
            clientePremium()
        } else {
            clienteNormal()
        }
    }

    private fun carteiraDigital() {

        println(CarteiraDigitalMenu.menu)

        try {
            escolha = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            carteiraDigital()
        }

        do {
            when (escolha) {
                1 -> minhaCarteiraDigital.monstrarSaldo()
                2 -> minhaCarteiraDigital.transferenciaPix()
//              3 -> minhaCarteiraDigital.pagarBoleto()
                4 -> minhaCarteiraDigital.investir()
                5 -> minhaCarteiraDigital.guardar()
                6 -> minhaCarteiraDigital.mostrarExtrato()
                0 -> return
                else -> println(NenhumaSelecaoAceitavelVoltarMenu.menu)
            }
            manterPainelMD()
        } while (escolha != 0)

        if (cliente.plano == PREMIUM) {
            clientePremium()
        } else {
            clienteDigital()
        }
    }

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


    private fun manterPainelMF() {
        var voltar = readln().toInt()
        while (voltar != 0) {
            println("Entrada inválida!!")
            voltar = readln().toInt()
        }

        when (cliente.plano) {
            NORMAL -> carteiraFisica()
            DIGITAL -> carteiraDigital()
            PREMIUM -> carteiraFisica()
            else -> {}
        }
    }
    private fun manterPainelMD() {
        var voltar = readln().toInt()
        while (voltar != 0) {
            println("Entrada inválida!!")
            voltar = readln().toInt()
        }

        when (cliente.plano) {
            NORMAL -> carteiraFisica()
            DIGITAL -> carteiraDigital()
            PREMIUM -> carteiraDigital()
            else -> {}
        }
    }

    //FIM
}

fun voltarMenuOpcoes() {

    try {
        escolha = readln().toInt()
    } catch (e: NumberFormatException) {
        println("Entrada inválida!")
        println("0 - Voltar")
        voltarMenuOpcoes()
    }

    when (escolha) {
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

                PREMIUM -> {
                    println(CarteiraDigitalMenu.menu)
                    escolha = readln().toInt()
                }

                else -> {}
            }
        }

        else -> {
            println("Entrada inválida!!")
            voltarMenuOpcoes()
        }
    }
}

fun voltarMenuOpcoesDireto() {

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