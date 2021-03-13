package com.github.vagroz.moneyproblem

import money.implicits._

object MoneyExample extends App {
  val moneyAmount1 = (5.rub + 95.rub) * 4 / 5 + 20.5.rub * 2
  println(moneyAmount1.getDouble)     // 121.00
  println(moneyAmount1.expression)    // (5 rub + 95 rub)*4/5 + (20.5 rub)*2

  val moneyAmount2 = 1345.645.usd / 1.usd
  println(moneyAmount2.value)         // 1345.645
  println(moneyAmount2.expression)    // (1345.65 usd)/(1 usd)

  val moneyAmount3 = 10 * (2.01.rub / 2.rub)
  println(moneyAmount3.value)         // 10.050
  println(moneyAmount3.expression)    // 10*(2.01 rub)/(2 rub)
}
