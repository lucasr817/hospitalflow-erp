# HospitalFlow ERP

# Documento de Regras de Negócio

Versão: 1.0

## Objetivo

Este documento define todas as regras de negócio do HospitalFlow ERP.

O objetivo é garantir que todas as funcionalidades do sistema sejam implementadas de acordo com o fluxo real de um hospital.

---

# RN-001 - Emissão de Senha

## Objetivo

Organizar o fluxo de atendimento do paciente desde sua chegada ao hospital.

## Regras

- Todo paciente do Pronto Atendimento deverá retirar uma senha no totem.
- O sistema deverá gerar automaticamente o número da senha.
- As senhas são separadas por categoria.
- Cada categoria possui sua própria sequência numérica.

## Tipos de Senha

- SUS
- Convênio
- Particular
- Emergência

## Exceção

Pacientes trazidos pelo SAMU, Corpo de Bombeiros ou outro serviço de resgate não utilizam o totem.

---

# RN-002 - Pesquisa do Paciente

Antes de realizar um novo cadastro, a recepção deverá pesquisar se o paciente já existe.

A pesquisa poderá ser realizada por:

- CPF
- Nome
- Data de nascimento
- Cartão SUS
- Número do prontuário

Caso o paciente seja localizado, o cadastro deverá ser atualizado quando necessário.

---

# RN-003 - Cadastro de Paciente

Caso o paciente não seja localizado, a recepção deverá realizar um novo cadastro.

O cadastro deverá armazenar todas as informações pessoais necessárias para identificação do paciente.

O sistema não permitirá pacientes duplicados.

---

# RN-004 - Geração Automática do Prontuário

Após o primeiro cadastro do paciente, o sistema deverá gerar automaticamente um número de prontuário.

O número do prontuário:

- é único;
- nunca poderá ser alterado;
- acompanhará o paciente por toda a vida.

Exemplo:

PR-000000001

PR-000000002

PR-000000003

---

# RN-005 - Atualização de Cadastro

Sempre que um paciente retornar ao hospital, seus dados poderão ser atualizados.

O número do prontuário permanecerá o mesmo.

---

# RN-006 - Abertura do Atendimento

Após localizar ou cadastrar o paciente, a recepção deverá abrir um novo atendimento.

Cada visita ao hospital gera um novo atendimento.

O atendimento receberá um número único.

Exemplo:

AT-20260805-000001

---

# RN-007 - Fluxo do Pronto Atendimento

O fluxo padrão será:

Totem

↓

Recepção

↓

Pesquisa do Paciente

↓

Cadastro ou Atualização

↓

Abertura do Atendimento

↓

Triagem

↓

Consulta Médica

↓

Alta

---

# RN-008 - Fluxo da Emergência

Pacientes trazidos por:

- SAMU
- Corpo de Bombeiros
- Ambulâncias
- Outros serviços de resgate

serão encaminhados diretamente para a Sala de Emergência.

Não passam pelo Totem.

Não passam pela Triagem do Pronto Atendimento.

Enquanto o paciente recebe atendimento, um familiar poderá comparecer à recepção para realizar ou atualizar seu cadastro.

Após o cadastro, a ficha será vinculada automaticamente ao atendimento da Emergência.

---

# RN-009 - Histórico do Paciente

Todo atendimento deverá ser registrado no prontuário do paciente.

O histórico deverá conter:

- Data
- Hora
- Médico responsável
- Especialidade
- Tipo de atendimento
- Diagnóstico
- Exames solicitados
- Prescrições
- Internações
- Alta médica

Nenhuma informação histórica poderá ser perdida.

---

# RN-010 - Tipos de Atendimento

O sistema deverá suportar os seguintes tipos de atendimento:

- Consulta
- Emergência
- Retorno
- Exame
- Internação

Cada atendimento poderá possuir um fluxo específico.

---

# RN-011 - Integridade do Cadastro

Não será permitido cadastrar dois pacientes com o mesmo CPF.

Nos casos de emergência em que o paciente não possa ser identificado, o CPF poderá ser informado posteriormente.

---

# RN-012 - Auditoria

O sistema deverá registrar todas as ações importantes.

Exemplos:

- Cadastro de paciente
- Atualização de cadastro
- Abertura de atendimento
- Início da triagem
- Início da consulta
- Solicitação de exames
- Internação
- Alta médica

Cada registro deverá armazenar:

- Data
- Hora
- Usuário responsável
- Operação realizada