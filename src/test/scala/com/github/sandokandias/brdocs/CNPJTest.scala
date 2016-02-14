package com.github.sandokandias.brdocs

import org.scalatest.FlatSpec

class CNPJTest extends FlatSpec {

  it should "produce IllegalArgumentException when value is empty on CNPJ instantiation" in {
    intercept[IllegalArgumentException] {
      CNPJ("")
    }
  }

  it should "produce IllegalArgumentException when value is empty on CNPJ.isValid" in {
    intercept[IllegalArgumentException] {
      CNPJ("").validate.isValid
    }
  }

  "An invalid CNPJ [56457412000101]" should "return invalid" in {
    assert(!CNPJ("56457412000101").validate.isValid)
  }

  "An valid CNPJ [56457412000100]" should "return valid" in {
    assert(CNPJ("56457412000100").validate.isValid)
  }

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
}