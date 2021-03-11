package com.github.vagroz.moneyproblem

import money.implicits._

object MoneyExample extends App {
  val expr = (5.rub + 95.rub) * 4 / 5 + 20.5.rub * 2
  println(expr.getValue)
}
