open class dcCliente(
    var nome: String,
    var sobrenome: String,
    var cpf: String,
    var senha: String,
    var plano: Planos,
){
    override fun toString(): String {
        return """
            =========================== MEUS DADOS =============================
                                      ~  $nome $sobrenome ~                         
                          CPF: $cpf | Senha: $senha              
                                       Plano ${plano.extenso}                           
                  Carteiras Disponiveis -> ${plano.carteiras}  
            =========================== BANCO KOTLIN ============================
                        PRESSIONE "0" PARA VOLTAR AO MENU PRINCIPAL
        """.trimIndent()
    }
}
