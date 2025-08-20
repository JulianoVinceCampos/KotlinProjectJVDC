# KotlinProjectJVDC

O **KotlinProjectJVDC** é um aplicativo multiplataforma desenvolvido com **Kotlin Multiplatform** e **Compose Multiplatform**, que exibe listas de filmes utilizando a API do The Movie Database (TMDb). O projeto demonstra como compartilhar lógica de negócio, modelos e interface entre Android e iOS, promovendo reutilização de código e experiência consistente entre plataformas.

---

## 📱 Plataformas Suportadas

- **Android**: Aplicativo nativo utilizando Jetpack Compose.
- **iOS**: Aplicativo nativo com SwiftUI como entry point, integrando componentes compartilhados via Compose Multiplatform.

---

## ✨ Funcionalidades

- Consulta e exibição de filmes nas categorias:
  - **Populares** (Popular)
  - **Mais Bem Avaliados** (Top Rated)
  - **Em Breve** (Upcoming)
- Interface multiplataforma baseada em **Jetpack Compose** e **Compose Multiplatform**.
- Consumo de API REST com **Ktor Client**.
- Arquitetura baseada em **ViewModel** e estado reativo com **StateFlow**.
- Compartilhamento de lógica de negócio, modelos e UI entre Android e iOS.
- Gerenciamento de estados de carregamento e erro.
- Carrossel horizontal para cada categoria de filmes.
- Suporte a internacionalização (idioma pt-BR).
- Estrutura pronta para extensão com novas funcionalidades e categorias.

---

## 🗂 Estrutura do Projeto

```text
KotlinProjectJVDC/
│
├── composeApp/           # Código compartilhado (Kotlin Multiplatform + Compose)
│   ├── src/
│   │   ├── commonMain/   # Lógica, modelos, ViewModel e UI multiplataforma
│   │   ├── androidMain/  # Código específico para Android
│   │   └── iosMain/      # Código específico para iOS
│   └── ...               # Configurações e dependências
│
├── iosApp/iosApp/        # Aplicativo iOS (Swift/SwiftUI, integra Compose)
│
└── ...                   # Outros arquivos e configurações
```

- **commonMain**: Lógica principal, modelos de dados, ViewModels, componentes de UI compartilhados.
- **androidMain**/**iosMain**: Extensões para código específico de cada plataforma.
- **iosApp**: Estrutura do app iOS, ponto de entrada Swift/SwiftUI.

---

## 🏛️ Arquitetura e Fluxo de Dados

1. **MoviesRepository**
   - Responsável por buscar listas de filmes das categorias populares, mais bem avaliados e em breve, consumindo a API TMDb via Ktor Client.
   - Realiza requisições autenticadas e trata respostas e erros.

2. **Ktor Client**
   - Configurado para requisições HTTP, incluindo autenticação e idioma pt-BR.
   - Utilizado em commonMain para garantir multiplataforma.

3. **Modelos de Dados**
   - `Movie`: Representa um filme (id, título, imagem, descrição, etc).
   - `MovieSection`: Representa uma categoria de filmes e sua lista.

4. **MoviesListViewModel**
   - Gerencia o estado da tela (carregando, sucesso, erro).
   - Dispara carregamento das seções de filmes e expõe o estado via StateFlow.
   - Permite fácil integração com Compose (Android/iOS).

5. **UI Compose**
   - Exibe listas de filmes por categoria em carrosséis horizontais.
   - Gerencia estados de carregamento e erro.
   - Compartilhada entre Android e iOS via Compose Multiplatform.

---

## 🖼️ Exemplos de Tela

- Tela inicial: Lista de seções (Popular, Top Rated, Upcoming), cada uma com carrossel horizontal de filmes.
- Estados de carregamento e erro exibidos de forma amigável ao usuário.

---

## ⚙️ Configuração da API Key TMDb

Para utilizar a API do TMDb, é necessário obter uma API Key gratuita em [https://www.themoviedb.org/settings/api](https://www.themoviedb.org/settings/api).

1. Crie um arquivo de configuração (exemplo: `local.properties` ou `.env`) conforme instruções do projeto.
2. Adicione sua chave:
   ```
   TMDB_API_KEY=suachaveaqui
   ```
3. O projeto já está preparado para ler essa chave e utilizá-la nas requisições.

---

## 🚀 Como Executar

### Pré-requisitos

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Android Studio](https://developer.android.com/studio)
- Xcode (para build iOS)
- API Key do TMDb

### Clonando o projeto

```bash
git clone https://github.com/JulianoVinceCampos/KotlinProjectJVDC.git
cd KotlinProjectJVDC
```

### Android

1. Abra o projeto no Android Studio.
2. Configure sua API Key conforme instruções acima.
3. Execute em um emulador ou dispositivo real.

### iOS

1. Abra o projeto Xcode em `iosApp/iosApp`.
2. Configure sua API Key conforme instruções acima.
3. Execute em um simulador ou dispositivo real.

---

## 🧪 Testes

- Testes unitários para lógica de negócio e ViewModel em `commonTest`.
- Testes instrumentados podem ser adicionados para Android e iOS conforme necessário.

---

## 🔗 Tecnologias e Bibliotecas

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Ktor Client](https://ktor.io/docs/client.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [StateFlow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/)
- [SwiftUI](https://developer.apple.com/xcode/swiftui/)

---

## 📃 Exemplo de Código

```kotlin
// Consulta as seções de filmes
val sections = MoviesRepository().getMovieSections()
// Cada seção contém uma lista de filmes por categoria (Popular, Top Rated, Upcoming)
```

---

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests com sugestões, melhorias ou correções.

---

## 📄 Licença

Distribuído sob a licença MIT. Veja [LICENSE](LICENSE) para mais detalhes.

---

## 📚 Saiba Mais

- [Documentação oficial do Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [API do The Movie Database (TMDb)](https://www.themoviedb.org/documentation/api)

---
