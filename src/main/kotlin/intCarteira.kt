interface Carteira {

    var senhaCarteira: String
    val tipo: Carteiras
    var saldo: Double
    var extrato: String

    fun monstrarSaldo(){

        println("""
            Seu saldo atual é de: ${currencyFormatter.format(saldo)}   
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent())

    }

    fun mostrarExtrato(){

        println("Seu extrato: \n$extrato " +
                "\nPRESSIONE \"0\" PARA VOLTAR AO MENU PRINCIPAL\n")

    }

}


class CarteiraFisica() :Carteira {

    override var senhaCarteira: String = ""
    override val tipo: Carteiras = Carteiras.CARTEIRA_FISICA
    override var saldo: Double = 0.0
    override var extrato: String = ""

    fun deposito(){

        println("Qual o valor do depósito?")
        val deposito = readln().toDouble()
        saldo += deposito

        // Printando mensagem de sucesso ao adicionar!!
        println("""
            Valor de ${currencyFormatter.format(deposito)} depositado!!
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
            """.trimIndent())
        // Adicionando saque ao extrato!!
        extrato += "Deposito de ${currencyFormatter.format(deposito)} \n"
    }

    fun saque(){

        println("Qual o valor do saque?")
        val saque = readln().toDouble()
        saldo -= saque

        // Printando mensagem de sucesso ao sacar!!
        println("""
            Saque de ${currencyFormatter.format(saque)} realizado!!
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent())
        // Adicionando saque ao extrato!!
        extrato += "Saque de ${currencyFormatter.format(saque)} \n"
    }

//    fun pagarBoleto(){}

}

//class CarteiraDigital(): CarteiraInterface  {

//    fun transferenciaPix(){}
//
//    fun pagarBoleto(){}
//
//    fun investir(){}
//
//    fun guardar(){}

//}


