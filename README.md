# br-docs-scala

API Scala para manipulação de documentos brasileiros como CPF, CNPJ, entre outros.

[![Build Status](https://secure.travis-ci.org/sandokandias/br-docs-scala.png?branch=master)](http://travis-ci.org/sandokandias/br-docs-scala?branch=master)
[![Test Coverage](http://codecov.io/github/sandokandias/br-docs-scala/coverage.svg?branch=master)](http://codecov.io/github/sandokandias/br-docs-scala?branch=master)
[![License](http://img.shields.io/badge/license-CC0%201.0-blue.svg)](https://creativecommons.org/publicdomain/zero/1.0/legalcode)


## Status

Este projeto encontra-se em fase de desenvolvimento. Sinta-se a vontade para implementar novos tipos ou sugerir melhorias/correções via pull request, como também qualquer correção do inglês empregado de forma incorreta.
\0/

## Features até o momento

* Tipo forte para **CPF** e **CNPJ**
* Validador para **CPF** e **CNPJ** *(Companion Object)*

## <a name="quick-start">Quick Start</a>

Utilizar a API é muito simples, apenas instancie o documento desejado e invoque o método de validação.

###CPF

```Scala
"An valid unformatted CPF [94677658706] " should "return formatted when CPF.formatted is called" in {

    val cpf = CPF("94677658706")

    assert(cpf.validate.isValid)
    assert(cpf.formatted == "946.776.587-06")
}
  
"An valid formatted CPF [946.776.587-06] " should "return plain when CPF.plain is called" in {

    val cpf = CPF("946.776.587-06")

    assert(cpf.validate.isValid)
    assert(cpf.plain == "94677658706")
}
```

###CNPJ

```Scala
  "An valid unformatted CNPJ [56457412000100] " should "return formatted when CNPJ.formatted is called" in {

    val cnpj = CNPJ("56457412000100")

    assert(cnpj.validate.isValid)
    assert(cnpj.formatted == "56.457.412/0001-00")
  }
  
  "An valid formatted CNPJ [56.457.412/0001-00] " should "return plain when CNPJ.plain is called" in {

    val cnpj = CNPJ("56.457.412/0001-00")

    assert(cnpj.validate.isValid)
    assert(cnpj.plain == "56457412000100")
  }
```

## Backlog

* Novos documentos
