open class Carteira(
    private var senhaCarteira: String,
    var tipo: Carteiras,
    var saldo: Double,
    var extrato: String
) {

     fun monstrarSaldo(){
        println("Seu saldo atual é de: ${formatacaoDinheiro.format(saldo)}")
    }

    fun mostrarExtrato(){
        println("Seu extrato: \n$extrato")
    }

}

class CarteiraFisica(
    senhaCF: String,
    tipoCF: Carteiras,
    saldoCF: Double,
    extratoCF: String,
):Carteira(senhaCarteira = senhaCF, tipo = tipoCF, saldo = saldoCF, extrato = extratoCF) {

    fun deposito(){
        println("Qual o valor do depósito?")
        val deposito = readln().toDouble()
        saldo += deposito
        println("Valor de ${formatacaoDinheiro.format(deposito)} depositado!!")
        extrato += "Deposito de $deposito \n"
    }

    fun saque(){
        println("Qual o valor do saque?")
        val saque = readln().toDouble()
        saldo -= saque
        println("Saque de ${formatacaoDinheiro.format(saque)} realizado!!")
        extrato += "Saque de $saque \n"
    }

    fun pagarBoleto(){}

}

class CarteiraDigital(
    senhaCD: String,
    tipoCD: Carteiras,
    saldoCD: Double,
    extratoCD: String,
): Carteira(senhaCarteira = senhaCD, tipo = tipoCD, saldo = saldoCD, extrato = extratoCD)  {

    fun transferenciaPix(){}

    fun pagarBoleto(){}

    fun investir(){}

    fun guardar(){}

}


