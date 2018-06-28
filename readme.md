# UFG-INF-ES-DW-2018-1

## Arquivos

`pom.xml` - Arquivo de configuração do projeto Maven.

`src/main/webapp` - Pasta para colocar conteúdo web. 

## Para executar o Tomcat

`mvn tomcat7:run`

## Para executar o Derby

`mvn exec:java@derby-start`

## Banco de Dados

### JDBC

URL: `jdbc:derby://localhost:1527/gastodb`

Usuário: `app`

Senha: `app`

### Tabelas

`
CREATE TABLE GASTO (
  CODIGO VARCHAR(100),
  DESCRICAO VARCHAR(100),
  VALOR FLOAT
)
`