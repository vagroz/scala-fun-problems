package com.github.vagroz.moneyproblem.calculator

import scala.math.BigDecimal.RoundingMode

sealed trait Token {
  def repr: String

  def priority: Int
}

abstract class Operator(override val repr: String, override val priority: Int) extends Token

object Tokens {
  case object Plus extends Operator(" + ", 1)
  case object Minus extends Operator(" - ", 1)
  case object Mult extends Operator("*", 2)
  case object Div extends Operator("/", 2)

  case class Value(amount: BigDecimal) extends Token {
    override def repr: String = amount.underlying().stripTrailingZeros().toPlainString

    override def priority: Int = Int.MaxValue
  }
}
