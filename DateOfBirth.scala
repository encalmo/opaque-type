package org.encalmo.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter

opaque type DateOfBirth = String

object DateOfBirth extends OpaqueString[DateOfBirth]:

  val isoDate = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
  val usDate = "(\\d{1,2})\\/(\\d{1,2})\\/(\\d\\d\\d\\d)".r

  def apply(dateOfBirth: String): DateOfBirth =
    dateOfBirth match {
      case isoDate(y, m, d) => dateOfBirth
      case usDate(m, d, y) =>
        LocalDate
          .of(y.toInt, m.toInt, d.toInt)
          .format(DateTimeFormatter.ISO_LOCAL_DATE)
      case _ =>
        throw new Exception(
          s"Wrong date of birth format: $dateOfBirth, should be yyyy-mm-dd or mm/dd/yyyy"
        )
    }

  inline def show(dateOfBirth: DateOfBirth): String = dateOfBirth
