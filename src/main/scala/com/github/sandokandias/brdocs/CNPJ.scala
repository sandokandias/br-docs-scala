package com.github.sandokandias.brdocs

import com.github.sandokandias.brdocs.checkers.CNPJPatternChecker
import com.github.sandokandias.brdocs.checkers.NonEmptyChecker

case class CNPJ(val value: String) {

  CNPJ.checkPattern(value)

  val plain = MaskUtils.removeMask(value, CNPJ.MASK_REGEX)
  val formatted = MaskUtils.applyMask(plain, CNPJ.FORMATTED_PATTERN, CNPJ.FORMATTED_REPLACEMENT)

  def validate(): ValidationResult = CNPJ.validate(plain)
}

object CNPJ {

  private val FORMATTED_REPLACEMENT = "$1.$2.$3/$4-$5"
  private val FORMATTED_PATTERN = "^([0-9]{2}).?([0-9]{3}).?([0-9]{3})/?([0-9]{4})-?([0-9]{2})$"r
  private val MASK_REGEX = "\\.|\\/|\\-"r
  private val FACTOR = Array(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
  private val CHECKERS = Seq(NonEmptyChecker, CNPJPatternChecker)

  def checkPattern(value: String) = {
    CHECKERS.foreach { c => c.check(value) }
  }

  def validate(value: String): ValidationResult = {
    val digit1: Int = DigitCalculator.calc(value.substring(0, 12), FACTOR);
    val digit2: Int = DigitCalculator.calc(value.substring(0, 12) + digit1, FACTOR);
    val calculated = value.substring(0, 12) + digit1.toString + digit2.toString

    ValidationResult(value.equals(calculated))
  }

}