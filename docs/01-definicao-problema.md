# 01 - Definição do Problema

## Contexto
A loja de tênis trabalha com produtos que possuem múltiplas variações, como modelo, marca, cor e principalmente numeração. Esse tipo de operação exige um controle detalhado de quantidade por item e por tamanho.

## Funcionamento atual do processo
Atualmente, o controle pode ser feito de forma manual, em planilhas ou em processos pouco padronizados. Em muitos cenários, o registro das entradas e saídas depende de atualização humana posterior, o que aumenta a chance de inconsistências.

## Usuários envolvidos
- **Funcionário do estoque:** realiza cadastro de produtos, entrada e saída de itens.
- **Gerente da loja:** acompanha disponibilidade, detecta produtos com estoque baixo e toma decisões de reposição.
- **Sistema:** recebe, valida e processa as operações de estoque.

## Dificuldades existentes atualmente
- Dificuldade para saber a quantidade disponível de cada tênis por numeração.
- Risco de registrar venda/saída sem estoque suficiente.
- Falta de alerta sobre produtos com estoque baixo.
- Retrabalho no controle manual.
- Erros humanos em lançamentos.
- Falta de histórico estruturado de movimentações.

## Como a solução proposta melhora o processo
A API proposta centraliza regras de negócio essenciais do controle de estoque:
- cadastra produtos com suas numerações;
- registra entradas e saídas com validações;
- consulta estoque por numeração;
- lista itens com estoque baixo;
- registra movimentações de entrada e saída.

Isso reduz erros, padroniza o processo e fornece uma base para futuras evoluções.

## Delimitação do escopo
### Escopo implementado
- Back-end em Java e Spring Boot.
- API REST para controle de estoque de tênis.
- Cadastro de tênis.
- Controle de numeração.
- Entrada e saída de estoque.
- Consulta de estoque por numeração.
- Identificação de estoque baixo.
- Testes unitários.
- Aplicação de princípios SOLID e padrões de projeto.

### Fora do escopo
- Front-end.
- Vendas completas.
- Cadastro de clientes.
- Financeiro.
- Pagamentos.
- Emissão fiscal.
- Segurança avançada e autenticação completa.

## Justificativa da escolha
O problema é real, frequente em pequenos e médios comércios e adequado ao objetivo da UC, pois permite aplicar análise de requisitos, modelagem UML, arquitetura em camadas, orientação a objetos, testes automatizados e boas práticas de Engenharia de Software.
