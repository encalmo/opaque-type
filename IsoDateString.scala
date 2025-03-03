package org.encalmo.models

import java.time.LocalDate
import upickle.default._

opaque type IsoDateString = LocalDate

object IsoDateString extends OpaqueType[IsoDateString, LocalDate]:

  val regex = "(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)".r

  def apply(isoDateString: String): IsoDateString =
    isoDateString.match {
      case regex(y, m, d) =>
        LocalDate.of(y.toInt, m.toInt, d.toInt)
      case _: String =>
        throw new IllegalArgumentException(
          s"date string must be a valid date in YYYY-MM-DD format"
        )
    }

  given ReadWriter[IsoDateString] =
    readwriter[String].bimap(_.toString(), LocalDate.parse)

  inline def apply(value: LocalDate): IsoDateString = value
  inline def show(value: IsoDateString): LocalDate = value
