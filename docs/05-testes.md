# 05 - Testes

## Objetivo dos testes
Garantir que as regras de negócio críticas do controle de estoque estejam corretas e protegidas contra regressões.

## Testes criados

### 1. Cadastro de tênis
**Arquivo:** `src/test/java/com/lojadetenis/estoque/service/TenisServiceTest.java`

**Objetivo:** validar se o cadastro cria corretamente o tênis e as variações por numeração.

**Regra validada:**
- o tênis é salvo com modelo, marca e cor;
- as numerações informadas geram itens de estoque com quantidade zero.

### 2. Entrada de estoque
**Arquivo:** `src/test/java/com/lojadetenis/estoque/service/EstoqueServiceTest.java`

**Objetivo:** validar se uma entrada soma corretamente ao estoque existente.

**Regra validada:**
- a quantidade final deve ser igual ao estoque anterior mais a entrada.

### 3. Saída de estoque com quantidade válida
**Arquivo:** `src/test/java/com/lojadetenis/estoque/service/EstoqueServiceTest.java`

**Objetivo:** validar uma saída permitida.

**Regra validada:**
- a quantidade final deve ser igual ao estoque anterior menos a saída.

### 4. Tentativa de saída maior que o estoque disponível
**Arquivo:** `src/test/java/com/lojadetenis/estoque/service/EstoqueServiceTest.java`

**Objetivo:** garantir que o sistema bloqueie uma operação inválida.

**Regra validada:**
- deve lançar `BusinessException` quando a saída excede o estoque disponível.

### 5. Identificação de estoque baixo
**Arquivo:** `src/test/java/com/lojadetenis/estoque/service/EstoqueServiceTest.java`

**Objetivo:** validar a listagem de itens abaixo do limite.

**Regra validada:**
- itens com quantidade menor ou igual ao limite devem ser retornados.

### 6. Consulta de estoque por numeração
**Arquivo:** `src/test/java/com/lojadetenis/estoque/service/EstoqueServiceTest.java`

**Objetivo:** validar a consulta da quantidade de um tênis por numeração.

**Regra validada:**
- o sistema retorna o item correto quando tênis e numeração existem.

### 7. Testes de controller
**Arquivos:**
- `src/test/java/com/lojadetenis/estoque/controller/TenisControllerTest.java`
- `src/test/java/com/lojadetenis/estoque/controller/EstoqueControllerTest.java`

**Objetivo:** validar respostas básicas dos endpoints principais.

## Como executar os testes
### Pelo Visual Studio Code
1. Instale a extensão **Extension Pack for Java**.
2. Abra a aba de testes do Java.
3. Execute todos os testes ou individualmente.

### Pelo terminal
```bash
mvn test
```

### Compilação com testes
```bash
mvn clean install
```
