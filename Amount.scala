package org.encalmo.models

import MathUtils.*

opaque type Amount <: Int = Int

object Amount extends SimpleOpaqueInteger[Amount] {

  inline def apply(amount: Int): Amount = amount
  inline def show(value: Amount): Int = value

  extension (amount: Amount) {
    inline def toAmountDecimalString: AmountDecimalString =
      AmountDecimalString(
        amount.toBigDecimal.movePointLeft(2).toPlainString()
      )

    inline def toAmountDecimal: AmountDecimal =
      AmountDecimal(amount.toBigDecimal / 100)

    inline def toAmountString: AmountString =
      AmountString(amount.toString())

    inline infix def plusBps(bps: Bps): Amount =
      roundedHalfUp(amount.toBigDecimal + (bps ** amount.toBigDecimal))

    inline infix def minusBps(bps: Bps): Amount =
      roundedHalfUp(amount.toBigDecimal - (bps ** amount.toBigDecimal))

    inline infix def plusPercentage(percentage: Percentage): Amount =
      roundedHalfUp(amount.toBigDecimal + (percentage ** amount.toBigDecimal))

    inline infix def minusPercentage(percentage: Percentage): Amount =
      roundedHalfUp(amount.toBigDecimal - (percentage ** amount.toBigDecimal))

    inline def applyPercentage(percentage: Percentage): Amount =
      Amount(
        BigDecimal(amount.toInt * percentage.toInt)
          .underlying()
          .movePointLeft(2)
          .roundToIntHalfUp
      )
  }

}
