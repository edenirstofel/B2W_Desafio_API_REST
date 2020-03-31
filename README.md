#** **Desafio  B2W Api Rest

#** **Descrição

Criar um jogo com algumas informações da franquia. Para possibilitar  a equipe de front criar essa aplicação, queremos desenvolver uma API que contenha os dados dos planetas.


#** **Tecnologias utilizadas

-Java 1.8
-Spring Data MongoDB 
-Spring Boot 2.2.5
-Junit4
-Postman
-IDEA Spring Tool Suit 4 (STS)


#** **Informações para utilizar a API 

-Para utilizar a API é necessário configurar o servidor do MongoDB
-A API está considerando que o mongodb local estará na sua porta padrão (27017)
-Arquivo de configuração application.properties do Spring : spring.data.mongodb.uri=mongodb://localhost:27017/apistarwars


#** **Funcionalidades desenvolvidas 
- Adicionar um planeta (com nome, clima e terreno)
(ao adicinar um planeta a API se comunica com API do Star Wars (https://swapi.co/),obtem a quantidade de aparições e finaliza o processo de salvar)
- Listar planetas
- Buscar por nome
- Buscar por ID
- Remover planeta

#** **API Rest

-** **Adicionar um planeta: http://localhost:8080/planetas 

POST

Exemplo:

{ "nome": "Endor", 
"clima": "temperate", 
"terreno": "forests, mountains, lakes" }

** **Listar os planetas  : http://localhost:8080/planetas

Exemplo:

{"id":"5e7938a90b907c27fd7e786e","nome":"Alderaan","clima":"temperate, 
     tropical","terreno":"jungle, rainforests","quantidadeAparicao":2}

** **Buscar por nome : http://localhost:8080/planetas/{buscanome}/nome

Exemplo:
http://localhost:8080/planetas/buscanome?nome=Alderaan

{"id":"5e7938a90b907c27fd7e786e","nome":"Alderaan","clima":"temperate, tropical","terreno":"jungle, rainforests",
  "quantidadeAparicao":2}

** **Buscar por ID:http://localhost:8080/planetas/{id}

Exemplo:

http://localhost:8080/planetas/5e7938a90b907c27fd7e786e

{"id":"5e7938a90b907c27fd7e786e","nome":"Alderaan","clima":"temperate, tropical","terreno":"jungle, rainforests","quantidadeAparicao":2}

** **Remover planeta :http://localhost:8080/planetas/{id}

Exemplo :

DELETE : http://localhost:8080/planetas/5e7938a90b907c27fd7e786e

Caso esse planeta não exista ele retornará o erro 404 não encontrado.





