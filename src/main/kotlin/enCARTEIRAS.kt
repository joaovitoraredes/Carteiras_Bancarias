enum class Carteiras(val id: Int, val extenso: String) {
    CARTEIRA_FISICA(id = 1, extenso = "Carteira Fisica"),
    CARTEIRA_DIGITAL(id = 2, extenso = "Carteira Digital"),
}

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
            """.trimIndent()),

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
            """.trimIndent()),

    MostrarCarteiras(
        menu = """
            ======= MINHAS CARTEIRAS ======
            1 ------------- CARTEIRA FÍSICA
            2 ------------ CARTEIRA DIGITAL
            ========= 0 - FECHAR  =========
            """.trimIndent()),

    NenhumaSelecaoAceitavelVoltarMenu(menu = """
             Entrada inválida!!
             PRESSIONE "0" PARA VOLTAR AO MENU DE OPÇÕES"
             """.trimIndent())
}

//Será que realmente tem a necessidade de criar as funcionalidades de cada um com o Id

enum class FuncionalidadesCarteiraFisica() {
    SALDO(),
    DEPOSITO,
    SAQUE,
    PAGARBOLETO,
    EXTRATO,
    SAIR,
}

enum class FuncionalidadesCarteiraDigital {
    SALDO,
    TRASNFERENCIAPIX,
    PAGARBOLETO,
    INVESTIR,
    GUARDAR,
    EXTRATO,
    SAIR
}