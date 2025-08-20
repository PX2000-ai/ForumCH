<h1>Fórum Hub Challenge</h1>
Este projeto é um desafio pela Alura, que utiliza Java com Spring Boot e MySQL para gerar um banco de dados com o intuito de armazenar as discussões sobre as diversas formações presentes na Alura assim como suas dividas e soluções. A aplicação armazena seus dados em um banco de dados do MySQL, onde apenas aqules que são cadastrados possuindo uma chave JWT (JSON Web Token) podem interagir com a plataforma.

<h2>🚀 Tecnologias Utilizadas</h2>

Spring Boot: Facilita a configuração e execução do projeto, fornecendo convenções e autoconfiguração.

Spring Security: Gerencia autenticação e autorização, incluindo JWT.

Spring Data JPA: Facilita o acesso a bancos de dados relacionais, abstraindo consultas SQL com repositórios.

Spring Web / Spring MVC: Permite criar APIs REST, controllers, endpoints e manipular requisições HTTP.

Lombok: Automatiza a geração de código repetitivo como:

-@Data: getters, setters, toString, equals e hashCode.

-@NoArgsConstructor e @AllArgsConstructor: gera construtores automaticamente.

-Reduz boilerplate e deixa o código mais limpo.

MySQL: Banco de dados relacional utilizado para armazenar usuários, perfis, tópicos, cursos e respostas.

Flyway: Gerencia versionamento de banco de dados e migrations SQL (V1__create_tables.sql, V2__alter_table_usuarios.sql).

JWT (JSON Web Token): Para autenticação sem estado (stateless), permitindo que o front-end ou Postman use tokens Bearer, ele está integrado com Spring Security através de filtros (JwtAuthenticationFilter).

Hibernate: Implementação JPA utilizada pelo Spring Data JPA para gerenciar entidades, consultas e relacionamentos.

Postman: ferramenta externa usada para testar APIs REST e autenticação JWT.

<h2>✨ Funcionalidades</h2>
A aplicação oferece as seguintes funcionalidades:
Busca de Livros por Título ou pelo Autor na API: Permite ao usuário pesquisar livros na API Gutendex utilizando um título ou nome de autor como critério.

Persistência de Dados no Banco de Dados: Os livros e autores encontrados na API são salvos no banco de dados PostgreSQL para consultas futuras .

Listagem de Autores: Exibe todos os autores registrados no banco de dados.

Listagem de Livros: Exibe todos os livros registrados no banco de dados.

Busca de Autores Vivos em Determinado Ano: Permite filtrar autores que estavam vivos em um ano específico.

Listagem de Livros em Determinado Idioma: Permite filtrar livros por um idioma específico.

<h2>⚙️ Como Rodar o Projeto</h2>
Siga os passos abaixo para configurar e executar o projeto em sua máquina:

<h3>Pré-requisitos</h3>
Java 24.

Postman.

Extensões Flyway e Lombok intaladas no InelliJ

Maven instalado.

MySQL instalado e configurado (certifique-se de ter um banco de dados e um usuário para a aplicação).

<h3>Configuração do Banco de Dados</h3>
Crie um banco de dados no MySQL para o projeto como de sua escolha.

Atualize o arquivo src/main/resources/application.properties com as credenciais do seu banco de dados: ao ir na parte de Edit Configurations e Adicionar em Environment Variablesos dados: DATASOURCE_URL=jdbc:mysql://localhost:3306/forumseu banco de dados; DATASOURCE_PASSWORD=sua senha
<h3>Configuração do Banco de Dados</h3>

Crie um banco de dados no MySQL para o projeto como de sua escolha.

Atualize o arquivo src/main/resources/application.properties com as credenciais do seu banco de dados: ao ir na parte de Edit Configurations e Adicionar em Environment Variablesos dados: DATASOURCE_URL=jdbc:mysql://localhost:3306/forumseu banco de dados; DATASOURCE_PASSWORD=sua senha

<h2>⚙️ Como Operar o Projeto⚙️</h2>
Ao iniciar o Projeto(Run) você irá ao Postman ou a um programa similar e utilizará POST http://localhost:8080/auth/register
com o Body: 
{
  "nome": "De-sua-escolha",
  "email": "De-sua-escolha@email.com",
  "senha": "123456"
} 
para então resgitrar o usuário que você deseja utilizar, em caso de fechar o app você não terá que fazer isso novamente para
este usuário, e depois utilizará POST http://localhost:8080/auth/login com o body:
{
  "email": igual ao do register,
  "senha": igual ao do register
}
Para se conectar e obter JWT (JSON Web Token), cada vez que o app se reiniciar você de refazer seu login.
com JWT (JSON Web Token) copiado e aplicado você pode utilizar POST http://localhost:8080/curso com body:
{
  "nome": "JavaScript 3",
  "categoria": "FRONT_END"
} nas Categorias FRONT_END, BACK_END e DATA_SCIENCE para gerar um curso ao qual você pode abrir um tópico
utilizando POST http://localhost:8080/forum de body: 
{
  "titulo": "Erro no código",
  "mensagem": "Imagem cortada",
  "dataDeCriacao": "2025-08-17T10:00:00",
  "estadoDoTopico": "ABERTO",
  "autorId": 1,
  "cursoId": 1
} a o qual você pode interegir com os comandos:

POST http://localhost:8080/resposta
GET http://localhost:8080/forum/1
GET http://localhost:8080/forum
PUT http://localhost:8080/forum/1
DELETE http://localhost:8080/forum/1

