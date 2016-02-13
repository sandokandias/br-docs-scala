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
}