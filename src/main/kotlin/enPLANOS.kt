enum class Planos(val id: Int, val extenso: String, val carteiras: String) {
    SEM_PLANO(id = 0, extenso = "Normal", carteiras = "Nenhuma carteira disponível"),
    NORMAL(id = 1, extenso = "Normal", carteiras = "Carteira Física"),
    DIGITAL(id = 2, extenso = "Digital", carteiras = "Carteira Digital"),
    PREMIUM(id = 3, extenso = "Premium", carteiras = "Carteira Física | Carteira Digital"),
}

enum class MenuPLanos(val menu: String) {

    Plano(menu = """
        ========== PLANOS ==========
        1 ------------------- NORMAL
        2 ------------------ DIGITAL
        3 ------------------ PREMIUM
        ======== 0 - FECHAR ========
    """.trimIndent()
    )
}
