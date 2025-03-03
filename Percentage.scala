package org.encalmo.models

opaque type Percentage <: Int = Int

object Percentage extends OpaqueInteger[Percentage]:

  inline def apply(percentage: Int): Percentage = percentage
  inline def show(value: Percentage): Int = value

  extension (percentage: Percentage)
    inline def **(value: BigDecimal): BigDecimal =
      BigDecimal(
        value
          .underlying()
          .multiply(BigDecimal(percentage).underlying().movePointLeft(2))
      )
