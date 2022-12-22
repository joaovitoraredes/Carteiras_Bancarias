/* Olhar se coloca tudo aqui dentro desta mesma Enum, ou se separa a aba MENUS, de funcionalidades */
// TLvz apresentar os menus como funcao
// Olhar se fica melhor os menus acerca das funcionalidades da carteria aqui junto das funcionalidades
// ou se fica melhor colocar os menus das carteiras tudo na enum sobre carteiras
// TLVZ SEJA MELHOR COLOCAR TUDO RELACIONADO AS CARTEIRAS, NA ABA CARTEIRAS
// TANTO OS ID, QUANTO OS MENU, QUANTO AS FUNCIONALIDADES PELAS ESCOLHASC

//enum class MenuFuncionalidades(val menu: String) {
//
//    CarteiraFisicaMenu(
//        menu = """
//            ==== CARTEIRA FÍSICA ====
//            1 ----------------- SALDO
//            2 -------------- DEPOSITO
//            3 ----------------- SAQUE
//            4 ----------- PAGARBOLETO
//            5 --------------- EXTRATO
//            ====== 0 - FECHAR =======
//            """.trimIndent()),
//
//    CarteiraDigitalMenu(
//        menu = """
//            ======= CARTEIRA DIGITAL ======
//            1 ----------------------- SALDO
//            2 ----------- TRASNFERÊNCIA PIX
//            3 ---------------- PAGAR BOLETO
//            4 -------------------- INVESTIR
//            5 --------------------- GUARDAR
//            6 --------------------- EXTRATO
//            ========= 0 - FECHAR  =========
//            """.trimIndent()),
//
//    /*VER SE ACRECSCENTA ESSE SELETOR NOS OUTROS PLANOS*/
//    MostrarCarteiras(
//        menu = """
//            ======= MINHAS CARTEIRAS ======
//            1 ------------- CARTEIRA FÍSICA
//            2 ------------ CARTEIRA DIGITAL
//            ========= 0 - FECHAR  =========
//            """.trimIndent()),
//}
    /*Provavelmente tenha que separa em duas funcionalidades diferentes por conta do menu*/



enum class FuncionalidadesCarteiraFisica {
    SALDO,
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

//enum class FuncionalidadesClientePremium {
//
//    SALDO,
//    DEPOSITO,
//    SAQUE,
//
//    TRASNFERENCIAPIX,
//    PAGARBOLETO,
//    INVESTIR,
//    GUARDAR,
//    EXTRATO,
//
//    SAIR
//}


