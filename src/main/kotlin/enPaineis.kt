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

const val precoKTLN41 = 71.88
const val precoJVLC63 = 29.31
const val precoPTHN03 = 14.43

enum class acoes(val menu: String){
    AcoesPainel(menu = """
        Nome	        |   Código	|    R$ (Valor por lote)
        KOTLINMB PN	    |   KTLN41	|           71,88
        JAVALCA PN	    |   JVLC63	|           29,31
        PYTHONJV ON1	|   PTHN03	|           14,43
    """.trimIndent())
}

enum class TransferenciaPix(val menu: String){
    Opcoes(menu = """
        ========= TRANSFERÊNCIA PIX =========
        Receber pix ----------------------- 1
        Enviar pix ------------------------ 2
        ============ 0 - FECHAR =============
    """.trimIndent())
}