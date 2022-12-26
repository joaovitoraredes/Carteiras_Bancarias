open class ClienteClass(
    var nome: String,
    var sobrenome: String,
    var cpf: String,
    var senha: String,
    var plano: Planos,
) {
    override fun toString(): String {

        when (cliente.plano) {
            Planos.NORMAL -> return """
                    ========================= MEUS DADOS =========================
                    Nome Cliente ${espacosNome()} $nome $sobrenome                         
                    Senha ----------------------------------------------- $senha   
                    CPF ------------------------------------------- $cpf 
                    Plano ------------------------------------------------- ${plano.extenso}                           
                    Carteiras Disponiveis ------------------------ ${plano.carteiras}  
                    ======================== BANCO KOTLIN ========================
                            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
                """.trimIndent()

            Planos.DIGITAL -> return """
                    ========================= MEUS DADOS =========================
                    Nome Cliente ${espacosNome()} $nome $sobrenome                         
                    Senha ----------------------------------------------- $senha   
                    CPF ------------------------------------------- $cpf 
                    Plano ------------------------------------------------ ${plano.extenso}                           
                    Carteiras Disponiveis ----------------------- ${plano.carteiras}  
                    ======================== BANCO KOTLIN ========================
                            PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
                """.trimIndent()

            else -> return """
                    ============================== MEUS DADOS ==============================
                    Nome Cliente ${espacosNome()} $nome $sobrenome                         
                    Senha --------------------------------------------------------- $senha   
                    CPF ----------------------------------------------------- $cpf 
                    Plano ---------------------------------------------------------- ${plano.extenso}                           
                    Carteiras Disponiveis --------------- ${plano.carteiras}  
                    ============================= BANCO KOTLIN =============================
                                PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
                """.trimIndent()
        }
    }
}

private fun espacosNome(): String {
    var tracos = ""
    val repeticoes = 47 - (cliente.nome.length + cliente.sobrenome.length)

    repeat(repeticoes) {
        tracos += "-"
    }
    return tracos
}