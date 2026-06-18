# 06 - Instruções de Execução

## Pré-requisitos
- Java JDK 17 ou superior
- Maven 3.9 ou superior
- Visual Studio Code
- Git
- Opcional: Postman, Insomnia ou Thunder Client

## Extensões recomendadas no VS Code
- Extension Pack for Java
- Spring Boot Extension Pack
- Maven for Java

## Como abrir o projeto
1. Clone ou copie a pasta `controle-estoque-tenis`.
2. No VS Code, clique em **File > Open Folder**.
3. Selecione a pasta do projeto.
4. Aguarde o Maven baixar as dependências.

## Como executar a aplicação
### Via terminal
```bash
mvn spring-boot:run
```

### Via VS Code
- Abra a classe `EstoqueApplication`.
- Clique em **Run** acima do método `main`.

## Como acessar o H2 Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:estoque_db`
- User Name: `sa`
- Password: deixe em branco

## Como testar os endpoints
Use Postman, Insomnia, Thunder Client ou curl.

Exemplos:

### Cadastrar tênis
```http
POST /api/tenis
Content-Type: application/json
```
```json
{
  "modelo": "Gel-Kayano",
  "marca": "Asics",
  "cor": "Azul",
  "numeracoes": [39, 40, 41, 42]
}
```

### Entrada de estoque
```http
POST /api/estoque/entrada
Content-Type: application/json
```
```json
{
  "tenisId": 1,
  "numero": 39,
  "quantidade": 5
}
```

### Saída de estoque
```http
POST /api/estoque/saida
Content-Type: application/json
```
```json
{
  "tenisId": 1,
  "numero": 39,
  "quantidade": 2
}
```

## Como rodar os testes
```bash
mvn test
```

## Como preparar o repositório GitHub
```bash
git init
git add .
git commit -m "Estrutura inicial do projeto"
git branch -M main
git remote add origin URL_DO_REPOSITORIO
git push -u origin main
```
