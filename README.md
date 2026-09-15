# 🏥 HospitalFlow

API REST para gerenciamento de processos e fluxo de atendimento hospitalar, desenvolvida com **Java 25** e **Spring Boot 4**.

O HospitalFlow é um projeto de backend desenvolvido para simular operações comuns de um sistema hospitalar, com foco em **regras de negócio, organização por domínio, persistência de dados, validação e construção de APIs REST**.

O projeto foi desenvolvido com uma abordagem de **monólito modular**, organizando as funcionalidades de acordo com seus respectivos domínios de negócio.

---

## 🎯 Objetivo

O objetivo do HospitalFlow é representar, de forma simplificada, o fluxo de um paciente dentro de um ambiente hospitalar, desde seu cadastro até processos de atendimento, triagem e internação.

O projeto também serve como aplicação prática de conceitos de desenvolvimento backend com Java e Spring Boot.

---

## 🛠️ Tecnologias

| Tecnologia          | Utilização                        |
| ------------------- | --------------------------------- |
| **Java 25**         | Linguagem principal               |
| **Spring Boot 4**   | Framework da aplicação            |
| **Spring Web**      | Desenvolvimento da API REST       |
| **Spring Data JPA** | Persistência e acesso aos dados   |
| **Hibernate**       | ORM                               |
| **PostgreSQL**      | Banco de dados relacional         |
| **Flyway**          | Versionamento e migração do banco |
| **Bean Validation** | Validação dos dados de entrada    |
| **JUnit 5**         | Testes automatizados              |
| **Mockito**         | Testes unitários                  |
| **Maven**           | Gerenciamento e build do projeto  |
| **Git / GitHub**    | Versionamento                     |
| **Postman**         | Testes da API                     |

---

## 🏗️ Arquitetura

O projeto utiliza uma estrutura organizada por **domínio de negócio**, mantendo as responsabilidades relacionadas a cada funcionalidade agrupadas.

```text
com.lucasramalho.hospitalflow
│
├── domain
│   ├── patient
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── repository
│   │   └── service
│   │
│   ├── attendance
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── enums
│   │   ├── repository
│   │   └── service
│   │
│   ├── triage
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── enums
│   │   ├── repository
│   │   └── service
│   │
│   └── hospitalization
│       ├── controller
│       ├── dto
│       ├── entity
│       ├── enums
│       ├── repository
│       └── service
│
└── shared
    └── exception
        ├── BusinessException.java
        ├── GlobalExceptionHandler.java
        └── ResourceNotFoundException.java
```

Cada domínio concentra suas próprias regras e componentes, reduzindo o acoplamento entre funcionalidades.

---

## 📋 Funcionalidades

### 👤 Cadastro de pacientes

* Cadastro de pacientes
* Registro de nome, data de nascimento e CPF
* Geração automática do número de prontuário
* Retorno dos dados do paciente através de DTO

Exemplo de prontuário gerado:

```text
PRT-000001
```

---

### 🧾 Atendimento

O módulo de atendimento controla a ficha e o ciclo de vida do atendimento.

Funcionalidades:

* Criação de ficha de atendimento
* Consulta de atendimento
* Consulta da fila de atendimentos
* Início do atendimento
* Finalização do atendimento
* Cancelamento do atendimento
* Controle das transições de status

Estados disponíveis:

```text
AGUARDANDO
    ↓
EM_ATENDIMENTO
    ↓
FINALIZADO
```

Também é possível:

```text
AGUARDANDO → CANCELADO
EM_ATENDIMENTO → CANCELADO
```

Operações inválidas são bloqueadas pelas regras de negócio.

---

### 🩺 Triagem

O módulo de triagem registra informações clínicas iniciais do paciente associadas a um atendimento.

Informações contempladas:

* Queixa principal
* Histórico dos sintomas
* Intensidade da dor
* Irradiação da dor
* Histórico médico
* Medicamentos contínuos
* Alergias
* Contexto recente
* Frequência cardíaca
* Pressão arterial
* Frequência respiratória
* Saturação de oxigênio
* Temperatura
* Glicemia capilar
* Nível de consciência
* Estado geral
* Classificação de risco

O sistema também impede que um mesmo atendimento possua mais de uma triagem.

Classificações disponíveis:

```text
URGENCIA
NAO_URGENTE
POUCO_URGENTE
EMERGENCIA
```

---

### 🏥 Internação

O módulo de internação controla o processo administrativo de admissão e encerramento da internação.

Estados disponíveis:

```text
AGENDADA
AGUARDANDO_ADMISSAO
INTERNADO
ALTA
OBITO
TRANSFERIDO
```

Fluxo principal implementado:

```text
AGUARDANDO_ADMISSAO
        ↓
    INTERNADO
        ↓
       ALTA
```

Também existem operações para:

* Registrar óbito
* Registrar transferência
* Registrar data de admissão
* Registrar data de encerramento
* Impedir operações incompatíveis com o estado atual da internação

---

## 🔄 Fluxo principal

```text
Paciente
   ↓
Cadastro
   ↓
Prontuário
   ↓
Ficha de atendimento
   ↓
Fila
   ↓
Triagem
   ↓
Classificação de risco
   ↓
Atendimento
   ↓
Finalização
```

Quando houver necessidade de internação:

```text
Atendimento
   ↓
Solicitação de internação
   ↓
Aguardando admissão
   ↓
Internado
   ↓
Alta / Óbito / Transferência
```

---

## 🧠 Regras de negócio

As regras de negócio são implementadas principalmente na camada de serviço.

Exemplos:

```text
AGUARDANDO → EM_ATENDIMENTO      ✓
EM_ATENDIMENTO → FINALIZADO      ✓
AGUARDANDO → CANCELADO           ✓

FINALIZADO → CANCELADO           ✗
FINALIZADO → EM_ATENDIMENTO     ✗
AGUARDANDO → FINALIZADO          ✗
```

Para internações:

```text
AGUARDANDO_ADMISSAO → INTERNADO  ✓
INTERNADO → ALTA                 ✓
INTERNADO → OBITO                ✓
INTERNADO → TRANSFERIDO          ✓
```

Operações inválidas geram exceções de negócio e são tratadas de forma centralizada.

---

## ⚠️ Tratamento de exceções

O projeto possui tratamento global para situações como:

* Recurso não encontrado
* Regra de negócio inválida
* Dados de entrada inválidos

As respostas da API seguem um padrão consistente.

Exemplo:

```json
{
  "status": 404,
  "message": "Paciente não encontrado"
}
```

Para erros de validação:

```json
{
  "status": 400,
  "message": "Dados inválidos",
  "errors": {
    "painIntensity": "A intensidade da dor deve ser no máximo 10"
  }
}
```

---

## 🗄️ Banco de dados

O projeto utiliza **PostgreSQL** como banco de dados e **Flyway** para controle de versão das alterações do schema.

Migrations atuais:

```text
V1 → Criação da tabela de pacientes
V2 → Criação das fichas de atendimento
V3 → Criação das triagens
V4 → Criação das internações
```

Principais tabelas:

```text
patients
attendance_records
triages
hospitalizations
flyway_schema_history
```

---

## 🧪 Testes

O projeto possui testes automatizados utilizando **JUnit 5** e **Mockito**.

Entre as regras já cobertas estão:

```text
✓ Confirmar internação
✓ Impedir confirmação de uma internação já internada
✓ Registrar alta
✓ Impedir alta de paciente que não está internado
```

Também existe teste de carregamento do contexto da aplicação Spring.

Os testes de regras de negócio utilizam mocks para isolar a camada de serviço e validar seu comportamento de forma independente do banco de dados.

---

## 📡 Principais endpoints

### Pacientes

```http
POST /patients
```

### Atendimentos

```http
POST /attendance-records
GET  /attendance-records/{id}
GET  /attendance-records/queue
PUT  /attendance-records/{id}/start
PUT  /attendance-records/{id}/finish
PUT  /attendance-records/{id}/cancel
```

### Triagem

```http
POST /api/triages
```

### Internação

```http
POST /api/hospitalizations
PUT  /api/hospitalizations/{id}/confirm
PUT  /api/hospitalizations/{id}/discharge
PUT  /api/hospitalizations/{id}/death
PUT  /api/hospitalizations/{id}/transfer
```

---

## 🚀 Como executar

### Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

* Java 25
* PostgreSQL 17
* Maven
* Git

### 1. Clonar o projeto

```bash
git clone https://github.com/lucasr817/hospitalflow-erp.git
cd hospitalflow-erp
```

### 2. Criar o banco

No PostgreSQL:

```sql
CREATE DATABASE hospitalflow_erp_db;
```

### 3. Configurar o banco

O projeto utiliza variáveis de ambiente para a senha do PostgreSQL.

Arquivo:

```text
src/main/resources/application.yml
```

Exemplo:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/hospitalflow_erp_db
    username: postgres
    password: ${DB_PASSWORD}
```

Defina a variável de ambiente:

```text
DB_PASSWORD=sua_senha
```

### 4. Executar a aplicação

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

A aplicação será disponibilizada em:

```text
http://localhost:8081
```

As migrations do Flyway serão executadas automaticamente durante a inicialização.

---

## 📁 Documentação adicional

As regras de negócio do projeto estão documentadas em:

```text
docs/01-Regras-de-Negocio.md
```

---

## 📌 Status do projeto

**v1.0.0 — Projeto concluído**

O HospitalFlow foi desenvolvido como projeto de portfólio com foco em backend Java e Spring Boot.

O projeto contempla:

* API REST
* Persistência relacional
* Regras de negócio
* Validação
* Tratamento global de exceções
* Versionamento de banco de dados
* Testes automatizados
* Organização por domínio

A containerização com Docker pode ser adicionada como etapa de infraestrutura do projeto.

---

## 👨‍💻 Autor

**Lucas Ramalho**

Desenvolvedor backend em formação, com foco em **Java, Spring Boot, APIs REST, SQL e desenvolvimento de sistemas de gestão**.

### Tecnologias

```text
Java
Spring Boot
Spring Data JPA
Hibernate
PostgreSQL
Flyway
JUnit
Mockito
Maven
Git
```

---

## 📄 Licença

Este projeto foi desenvolvido para fins de estudo e portfólio.
