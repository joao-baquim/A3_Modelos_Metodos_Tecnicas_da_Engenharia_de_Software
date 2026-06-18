# 04 - SOLID e Padrões de Projeto

## Aplicação dos princípios SOLID

### 1. SRP - Single Responsibility Principle
Cada classe possui uma responsabilidade principal:
- `TenisController` lida apenas com endpoints de tênis.
- `EstoqueController` lida apenas com endpoints de estoque.
- `TenisService` contém regras de cadastro e consulta de tênis.
- `EstoqueService` contém regras de movimentação e consulta de estoque.
- `MovimentacaoEstoqueFactory` cria objetos `MovimentacaoEstoque`.
- `EntradaEstoqueStrategy` e `SaidaEstoqueStrategy` encapsulam comportamentos distintos de movimentação.
- `GlobalExceptionHandler` centraliza o tratamento de exceções.

### 2. OCP - Open/Closed Principle
O projeto está aberto para extensão e fechado para modificação em pontos importantes:
- A interface `EstoqueOperationStrategy` permite criar novas estratégias sem alterar a lógica central do serviço.
- Se houver um novo tipo de movimentação no futuro (por exemplo, ajuste de inventário), pode-se criar uma nova estratégia e registrá-la.

### 3. LSP - Liskov Substitution Principle
As implementações `EntradaEstoqueStrategy` e `SaidaEstoqueStrategy` podem substituir a abstração `EstoqueOperationStrategy` sem quebrar o comportamento esperado do serviço.

### 4. ISP - Interface Segregation Principle
As portas `TenisServicePort` e `EstoqueServicePort` separam os contratos por contexto, evitando interfaces grandes e genéricas.

### 5. DIP - Dependency Inversion Principle
Os controladores dependem das interfaces `TenisServicePort` e `EstoqueServicePort`, não das implementações concretas. O `EstoqueService` depende da abstração `EstoqueOperationStrategy`, e não de estratégias específicas fixas no código.

## Padrões de projeto utilizados

### Repository Pattern
**Onde foi usado:**
- `TenisRepository`
- `EstoqueItemRepository`
- `MovimentacaoEstoqueRepository`

**Por que faz sentido:**
Separa a lógica de acesso a dados da lógica de negócio, utilizando Spring Data JPA para persistência.

### DTO Pattern
**Onde foi usado:**
- `TenisRequestDTO`
- `TenisResponseDTO`
- `MovimentacaoEstoqueDTO`
- `EstoquePorNumeracaoDTO`
- `EstoqueBaixoDTO`

**Por que faz sentido:**
Evita expor diretamente entidades da camada de persistência na API e permite controlar o formato das entradas e saídas.

### Service Layer Pattern
**Onde foi usado:**
- `TenisService`
- `EstoqueService`

**Por que faz sentido:**
Centraliza regras de negócio, validações e orquestração das transações, mantendo controladores enxutos.

### Factory Method / Factory
**Onde foi usado:**
- `MovimentacaoEstoqueFactory`

**Por que faz sentido:**
Padroniza a criação de registros de movimentação, evitando duplicação na montagem do objeto `MovimentacaoEstoque` e facilitando alterações futuras.

### Strategy Pattern
**Onde foi usado:**
- `EstoqueOperationStrategy`
- `EntradaEstoqueStrategy`
- `SaidaEstoqueStrategy`

**Por que faz sentido:**
Entrada e saída possuem regras diferentes. A Strategy encapsula essas diferenças e evita condicionais espalhadas no código.

## Benefícios arquiteturais obtidos
- Maior coesão entre classes.
- Melhor separação de responsabilidades.
- Facilidade de teste unitário.
- Maior clareza para manutenção e evolução.
- Aderência ao escopo acadêmico proposto.
