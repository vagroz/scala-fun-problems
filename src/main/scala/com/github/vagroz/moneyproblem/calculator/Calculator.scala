package com.github.vagroz.moneyproblem.calculator

import scala.collection.immutable.Queue
import scala.math.BigDecimal.RoundingMode

object Calculator {
  import Tokens._
  def solveReversePolishNotation(queue: Queue[Token], scale: Int = 2): BigDecimal = {
    queue.foldLeft[List[BigDecimal]](Nil) { (stack, token) =>
      (token, stack) match {
        case (Value(amount), _) => amount :: stack
        case (Plus, a :: b :: tail) => (a + b) :: tail
        case (Minus, a :: b :: tail) => (b - a) :: tail
        case (Mult, a :: b :: tail) => (a * b) :: tail
        case (Div, a :: b :: tail) => (b / a) :: tail
        case _ =>throw new IllegalStateException(s"Unexpected token=$token and stack=$stack")
      }
    }.headOption
      .map(_.setScale(scale, RoundingMode.HALF_UP))
      .getOrElse(throw new IllegalStateException("Stack was empty"))
  }
}
