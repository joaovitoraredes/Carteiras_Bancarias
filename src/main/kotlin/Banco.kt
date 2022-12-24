import MenuFuncionalidades.*
import Planos.*
import Carteiras.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

var minhaCarteiraFisica = CarteiraFisica("",CARTEIRA_FISICA,0.0,"")
var minhaCarteiraDigital = CarteiraDigital("",CARTEIRA_DIGITAL,0.0,"")

val formatacaoDinheiro: NumberFormat = DecimalFormat.getCurrencyInstance(Locale("pt", "BR"))
var selecao = 10


class Banco{

    init {
        when (cliente.plano) {
        SEM_PLANO -> println("Você ainda não é nosso cliente")
        NORMAL -> carteiraFisica()
        DIGITAL -> carteiraDigital()
        PREMIUM -> seletorCarteira()
        }
    }

    private fun carteiraFisica(){

//        println("Escolha a senha para a sua carteira!!")
//        var senha = readln()

        println(CarteiraFisicaMenu.menu)
        selecao = readln().toInt()

        do{
        when(selecao) {
            1 -> minhaCarteiraFisica.monstrarSaldo()
            2 -> minhaCarteiraFisica.deposito()
            3 -> minhaCarteiraFisica.saque()
            4 -> minhaCarteiraFisica.pagarBoleto()
            5 -> minhaCarteiraFisica.mostrarExtrato()
            }
            voltarMenuPrincipal()
        }while (selecao!=0)

    }

    private fun carteiraDigital(){
        println(CarteiraDigitalMenu.menu)
        selecao = readln().toInt()

        do{

            when(selecao) {
                1 -> minhaCarteiraDigital.monstrarSaldo()
                2 -> minhaCarteiraDigital.transferenciaPix()
                3 -> minhaCarteiraDigital.pagarBoleto()
                4 -> minhaCarteiraDigital.investir()
                5 -> minhaCarteiraDigital.guardar()
                6 -> minhaCarteiraDigital.mostrarExtrato()
            }
            voltarMenuPrincipal()
        }while (selecao!=0)
    }

    private fun seletorCarteira(){
        println(MostrarCarteiras.menu)
        when(readln().toInt()){
            CARTEIRA_FISICA.id -> carteiraFisica()
            CARTEIRA_DIGITAL.id -> carteiraDigital()
        }
    }

}

fun voltarMenuPrincipal(){
    println("Voltar - 0")
    when(readln().toInt()){
        0 -> {
            println(CarteiraFisicaMenu.menu)
            selecao = readln().toInt()
        }
        else -> {
            println("Entrada inválida!!")
            voltarMenuPrincipal()
        }
    }
}