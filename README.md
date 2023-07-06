# Gerenciamento de Pessoa
Este projeto Java oferece uma API para o gerenciamento de pessoas, permitindo o cadastro de informações pessoais no banco de dados. A aplicação utiliza o framework Spring Boot, o Spring Data JPA para acesso ao banco de dados e o H2 como banco de dados em memória.

## Funcionalidades
A API oferece as seguintes funcionalidades:

- Cadastro de uma pessoa com informações básicas, como nome e identificador (CPF ou CNPJ).
- Validação do identificador informado (CPF ou CNPJ) e tratamento adequado com base no seu tamanho.
- Persistência dos dados no banco de dados H2.

# Documentação da API

A documentação detalhada da API pode ser acessada através do Swagger UI. As URLs para acesso são as seguintes:

- Swagger UI: [http://localhost:8080/srm-service/swagger-ui.html](http://localhost:8080/srm-service/swagger-ui/index.html)
- Documentação do endpoint de cadastro de pessoa: [http://localhost:8080/srm-service/swagger-ui.html#/people/createPersonUsingPOST](http://localhost:8080/srm-service/swagger-ui/index.html#/Servico/createPerson)
- No Swagger UI, você encontrará a descrição completa da API, incluindo detalhes dos endpoints disponíveis, informações sobre os parâmetros e respostas, e a capacidade de testar os endpoints diretamente pela interface.

# Configuração do Projeto
Para executar o projeto, siga as etapas abaixo:

- Certifique-se de ter o Java JDK 17 (ou uma versão compatível) instalado em seu sistema.
- Faça o clone deste repositório para a sua máquina local.
- Navegue até o diretório do projeto.
- Execute o seguinte comando para construir o projeto e iniciar o servidor embutido:
```bash
  mvn spring-boot:run
```
Após executar essas etapas, a aplicação estará em execução e a API estará disponível para uso.

# Configurações Adicionais

- O projeto está configurado para usar o banco de dados H2 em memória para fins de desenvolvimento. Os dados não serão persistidos após a reinicialização do aplicativo. Para um ambiente de produção, configure um banco de dados adequado, como MySQL ou PostgreSQL.
- As configurações do projeto, como a porta do servidor e as configurações do banco de dados, podem ser ajustadas no arquivo src/main/resources/application.properties.
- O arquivo pom.xml contém as dependências do projeto e outras configurações do Maven.

Certifique-se de ajustar as configurações do projeto, como o banco de dados, para atender às suas necessidades específicas.

# Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas (issues) e enviar solicitações de pull request para aprimorar este projeto.

Espero que este projeto seja útil como exemplo básico de uma API de gerenciamento de pessoas usando o Spring Boot e o H2 como banco de dados em memória. Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato.
