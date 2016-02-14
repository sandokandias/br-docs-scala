package com.github.sandokandias.brdocs

import scala.util.matching.Regex

object MaskUtils {

  def removeMask(value: String, regex: Regex): String =
    regex.replaceAllIn(value, "")

  def applyMask(value: String, regex: Regex, replacement: String): String =
    regex.replaceAllIn(value, replacement)

}