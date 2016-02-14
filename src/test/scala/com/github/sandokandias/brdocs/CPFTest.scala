package com.github.sandokandias.brdocs

import org.scalatest.FlatSpec

class CPFTest extends FlatSpec {

  it should "produce IllegalArgumentException when value is empty on CPF instantiation" in {
    intercept[IllegalArgumentException] {
      CPF("")
    }
  }

  it should "produce IllegalArgumentException when value is empty on CPF.isValid" in {
    intercept[IllegalArgumentException] {
      CPF("").validate.isValid
    }
  }

  "An invalid CPF [94677658705]" should "return invalid" in {
    assert(!CPF("94677658705").validate.isValid)
  }

  "An valid CPF [94677658706]" should "return valid" in {
    assert(CPF("94677658706").validate.isValid)
  }

  "An invalid CPF formmated [946.776.587-05]" should "return invalid" in {
    assert(!CPF("946.776.587-05").validate.isValid)
  }

  "An valid CPF formatted [946.776.587-06]" should "return valid" in {
    assert(CPF("946.776.587-06").validate.isValid)
  }

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
}