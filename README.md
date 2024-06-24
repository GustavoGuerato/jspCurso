# README: Projeto de Tela de Login em JSP com Servlets

## Descrição do Projeto
Este projeto implementa uma simples tela de login utilizando JavaServer Pages (JSP) para a interface do usuário e Servlets para o processamento das requisições. A aplicação permite que usuários façam login fornecendo um nome de usuário e senha.

## Tecnologias Utilizadas
- **Apache Tomcat**: Servidor web para executar a aplicação JSP e Servlets.
- **Java Servlet API**: Utilizada para desenvolver os controladores (Servlets) que processam as requisições HTTP.
- **JSP (JavaServer Pages)**: Utilizado para a criação das páginas web dinâmicas que compõem a interface do usuário.
- **JSTL (JavaServer Pages Standard Tag Library)**: Biblioteca de tags que simplifica a escrita de código JSP, promovendo uma separação entre a lógica de apresentação e a lógica de negócio.

## Estrutura do Projeto
O projeto é estruturado da seguinte maneira:

- **`/src`**: Contém os Servlets Java responsáveis pelo processamento das requisições.
- **`/WebContent`**: Diretório raiz da aplicação web.
  - **`/WEB-INF`**: Diretório especial que contém configurações e recursos que não são acessíveis diretamente pelo navegador.
    - **`/lib`**: Bibliotecas JAR utilizadas na aplicação, como o JSTL.
    - **`/web.xml`**: Arquivo de configuração do projeto web onde são definidos Servlets, filtros e outras configurações.
  - **`/index.jsp`**: Página inicial da aplicação onde está a interface de login.
  - **`/WEB-INF/web.xml`**: Arquivo de configuração do projeto web onde são definidos Servlets, filtros e outras configurações.

## Configuração do Ambiente de Desenvolvimento
1. **Java Development Kit (JDK)**:
   - Certifique-se de ter o JDK instalado e configurado corretamente no seu ambiente de desenvolvimento.

2. **Apache Tomcat**:
   - Faça o download do Apache Tomcat e configure-o no seu ambiente de desenvolvimento.
   - Certifique-se de configurar o `CATALINA_HOME` e o `JAVA_HOME` corretamente.

3. **IDE (Integrated Development Environment)**:
   - Utilize uma IDE como Eclipse, IntelliJ IDEA ou outra de sua preferência para desenvolver e gerenciar o projeto.

## Executando o Projeto
Para executar o projeto localmente:

1. **Importe o Projeto**:
   - Importe o projeto para a sua IDE como um projeto web existente.

2. **Configure o Tomcat**:
   - Configure o Apache Tomcat na sua IDE e defina o servidor para executar a aplicação.

3. **Deploy da Aplicação**:
   - Realize o deploy da aplicação no servidor Tomcat configurado.

4. **Acesso à Aplicação**:
   - Acesse a aplicação através do navegador utilizando o endereço `http://localhost:8080/nome-do-seu-projeto`.

## Funcionalidades Implementadas
- **Tela de Login**:
  - Formulário simples com campos para inserir usuário e senha.
  - Validação básica no lado do cliente e do servidor para garantir que os campos obrigatórios sejam preenchidos.

- **Servlet de Login**:
  - Servlet que processa as requisições de login.
  - Verifica as credenciais fornecidas pelo usuário e autentica o acesso.

- **Tratamento de Erros**:
  - Tratamento básico de erros, como login inválido ou campos não preenchidos corretamente.

## Melhorias Futuras
Para melhorar este projeto, considere implementar:

- **Autenticação com Banco de Dados**: Utilizar um banco de dados para armazenar e validar as credenciais dos usuários.
- **Melhorias na Interface**: Aprimorar o design e a usabilidade da tela de login.
- **Segurança**: Implementar medidas de segurança adicionais, como criptografia para armazenamento de senhas.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para forkar o projeto, fazer melhorias e enviar um pull request.

## Autores
- Este projeto foi desenvolvido por [Gustavo Guerato]([https://github.com/seu-usuario](https://github.com/GustavoGuerato)).

## Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](./LICENSE) para mais detalhes.
