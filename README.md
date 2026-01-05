Sistema de Biblioteca em Java
Descrição do Projeto

Este projeto consiste no desenvolvimento de um Sistema de Biblioteca em Java, com o objetivo de simular operações reais como cadastro de livros, autores e usuários, empréstimos, devoluções e consultas, aplicando na prática os principais conceitos aprendidos ao longo do curso técnico em Desenvolvimento de Sistemas.

O sistema foi desenvolvido com foco em boas práticas de Programação Orientada a Objetos, uso de Streams e Lambdas, exceções personalizadas, repositórios genéricos e separação de responsabilidades, servindo também como base de estudo para evolução futura em Spring Boot.

Objetivos do Projeto

Consolidar conceitos fundamentais e avançados de Java

Aplicar Programação Orientada a Objetos de forma correta

Utilizar Generics para criar repositórios reutilizáveis

Aplicar Streams, Lambdas e operações de filtro

Trabalhar com exceções personalizadas

Implementar regras de negócio em uma camada de serviço

Simular um sistema real de biblioteca

Criar uma base sólida para transição futura para Java + Spring Boot

Tecnologias Utilizadas

Java

Java Collections

Streams e Lambdas

Java Time API (LocalDate)

JDBC

Maven (quando aplicável)

Estrutura do Projeto
src/
 ├── Classes
 │   ├── dominio
 │   │   ├── Livro
 │   │   ├── Autor
 │   │   ├── Usuario
 │   │   └── Emprestimo
 │
 │   ├── repositorio
 │   │   ├── Repositorio<T, ID>
 │   │   ├── LivroRepositorio
 │   │   ├── AutorRepositorio
 │   │   ├── UsuarioRepositorio
 │   │   └── EmprestimoRepositorio
 │
 │   ├── service
 │   │   └── BibliotecaService
 │
 │   ├── excecoes
 │   │   ├── NaoCadastradoException
 │   │   ├── JaCadastradoException
 │   │   └── RepositorioVazioException
 │
 └── main
     └── Main

Funcionalidades Implementadas
Livros

Cadastro de livros

Busca de livros por título

Listagem de livros disponíveis

Controle de status (emprestado ou disponível)

Usuários

Cadastro de usuários

Controle de quantidade de empréstimos

Verificação de multas

Autores

Cadastro de autores

Convite para palestras

Validação de autor cadastrado

Empréstimos

Realização de empréstimos

Devolução de livros

Verificação de atraso

Aplicação de multa em caso de atraso

Tratamento de Exceções

O sistema utiliza exceções personalizadas para garantir regras de negócio claras e seguras, como:

Entidade não cadastrada (NaoCadastradoException)

Entidade já cadastrada (JaCadastradoException)

Repositório vazio (RepositorioVazioException)

Livro indisponível para empréstimo

Usuário multado não pode realizar empréstimos

Exemplo de uso de exceção genérica:

throw new NaoCadastradoException(Livro.class, idLivro);

Conceitos Aplicados

Programação Orientada a Objetos

Encapsulamento e abstração

Repositórios genéricos com Generics

Streams e Lambdas

Optional

Tratamento de exceções

Organização em camadas (Domínio, Repositório, Serviço)

Separação de regras de negócio

Boas práticas de código limpo

Próximos Passos (Roadmap)

Migração do projeto para Spring Boot

Criação de API REST

Uso de JPA e Hibernate

Implementação de testes automatizados com JUnit

Validações com Bean Validation

Documentação de API com Swagger

Autor

Projeto desenvolvido por Gabriel Oliveira Dias Barboza,
aluno do curso técnico em Desenvolvimento de Sistemas,
com fins educacionais e foco no aprendizado de Backend Java.
