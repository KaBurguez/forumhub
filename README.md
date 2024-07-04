# ForumHub

## Descrição

ForumHub é uma API REST para um fórum online onde os usuários podem criar, visualizar, atualizar e excluir tópicos de discussão. Este projeto foi desenvolvido como parte do último desafio da formação Back End da Alura, utilizando Spring Boot 3.3.1, Java 17 e MySQL.

## Funcionalidades

- **Criar um novo tópico:** Permite que os usuários criem novos tópicos de discussão.
- **Mostrar todos os tópicos criados:** Lista todos os tópicos existentes no fórum.
- **Mostrar um tópico específico:** Exibe detalhes de um tópico específico através do seu ID.
- **Atualizar um tópico:** Permite a atualização de informações de um tópico existente.
- **Eliminar um tópico:** Remove um tópico do fórum.

## Como Utilizar

Para utilizar a API do ForumHub, siga os passos abaixo:

1. **Clone o repositório:**

    ```sh
    git clone https://github.com/KaBurguez/forumhub.git
    cd forumhub
    ```

2. **Compile o projeto utilizando Maven:**

    ```sh
    mvn clean install
    ```

3. **Configure o banco de dados MySQL:**

    Crie um banco de dados e um usuário:

    ```sql
    CREATE DATABASE forumhub;
    CREATE USER 'forumuser'@'localhost' IDENTIFIED BY 'sua_senha';
    GRANT ALL PRIVILEGES ON forumhub.* TO 'forumuser'@'localhost';
    FLUSH PRIVILEGES;
    ```

4. **Configure as variáveis de ambiente no arquivo `application.properties`:**

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
    spring.datasource.username=forumuser
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    ```

5. **Execute a aplicação:**

    Utilize o comando abaixo para iniciar a aplicação:

    ```sh
    mvn spring-boot:run
    ```

    A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

### Tópicos

- `POST /topicos`: Cria um novo tópico
- `GET /topicos`: Lista todos os tópicos
- `GET /topicos/{id}`: Mostra um tópico específico
- `PUT /topicos/{id}`: Atualiza um tópico
- `DELETE /topicos/{id}`: Deleta um tópico

## Autores

- [Karina Burguez](https://github.com/KaBurguez)

Este projeto foi desenvolvido como parte do desafio da formação Back End da Alura. Agradecimentos especiais aos instrutores e à comunidade da Alura pelo suporte e orientação durante o desenvolvimento deste projeto.

