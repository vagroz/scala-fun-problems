package com.github.vagroz.moneyproblem.calculator

sealed trait Token

abstract class Operator(val repr: String, priority: Int) extends Token

object Tokens {
  case object Plus extends Operator("+", 1)
  case object Minus extends Operator("-", 1)
  case object Mult extends Operator("*", 2)
  case object Div extends Operator("/", 2)

  case class Value(amount: BigDecimal) extends Token
}
