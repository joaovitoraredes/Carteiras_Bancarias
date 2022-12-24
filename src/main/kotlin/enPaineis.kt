enum class enPaineis(val menu: String) {

    PainelClienteNormal(menu = """
        ========== Banco Kotlin ==========
        1 ---------- MINHA CARTEIRA FÍSICA
        2 --------------------- MEUS DADOS
        ======== 0 - FECHAR ==============
    """.trimIndent()
    ),

    PainelClienteDigital(menu = """
        ========== Banco Kotlin ==========
        1 --------- MINHA CARTEIRA DIGITAL
        2 --------------------- MEUS DADOS
        ======== 0 - FECHAR ==============
    """.trimIndent()
    ),

    PainelClientePremium(menu = """
        ========== Banco Kotlin ==========
        1 ---------- MINHA CARTEIRA FÍSICA
        2 --------- MINHA CARTEIRA DIGITAL
        3 --------------------- MEUS DADOS
        ======== 0 - FECHAR ==============
    """.trimIndent()
    )
}

//talvez colocar o nome do cliente no lugar do banco kotlin, mas para isso formatar


