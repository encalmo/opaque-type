package org.encalmo.models

opaque type Bps <: Int = Int

object Bps extends OpaqueInteger[Bps]:

  inline def apply(bps: Int): Bps = bps
  inline def show(value: Bps): Int = value

  extension (bps: Bps)
    inline def **(value: BigDecimal): BigDecimal =
      BigDecimal(
        value
          .underlying()
          .multiply(BigDecimal(bps).underlying().movePointLeft(4))
      )
