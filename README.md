# Minicurso de Kotlin

Este é um projeto simples de linha de comando desenvolvido para ensinar os conceitos fundamentais da linguagem Kotlin para pessoas que já possuem conhecimento em programação.

O programa é um "Diário de Filmes e Séries", onde o usuário pode adicionar, listar, ver detalhes, apagar e buscar por registros de filmes ou séries que assistiu.

## Conceitos de Kotlin Utilizados

O código-fonte (`src/main/kotlin/Main.kt`) demonstra os seguintes conceitos da linguagem Kotlin:

- **Classes Seladas (`sealed class`)**: Para representar um conjunto restrito de tipos, como os gêneros dos filmes/séries.
- **Classes de Dados (`data class`)**: Para criar classes concisas que servem primariamente para armazenar dados, como cada entrada no diário.
- **Listas Mutáveis (`mutableListOf`)**: Para armazenar a coleção de entradas do diário, permitindo a adição e remoção de itens.
- **Expressão `when`**: Utilizada para controle de fluxo, como na seleção de opções do menu e na conversão de tipos de gênero para texto.
- **Segurança de Nulos (`Null Safety`)**: O projeto lida com valores que podem ser nulos (`String?`), utilizando operadores como `?:` (elvis) e chamadas seguras para evitar `NullPointerException`.
- **Funções**: O código é modularizado em funções, cada uma com uma responsabilidade clara.
- **Templates de String**: Para interpolação de variáveis e expressões dentro de strings.
- **Funções de Ordem Superior e Lambdas**: Funções como `forEachIndexed` e `filter` são usadas para processar a lista de entradas de forma funcional e concisa.
- **Inferência de Tipos**: O compilador infere os tipos de variáveis, tornando o código menos verboso.
- **Entrada e Saída Padrão**: Uso de `println`, `print` e `readLine` para interação com o usuário no console.

## Como Rodar o Programa

Este projeto utiliza o Gradle para gerenciamento de dependências e para a sua execução. Você não precisa ter o Kotlin ou o Gradle instalados na sua máquina, pois o projeto inclui o Gradle Wrapper.

### Pré-requisitos

- Java Development Kit (JDK) versão 8 ou superior.

### Execução

1.  Abra um terminal ou prompt de comando.
2.  Navegue até o diretório raiz do projeto.
3.  Execute o seguinte comando:

    **No macOS/Linux:**
    ```bash
    ./gradlew run
    ```

    **No Windows:**
    ```bash
    .\gradlew.bat run
    ```

O Gradle irá baixar as dependências necessárias e executar o programa. Siga as instruções que aparecerão no console para interagir com o diário.

### Abrindo no IntelliJ IDEA

Como o projeto é baseado em Gradle, abri-lo no IntelliJ IDEA é um processo simples.

1.  Com o IntelliJ IDEA aberto, vá em `File > Open...` (Arquivo > Abrir).
2.  Navegue até o diretório raiz deste projeto e selecione o arquivo `build.gradle.kts`.
3.  Clique em `Open as Project` (Abrir como Projeto).
4.  O IntelliJ irá sincronizar o projeto com o Gradle, o que pode levar alguns instantes.
5.  Após a sincronização, localize o arquivo `Main.kt` em `src/main/kotlin`.
6.  Você verá um ícone de "play" verde ao lado da função `main`. Clique nele e selecione `Run 'MainKt'` para executar o programa.
7.  O painel `Run` (Execução) irá aparecer na parte inferior da IDE, onde você poderá interagir com o programa.
