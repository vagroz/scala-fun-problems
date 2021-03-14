package com.github.vagroz.moneyproblem.calculator

object Calculator {

  private def bracket(expr: String, necessary: Boolean): String =
    if (necessary) s"($expr)"
    else expr

  def concatenateExpressions(operator: Operator, expr1: String, priority1: Int, expr2: String, priority2: Int): String = {
    s"${bracket(expr1, priority1 < operator.priority)}${operator.repr}${bracket(expr2, priority2 < operator.priority)}"
  }
}
