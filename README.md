
# Controle de Estoque de TÃªnis

## DescriÃ§Ã£o resumida
Projeto acadÃªmico da UC de Engenharia de Software com foco no desenvolvimento de um back-end em Java Spring Boot para controlar o estoque de uma loja de tÃªnis, considerando variaÃ§Ãµes por modelo, marca, cor e numeraÃ§Ã£o.

## Problema identificado
Uma loja de tÃªnis possui dificuldades para controlar corretamente o estoque, especialmente por causa das variaÃ§Ãµes de numeraÃ§Ã£o. O processo atual manual ou baseado em planilhas pode causar erros de contagem, saÃ­das indevidas e falta de visibilidade sobre estoque baixo.

## Objetivo da soluÃ§Ã£o
Disponibilizar uma API REST capaz de cadastrar tÃªnis, controlar quantidades por numeraÃ§Ã£o, registrar entradas e saÃ­das, impedir saÃ­da maior que o estoque disponÃ­vel e identificar estoque baixo.

## Escopo implementado
- Cadastro de tÃªnis
- Controle de variaÃ§Ãµes por numeraÃ§Ã£o
- Consulta de estoque por numeraÃ§Ã£o
- Registro de entrada de estoque
- Registro de saÃ­da de estoque
- ValidaÃ§Ã£o de saÃ­da maior que o estoque disponÃ­vel
- Listagem de produtos com estoque baixo
- Testes unitÃ¡rios
- AplicaÃ§Ã£o de SOLID e padrÃµes de projeto

### Fora de escopo
- Front-end
- Sistema de vendas completo
- Financeiro
- Clientes
- Pagamentos
- EmissÃ£o fiscal
- AutenticaÃ§Ã£o avanÃ§ada

## Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database em memÃ³ria
- Maven
- JUnit 5
- Mockito
- Git e GitHub

## Estrutura do projeto
```text
controle-estoque-tenis/
â”œâ”€â”€ README.md
â”œâ”€â”€ pom.xml
â”œâ”€â”€ src/
â”‚   â”œâ”€â”€ main/
â”‚   â”‚   â”œâ”€â”€ java/com/lojadetenis/estoque/
â”‚   â”‚   â”‚   â”œâ”€â”€ config/
â”‚   â”‚   â”‚   â”œâ”€â”€ controller/
â”‚   â”‚   â”‚   â”œâ”€â”€ dto/
â”‚   â”‚   â”‚   â”œâ”€â”€ exception/
â”‚   â”‚   â”‚   â”œâ”€â”€ factory/
â”‚   â”‚   â”‚   â”œâ”€â”€ model/
â”‚   â”‚   â”‚   â”œâ”€â”€ repository/
â”‚   â”‚   â”‚   â”œâ”€â”€ service/
â”‚   â”‚   â”‚   â”œâ”€â”€ strategy/
â”‚   â”‚   â”‚   â””â”€â”€ EstoqueApplication.java
â”‚   â”‚   â””â”€â”€ resources/application.properties
â”‚   â””â”€â”€ test/
â”‚       â””â”€â”€ java/com/lojadetenis/estoque/
â”‚           â”œâ”€â”€ controller/
â”‚           â””â”€â”€ service/
â””â”€â”€ docs/
    â”œâ”€â”€ 01-definicao-problema.md
    â”œâ”€â”€ 02-requisitos.md
    â”œâ”€â”€ 03-modelagem.md
    â”œâ”€â”€ 04-solid-padroes.md
    â”œâ”€â”€ 05-testes.md
    â”œâ”€â”€ 06-instrucoes-execucao.md
    â””â”€â”€ diagramas/
```

## Objetivo de cada pacote
- `controller`: expÃµe os endpoints REST.
- `dto`: transporta dados entre API e serviÃ§os.
- `exception`: trata exceÃ§Ãµes e respostas de erro.
- `model`: entidades de domÃ­nio persistidas no banco.
- `repository`: acesso a dados com Spring Data JPA.
- `service`: regras de negÃ³cio e orquestraÃ§Ã£o da aplicaÃ§Ã£o.
- `strategy`: comportamento especÃ­fico para entrada e saÃ­da de estoque.
- `factory`: criaÃ§Ã£o padronizada de objetos de movimentaÃ§Ã£o.
- `config`: configuraÃ§Ã£o e carga inicial de dados.

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
- UsuÃ¡rio: `sa`
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
- Integrante 4: Vitória Rabelo Leite - 123115759

## URL do repositÃ³rio
- GitHub: https://github.com/joao-baquim/A3_Modelos_Metodos_Tecnicas_da_Engenharia_de_Software.git
