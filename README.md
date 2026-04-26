# 🚗 AutoGenius

AutoGenius é um sistema de gerenciamento para oficina mecânica desenvolvido como Trabalho de Conclusão de Curso (TCC), com foco na organização de processos operacionais e controle básico de estoque.

## 🚀 Objetivo do projeto

O sistema foi desenvolvido para auxiliar na gestão de oficinas mecânicas, permitindo o controle de cadastros, ordens de serviço e movimentação de produtos utilizados em serviços.

## 🛠️ Funcionalidades

### Cadastros | alteração | Exclusão
- Clientes
- Funcionários
- Fornecedores
- Produtos

### Ordem de Serviço
- Abertura de ordens de serviço
- Registro dos serviços realizados
- Associação de produtos utilizados

### Controle de Estoque
- Controle básico de quantidade de produtos
- Baixa automática ao utilizar produtos em uma ordem de serviço
- Validação de estoque disponível
- Alerta quando não houver quantidade suficiente para o uso

## ⚙️ Regra de negócio implementada

Ao registrar uma ordem de serviço e utilizar determinada quantidade de um produto:

- o sistema realiza a baixa automática no estoque;
- verifica se há saldo disponível;
- caso a quantidade seja insuficiente, o sistema informa indisponibilidade do item.

## 💻 Tecnologias utilizadas

- Java
- PostgreSQL
- JDBC
- Programação Orientada a Objetos

## 📂 Estrutura do projeto

- Módulo de Clientes  
- Módulo de Funcionários  
- Módulo de Fornecedores  
- Módulo de Produtos  
- Módulo de Ordens de Serviço  
- Controle de Estoque

## 🎓 Projeto acadêmico

Projeto desenvolvido como Trabalho de Conclusão de Curso (TCC).

## 📌 Status

Finalizado e disponível para fins de portfólio e estudos.
