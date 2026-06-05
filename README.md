# Sistema de Controle de Estacionamento (Refatorado)

Este projeto consiste na refatoração completa de um sistema de controle e gerenciamento de vagas de estacionamento desenvolvido em Java. O foco principal desta atualização foi a aplicação de conceitos consolidados de Programação Orientada a Objetos (POO), garantindo maior segurança, organização e manutenibilidade ao código.

## 🚀 O que mudou nesta versão?

* **Encapsulamento Estrito:** Todos os atributos de todas as classes foram modificados para o modificador de acesso `private`.
* **Métodos de Acesso:** Inclusão correta de métodos `Getters` e `Setters` para a manipulação segura das propriedades das classes.
* **Uso de Enums (3 Estados):** Substituição de Strings soltas e tipos primitivos por estruturas robustas de Enum:
    * `TipoVeiculo`: Gerencia as categorias aceitas (`CARRO`, `MOTO`, `CAMINHAO`).
    * `StatusVaga`: Controla o fluxo de ocupação (`DISPONIVEL`, `OCUPADA`, `MANUTENCAO`).
* **Correção no Ponto de Entrada:** Ajuste no escopo do método principal na classe `Main` para `public static void main`, permitindo a correta inicialização do ciclo de vida da aplicação.

## 📂 Estrutura do Projeto

O código foi desacoplado e organizado nos seguintes pacotes:

```text
src/
├── Applications/
│   ├── Main/
│   │   └── Main.java
│   └── Menu/
│       └── Menu.java
├── Enums/
│   ├── StatusVaga.java
│   └── TipoVeiculo.java
└── Entities/
    ├── Estacionamento/
    │   └── Estacionamento.java
    └── Veiculo/
        └── Veiculo.java
