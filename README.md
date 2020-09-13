# Safra Easyway
> Aplicação Spring Boot para o Hackathon Technee Banco Safra

Solução para oferecimento de microcrédito a fim de fidelizar e aumentar a participação do Safra dentro desse mercado. Ao cadastrar um novo cliente, o mesmo é gravado na base de dados do Easyway(H2) e é feito um envio de Opt In para a API do Safra. Além disso o cálculo de score baseado no CPF é um mock simulando um serviço à parte.

![](../header.png)

## Instruções de uso

Desenvolvimento Backend: Gabriel Marins dos Santos
Desenvolvimento SignInController e FrontEnd: Diego Santana

## Instruções de uso

Pré Requisitos:

Java 11: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
https://medium.com/@mauriciogeneroso/configurando-java-4-como-configurar-as-vari%C3%A1veis-java-home-path-e-classpath-no-windows-46040950638f

Maven: https://www.devmedia.com.br/introducao-ao-maven/25128

Dependendo da IDE, será necessário configurar o Lombok para funcionamento da API:

Caso esteja usando a Eclipse IDE, seguir as instruções do link:

https://dicasdejava.com.br/como-configurar-o-lombok-no-eclipse/

Caso esteja usando a Intellij IDE, é necessário apenas instalar o plugin do Lombok para a IDE.

## Rodando a aplicação

Após as configurações iniciais, iniciar a aplicação Easyway (porta 8080). Após a aplicação estar rodando, acessar o endpoint: localhost:8080/microcredito para cadastrar novo cliente. 


## Parâmetros de Conexão ao Banco de Dados
Após mensagem de confirmação, acessar endpoint localhost:8080/h2-console, e preencher os seguintes campos com os seguintes valores:

JDBC URL: jdbc:h2:mem:EASYWAY
User Name: easyway
Password: safra

Após o login, será possível realizar Select nas tabelas para confirmar os cadastros.


## Payloads Permitidos via Postman/similar

Caso seja necessário realizar algum tipo de teste de integração via Postman ou ferramenta similar, os seguintes tipos de payload são permitidos:

PS: Valores dos campos são livres, mas se alterar o valor dos campos "name", "email" e "phoneNumber", não será possível realizar o Opt In na API do Safra devido ao endpoint ser mockado.

{
        "name": "Eric Evans Silva",
        "cpf": "12345678900",
	    "email": "eric.evans@ddd.com",
	    "phoneNumber": 5511911111111,
        "customerType": "MICROCREDIT",
        "creditAmount": 5000.00
}

{
        "name": "Eric Evans Silva",
        "cpf": "12345678900",
	    "email": "eric.evans@ddd.com",
	    "phoneNumber": 5511911111111,
        "customerType": "INVESTMENT",
        "income": 100000.00,
		"investingAmount": 10000.00,
        "rescueTime": "teste",
		"allowedLossAmount": 50000.00
}

{
        "name": "Eric Evans Silva",
        "cpf": "12345678900",
	    "email": "eric.evans@ddd.com",
	    "phoneNumber": 5511911111111,
        "customerType": "LOAN",
        "age": 25,
		"segmentType": "MEI", values:{MEI/AUTONOMOUS}
        "businessType": "Finance"
}