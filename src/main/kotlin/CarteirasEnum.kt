enum class Carteiras(val id: Int, val extenso: String) {
    CARTEIRA_FISICA(id = 1, extenso = "Carteira Fisica"),
    CARTEIRA_DIGITAL(id = 2, extenso = "Carteira Digital"),
}

//FUNCIONALIDADES
enum class MenuFuncionalidades(val menu: String) {

    CarteiraFisicaMenu(
        menu = """
            ==== CARTEIRA FÍSICA ====
            1 ----------------- SALDO
            2 -------------- DEPOSITO
            3 ----------------- SAQUE
            4 ---------- PAGAR BOLETO
            5 --------------- EXTRATO
            ====== 0 - FECHAR =======
            """.trimIndent()
    ),

    CarteiraDigitalMenu(
        menu = """
            ======= CARTEIRA DIGITAL ======
            1 ----------------------- SALDO
            2 ----------- TRASNFERÊNCIA PIX
            3 ---------------- PAGAR BOLETO
            4 -------------------- INVESTIR
            5 --------------------- GUARDAR
            6 --------------------- EXTRATO
            ========= 0 - FECHAR  =========
            """.trimIndent()
    ),

    NenhumaSelecaoAceitavelVoltarMenu(
        menu = """
             Entrada inválida!!
             PRESSIONE "0" PARA VOLTAR AO MENU DE OPÇÕES"
             """.trimIndent()
    )
}

enum class Acoes(val menu: String) {
    AcoesPainel(
        menu = """
        Nome	        |   Código	|    R$ (Valor por lote)
        KOTLINMB PN	    |   KTLN41	|           71,88
        JAVALCA PN	    |   JVLC63	|           29,31
        PYTHONJV ON1	|   PTHN03	|           14,43
    """.trimIndent()
    )
}

enum class TransferenciaPix(val menu: String) {
    Opcoes(
        menu = """
        ========= TRANSFERÊNCIA PIX =========
        Receber pix ----------------------- 1
        Enviar pix ------------------------ 2
        ============ 0 - FECHAR =============
    """.trimIndent()
    )
}

const val precoKTLN41 = 71.88
const val precoJVLC63 = 29.31
const val precoPTHN03 = 14.43