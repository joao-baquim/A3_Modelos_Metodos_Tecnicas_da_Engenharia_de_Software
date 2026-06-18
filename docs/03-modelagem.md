# 03 - Modelagem

## Objetivo da modelagem
A modelagem foi elaborada para representar de forma fiel a solução implementada no código, facilitando o entendimento das entidades, responsabilidades, interações entre camadas e fluxo das operações de entrada e saída de estoque.

## Diagramas elaborados
- Diagrama de Classes (obrigatório)
- Diagrama de Casos de Uso
- Diagrama de Sequência - Entrada de Estoque
- Diagrama de Sequência - Saída de Estoque
- Diagrama de Componentes

## 1. Diagrama de Classes
### Finalidade
Representar as principais classes do domínio, DTOs, serviços, estratégias, fábrica, controladores e repositórios, evidenciando atributos, métodos principais e relacionamentos.

### Arquivo sugerido
`docs/diagramas/diagrama-classes.png`

### Observação de alinhamento com o código
Os nomes das classes e métodos foram mantidos exatamente conforme o projeto:
- `Tenis`
- `EstoqueItem`
- `MovimentacaoEstoque`
- `TenisService`
- `EstoqueService`
- `MovimentacaoEstoqueFactory`
- `EntradaEstoqueStrategy`
- `SaidaEstoqueStrategy`
- `TenisController`
- `EstoqueController`

## 2. Diagrama de Casos de Uso
### Finalidade
Representar o que cada ator faz no sistema: cadastrar tênis, consultar estoque, registrar entrada, registrar saída e verificar estoque baixo.

### Arquivo sugerido
`docs/diagramas/diagrama-casos-uso.png`

## 3. Diagrama de Sequência - Entrada de Estoque
### Finalidade
Representar a sequência de chamadas entre controlador, serviço, repositórios, estratégia de entrada e fábrica de movimentação.

### Arquivo sugerido
`docs/diagramas/sequencia-entrada-estoque.png`

## 4. Diagrama de Sequência - Saída de Estoque
### Finalidade
Representar a lógica de validação da saída, incluindo o bloqueio de saída maior que o disponível.

### Arquivo sugerido
`docs/diagramas/sequencia-saida-estoque.png`

## 5. Diagrama de Componentes
### Finalidade
Representar as camadas da aplicação e suas dependências principais.

### Arquivo sugerido
`docs/diagramas/diagrama-componentes.png`

## Ferramentas recomendadas
- Mermaid Live Editor: https://mermaid.live/
- PlantUML: https://www.plantuml.com/plantuml/
- diagrams.net: https://app.diagrams.net/

## Instrução de uso das ferramentas
### Mermaid Live Editor
1. Acesse `https://mermaid.live/`.
2. Apague o código de exemplo.
3. Cole o código Mermaid fornecido neste projeto.
4. Visualize o diagrama automaticamente.
5. Exporte em PNG ou SVG.
6. Salve em `docs/diagramas/` com o nome sugerido.

### PlantUML
1. Acesse `https://www.plantuml.com/plantuml/`.
2. Cole o código PlantUML fornecido.
3. Gere o diagrama.
4. Exporte a imagem.
5. Salve na pasta `docs/diagramas/`.

### diagrams.net
1. Acesse `https://app.diagrams.net/`.
2. Selecione dispositivo local ou Google Drive.
3. Crie um novo diagrama em branco.
4. Monte o desenho com base no código Mermaid ou PlantUML fornecido.
5. Exporte como PNG.
6. Salve na pasta `docs/diagramas/`.
