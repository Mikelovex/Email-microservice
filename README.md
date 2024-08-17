# Microservices: User Registration and Email Notification

Este repositório contém dois microservices simples que trabalham em conjunto: um para o cadastro de usuários e outro para o envio de e-mails.

## Arquitetura

1. **Microservice de Cadastro de Usuário**
   - Responsável pelo registro de novos usuários.
   - Ao registrar um usuário, uma mensagem é enviada para uma fila RabbitMQ.

2. **Microservice de Envio de E-mail**
   - Escuta a fila RabbitMQ para mensagens de novos registros.
   - Envia um e-mail de confirmação para o usuário registrado.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para construção dos microservices.
- **Spring Mail**: Utilizado para o envio de e-mails.
- **RabbitMQ**: Sistema de mensageria usado para comunicação entre os microservices.
- **Filas**: RabbitMQ gerencia filas para armazenar mensagens entre o envio e o processamento.
- **PostgreSQL**: Banco de dados utilizado para armazenar os dados.

## Configuração

### 1. Pré-requisitos

- **Java 17** ou superior
- **Maven 3.8** ou superior
- **RabbitMQ** instalado e em execução

