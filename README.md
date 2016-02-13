# br-docs-scala

API Scala para manipulação de documentos brasileiros como CPF, CNPJ, entre outros.

## Status

Este projeto encontra-se em fase de desenvolvimento. No momento apenas o tipo ***CPF*** e seu validador está implementado.
Fique a vontade para implementar novos tipos ou sugerir melhorias/correções via pull request.

## Features até o momento

* Tipo forte para **CPF**
* Validador para **CPF** *(Companion Object)*

## Backlog

* Integração Contínua
* Tipo e validador para CNPJ

## <a name="quick-start">Quick Start</a>

Utilizar a API é muito simples, apenas instancie o documento desejado e invoque o método de validação.
Para demonstrar seu uso, focaremos na implementação de um caso de uso para cadastrar clientes.

###Domain

```Scala
case class Customer(
  val email: String,
  val cpf: CPF)
```

###Use Case

```Scala
class CustomerService{

  def register(val request: Request): Response = {
    val cpfParam = request.param("cpf")
    val emailParam = request.param("email")
    
    val cpf = CPF(cpfParam)
    val result = cpf.validate 
    result.isValid match {
      case true => {
        repository.add(Customer(email, cpf))
        Response.created()
      }
      case false => Response.badRequest("CPF inválido.")
    }
  }
}
```

## License

Creative commons Zero CC0 - https://creativecommons.org/publicdomain/zero/1.0
