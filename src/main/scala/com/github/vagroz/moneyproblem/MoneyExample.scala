package com.github.vagroz.moneyproblem

import money.implicits._

object MoneyExample extends App {
  val moneyAmount1 = (5.rub + 95.rub) * 4 / 5 + 20.5.rub * 2
  println(moneyAmount1.getValue)      // 121.00
  println(moneyAmount1.getInfixExpr)  // (5 + 95)*4/5 + 20.5*2

  val moneyAmount2 = 1345.645.rub
  println(moneyAmount2.getValue)      // 1345.65
  println(moneyAmount2.getInfixExpr)  // 1345.645

  val moneyAmount3 = 10 * (2.01.rub / 2)
  println(moneyAmount3.getValue)      // 10.05
  println(moneyAmount3.getInfixExpr)  // 2.01/2*10
}
