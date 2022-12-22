open class Carteira(
    private var senhaCarteira: String,
    var tipo: Carteiras,
    var saldo: Double,
    var extrato: String
) {

     fun monstrarSaldo(){
        println("mostrou o saldo")
    }

    fun mostrarExtrato(){
        println("mostrou o extrato")
    }

}

class CarteiraFisica(
    senhaCF: String,
    tipoCF: Carteiras,
    saldoCF: Double,
    extratoCF: String,
):Carteira(senhaCarteira = senhaCF, tipo = tipoCF, saldo = saldoCF, extrato = extratoCF) {

    fun deposito(){}

    fun saque(){}

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


