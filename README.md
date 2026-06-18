# Controle de Estoque de Tênis

## Descrição resumida
Projeto acadêmico da UC de Engenharia de Software com foco no desenvolvimento de um back-end em Java Spring Boot para controlar o estoque de uma loja de tênis, considerando variações por modelo, marca, cor e numeração.

## Problema identificado
Uma loja de tênis possui dificuldades para controlar corretamente o estoque, especialmente por causa das variações de numeração. O processo atual manual ou baseado em planilhas pode causar erros de contagem, saídas indevidas e falta de visibilidade sobre estoque baixo.

## Objetivo da solução
Disponibilizar uma API REST capaz de cadastrar tênis, controlar quantidades por numeração, registrar entradas e saídas, impedir saída maior que o estoque disponível e identificar estoque baixo.

## Escopo implementado
- Cadastro de tênis
- Controle de variações por numeração
- Consulta de estoque por numeração
- Registro de entrada de estoque
- Registro de saída de estoque
- Validação de saída maior que o estoque disponível
- Listagem de produtos com estoque baixo
- Testes unitários
- Aplicação de SOLID e padrões de projeto

### Fora de escopo
- Front-end
- Sistema de vendas completo
- Financeiro
- Clientes
- Pagamentos
- Emissão fiscal
- Autenticação avançada

## Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database em memória
- Maven
- JUnit 5
- Mockito
- Git e GitHub

## Estrutura do projeto
```text
controle-estoque-tenis/
├── README.md
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/lojadetenis/estoque/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── factory/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── strategy/
│   │   │   └── EstoqueApplication.java
│   │   └── resources/application.properties
│   └── test/
│       └── java/com/lojadetenis/estoque/
│           ├── controller/
│           └── service/
└── docs/
    ├── 01-definicao-problema.md
    ├── 02-requisitos.md
    ├── 03-modelagem.md
    ├── 04-solid-padroes.md
    ├── 05-testes.md
    ├── 06-instrucoes-execucao.md
    └── diagramas/
```

## Objetivo de cada pacote
- `controller`: expõe os endpoints REST.
- `dto`: transporta dados entre API e serviços.
- `exception`: trata exceções e respostas de erro.
- `model`: entidades de domínio persistidas no banco.
- `repository`: acesso a dados com Spring Data JPA.
- `service`: regras de negócio e orquestração da aplicação.
- `strategy`: comportamento específico para entrada e saída de estoque.
- `factory`: criação padronizada de objetos de movimentação.
- `config`: configuração e carga inicial de dados.

## Funcionalidades
- `POST /api/tenis`
- `GET /api/tenis`
- `GET /api/tenis/{id}`
- `POST /api/estoque/entrada`
- `POST /api/estoque/saida`
- `GET /api/estoque/{tenisId}/numeracao/{numero}`
- `GET /api/estoque/baixo`

## Como executar
```bash
mvn clean install
mvn spring-boot:run
```

## Como rodar os testes
```bash
mvn test
```

## H2 Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:estoque_db`
- Usuário: `sa`
- Senha: em branco

## Exemplos de endpoints
### POST /api/tenis
```json
{
  "modelo": "Chuck Taylor All Star",
  "marca": "Converse",
  "cor": "Preto",
  "numeracoes": [38, 39, 40, 41]
}
```

### POST /api/estoque/entrada
```json
{
  "tenisId": 1,
  "numero": 39,
  "quantidade": 10
}
```

### POST /api/estoque/saida
```json
{
  "tenisId": 1,
  "numero": 39,
  "quantidade": 3
}
```

## Integrantes do grupo
- Integrante 1: __________________________________
- Integrante 2: __________________________________
- Integrante 3: __________________________________
- Integrante 4: __________________________________
- Integrante 5: __________________________________

## URL do repositório
- GitHub: __________________________________
