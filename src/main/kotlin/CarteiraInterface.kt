import kotlin.random.Random

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
            """
            Seu extrato:
            $extrato
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent()
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
            """
Seu extrato: 
$extrato===================
Saldo atual ${currencyFormatter.format(minhaCarteiraFisica.saldo)}
PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent()
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

        if (validacaoSenha()) {
            if (saque <= saldo) {
                saldo -= saque
                extrato += "Saque de ${currencyFormatter.format(saque)} \n"
                // Printando mensagem de sucesso ao sacar!!
                println(
                    """
            Saque de ${currencyFormatter.format(saque)} realizado!!
            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent()
                )
            } else {
                println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
                saque()
            }
        } else {
            println("Senha incorreta!! Impossivel realizar transação!!")
        }


    }

    fun pagarBoleto() {
        println("Entre com o código de barras do seu boleto: (Basta entrar com os número para ver o valor!!)")

        try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            pagarBoleto()
        }

        val random = Random.nextInt(50, 1000)
        println("Valor do boleto ${currencyFormatter.format(random)}")

        if (validacaoSenha()) {
            if (random <= saldo) {
                println(
                    "Boleto no valor de ${currencyFormatter.format(random)} pago!!\n" +
                            "RESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL"
                )
                saldo -= random
                extrato += "Boleto no valor de ${currencyFormatter.format(random)} pago!!\n"
            } else {
                println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
                println("PRESSIONE 0 PARA VOLTAR AO MENU PRINCIPAL")
            }
        } else {
            println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
            pagarBoleto()
        }

        return
    }
}

class CarteiraDigital() : Carteira {

    override var senhaCarteira: String = ""
    override val tipo: Carteiras = Carteiras.CARTEIRA_DIGITAL
    override var saldo: Double = 0.0
    override var extrato: String = ""
    private var totalGuardado = 0.0

    override fun mostrarExtrato() {

        println(
            """
Seu extrato: 
$extrato===================
Saldo atual ${currencyFormatter.format(minhaCarteiraDigital.saldo)}
+ Saldo guardado ${currencyFormatter.format(totalGuardado)}
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

            if (validacaoSenha()) {
                if (valorPixPagar <= saldo) {
                    minhaCarteiraDigital.saldo -= valorPixPagar
                    extrato += "Pix de ${currencyFormatter.format(valorPixPagar)} pago\n"
                    println("Pix de ${currencyFormatter.format(valorPixPagar)} pago!!")
                    println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
                } else {
                    println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
                    pagarPix()
                }
            } else {
                println("Senha incorreta!! Impossivel realizar transação!!")
            }
        }

        println(TransferenciaPix.Opcoes.menu)

        try {
            escolha = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            transferenciaPix()
        }

        when (escolha) {
            1 -> receberPix()
            2 -> pagarPix()
            0 -> voltarMenuOpcoesDireto()
            else -> {
                println("Entrada invalida!!")
            }
        }

    }

    fun pagarBoleto() {
        println("Entre com o código de barras do seu boleto: (Basta entrar com os número para ver o valor!!)")

        try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            pagarBoleto()
        }

        val random = Random.nextInt(50, 1000)
        println("Valor do boleto ${currencyFormatter.format(random)}")

        if (validacaoSenha()) {
            if (random <= saldo) {
                println(
                    "Boleto no valor de ${currencyFormatter.format(random)} pago!!\n" +
                            "RESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL"
                )
                saldo -= random
                extrato += "Boleto no valor de ${currencyFormatter.format(random)} pago!!\n"
            } else {
                println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
                println("PRESSIONE 0 PARA VOLTAR AO MENU PRINCIPAL")
            }
        } else {
            println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
            pagarBoleto()
        }

        return
    }

    fun investir() {
        println(Acoes.AcoesPainel.menu)
        println("Entre com o código da ação que você deseja investir:")

        val acao = try {
            readln()
        } catch (e: NumberFormatException) {
            println("Entrada inválida!")
            investir()
        }

        println("Quanto lotes desta ação você deseja:")
        val qtsAcao = readln().toInt()


        if (validacaoSenha()) {
            when (acao) {
                "PTHN03" -> {
                    val valorTotal = precoPTHN03 * qtsAcao

                    if (valorTotal <= saldo) {
                        minhaCarteiraDigital.saldo -= valorTotal
                        extrato += "Investimento de ${currencyFormatter.format(valorTotal)} em PYTHONJTV ON\n"
                        println("Sucesso, você acaba de investir ${currencyFormatter.format(valorTotal)} em PYTHONJTV ON")
                        println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
                    } else {
                        println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
                        investir()
                    }
                }

                "KTLN41" -> {
                    val valorTotal = precoKTLN41 * qtsAcao

                    if (valorTotal <= saldo) {
                        minhaCarteiraDigital.saldo -= valorTotal
                        extrato += "Investimento de ${currencyFormatter.format(valorTotal)} em KOTLINMB PN\n"
                        println("Sucesso, você acaba de investir ${currencyFormatter.format(valorTotal)} em KOTLINMB PN")
                        println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
                    } else {
                        println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
                        investir()
                    }

                }

                "JVLC63" -> {
                    val valorTotal = precoJVLC63 * qtsAcao

                    if (valorTotal <= saldo) {
                        minhaCarteiraDigital.saldo -= valorTotal
                        extrato += "Investimento de ${currencyFormatter.format(valorTotal)} em JAVALCA PN\n"
                        println("Sucesso, você acaba de investir ${currencyFormatter.format(valorTotal)} em JAVALCA PN")
                        println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
                    } else {
                        println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
                        investir()
                    }
                }

                else -> {
                    println("Sentimos muito!! Ação não encontrada!!")
                    println("0 - Voltar")
                }
            }
        } else {
            println("Senha incorreta!! Impossivel realizar transação!!")
        }
    }

    fun guardar() {
        println(
            """
            Você possui ${currencyFormatter.format(minhaCarteiraDigital.saldo)}, quanto você gostaria de guardar:
        """.trimIndent()
        )
        val valorGuardar = readln().toDouble()

        if (validacaoSenha()) {
            totalGuardado += valorGuardar

            if (valorGuardar <= saldo) {
                saldo -= valorGuardar
                dinheiroGuardado += valorGuardar
                extrato += "Você guardou ${currencyFormatter.format(valorGuardar)}\n"
                println("Você guardou ${currencyFormatter.format(valorGuardar)}, deixe esse dinheiro quieto!!")
                println("PRESSIONE '0' PARA VOLTAR AO MENU PRINCIPAL")
            } else {
                println("Saldo insuficiente!! Seu saldo atual é de ${currencyFormatter.format(saldo)}")
                guardar()
            }
        } else {
            println("Senha incorreta!! Impossivel realizar transação!!")
        }


    }
}

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
    } else {
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
