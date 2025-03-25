<a href="https://github.com/encalmo/opaque-type">![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)</a> <a href="https://central.sonatype.com/artifact/org.encalmo/opaque-type_3" target="_blank">![Maven Central Version](https://img.shields.io/maven-central/v/org.encalmo/opaque-type_3?style=for-the-badge)</a> <a href="https://encalmo.github.io/opaque-type/scaladoc/org/encalmo/models.html" target="_blank"><img alt="Scaladoc" src="https://img.shields.io/badge/docs-scaladoc-red?style=for-the-badge"></a>

# opaque-type

This Scala 3 library provides a support to easily define opaque types serializable using [upickle](https://github.com/com-lihaoyi/upickle).

## Table of contents

- [Dependencies](#dependencies)
- [Usage](#usage)
- [Example](#example)

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
├── _site
│   └── scaladoc
│       ├── favicon.ico
│       ├── fonts
│       │   ├── dotty-icons.ttf
│       │   ├── dotty-icons.woff
│       │   ├── FiraCode-Regular.ttf
│       │   ├── Inter-Bold.ttf
│       │   ├── Inter-Medium.ttf
│       │   ├── Inter-Regular.ttf
│       │   └── Inter-SemiBold.ttf
│       │
│       ├── hljs
│       │   ├── highlight.pack.js
│       │   └── LICENSE
│       │
│       ├── images
│       │   ├── banner-icons
│       │   │   ├── error.svg
│       │   │   ├── info.svg
│       │   │   ├── neutral.svg
│       │   │   ├── success.svg
│       │   │   └── warning.svg
│       │   │
│       │   ├── bulb
│       │   │   ├── dark
│       │   │   │   └── default.svg
│       │   │   │
│       │   │   └── light
│       │   │       └── default.svg
│       │   │
│       │   ├── class-big.svg
│       │   ├── class-dark-big.svg
│       │   ├── class-dark.svg
│       │   ├── class.svg
│       │   ├── class_comp.svg
│       │   ├── def-big.svg
│       │   ├── def-dark-big.svg
│       │   ├── discord-icon-black.png
│       │   ├── discord-icon-white.png
│       │   ├── enum-big.svg
│       │   ├── enum-dark-big.svg
│       │   ├── enum-dark.svg
│       │   ├── enum.svg
│       │   ├── enum_comp.svg
│       │   ├── footer-icon
│       │   │   ├── dark
│       │   │   │   └── default.svg
│       │   │   │
│       │   │   └── light
│       │   │       └── default.svg
│       │   │
│       │   ├── github-icon-black.png
│       │   ├── github-icon-white.png
│       │   ├── gitter-icon-black.png
│       │   ├── gitter-icon-white.png
│       │   ├── given-big.svg
│       │   ├── given-dark-big.svg
│       │   ├── given-dark.svg
│       │   ├── given.svg
│       │   ├── icon-buttons
│       │   │   ├── arrow-down
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── arrow-right
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── close
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── copy
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── discord
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── gh
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── gitter
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── hamburger
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── link
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── menu-animated
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── menu-animated-open
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── minus
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── moon
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── plus
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── search
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── sun
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   └── twitter
│       │   │       ├── dark
│       │   │       │   ├── active.svg
│       │   │       │   ├── default.svg
│       │   │       │   ├── disabled.svg
│       │   │       │   ├── focus.svg
│       │   │       │   ├── hover.svg
│       │   │       │   └── selected.svg
│       │   │       │
│       │   │       └── light
│       │   │           ├── active.svg
│       │   │           ├── default.svg
│       │   │           ├── disabled.svg
│       │   │           ├── focus.svg
│       │   │           ├── hover.svg
│       │   │           └── selected.svg
│       │   │
│       │   ├── info
│       │   │   ├── dark
│       │   │   │   └── default.svg
│       │   │   │
│       │   │   └── light
│       │   │       └── default.svg
│       │   │
│       │   ├── inkuire.svg
│       │   ├── method-big.svg
│       │   ├── method-dark-big.svg
│       │   ├── method-dark.svg
│       │   ├── method.svg
│       │   ├── no-results-icon.svg
│       │   ├── object-big.svg
│       │   ├── object-dark-big.svg
│       │   ├── object-dark.svg
│       │   ├── object.svg
│       │   ├── object_comp.svg
│       │   ├── package-big.svg
│       │   ├── package-dark-big.svg
│       │   ├── package-dark.svg
│       │   ├── package.svg
│       │   ├── scaladoc_logo.svg
│       │   ├── scaladoc_logo_dark.svg
│       │   ├── static-big.svg
│       │   ├── static-dark-big.svg
│       │   ├── static-dark.svg
│       │   ├── static.svg
│       │   ├── thick-dark.svg
│       │   ├── thick.svg
│       │   ├── trait-big.svg
│       │   ├── trait-dark-big.svg
│       │   ├── trait-dark.svg
│       │   ├── trait.svg
│       │   ├── trait_comp.svg
│       │   ├── twitter-icon-black.png
│       │   ├── twitter-icon-white.png
│       │   ├── type-big.svg
│       │   ├── type-dark-big.svg
│       │   ├── type-dark.svg
│       │   ├── type.svg
│       │   ├── val-big.svg
│       │   ├── val-dark-big.svg
│       │   ├── val-dark.svg
│       │   └── val.svg
│       │
│       ├── index.html
│       ├── inkuire-db.json
│       ├── META-INF
│       │   └── MANIFEST.MF
│       │
│       ├── org
│       │   └── encalmo
│       │       ├── models
│       │       │   ├── Amount$.html
│       │       │   ├── AmountDecimal$.html
│       │       │   ├── AmountDecimalString$.html
│       │       │   ├── AmountString$.html
│       │       │   ├── AutoApply$given_Conversion_T_O$.html
│       │       │   ├── AutoApply.html
│       │       │   ├── AutoShow$given_Conversion_O_T$.html
│       │       │   ├── AutoShow.html
│       │       │   ├── Bps$.html
│       │       │   ├── City$.html
│       │       │   ├── Country$.html
│       │       │   ├── Currency$.html
│       │       │   ├── DateOfBirth$.html
│       │       │   ├── EmailAddress$.html
│       │       │   ├── Fee$.html
│       │       │   ├── FirstName$.html
│       │       │   ├── IPAddress$.html
│       │       │   ├── ISO3166$$Country.html
│       │       │   ├── ISO3166$.html
│       │       │   ├── ISO4217$.html
│       │       │   ├── IsoDateString$.html
│       │       │   ├── LastName$.html
│       │       │   ├── LocalPhoneNumber$.html
│       │       │   ├── MathUtils$.html
│       │       │   ├── OpaqueBigDecimal.html
│       │       │   ├── OpaqueInteger.html
│       │       │   ├── OpaqueString.html
│       │       │   ├── OpaqueStringWithPattern.html
│       │       │   ├── OpaqueStringWithValidator.html
│       │       │   ├── OpaqueType.html
│       │       │   ├── OpaqueUUIDString.html
│       │       │   ├── Percentage$.html
│       │       │   ├── PhoneNumber$.html
│       │       │   ├── PhoneNumberCountryPrefix$.html
│       │       │   ├── SimpleOpaqueInteger.html
│       │       │   └── SimpleOpaqueString.html
│       │       │
│       │       └── models.html
│       │
│       ├── scaladoc.version
│       ├── scripts
│       │   ├── common
│       │   │   ├── component.js
│       │   │   └── utils.js
│       │   │
│       │   ├── components
│       │   │   ├── DocumentableList.js
│       │   │   ├── Filter.js
│       │   │   ├── FilterBar.js
│       │   │   ├── FilterGroup.js
│       │   │   └── Input.js
│       │   │
│       │   ├── contributors.js
│       │   ├── data.js
│       │   ├── hljs-scala3.js
│       │   ├── inkuire-config.json
│       │   ├── inkuire-worker.js
│       │   ├── inkuire.js
│       │   ├── scaladoc-scalajs.js
│       │   ├── scastieConfiguration.js
│       │   ├── searchData.js
│       │   ├── theme.js
│       │   └── ux.js
│       │
│       ├── styles
│       │   ├── apistyles.css
│       │   ├── code-snippets.css
│       │   ├── content-contributors.css
│       │   ├── dotty-icons.css
│       │   ├── filter-bar.css
│       │   ├── fontawesome.css
│       │   ├── nord-light.css
│       │   ├── searchbar.css
│       │   ├── social-links.css
│       │   ├── staticsitestyles.css
│       │   ├── theme
│       │   │   ├── bundle.css
│       │   │   ├── components
│       │   │   │   ├── bundle.css
│       │   │   │   └── button
│       │   │   │       └── bundle.css
│       │   │   │
│       │   │   └── layout
│       │   │       └── bundle.css
│       │   │
│       │   └── versions-dropdown.css
│       │
│       └── webfonts
│           ├── fa-brands-400.eot
│           ├── fa-brands-400.svg
│           ├── fa-brands-400.ttf
│           ├── fa-brands-400.woff
│           ├── fa-brands-400.woff2
│           ├── fa-regular-400.eot
│           ├── fa-regular-400.svg
│           ├── fa-regular-400.ttf
│           ├── fa-regular-400.woff
│           ├── fa-regular-400.woff2
│           ├── fa-solid-900.eot
│           ├── fa-solid-900.svg
│           ├── fa-solid-900.ttf
│           ├── fa-solid-900.woff
│           └── fa-solid-900.woff2
│
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
├── opaque-type_3-0.9.2.zip
├── OpaqueType.scala
├── OpaqueType.test.scala
├── Percentage.scala
├── PhoneNumber.scala
├── PhoneNumberCountryPrefix.scala
├── project.scala
├── README.md
└── test.sh
```