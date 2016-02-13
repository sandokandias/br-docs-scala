package com.github.sandokandias.brdocs

import com.github.sandokandias.brdocs.checkers.NonEmptyChecker
import com.github.sandokandias.brdocs.checkers.CPFPatternChecker

case class CPF(val value: String) {

  CPF.checkPattern(value)

  def validate(): ValidationResult = CPF.validate(value)
}

object CPF {

  private val FACTOR = Array(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)
  private val CHECKERS = Seq(NonEmptyChecker, CPFPatternChecker)

  def checkPattern(value: String) = {
    CHECKERS.foreach { c => c.check(value) }
  }

  def validate(value: String): ValidationResult = {
    val digit1: Int = calcDigit(value.substring(0, 9));
    val digit2: Int = calcDigit(value.substring(0, 9) + digit1);
    val calculated = value.substring(0, 9) + digit1.toString + digit2.toString

    ValidationResult(value.equals(calculated))
  }

  private def calcDigit(str: String): Int = {
    var sum: Int = 0
    for (i <- str.length - 1 to 0 by -1) {
      var digit: Int = str.substring(i, i + 1).toInt
      sum += digit * FACTOR(FACTOR.length - str.length + i);
    }
    sum = 11 - sum % 11;
    if (sum > 9) 0 else sum
  }
}