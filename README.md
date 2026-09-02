# 🏥 HospitalFlow

API REST para gerenciamento do fluxo de atendimento hospitalar, desenvolvida com Java e Spring Boot.

O projeto tem como objetivo simular processos de um sistema hospitalar, aplicando conceitos de desenvolvimento backend, modelagem de domínio, regras de negócio, persistência de dados e APIs REST.

---

## 🚀 Tecnologias

- Java 25
- Spring Boot 4
- Spring Data JPA
- Hibernate
- PostgreSQL
- Flyway
- Maven
- Git e GitHub
- Postman

---

## 🏗️ Estrutura

O projeto é organizado por domínio, separando as responsabilidades da aplicação:

```text
com.lucasramalho.hospitalflow
│
├── domain
│   ├── patient
│   ├── attendance
│   └── triage
│
└── shared

Cada domínio possui suas próprias camadas de:

Controladores
Serviços
Repositórios
Entidades
DTOs
Enumerações

🧩 Funcionalidades

👤 Pacientes
Cadastro de pacientes
Identificação por CPF
Geração automática do número de prontuário

🧾 Atendimento
Criação de ficha de atendimento
Consulta de ficha
Controle da fila
Início do atendimento
Finalização do atendimento
Cancelamento do atendimento

🩺 Triagem
Registro das informações iniciais do paciente:

Queixa principal
Histórico dos sintomas
Intensidade e irradiação da dor
Histórico médico
Medicamentos contínuos
Alergias
Sinais vitais
Nível de consciência
Estado geral
Classificação de risco

🔄 Fluxo de atendimento
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
Controle de status
AGUARDANDO
     ↓
EM_ATENDIMENTO
     ↓
FINALIZADO

Também é possível cancelar um atendimento antes da finalização.

📡 Principais endpoints
Pacientes
POST /patients
Fichas de atendimento
POST /attendance-records
GET  /attendance-records/{id}
GET  /attendance-records/queue
PUT  /attendance-records/{id}/start
PUT  /attendance-records/{id}/finish
PUT  /attendance-records/{id}/cancel
Triagem
POST /api/triages

🗄️ Banco de dados

O projeto utiliza PostgreSQL e Flyway para controle e versionamento das alterações do banco.

Principais tabelas:

patients
    ↓
attendance_records
    ↓
triages

🧠 Regras de negócio

O sistema controla as transições de estado dos atendimentos para impedir operações inválidas.

Exemplos:

AGUARDANDO → EM_ATENDIMENTO     ✓
EM_ATENDIMENTO → FINALIZADO     ✓
AGUARDANDO → CANCELADO          ✓

FINALIZADO → CANCELADO          ✗
FINALIZADO → EM_ATENDIMENTO     ✗
AGUARDANDO → FINALIZADO         ✗

As regras são implementadas na camada de serviço.

▶️ Como executar
Pré-requisitos
Java 25
PostgreSQL
Maven
Git
Banco de dados

Crie o banco:

CREATE DATABASE hospitalflow_erp_db;

Configure as credenciais no arquivo:

src/main/resources/application.properties

Execute a aplicação:

.\mvnw.cmd spring-boot:run

A API estará disponível em:

http://localhost:8081
📌 Status do projeto

🚧 Em desenvolvimento.

O projeto está sendo desenvolvido de forma incremental, com novos módulos e melhorias planejados.

Próximas etapas
Validação dos dados
Tratamento global de exceções
Documentação com Swagger
Testes automatizados
Autenticação e autorização
Gestão de médicos
Consultas
Exames
Internações
Docker


👨‍💻 Autor

Lucas Ramalho

Estudante de Análise e Desenvolvimento de Sistemas, com foco em desenvolvimento backend utilizando Java e Spring Boot.

Tecnologias: Java • Spring Boot • PostgreSQL • SQL • Git