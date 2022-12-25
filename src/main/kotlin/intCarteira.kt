import enPaineis.*

var dinheiroGuardado = 0.0

interface Carteira {

    var senhaCarteira: String
    val tipo: Carteiras
    var saldo: Double
    var extrato: String

    fun monstrarSaldo() {

        println(
            """
            Seu saldo atual é de: ${currencyFormatter.format(saldo)}   
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent()
        )

    }

    fun mostrarExtrato() {

        println(
            "Seu extrato: \n$extrato " +
                    "\nPRESSIONE \"0\" PARA VOLTAR AO MENU PRINCIPAL\n"
        )

    }
}


class CarteiraFisica() : Carteira {

    override var senhaCarteira: String = ""
    override val tipo: Carteiras = Carteiras.CARTEIRA_FISICA
    override var saldo: Double = 0.0
    override var extrato: String = ""

    override fun mostrarExtrato() {

        println(
            "Seu extrato: \n$extrato " +
                    "\n--------------------------- Saldo atual \n${currencyFormatter.format(minhaCarteiraFisica.saldo)}" +
                    "\nPRESSIONE \"0\" PARA VOLTAR AO MENU PRINCIPAL\n"
        )
    }

    fun deposito() {

        println("Qual o valor do depósito?")
        val deposito = validarDeposito(readln())
        saldo += deposito


        // Adicionando saque ao extrato!!
        extrato += "Deposito de ${currencyFormatter.format(deposito)} \n"

        // Printando mensagem de sucesso ao adicionar!!
        println(
            """
            Valor de ${currencyFormatter.format(deposito)} depositado!!
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
            """.trimIndent()
        )
    }

    fun saque() {

        println("Qual o valor do saque?")
        val saque = validarSaque(readln())
        saldo -= saque

        // Adicionando saque ao extrato!!
        extrato += "Saque de ${currencyFormatter.format(saque)} \n"

        // Printando mensagem de sucesso ao sacar!!
        println(
            """
            Saque de ${currencyFormatter.format(saque)} realizado!!
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent()
        )
    }

    fun pagarBoleto() {}

}

class CarteiraDigital() : Carteira {

    override var senhaCarteira: String = ""
    override val tipo: Carteiras = Carteiras.CARTEIRA_DIGITAL
    override var saldo: Double = 0.0
    override var extrato: String = ""

    override fun mostrarExtrato() {

        println("""
            Seu extrato: 
            $extrato
            --------------------------- 
            Saldo atual $${currencyFormatter.format(minhaCarteiraDigital.saldo)}
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent()

        )
    }

    fun transferenciaPix() {
        fun receberPix() {
            println("Qual o valor a receber!!")
            val valorPixReceber = validarPix(readln())
            minhaCarteiraDigital.saldo += valorPixReceber
            extrato += "Pix de ${currencyFormatter.format(valorPixReceber)} recebido\n"
            println("Pix de ${currencyFormatter.format(valorPixReceber)} recebido")
            println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
        }

        fun pagarPix() {
            println("Qual o valor a pagar!!")
            val valorPixPagar = validarPix(readln())
            minhaCarteiraDigital.saldo -= valorPixPagar
            extrato += "Pix de ${currencyFormatter.format(valorPixPagar)} pago\n"
            println("Pix de ${currencyFormatter.format(valorPixPagar)} pago")
            println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
        }

        println(TransferenciaPix.Opcoes.menu)
        when (readln().toInt()) {
            1 -> receberPix()
            2 -> pagarPix()
            0 -> voltarMenuPrincipalDireto()
            else -> {
                println("Entrada invalida!!")
            }
        }

    }

    fun pagarBoleto() {}

    fun investir() {
        println(acoes.AcoesPainel.menu)
        println("Entre com o código da ação que você deseja investir:")
        val acao = readln()
        println("Quanto lotes da $acao você deseja:")
        val qtsAcao = readln().toInt()


        when (acao) {

            "KTLN41" -> {
                val valorTotal = precoKTLN41 * qtsAcao
                minhaCarteiraDigital.saldo - valorTotal
                extrato += "Investimento de ${currencyFormatter.format(valorTotal)} em KOTLINMB PN\n"
                println("Sucesso, você acaba de investir ${currencyFormatter.format(valorTotal)} em KOTLINMB PN")
                println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
            }

            "JVLC63" -> {
                val valorTotal = precoJVLC63 * qtsAcao
                minhaCarteiraDigital.saldo - valorTotal
                extrato += "Investimento de ${currencyFormatter.format(valorTotal)} em JAVALCA PN\n"
                println("Sucesso, você acaba de investir ${currencyFormatter.format(valorTotal)} em JAVALCA PN")
                println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
            }

            "PTHN03" -> {
                val valorTotal = precoPTHN03 * qtsAcao
                minhaCarteiraDigital.saldo - valorTotal
                extrato += "Investimento de ${currencyFormatter.format(valorTotal)} em PYTHONJTV ON\n"
                println("Sucesso, você acaba de investir ${currencyFormatter.format(valorTotal)} em PYTHONJTV ON")
                println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
            }
        }
    }

    fun guardar() {
        println(
            """
            Você possui ${currencyFormatter.format(minhaCarteiraDigital.saldo)}, quanto você gostaria de guardar:
        """.trimIndent()
        )
        val valorGuardar = readln().toDouble()
        saldo -= valorGuardar
        dinheiroGuardado += valorGuardar
        extrato += "Você guardou ${currencyFormatter.format(valorGuardar)}\n"
        println("Você guardou ${currencyFormatter.format(valorGuardar)}, deixe esse dinheiro quieto!!\n")
        println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
    }
}


fun validarDeposito(valorDepositado: String): Double {

    return if (valorDepositado.isEmpty() || valorDepositado.isBlank()) {
        println("Entrada em Branco!!\nPor favor entre com um valor!!")
        validarDeposito(readln())
    } else if (valorDepositado <= 0.0.toString()) {
        println("Valor inválido para deposito!!\nEntre com um valor maior que 0!!")
        validarDeposito(readln())
    } else {
        return valorDepositado.toDouble()
    }
}

fun validarSaque(valorDesejado: String): Double {

    return if (valorDesejado.isEmpty() || valorDesejado.isBlank()) {
        println(
            """
            Entrada em Branco!!
            Por favor entre com um valor!! """.trimIndent()
        )
        validarSaque(readln())
    }
//    else if (valorDesejado >= minhaCarteiraFisica.saldo.toString()) {
//        println("""
//            Saldo insuficiente!!
//            Você possui até ${currencyFormatter.format(minhaCarteiraFisica.saldo)} para sacar!!
//            0 - Voltar Para o menu princial
//        """.trimIndent())
//        voltarMenuPrincipal()
//        validarSaque(readln())
//    }
    else {
        return valorDesejado.toDouble()
    }
}

fun validarPix(valorPix: String): Double {

    return if (valorPix.isEmpty() || valorPix.isBlank()) {
        println("Entrada em Branco!!\nPor favor entre com um valor!!")
        validarDeposito(readln())
    } else if (valorPix <= 0.0.toString()) {
        println("Valor inválido para deposito!!\nEntre com um valor maior que 0!!")
        validarDeposito(readln())
    } else {
        return valorPix.toDouble()
    }
}