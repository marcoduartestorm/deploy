# Back-end
Back-end da calculadora de co2 da Terrazul, onde implementa-se uma REST API usando o Spring Boot Framework usando Java.
Usa-se o endpoint "administradores/salvar" para "POST", com os parametros da requisição "email" e "senha" do administrador logado (nesta ordem).
E "administradores/{id}" para as requisições "GET", "PUT" e "DELETE". Usa-se o endpoint "administradores/listar" com a requisição "POST" para listar os administradores,
usando o JSON de administradores.

Usa-se o endpoint "clientes/salvar" para "POST", com os parâmetros da requisição "email" e "senha" do administrador logado (nesta ordem).
E "clientes/{id}" para as requisições "GET", "PUT" e "DELETE". Usa-se o endpoint "clientes/listar" com a requisição "POST" para listar os clientes,
usando o JSON de administradores.

Usa-se o endpoint "emissoes/salvar" para "POST" com os parâmetros da requisição "email" e "senha" do administrador logado (nesta ordem),
e "emissoes/{id}" para as requisições "GET", "PUT" e "DELETE". Usa-se o endpoint "emissoes/listar" com a requisição "POST" para listar as emissões,
usando o JSON de administradores.

JSON de administradores:

{ "email":"", "senha":"", "nome":"" }

JSON de clientes:

{ "data": "", "projeto": "", "nome": "", "cpf": "", "endereco": "", "email": "", "telefone": "", "matriculaDeEnergia": "", "titularEnergiaCpf": "", "matriculaDeAgua": "", "titularAguaCpf": "", "matriculaDeGas": "", "titularGasCpf": "", "habitantes": "" }

JSON de emissoes:

{"tipoEmissao":"", "nome":"", "cpf":"", "mes":"", "ano":"", "consumo":""}
