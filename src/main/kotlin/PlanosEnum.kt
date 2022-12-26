enum class Planos(val id: Int, val extenso: String, val carteiras: String) {
    SEM_PLANO(id = 0, extenso = "Normal", carteiras = "Nenhuma carteira disponível"),
    NORMAL(id = 1, extenso = "Normal", carteiras = "Carteira Física"),
    DIGITAL(id = 2, extenso = "Digital", carteiras = "Carteira Digital"),
    PREMIUM(id = 3, extenso = "Premium", carteiras = "Carteira Física | Carteira Digital"),
}

//Menu de Planos
enum class MenuPLanos(val menu: String) {

    Plano(
        menu = """
        ========== PLANOS ==========
        1 ------------------- NORMAL
        2 ------------------ DIGITAL
        3 ------------------ PREMIUM
        ======== 0 - FECHAR ========
    """.trimIndent()
    )
}

//Paineis de cada tipo de cliente
enum class PainelInicial(val menu: String) {

    PainelClienteNormal(
        menu = """
        ========== Banco Kotlin ==========
        1 ---------- MINHA CARTEIRA FÍSICA
        2 --------------------- MEUS DADOS
        ======== 0 - FECHAR ==============
    """.trimIndent()
    ),

    PainelClienteDigital(
        menu = """
        ========== Banco Kotlin ==========
        1 --------- MINHA CARTEIRA DIGITAL
        2 --------------------- MEUS DADOS
        ======== 0 - FECHAR ==============
    """.trimIndent()
    ),

    PainelClientePremium(
        menu = """
        ========== Banco Kotlin ==========
        1 ---------- MINHA CARTEIRA FÍSICA
        2 --------- MINHA CARTEIRA DIGITAL
        3 --------------------- MEUS DADOS
        ======== 0 - FECHAR ==============
    """.trimIndent()
    )
}