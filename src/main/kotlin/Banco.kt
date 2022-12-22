/*Aqui irá funcinar como se o usuário estivesse realmente utilizando o banco e a suas carteiras*/
//Adicionar funcionalidades como de mudar dados como nome, pedindo a senha
import MenuFuncionalidades.*
import Planos.*
import Carteiras.*

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
        println(CarteiraFisicaMenu.menu)
    }

    private fun carteiraDigital(){
        println(CarteiraDigitalMenu.menu)
    }

    private fun seletorCarteira(){
        println(MostrarCarteiras.menu)
        when(readln().toInt()){
            CARTEIRA_FISICA.id -> carteiraFisica()
            CARTEIRA_DIGITAL.id -> carteiraDigital()
        }
    }
//    fun clientePremium(){
//        println(MenuClientePremium.menu)
//    }

//    Menu Cliente Normal
//    do {
//
//    } while (selecao!=0)
//
//    //Menu Cliente Normal
//    do {
//
//    } while (selecao!=0)



}