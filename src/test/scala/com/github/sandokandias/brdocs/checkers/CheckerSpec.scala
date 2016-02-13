package com.github.sandokandias.brdocs.checkers

import org.scalatest.FlatSpec

class CheckerSpec extends FlatSpec {

  it should "produce IllegalArgumentException when value is empty String" in {
    intercept[IllegalArgumentException] {
      NonEmptyChecker.check("")
    }
  }

  it should "return nothing when value isn't empty String" in {
    NonEmptyChecker.check("41536843334")
  }

  it should "produce IllegalArgumentException when chars isn't cpf pattern" in {
    intercept[IllegalArgumentException] {
      CPFPatternChecker.check("41536843334567")
    }
  }

  it should "return nothing when chars is cpf pattern" in {
    CPFPatternChecker.check("41536843334")
  }

}