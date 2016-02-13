package com.github.sandokandias.brdocs.checkers

import scala.collection.Traversable

import org.scalatest.FlatSpec

class CheckerSpec extends FlatSpec {

  it should "produce IllegalArgumentException when value is empty String" in {
    intercept[IllegalArgumentException] {
      NonEmptyChecker.check("")
    }
  }

  it should "produce IllegalArgumentException when value is empty Traversable" in {
    intercept[IllegalArgumentException] {
      NonEmptyChecker.check(Traversable())
    }
  }

  it should "return nothing when value isn't empty String" in {
    NonEmptyChecker.check("41536843334")
  }

  it should "return nothing when value isn't empty Traversable" in {
    NonEmptyChecker.check(Traversable("41536843334"))
  }
}