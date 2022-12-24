import MenuFuncionalidades.*
import Planos.*
import Carteiras.*
import enPaineis.*
import java.text.NumberFormat
import java.util.*

var escolha: Int = 1

var minhaCarteiraFisica = CarteiraFisica()
//var minhaCarteiraDigital = CarteiraDigital()

val currencyFormatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

class Banco {

    init {
        when (cliente.plano) {
            SEM_PLANO -> println("Você ainda não é nosso cliente")
            NORMAL -> clienteNormal()
            DIGITAL -> carteiraDigital()
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
            }
            manterPainel()
        } while (escolha != 0)
    }

    private fun carteiraDigital() {

        println(CarteiraDigitalMenu.menu)
        val escolha = readln().toInt()


//        do{
//            when(escolha) {
//                1 -> minhaCarteiraDigital.monstrarSaldo()
//                2 -> minhaCarteiraDigital.transferenciaPix()
//                3 -> minhaCarteiraDigital.pagarBoleto()
//                4 -> minhaCarteiraDigital.investir()
//                5 -> minhaCarteiraDigital.guardar()
//                6 -> minhaCarteiraDigital.mostrarExtrato()
//            }
//                voltarMenuPrincipal()
//        } while (escolha!=0)
    }

    private fun seletorCarteira() {

        println(MostrarCarteiras.menu)
        when (readln().toInt()) {
            CARTEIRA_FISICA.id -> carteiraFisica()
            CARTEIRA_DIGITAL.id -> carteiraDigital()
        }
    }

    private fun printarDados() {
        println(cliente)

        while (readln().toInt() != 0){
            println("Entrada inválida!! \nPRESSIONE \"0\" PARA VOLTAR AO MENU PRINCIPAL")
        }
        clienteNormal()
    }

    private fun manterPainel(){
        var voltar = readln().toInt()
        while (voltar != 0){
            println("Entrada inválida!!")
            voltar = readln().toInt()
        }
        carteiraFisica()
    }





    //FIM
}


fun voltarMenuPrincipal() {
    println("Voltar - 0")
    when (readln().toInt()) {
        0 -> {
            println(CarteiraFisicaMenu.menu)
            escolha = readln().toInt()
        }

        else -> {
            println("Entrada inválida!!")
            voltarMenuPrincipal()
        }
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