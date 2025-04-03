# 📚 API RESTful Hosting system com Spring Boot 🍃

Bem-vindo! Este projeto é uma API RESTful desenvolvida para gerenciar usuários e hospedagens de forma eficiente. A seguir, você encontrará um guia sobre como utilizá-la.

### **🛠 Tecnologias utilizadas e as dependências do Java**

- Java 17.0.4
- Maven 3.9.9
- Spring Boot (3.4.3)
  - **Spring Boot DevTools**
  - **Spring Web**
  - **Spring Data JPA**
  - **H2 Database**
  - **Spring Boot Actuator**
  - **Lombok Project**
  - **SpringDoc OpenAPI 2.x (para Swagger Ui)**
- Git/GitHub

### 💻 H2 Database Modeling

```mermaid
erDiagram
    User {
        Long id
        string name
        string cpf
        string phoneNumber
        string street
        string number
        string city
    }

    Hosting {
        Long id
        Long id_user
        double price
        string description
        string street
        string city
        string state
        string country
        boolean available
    }

    User ||--o{ Hosting : "has"
```

## 📄 Documentação Swagger

A API conta com documentação interativa via **Swagger UI**, facilitando testes e visualização dos endpoints.

### 🔗 Como Acessar a Documentação

Após iniciar a aplicação, acesse:

🔹 **Swagger UI:** [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui)


📌 **Exemplo da interface Swagger UI:**
<img src="imgs/swagger_img.png" withd = 500>



### 🔍 Fazendo Requisições (/User)

Após iniciar o projeto, o servidor ficará escutando na root `http://localhost:8080/`.

#### 🟣 Gerenciamento do User

| Method | Parameters | Action                              |
| ------ | ---------- | ----------------------------------- |
| POST   | /          | Cria um User                        |
| PUT    | /{id}      | Atualiza o User do id selecionado   |
| GET    | /          | Retorna uma lista de todos os Users |
| GET    | /{id}      | Retorna o User específico do id     |
| DELETE | /{id}      | Deleta o User do id selecionado     |

#### 🟣 Criando um User

- **Body (JSON):**
  ```json
  {
    "name": "nome",
    "cpf": "000.000.000-00",
    "street": "Rua Exemplo",
    "number": "00",
    "city": "cidade"
    "phoneNumber": "(00) 000000-000"
  }
  ```

### 🔍 Fazendo Requisições (/hosting)

#### 🟣 Gerenciamento do Hosting

| Method | Parameters | Action                                 |
| ------ | ---------- | -------------------------------------- |
| POST   | /          | Cria um Hosting                        |
| PUT    | /{id}      | Atualiza o Hosting do id selecionado   |
| GET    | /          | Retorna uma lista de todos os Hostings |
| GET    | /{id}      | Retorna o Hosting específico do id     |
| DELETE | /{id}      | Deleta o Hosting do id selecionado     |

#### 🟣 Criando um Hosting

- **Body (JSON):**
  ```json
  {
  "price": 0.0,
  "description": "descrição",
  "street": "rua",
  "city": "cidade",
  "state": "estado",
  "country": "pais",
  "available": true
  }
  ```
  #

## 🚀 Como Executar o Projeto

1️⃣ Clone o repositório:

```sh
git clone https://github.com/brunopaz8/Hosting-system
cd Hosting-system
```

2️⃣ Instale as dependências e compile o projeto:

```sh
mvn clean install
```

3️⃣ Inicie o servidor:

```sh
mvn spring-boot:run
```

4️⃣ A API estará disponível em:

```
http://localhost:8080/
```

5️⃣ Para acessar o **banco de dados H2**, utilize:

```
http://localhost:8080/h2-console
```
6️⃣ Caso queria usar o **swagger**, acesse:
```
http://localhost:8080/swagger-ui
```

### 💻 Configuração do Banco de Dados H2

- **URL JDBC:** `jdbc:h2:mem:testdb`
- **Driver:** `org.h2.Driver`
- **Usuário:** `sa`
- **Senha:** *(vazio)*
- **Dialect:** `org.hibernate.dialect.H2Dialect`
- **Modo Console:** Habilitado (`/h2-console`)

### 📌 Como acessar o console H2:

1. Vá até `http://localhost:8080/h2-console`
2. No campo *JDBC URL*, insira `jdbc:h2:mem:testdb`
3. Usuário: `sa` (sem senha)
4. Clique em *Connect* para visualizar as tabelas e os dados

---

























