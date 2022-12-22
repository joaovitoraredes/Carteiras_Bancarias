open class dc_Cliente(
    var nome: String,
    var sobrenome: String,
    var cpf: String,
    var senha: String,
    var plano: Planos,
){
    override fun toString(): String {
        return """
            =========================== MEUS DADOS =============================
            ||                       ~  $nome $sobrenome ~                         ||
            ||           CPF: $cpf | Senha: $senha              ||
            ||                        Plano ${plano.extenso}                           ||
            ||   Carteiras Disponiveis -> ${plano.carteiras}  ||
            =========================== BANCO KOTLIN ======-=====================
        """.trimIndent()
    }
}

//class ClienteNormal(
//    nomeCN: String,
//    sobrenomeCN: String,
//    cpfCN: String,
//    senhaCN: String,
//): Cliente(nome = nomeCN, sobrenome = sobrenomeCN, cpf = cpfCN, senha = senhaCN, plano = NORMAL)
//
//class ClienteDigital(
//    nomeCD: String,
//    sobrenomeCD: String,
//    cpfCD: String,
//    senhaCD: String,
//): Cliente(nome = nomeCD, sobrenome = sobrenomeCD, cpf = cpfCD, senha = senhaCD, plano = DIGITAL)
//
//class ClientePremium(
//    nomeCP: String,
//    sobrenomeCP: String,
//    cpfCP: String,
//    senhaCP: String,
//): Cliente(nome = nomeCP, sobrenome = sobrenomeCP, cpf = cpfCP, senha = senhaCP, plano = PREMIUM)