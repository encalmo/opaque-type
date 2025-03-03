package org.encalmo.models

opaque type Fee <: Int = Int

object Fee extends SimpleOpaqueInteger[Fee]:

  inline def apply(value: Int): Fee = value
  inline def show(value: Fee): Int = value

  extension (fee: Fee) {
    inline def toAmount: Amount =
      Amount(show(fee))

    inline infix def plusBps(bps: Bps): Fee =
      roundedHalfUp(fee.toBigDecimal + (bps ** fee.toBigDecimal))

    inline infix def minusBps(bps: Bps): Fee =
      roundedHalfUp(fee.toBigDecimal - (bps ** fee.toBigDecimal))

    inline infix def plusPercentage(percentage: Percentage): Fee =
      roundedHalfUp(fee.toBigDecimal + (percentage ** fee.toBigDecimal))

    inline infix def minusPercentage(percentage: Percentage): Fee =
      roundedHalfUp(fee.toBigDecimal - (percentage ** fee.toBigDecimal))
  }
