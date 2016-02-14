package com.github.sandokandias.brdocs.checkers

import org.scalatest.FlatSpec

class CheckerTest extends FlatSpec {

  it should "produce IllegalArgumentException when value is empty String" in {
    intercept[IllegalArgumentException] {
      NonEmptyChecker.check("")
    }
  }

  it should "return nothing when value isn't empty String" in {
    NonEmptyChecker.check("41536843334")
  }

  it should "produce IllegalArgumentException when chars isn't CPF pattern" in {
    intercept[IllegalArgumentException] {
      CPFPatternChecker.check("41536843334567")
    }
  }

  it should "return nothing when chars is CPF pattern" in {
    CPFPatternChecker.check("41536843334")
  }
  
   it should "produce IllegalArgumentException when chars isn't CNPJ pattern" in {
    intercept[IllegalArgumentException] {
      CNPJPatternChecker.check("000000000001000")
    }
  }

  it should "return nothing when chars is CNPJ pattern" in {
    CNPJPatternChecker.check("00000000000100")
  }

}