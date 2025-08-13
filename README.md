# KotlinProjectJVDC

Projeto **KotlinProjectJVDC** é um exemplo de aplicativo desenvolvido com **Kotlin Multiplatform** para exibição de listas de filmes, utilizando a API do The Movie Database (TMDb). O projeto tem como objetivo demonstrar como compartilhar lógica de negócio, modelos e interface entre Android e iOS utilizando **Compose Multiplatform**.

---

## 📱 Plataformas Suportadas

- **Android**
- **iOS** (SwiftUI como entry point, compartilhando componentes com Compose)

---

## ✨ Funcionalidades

- Consulta de filmes nas categorias:
  - Populares (Popular)
  - Mais Bem Avaliados (Top Rated)
  - Em Breve (Upcoming)
- Interface multiplataforma baseada em **Jetpack Compose** e **Compose Multiplatform**
- Consumo de API REST utilizando **Ktor Client**
- Arquitetura baseada em **ViewModel** e estado reativo (StateFlow)
- Compartilhamento de código de negócio e UI entre as plataformas

---

## 🗂 Estrutura do Projeto

```text
KotlinProjectJVDC/
│
├── composeApp/           # Código compartilhado entre Android e iOS (Kotlin Multiplatform + Compose)
│   ├── src/
│   │   ├── commonMain/   # Lógica, modelos, ViewModel e UI multiplataforma
│   │   ├── androidMain/  # Código específico para Android
│   │   └── iosMain/      # Código específico para iOS
│   └── ...               # Outros arquivos de configuração
│
├── iosApp/iosApp/        # Aplicativo iOS (entry point, integra com SwiftUI)
│
└── ...                   # Outros arquivos e configurações
```

- **commonMain**: Onde está a lógica principal do negócio, modelos de dados, ViewModels, e componentes de UI compartilhados.
- **androidMain**/**iosMain**: Pontos de extensão para código específico de plataforma, se necessário.
- **iosApp**: Estrutura do app iOS, onde é possível adicionar código Swift/SwiftUI.

---

## ⚙️ Como Funciona

1. **Repositório de Filmes (`MoviesRepository`)**  
   Responsável por buscar listas de filmes (popular, top rated, upcoming) da API TMDb, utilizando o `KtorClient`.

2. **KtorClient**  
   Configurado para realizar requisições HTTP autenticadas à API TMDb e obter listas de filmes no idioma português (pt-BR).

3. **Modelos de Dados**  
   - `Movie`: Representa um filme.
   - `MovieSection`: Representa uma seção de filmes (por categoria).

4. **ViewModel (`MoviesListViewModel`)**
   - Gerencia o estado da tela (carregando, sucesso, erro).
   - Dispara carregamento das seções de filmes e expõe o estado via StateFlow.

5. **UI Compose**
   - Exibe as listas de filmes separadas por categoria, cada uma em um carrossel horizontal.
   - Possui gerenciamento de estados para carregamento e erro.

---

## 🚀 Como Executar

### Pré-requisitos

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Android Studio](https://developer.android.com/studio) (recomendado para Android e multiplataforma)
- Xcode (para build iOS)

### Clonando o projeto

```bash
git clone https://github.com/JulianoVinceCampos/KotlinProjectJVDC.git
cd KotlinProjectJVDC
```

### Android

Abra o projeto no Android Studio e execute normalmente em um emulador ou dispositivo real.

### iOS

1. Abra o projeto Xcode dentro de `iosApp/iosApp`
2. Certifique-se de ter os requisitos de ambiente iOS instalados.
3. Execute em um simulador ou dispositivo real.

---

## 🔗 Tecnologias e Bibliotecas

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Ktor Client](https://ktor.io/docs/client.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [StateFlow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/)

---

## 📃 Exemplo de Código

```kotlin
// Consulta as seções de filmes
val sections = MoviesRepository().getMovieSections()
// Cada seção contém uma lista de filmes por categoria (Popular, Top Rated, Upcoming)
```

---

## 🤝 Contribuição

Sinta-se à vontade para abrir issues e pull requests! Sugestões, melhorias e correções são sempre bem-vindas.

---

## 📄 Licença

Este projeto é distribuído sob a licença MIT. Veja [LICENSE](LICENSE) para mais detalhes.

---

## 📚 Saiba Mais

- [Documentação oficial do Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [API do The Movie Database (TMDb)](https://www.themoviedb.org/documentation/api)

---
