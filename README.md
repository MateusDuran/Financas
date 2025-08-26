💰 Sistema de Controle Financeiro 

Este projeto é um sistema de controle financeiro desenvolvido em Java + Spring Boot, baseado no diagrama UML de classes. 

Ele permite o gerenciamento de usuários, contas, bancos, lançamentos e faturas. 

 

📊 Diagrama UML 

O sistema foi modelado a partir do seguinte diagrama de classes UML: 

 

🛠️ Tecnologias Utilizadas 

Java 17+ 

Spring Boot 3.x 

Spring Data JPA 

Hibernate 

MySQL (ou PostgreSQL) 

Maven 

📂 Estrutura do Projeto 

src/main/java/com/seuprojeto/financeiro 
 │── controller -> Camada de controllers (APIs REST) 
 │── service -> Regras de negócio 
 │── repository -> Interfaces de acesso ao banco (Spring Data JPA) 
 │── model -> Classes de entidade (baseadas no UML) 
 │── dto -> Objetos de transferência de dados 
 │── config -> Configurações da aplicação 

  

## ⚙️ Configuração do Banco de Dados 

No arquivo `src/main/resources/application.properties` configure a conexão: 

  

```properties 

spring.datasource.url=jdbc:mysql://localhost:3306/controle_financeiro 

spring.datasource.username=root 

spring.datasource.password=senha 

spring.jpa.hibernate.ddl-auto=update 

spring.jpa.show-sql=true 

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect 

 

📑 Funcionalidades 

Cadastro, alteração, exclusão e listagem de: 

Pessoas 

Usuários (ADMIN e CLIENTE) 

Contas (Corrente, Poupança, Cartão de Crédito, Investimento, Alimentação) 

Bancos 

Lançamentos (Crédito e Débito) 

Faturas (Aberto, Fechado, Atrasado, Pago) 

Centros de Custo 

Controle de status das faturas. 

Controle de situação dos lançamentos (Aberto/Baixado). 

package com.seuprojeto.financeiro.model; 

  

import jakarta.persistence.*; 

import lombok.*; 

import java.math.BigDecimal; 

import java.time.LocalDate; 

import java.util.List; 

  

@Getter 

@Setter 

@NoArgsConstructor 

@AllArgsConstructor 

@Entity 

public class Pessoa { 

    @Id 

    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private Integer idPessoa; 

  

    private String nome; 

    private String email; 

    private String senha; 

    private LocalDate criadoEm; 

  

    // Métodos de negócio podem ser implementados no Service 

} 

package com.seuprojeto.financeiro.model; 

  

import jakarta.persistence.*; 

import lombok.*; 

  

@Getter 

@Setter 

@NoArgsConstructor 

@AllArgsConstructor 

@Entity 

public class Usuario { 

    @Id 

    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private Integer idUsuario; 

  

    private String razaoSocial; 

  

    @Enumerated(EnumType.STRING) 

    private TipoUsuario tipoUsuario; 

} 

<img width="1273" height="928" alt="image" src="https://github.com/user-attachments/assets/1fce36c3-2468-4303-8e4f-48c8477bf720" />

 

 
