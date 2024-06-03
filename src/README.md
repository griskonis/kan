Aplicação desenvolvida em SPRING BOOT utilizando o Clean Code.

Fazer o download da Aplicação e atualizar o POM.XML.

Referente ao banco de dados o script se encontra no arquivo data.sql dentro da pasta resources.

Para rodar a Aplicação executar a classe KanApplication (main).

Segue anexo os metodos e o request

1-) (POST) - Cadastrar um beneficiario junto com os seus documentos.

	localhost:8080/beneficiario
	
	POST (Body -->JSON)

{
    "nome": "xx xx x",
    "telefone": "xxx",
    "dataInclusao": "08-06-2015",
    "dataNascimento": "08-06-2015",
    "dataAlteracao": "08-06-2015",
    "listDocumentoDto": [
        {
            "descricao": "x 1",
            "tipoDocumento": "xxx 222 1",
            "dataInclusao": "08-06-2015",
            "dataAlteracao": "08-06-2015"
        },
        {
            "descricao": "x 4",
            "tipoDocumento": "444",
            "dataInclusao": "08-06-2015",
            "dataAlteracao": "08-06-2015"
        }

    ]
}


2-) (GET) - Listar todos os beneficiarios cadastrados
	localhost:8080/beneficiario
	

3-) (GET) - Listar todos os documentos de um beneficiario a partir do seu ID.

	localhost:8080/beneficiario/1


4-) (PUT) - Atualizar os dados cadastrais de um beneficiario.

	localhost:8080/beneficiario/1
	
	PUT (Body -->JSON)
	
	{
    "nome": "aaaa",
    "telefone": "aaa",
    "dataInclusao": "09-06-2015",
    "dataNascimento": "09-06-2015",
    "dataAlteracao": "09-06-2015"
	}
	
5-) (DELETE) - Remover um beneficiario.

	localhost:8080/beneficiario/1
	
	
	
