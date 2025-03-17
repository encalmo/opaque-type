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

- [Amount](Amount.scala)
- [AmountDecimal](AmountDecimal.scala)
- [AmountDecimalString](AmountDecimalString.scala)
- [AmountString](AmountString.scala)
- [Bps](Bps.scala)
- [City](City.scala)
- [Country](Country.scala)
- [Currency](Currency.scala)
- [DateOfBirth](DateOfBirth.scala)
- [EmailAddress](EmailAddress.scala)
- [Fee](Fee.scala)
- [FirstName](FirstName.scala)
- [IsoDateString](IsoDateString.scala)
- [LastName](LastName.scala)
- [LocalPhoneNumber](LocalPhoneNumber.scala)
- [Percentage](Percentage.scala)
- [PhoneNumber](PhoneNumber.scala)
- [PhoneNumberCountryPrefix](PhoneNumberCountryPrefix.scala)
