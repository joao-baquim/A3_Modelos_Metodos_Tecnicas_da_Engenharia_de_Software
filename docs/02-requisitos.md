# 02 - Requisitos

## Abordagem adotada
Foi utilizada uma abordagem ágil, com levantamento incremental de necessidades do processo de estoque da loja. Os requisitos foram identificados por análise do problema, observação do fluxo operacional e decomposição do escopo em funcionalidades pequenas, implementáveis e priorizáveis.

## Como os requisitos foram levantados
- Observação do problema do controle manual/planilhas.
- Identificação dos usuários envolvidos.
- Mapeamento das operações essenciais do estoque.
- Priorização de funcionalidades de maior valor para o escopo viável do trabalho.

## Atores envolvidos
- **Funcionário do estoque**
- **Gerente da loja**
- **Sistema**

## Backlog do produto
1. Cadastrar tênis com marca, modelo, cor e numerações.
2. Listar todos os tênis cadastrados.
3. Buscar um tênis específico por ID.
4. Registrar entrada de estoque por numeração.
5. Registrar saída de estoque por numeração.
6. Consultar estoque de um tênis por numeração.
7. Listar produtos com estoque baixo.
8. Impedir saída maior que o estoque disponível.
9. Registrar movimentações de estoque.
10. Criar testes unitários para regras de negócio críticas.

## User stories
### US01 - Cadastrar tênis
Como **funcionário do estoque**, quero **cadastrar um tênis com suas numerações** para **controlar o estoque por tamanho**.

**Critérios de aceitação**
- Deve informar modelo, marca e cor.
- Deve existir ao menos uma numeração.
- Não pode haver numerações duplicadas no mesmo cadastro.
- As numerações cadastradas iniciam com quantidade zero.

### US02 - Listar tênis cadastrados
Como **funcionário do estoque**, quero **listar os tênis cadastrados** para **consultar rapidamente os produtos existentes**.

**Critérios de aceitação**
- O sistema deve retornar todos os tênis.
- O retorno deve exibir também as numerações controladas e suas quantidades.

### US03 - Buscar tênis por ID
Como **gerente da loja**, quero **buscar um tênis por ID** para **ver detalhes do produto e seu estoque por numeração**.

**Critérios de aceitação**
- Se o ID existir, o sistema retorna o tênis.
- Se o ID não existir, o sistema retorna erro 404.

### US04 - Registrar entrada de estoque
Como **funcionário do estoque**, quero **registrar entrada de itens por numeração** para **atualizar o estoque disponível**.

**Critérios de aceitação**
- Deve informar tênis, numeração e quantidade.
- Quantidade deve ser maior que zero.
- O sistema deve somar a quantidade ao estoque atual.
- Caso a numeração ainda não exista para o tênis, a entrada pode criar essa variação.

### US05 - Registrar saída de estoque
Como **funcionário do estoque**, quero **registrar saída de itens por numeração** para **reduzir o estoque disponível**.

**Critérios de aceitação**
- Deve informar tênis, numeração e quantidade.
- Quantidade deve ser maior que zero.
- O sistema deve impedir saída maior que o estoque atual.
- Se a numeração não existir, deve retornar erro.

### US06 - Consultar estoque por numeração
Como **funcionário do estoque**, quero **consultar a quantidade disponível de um tênis por numeração** para **confirmar disponibilidade antes de uma movimentação**.

**Critérios de aceitação**
- O sistema deve localizar o tênis e a numeração.
- Deve retornar a quantidade atual.
- Se não encontrar, deve retornar erro 404.

### US07 - Identificar estoque baixo
Como **gerente da loja**, quero **listar produtos com estoque baixo** para **planejar reposição**.

**Critérios de aceitação**
- O sistema deve retornar produtos cuja quantidade seja menor ou igual ao limite definido.
- Se nenhum item estiver baixo, deve retornar lista vazia.
- O limite pode ser informado por parâmetro; se não informado, usar padrão 3.

### US08 - Registrar histórico interno
Como **sistema**, quero **registrar cada movimentação** para **manter rastreabilidade mínima do estoque**.

**Critérios de aceitação**
- Toda entrada deve gerar um registro de movimentação.
- Toda saída deve gerar um registro de movimentação.
- O registro deve armazenar tipo, data/hora, tênis, numeração e quantidade.

## Requisitos funcionais
- **RF01**: Cadastrar tênis.
- **RF02**: Listar todos os tênis.
- **RF03**: Buscar tênis por ID.
- **RF04**: Registrar entrada de estoque.
- **RF05**: Registrar saída de estoque.
- **RF06**: Consultar estoque por numeração.
- **RF07**: Listar estoque baixo.
- **RF08**: Impedir saída acima do disponível.
- **RF09**: Registrar movimentações de estoque.

## Requisitos não funcionais
- **RNF01**: A aplicação deve ser desenvolvida em Java 17 ou superior.
- **RNF02**: Deve utilizar Spring Boot e Maven.
- **RNF03**: Deve expor API REST em arquitetura em camadas.
- **RNF04**: Deve usar banco H2 em memória para facilitar execução acadêmica.
- **RNF05**: Deve possuir testes unitários com JUnit 5 e Mockito.
- **RNF06**: Deve aplicar princípios SOLID.
- **RNF07**: Deve utilizar padrões de projeto coerentes.
- **RNF08**: Deve ser executável no Visual Studio Code.
- **RNF09**: Deve conter documentação técnica em Markdown.

## Priorização dos requisitos
### Alta prioridade
- RF01, RF02, RF03, RF04, RF05, RF06, RF07, RF08

### Média prioridade
- RF09

### Baixa prioridade
- Melhorias futuras, como autenticação, relatórios e integração com vendas.
