package com.github.sandokandias.brdocs

import com.github.sandokandias.brdocs.checkers.CPFPatternChecker
import com.github.sandokandias.brdocs.checkers.NonEmptyChecker

case class CPF(val value: String) {

  CPF.checkPattern(value)

  val plain = MaskUtils.removeMask(value, CPF.MASK_REGEX)
  val formatted = MaskUtils.applyMask(plain, CPF.FORMATTED_PATTERN, CPF.FORMATTED_REPLACEMENT)

  def validate(): ValidationResult = CPF.validate(plain)

}

object CPF {

  private val FORMATTED_REPLACEMENT = "$1.$2.$3-$4"
  private val FORMATTED_PATTERN = "^([0-9]{3}).?([0-9]{3}).?([0-9]{3})-?([0-9]{2})$"r
  private val MASK_REGEX = "\\.|\\-"r
  private val FACTOR = Array(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)
  private val CHECKERS = Seq(NonEmptyChecker, CPFPatternChecker)

  def checkPattern(value: String) = {
    CHECKERS.foreach { c => c.check(value) }
  }

  private def validate(value: String): ValidationResult = {
    val digit1: Int = DigitCalculator.calc(value.substring(0, 9), FACTOR);
    val digit2: Int = DigitCalculator.calc(value.substring(0, 9) + digit1, FACTOR);
    val calculated = value.substring(0, 9) + digit1.toString + digit2.toString

    ValidationResult(value.equals(calculated))
  }

}