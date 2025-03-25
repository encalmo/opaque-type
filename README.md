<a href="https://github.com/encalmo/opaque-type">![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)</a> <a href="https://central.sonatype.com/artifact/org.encalmo/opaque-type_3" target="_blank">![Maven Central Version](https://img.shields.io/maven-central/v/org.encalmo/opaque-type_3?style=for-the-badge)</a> <a href="https://encalmo.github.io/opaque-type/scaladoc/org/encalmo/models.html" target="_blank"><img alt="Scaladoc" src="https://img.shields.io/badge/docs-scaladoc-red?style=for-the-badge"></a>

# opaque-type

This Scala 3 library provides a support to easily define opaque types serializable using [upickle](https://github.com/com-lihaoyi/upickle).

## Table of contents

- [Dependencies](#dependencies)
- [Usage](#usage)
- [Example](#example)
- [Project content](#project-content)

## Dependencies

   - [Scala](https://www.scala-lang.org) >= 3.3.5
   - [Scala **toolkit** 0.7.0](https://github.com/scala/toolkit)

## Usage

Use with SBT

    libraryDependencies += "org.encalmo" %% "opaque-type" % "0.9.2"

or with SCALA-CLI

    //> using dep org.encalmo::opaque-type:0.9.2

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


## Project content

```
├── .github
│   └── workflows
│       ├── pages.yaml
│       ├── release.yaml
│       └── test.yaml
│
├── .gitignore
├── .scalafmt.conf
├── Amount.scala
├── AmountDecimal.scala
├── AmountDecimalString.scala
├── AmountString.scala
├── Bps.scala
├── City.scala
├── Country.scala
├── Currency.scala
├── DateOfBirth.scala
├── EmailAddress.scala
├── Fee.scala
├── FirstName.scala
├── IPAddress.scala
├── IsoDateString.scala
├── LastName.scala
├── LICENSE
├── LocalPhoneNumber.scala
├── MathUtils.scala
├── MathUtils.test.scala
├── OpaqueType.scala
├── OpaqueType.test.scala
├── Percentage.scala
├── PhoneNumber.scala
├── PhoneNumberCountryPrefix.scala
├── project.scala
├── README.md
└── test.sh
```

