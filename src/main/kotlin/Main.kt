package org.example

sealed class Genero {
    object Drama : Genero()
    object Suspense : Genero()
    object FiccaoCientifica : Genero()
    object Terror : Genero()
    data class Outro(val nome: String) : Genero()
}

data class Entrada(
    val titulo: String,
    val genero: Genero,
    val comentario: String?
)

val diario = mutableListOf<Entrada>()

fun registrarNovaEntrada() {
    println("\n--- Novo Registro ---")
    print("Título: ")
    val titulo = readLine() ?: "Título Desconhecido"

    println("Gênero: 1. Drama, 2. Suspense, 3. Ficção, 4. Terror, 5. Outro: ")
    val generoEscolhido = when (readLine()) {
        "1" -> Genero.Drama
        "2" -> Genero.Suspense
        "3" -> Genero.FiccaoCientifica
        "4" -> Genero.Terror
        else -> {
            print("Digite o nome do gênero: ")
            Genero.Outro(readLine() ?: "Desconhecido")
        }
    }

    println("Comentário (opcional): ")
    val comentario = readLine()
    val comentarioFinal = if (comentario.isNullOrBlank()) null else comentario

    val novaEntrada = Entrada(titulo, generoEscolhido, comentarioFinal)
    diario.add(novaEntrada)

    println("\n--- ${novaEntrada.titulo} registrado com sucesso!")
}

fun listarRegistros() {
    println("\n--- Todos os registros ---")
    if (diario.isEmpty()) {
        println("Nenhum registro encontrado")
        return
    }

    diario.forEachIndexed { index, entrada ->
        val nomeGenero = when (entrada.genero) {
            is Genero.Drama -> "Drama"
            is Genero.Suspense -> "Suspense"
            is Genero.FiccaoCientifica -> "Ficção"
            is Genero.Terror -> "Terror"
            is Genero.Outro -> entrada.genero.nome
        }
        println("${index + 1}. ${entrada.titulo} ($nomeGenero)")
    }
}

fun verRegistroCompleto() {
    print("Digite o número do registro que desejar ver: ")
    val index = readLine()?.toIntOrNull()?.minus(1)

    val entrada = diario.getOrNull(index!!)
    if (entrada == null) {
        println("Registro inválido ou não encontrado")
    } else {
        println("\n--- Detalhes do Registro ---")
        val nomeGenero = when (entrada.genero) {
            is Genero.Drama -> "Drama"
            is Genero.Suspense -> "Suspense"
            is Genero.FiccaoCientifica -> "Ficção"
            is Genero.Terror -> "Terror"
            is Genero.Outro -> entrada.genero.nome
        }
        println("Título: ${entrada.titulo}")
        println("Gênero: $nomeGenero")
        println("Comentário: ${entrada.comentario ?: "Nenhum comentário."}")
    }
}

fun apagarRegistro() {
    print("Digite o número do registro que deseja apagar: ")
    val index = readLine()?.toIntOrNull()?.minus(1)

    if (index != null && index in diario.indices) {
        val entradaRemovida = diario.removeAt(index)
        println("${entradaRemovida.titulo} foi removido com sucesso.")
    } else {
        println("Registro inválido ou não encontrado")
    }
}

fun buscarRegistros() {
    print("Digite o termo para buscar no título ou gênero: ")
    val termo = readLine()
    if (termo.isNullOrBlank()) {
        println("Termo de busca não pode ser vazio.")
        return
    }

    val resultados = diario.filter { entrada ->
        val nomeGenero = when (entrada.genero) {
            is Genero.Drama -> "Drama"
            is Genero.Suspense -> "Suspense"
            is Genero.FiccaoCientifica -> "Ficção"
            is Genero.Terror -> "Terror"
            is Genero.Outro -> entrada.genero.nome
        }

        val termoBuscaLower = termo.lowercase()
        entrada.titulo.lowercase().contains(termoBuscaLower) ||
                nomeGenero.lowercase().contains(termoBuscaLower)
    }

    println("\n--- Resultados da busca por '$termo' ---")
    if (resultados.isEmpty()) {
        println("Nenhum registro encontrado.")
    } else {
        resultados.forEach { entrada ->
            val nomeGenero = when (entrada.genero) {
                is Genero.Drama -> "Drama"
                is Genero.Suspense -> "Suspense"
                is Genero.FiccaoCientifica -> "Ficção"
                is Genero.Terror -> "Terror"
                is Genero.Outro -> entrada.genero.nome
            }
            println("- '${entrada.titulo}' (${nomeGenero})")
        }
    }
}

fun main() {
    println("--- Diário de Filmes e Série ---")

    while (true) {
        println("Escolha uma opção:")
        println("1. Novo registro")
        println("2. Listar registros")
        println("3. Ver Registro Completo")
        println("4. Apagar registro")
        println("5. Buscar registros")
        println("6. Sair")

        print("Escolha uma opção:")
        val opcao = readLine()

        when (opcao) {
            "1" -> registrarNovaEntrada()
            "2" -> listarRegistros()
            "3" -> verRegistroCompleto()
            "4" -> apagarRegistro()
            "5" -> buscarRegistros()
            "6" -> {
                println("Obrigado! Até mais!")
                break
            }

            else -> println("Opção inválida. Escolha de 1 a 6")
        }
    }
}