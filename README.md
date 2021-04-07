<h1>Senior</h1>
<h2>Sistema de Cadastro de Pedidos</h2>

<h3>Aplicação está hospedada no HEROKU, abaixo segue os endpoints para testes via POSTMAN</h3>

<h3>Endpoint Serviços - POST:</h3> 
https://cadastro-servicos-senior.herokuapp.com/servicos

JSON CREATE SERVIÇOS

{
        "id": 1,
        "nomeServico": "Manutenção de Sites",
        "valorHoraServico": 200.0
    }



<h3>Endpoint Visualizar todos os SERVIÇOS - GET:</h3>
https://cadastro-servicos-senior.herokuapp.com/servicos


<h3>Endpoint Visualizar apenas um SERVIÇO - GET:</h3>
https://cadastro-servicos-senior.herokuapp.com/servicos/1


<hr>

<h3>Endpoint Pedidos - POST:</h3>
https://cadastro-servicos-senior.herokuapp.com/pedidos

JSON CREATE PEDIDOS:

{
        "servicoComercializado": "TESTE",
        "qtdHora": 20,
        "profissionalAlocado": "Adriano Matias de Souza",
        "porcentagemImposto": 15.0,
        "lucroEmPorcentagem": 85.0,
        "total": 0.0,
        "servico": {
            "id": 1,
            "nomeServico": "Manutenção de Sites",
            "valorHoraServico": 200.0
        },
        "items": [],
        "id": 1
    }
    
<h3>Endpoint Visualizar todos os PEDIDOS - GET:</h3>
https://cadastro-servicos-senior.herokuapp.com/pedidos

<h3>Endpoint Visualizar apenas um PEDIDO - GET:</h3>
https://cadastro-servicos-senior.herokuapp.com/pedidos/1
