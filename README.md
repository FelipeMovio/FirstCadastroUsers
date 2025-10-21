📝 Modelo de README para backend do seu projeto

Você pode adaptar isso diretamente no seu repositório. Aqui vai um template:

# CadastroUsers Backend (Spring Boot + JWT)

Backend da aplicação de cadastro de usuários, responsável por fornecer API REST para registro, login e operações de usuário com autenticação via JWT.

---

## 🚀 Tecnologias

- Java 17+ / 11+  
- Spring Boot  
- Spring Security  
- JWT  
- JPA / Hibernate  
- Banco de dados (H2 ou outro configurável)  
- Lombok  
- DTOs e validações (`@Valid`)  

---

## 📦 Estrutura de pastas (exemplo)



src/
├ main/
│ ├ java/
│ │ └ com/felipemovio/CadastroUsers/
│ │ ├ controller/
│ │ ├ dto/
│ │ ├ model/
│ │ ├ repository/
│ │ ├ security/
│ │ ├ service/
│ └ resources/
│ └ application.properties


---

## 📋 Endpoints da API

| Método | Rota | Acesso | Descrição |
|--|--|--|--|
| POST | `/api/auth/register` | Público | Registra novo usuário |
| POST | `/api/auth/login` | Público | Autentica usuário e retorna token JWT |
| GET | `/api/users` | Necessita autenticação | Lista todos usuários |
| GET | `/api/users/{id}` | Necessita autenticação | Retorna dados de um usuário específico |
| DELETE | `/api/users/{id}` | Necessita autenticação | Deleta usuário pelo ID |
