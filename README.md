# Alura Food

Bem-vindo ao repositório do projeto **Alura Food**! Este projeto é uma aplicação completa de e-commerce de alimentos, implementada utilizando uma arquitetura de microsserviços, utilizado no Curso 'Microsserviços na prática: mensageria com RabbitMQ'. Abaixo você encontrará uma descrição detalhada dos componentes do sistema, bem como instruções para configuração e execução.

## Componentes do Sistema

- Microsserviço de Pagamento
- Microsserviço de Pedido
- Microsserviço de Avaliação
- Server Discovery
- Gateway
- Broker RabbitMQ

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em seu ambiente de desenvolvimento:

- Java 17
- Maven
- Docker
- MySQL

## Configuração e Execução

### Clonando o Repositório

```bash
git clone https://github.com/uFelps/Alura-Food-Microsservices.git
cd alura-food
```

### Rodando o Docker-Compose

```bash
docker-compose up
```

## Utilizando as API's

### 1º Passo

Voce pode começar criando um novo pedidos apartir de uma Request POST na URL: `http://localhost:8085/pedidos-ms/pedidos`

```bash
{
    "itens": [
    {
        "quantidade": 10,
        "descrição": "Coca-cola"
    },
    {
        "quantidade": 5,
        "descrição": "Mc Chicken"
    }
    ]
}
```

Confira se o pedido foi criado apartir de uma Request GET na URL: `http://localhost:8085/pedidos-ms/pedidos`

### 2º Passo

Você pode criar um novo pagamento mandando uma request POST na URL: `http://localhost:8085/pagamentos-ms/pagamentos`

```bash
{
    "valor": 500,
    "nome": "John",
    "numero": "12345678",
    "expiracao": "10/29",
    "codigo": "123",
    "pedidoId": 1,
    "formaDePagamentoId": 1
}
```

Confira se o pedido foi criado mandando uma Request GET na URL: `http://localhost:8085/pagamentos-ms/pagamentos`

### 3º Passo

Confirme o pagamento mandando uma Request PATCH na URL: `http://localhost:8085/pagamentos-ms/pagamentos/{id_pagamento}/confirmar`

Após essa request, o irá enviar mensagens assíncronas para os microsserviços de pedidos e avaliação, informando que o pagamento foi confirmado

<img src="https://github.com/uFelps/assets/blob/main/Alura-Food/comunicacaoAssincrona.png?raw=true" alt="Representação comunicação Assincrona">

Se você buscar todos os pagamentos novamente, o pagamento agora estará com o status CONFIRMADO.

Já o pedido agora estará como PAGO.
