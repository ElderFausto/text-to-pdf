# API de Conversão de Texto para PDF

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-4.0-red.svg)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

API RESTful robusta e eficiente construída com **Spring Boot** para converter dinamicamente texto puro em documentos PDF. Esta aplicação foi projetada para ser leve, escalável e facilmente integrável com qualquer cliente frontend.

## 🚀 Funcionalidades Principais

-   **Conversão Dinâmica:** Gera arquivos PDF em tempo real a partir de um corpo de texto (`text/plain`) enviado via requisição POST.
-   **Manipulação de Arquivos:** Utiliza a poderosa biblioteca **iText7** para a criação de documentos PDF na memória, garantindo alta performance sem a necessidade de salvar arquivos temporários no servidor.
-   **Segurança:** Implementa um limite de tamanho de requisição para proteger a aplicação contra sobrecarga de memória e ataques de negação de serviço.
-   **CORS Habilitado:** Configurado para aceitar requisições de clientes frontend específicos (ex: `http://localhost:4200`), permitindo uma integração segura e sem falhas.

## 🛠️ Tecnologias Utilizadas

-   **Java 17**
-   **Spring Boot 3**
-   **Spring Web:** Para a construção dos endpoints RESTful.
-   **Maven:** Para gerenciamento de dependências.
-   **iText7:** Biblioteca de ponta para a criação e manipulação de arquivos PDF.
-   **Lombok:** Para reduzir código boilerplate e aumentar a legibilidade.

## 📄 Endpoint da API

### Gerar um PDF

-   **Método:** `POST`
-   **URL:** `/api/pdf/generate`
-   **Headers:**
    -   `Content-Type: text/plain`
-   **Corpo da Requisição (Body):**
    -   O texto puro que você deseja converter.
-   **Resposta de Sucesso:**
    -   **Código:** `200 OK`
    -   **Corpo:** O arquivo `documento.pdf` para download.

## ⚙️ Como Executar o Projeto

1.  **Pré-requisitos:**
    -   Java 17 (ou superior) instalado.
    -   Maven instalado.

2.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/text-to-pdf.git](https://github.com/seu-usuario/text-to-pdf.git)
    cd text-to-pdf
    ```

3.  **Execute a aplicação com o Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```

4.  A API estará disponível em `http://localhost:8080`.
