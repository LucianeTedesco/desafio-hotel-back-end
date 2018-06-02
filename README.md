
    
## Conexão:
Necessário alterar o arquivo application.properties, localizando em <Diretório>\desafio-hotel-back-end\hotel-desafio\src\main\resources

## Execução:
<Diretório>\desafio-hotel-back-end\hotel-desafio>mvnw spring-boot:run

## Exemplos Requisições:
***
1) <Cadastrar hóspedes(Retorna o Id) - POST

    Ex: <http://localhost:8080/hospede>
    ```java
    {
    	"nome" : "Luciane Tedesco",
    	"documento": "123456",
    	"telefone": "47991620567"
    }
    ```
***
2) Alterar cadastro do hóspedes(Retorna o Id)  - POST

    Ex: <http://localhost:8080/hospede>
    ```java
    {
    	"id": "1",
    	"nome" : "Luciane Tedesco",
    	"documento": "123456",
    	"telefone": "47991620567"
    }
    ```
***
3) Excluir hóspedes - DELETE

    Ex: <http://localhost:8080/hospede/{hospedeId}>
***   
4) Listar todos os hóspedes - GET

    Ex: <http://localhost:8080/hospede/listAll>
***
5) Pesquisar hóspede por Id - GET

    Ex: <http://localhost:8080/hospede/{hospedeId}>
***
6) Buscar hóspedes cadastrados pelo nome, documento ou telefone - GET

    Ex: <http://localhost:8080/hospede/findHospede?nome=Luciane Tedesco>

    Ex: <http://localhost:8080/hospede/findHospede?documento=123456>

    Ex: <http://localhost:8080/hospede/findHospede?telefone=47991620567>
***
7) Cadastrar checkin (Retorna o Id) - POST

    Ex:<http://localhost:8080/checkin>
    ```java
    {
    	"hospede": {
    		"id" : 1
    	},
    	"dataEntrada" : "2018-06-01T15:00:00",
    	"dataSaida": "2018-06-03T14:00:00",
    	"adicionalVeiculo": "true"
    }
    ```
***
8) Alterar cadastro do checkin (Retorna o Id) - POST

    Ex:<http://localhost:8080/checkin>
    ```java
    {	"id": "1",
	    "hospede": {
    		"id" : 1
    	},
    	"dataEntrada" : "2018-06-01T15:00:00",
    	"dataSaida": "2018-06-03T14:00:00",
    	"adicionalVeiculo": "false"
    }
    ```
***
9) Excluir checkins - DELETE

    Ex: <http://localhost:8080/checkin/{checkinId}>
***
10) Listar todos os checkins - GET

    Ex: <http://localhost:8080/checkin/listAll>
***
11) Pesquisar checkin por Id - GET

    Ex: <http://localhost:8080/checkin/{checkinId}>
***
12) Consultar hóspedes que já realizaram o check in e não estão mais no hotel - GET

    Ex: <http://localhost:8080/checkin/findAllInHotel>
***
13) Consultar hóspedes que ainda estão no hotel - GET

    Ex: <http://localhost:8080/checkin/findAllOutHotel>
