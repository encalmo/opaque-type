<a href="https://central.sonatype.com/artifact/org.encalmo/opaque-type_3" target="_blank">![Maven Central Version](https://img.shields.io/maven-central/v/org.encalmo/opaque-type_3?style=for-the-badge)</a> <a href="https://encalmo.github.io/opaque-type/scaladoc/org/encalmo/models.html" target="_blank"><img alt="Scaladoc" src="https://img.shields.io/badge/docs-scaladoc-red?style=for-the-badge"></a>

# opaque-type

This Scala 3 library provides a support to easily define opaque types serializable using [upickle](https://github.com/com-lihaoyi/upickle).

## Dependencies

- Scala >= 3.3.5 LTS

## Usage

Use with SBT

    libraryDependencies += "org.encalmo" %% "opaque-type" % "0.9.1"

or with SCALA-CLI

    //> using dep org.encalmo::opaque-type:0.9.1

## Example

A number of common opaque types is included as an example:

- [Amount](https://github.com/encalmo/opaque-type/blob/main/Amount.scala)
- [AmountDecimal](https://github.com/encalmo/opaque-type/blob/main/AmountDecimal.scala)
- [AmountDecimalString](https://github.com/encalmo/opaque-type/blob/main/AmountDecimalString.scala)
- [AmountString](https://github.com/encalmo/opaque-type/blob/main/AmountString.scala)
- [Bps](https://github.com/encalmo/opaque-type/blob/main/Bps.scala)
- [City](https://github.com/encalmo/opaque-type/blob/main/City.scala)
- [Country](https://github.com/encalmo/opaque-type/blob/main/Country.scala)
- [Currency](https://github.com/encalmo/opaque-type/blob/main/Currency.scala)
- [DateOfBirth](https://github.com/encalmo/opaque-type/blob/main/DateOfBirth.scala)
- [EmailAddress](https://github.com/encalmo/opaque-type/blob/main/EmailAddress.scala)
- [Fee](https://github.com/encalmo/opaque-type/blob/main/Fee.scala)
- [FirstName](https://github.com/encalmo/opaque-type/blob/main/FirstName.scala)
- [IsoDateString](https://github.com/encalmo/opaque-type/blob/main/IsoDateString.scala)
- [LastName](https://github.com/encalmo/opaque-type/blob/main/LastName.scala)
- [LocalPhoneNumber](https://github.com/encalmo/opaque-type/blob/main/LocalPhoneNumber.scala)
- [Percentage](https://github.com/encalmo/opaque-type/blob/main/Percentage.scala)
- [PhoneNumber](https://github.com/encalmo/opaque-type/blob/main/PhoneNumber.scala)
- [PhoneNumberCountryPrefix](https://github.com/encalmo/opaque-type/blob/main/PhoneNumberCountryPrefix.scala)
