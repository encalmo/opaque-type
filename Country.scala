package org.encalmo.models

import upickle.default.*

opaque type Country = String

object Country extends OpaqueString[Country]:

  val error =
    "country code must be 2 or 3 letters valid ISO-3166 code, e.g. USA or US"

  def apply(country: String): Country =
    if (country.length() == 2)
      ISO3166.countries.find(_.alpha2 == country).match {
        case Some(c) => c.alpha2
        case None    => throw new IllegalArgumentException(error)
      }
    else if (country.length() == 3)
      ISO3166.countries.find(_.alpha3 == country).match {
        case Some(c) => c.alpha3
        case None    => throw new IllegalArgumentException(error)
      }
    else throw new IllegalArgumentException(error)

  inline def show(value: Country): String = value

  extension (country: Country)
    def toString(): String = country

    def alpha2: String =
      if (country.length() == 2) then
        ISO3166.countries
          .find(_.alpha2 == country)
          .map(_.alpha2)
          .getOrElse(
            throw new Exception(
              s"Country code not valid: $country"
            )
          )
      else if (country.length() == 3) then
        ISO3166.countries
          .find(_.alpha3 == country)
          .map(_.alpha2)
          .getOrElse(
            throw new Exception(
              s"Country code not valid: $country"
            )
          )
      else
        throw new Exception(
          s"Country code not valid: $country"
        )

    def alpha3: String =
      if (country.length() == 2) then
        ISO3166.countries
          .find(_.alpha2 == country)
          .map(_.alpha3)
          .getOrElse(
            throw new Exception(
              s"Country code not valid: $country"
            )
          )
      else if (country.length() == 3) then
        ISO3166.countries
          .find(_.alpha3 == country)
          .map(_.alpha3)
          .getOrElse(
            throw new Exception(
              s"Country code not valid: $country"
            )
          )
      else
        throw new Exception(
          s"Country code not valid: $country"
        )

  val US = Country("US")
  val PH = Country("PH")
  val MX = Country("MX")
  val PA = Country("PA")

end Country

object ISO3166:

  final case class Country(
      name: String,
      alpha2: String,
      alpha3: String,
      countryCode: String
  )

  final val countries = Set(
    Country("United States of America", "US", "USA", "0"),
    Country("Afghanistan", "AF", "AFG", "4"),
    Country("Åland Islands", "AX", "ALA", "8"),
    Country("Albania", "AL", "ALB", "8"),
    Country("Algeria", "DZ", "DZA", "2"),
    Country("American Samoa", "AS", "ASM", "6"),
    Country("Andorra", "AD", "AND", "0"),
    Country("Angola", "AO", "AGO", "4"),
    Country("Anguilla", "AI", "AIA", "0"),
    Country("Antarctica", "AQ", "ATA", "0"),
    Country("Antigua and Barbuda", "AG", "ATG", "8"),
    Country("Argentina", "AR", "ARG", "2"),
    Country("Armenia", "AM", "ARM", "1"),
    Country("Aruba", "AW", "ABW", "3"),
    Country("Australia", "AU", "AUS", "6"),
    Country("Austria", "AT", "AUT", "0"),
    Country("Azerbaijan", "AZ", "AZE", "1"),
    Country("Bahamas", "BS", "BHS", "4"),
    Country("Bahrain", "BH", "BHR", "8"),
    Country("Bangladesh", "BD", "BGD", "0"),
    Country("Barbados", "BB", "BRB", "2"),
    Country("Belarus", "BY", "BLR", "2"),
    Country("Belgium", "BE", "BEL", "6"),
    Country("Belize", "BZ", "BLZ", "4"),
    Country("Benin", "BJ", "BEN", "4"),
    Country("Bermuda", "BM", "BMU", "0"),
    Country("Bhutan", "BT", "BTN", "4"),
    Country("Bolivia (Plurinational State of)", "BO", "BOL", "8"),
    Country("Bonaire, Sint Eustatius and Saba", "BQ", "BES", "5"),
    Country("Bosnia and Herzegovina", "BA", "BIH", "0"),
    Country("Botswana", "BW", "BWA", "2"),
    Country("Bouvet Island", "BV", "BVT", "4"),
    Country("Brazil", "BR", "BRA", "6"),
    Country("British Indian Ocean Territory", "IO", "IOT", "6"),
    Country("Brunei Darussalam", "BN", "BRN", "6"),
    Country("Bulgaria", "BG", "BGR", "0"),
    Country("Burkina Faso", "BF", "BFA", "4"),
    Country("Burundi", "BI", "BDI", "8"),
    Country("Cabo Verde", "CV", "CPV", "2"),
    Country("Cambodia", "KH", "KHM", "6"),
    Country("Cameroon", "CM", "CMR", "0"),
    Country("Canada", "CA", "CAN", "4"),
    Country("Cayman Islands", "KY", "CYM", "6"),
    Country("Central African Republic", "CF", "CAF", "0"),
    Country("Chad", "TD", "TCD", "8"),
    Country("Chile", "CL", "CHL", "2"),
    Country("China", "CN", "CHN", "6"),
    Country("Christmas Island", "CX", "CXR", "2"),
    Country("Cocos (Keeling) Islands", "CC", "CCK", "6"),
    Country("Colombia", "CO", "COL", "0"),
    Country("Comoros", "KM", "COM", "4"),
    Country("Congo", "CG", "COG", "8"),
    Country("Congo, Democratic Republic of the", "CD", "COD", "0"),
    Country("Cook Islands", "CK", "COK", "4"),
    Country("Costa Rica", "CR", "CRI", "8"),
    Country("Côte d'Ivoire", "CI", "CIV", "4"),
    Country("Croatia", "HR", "HRV", "1"),
    Country("Cuba", "CU", "CUB", "2"),
    Country("Curaçao", "CW", "CUW", "1"),
    Country("Cyprus", "CY", "CYP", "6"),
    Country("Czechia", "CZ", "CZE", "3"),
    Country("Denmark", "DK", "DNK", "8"),
    Country("Djibouti", "DJ", "DJI", "2"),
    Country("Dominica", "DM", "DMA", "2"),
    Country("Dominican Republic", "DO", "DOM", "4"),
    Country("Ecuador", "EC", "ECU", "8"),
    Country("Egypt", "EG", "EGY", "8"),
    Country("El Salvador", "SV", "SLV", "2"),
    Country("Equatorial Guinea", "GQ", "GNQ", "6"),
    Country("Eritrea", "ER", "ERI", "2"),
    Country("Estonia", "EE", "EST", "3"),
    Country("Eswatini", "SZ", "SWZ", "8"),
    Country("Ethiopia", "ET", "ETH", "1"),
    Country("Falkland Islands (Malvinas)", "FK", "FLK", "8"),
    Country("Faroe Islands", "FO", "FRO", "4"),
    Country("Fiji", "FJ", "FJI", "2"),
    Country("Finland", "FI", "FIN", "6"),
    Country("France", "FR", "FRA", "0"),
    Country("French Guiana", "GF", "GUF", "4"),
    Country("French Polynesia", "PF", "PYF", "8"),
    Country("French Southern Territories", "TF", "ATF", "0"),
    Country("Gabon", "GA", "GAB", "6"),
    Country("Gambia", "GM", "GMB", "0"),
    Country("Georgia", "GE", "GEO", "8"),
    Country("Germany", "DE", "DEU", "6"),
    Country("Ghana", "GH", "GHA", "8"),
    Country("Gibraltar", "GI", "GIB", "2"),
    Country("Greece", "GR", "GRC", "0"),
    Country("Greenland", "GL", "GRL", "4"),
    Country("Grenada", "GD", "GRD", "8"),
    Country("Guadeloupe", "GP", "GLP", "2"),
    Country("Guam", "GU", "GUM", "6"),
    Country("Guatemala", "GT", "GTM", "0"),
    Country("Guernsey", "GG", "GGY", "1"),
    Country("Guinea", "GN", "GIN", "4"),
    Country("Guinea-Bissau", "GW", "GNB", "4"),
    Country("Guyana", "GY", "GUY", "8"),
    Country("Haiti", "HT", "HTI", "2"),
    Country("Heard Island and McDonald Islands", "HM", "HMD", "4"),
    Country("Holy See", "VA", "VAT", "6"),
    Country("Honduras", "HN", "HND", "0"),
    Country("Hong Kong", "HK", "HKG", "4"),
    Country("Hungary", "HU", "HUN", "8"),
    Country("Iceland", "IS", "ISL", "2"),
    Country("India", "IN", "IND", "6"),
    Country("Indonesia", "ID", "IDN", "0"),
    Country("Iran (Islamic Republic of)", "IR", "IRN", "4"),
    Country("Iraq", "IQ", "IRQ", "8"),
    Country("Ireland", "IE", "IRL", "2"),
    Country("Isle of Man", "IM", "IMN", "3"),
    Country("Israel", "IL", "ISR", "6"),
    Country("Italy", "IT", "ITA", "0"),
    Country("Jamaica", "JM", "JAM", "8"),
    Country("Japan", "JP", "JPN", "2"),
    Country("Jersey", "JE", "JEY", "2"),
    Country("Jordan", "JO", "JOR", "0"),
    Country("Kazakhstan", "KZ", "KAZ", "8"),
    Country("Kenya", "KE", "KEN", "4"),
    Country("Kiribati", "KI", "KIR", "6"),
    Country("Korea (Democratic People's Republic of)", "KP", "PRK", "8"),
    Country("Korea, Republic of", "KR", "KOR", "0"),
    Country("Kuwait", "KW", "KWT", "4"),
    Country("Kyrgyzstan", "KG", "KGZ", "7"),
    Country("Lao People's Democratic Republic", "LA", "LAO", "8"),
    Country("Latvia", "LV", "LVA", "8"),
    Country("Lebanon", "LB", "LBN", "2"),
    Country("Lesotho", "LS", "LSO", "6"),
    Country("Liberia", "LR", "LBR", "0"),
    Country("Libya", "LY", "LBY", "4"),
    Country("Liechtenstein", "LI", "LIE", "8"),
    Country("Lithuania", "LT", "LTU", "0"),
    Country("Luxembourg", "LU", "LUX", "2"),
    Country("Macao", "MO", "MAC", "6"),
    Country("Madagascar", "MG", "MDG", "0"),
    Country("Malawi", "MW", "MWI", "4"),
    Country("Malaysia", "MY", "MYS", "8"),
    Country("Maldives", "MV", "MDV", "2"),
    Country("Mali", "ML", "MLI", "6"),
    Country("Malta", "MT", "MLT", "0"),
    Country("Marshall Islands", "MH", "MHL", "4"),
    Country("Martinique", "MQ", "MTQ", "4"),
    Country("Mauritania", "MR", "MRT", "8"),
    Country("Mauritius", "MU", "MUS", "0"),
    Country("Mayotte", "YT", "MYT", "5"),
    Country("Mexico", "MX", "MEX", "4"),
    Country("Micronesia (Federated States of)", "FM", "FSM", "3"),
    Country("Moldova, Republic of", "MD", "MDA", "8"),
    Country("Monaco", "MC", "MCO", "2"),
    Country("Mongolia", "MN", "MNG", "6"),
    Country("Montenegro", "ME", "MNE", "9"),
    Country("Montserrat", "MS", "MSR", "0"),
    Country("Morocco", "MA", "MAR", "4"),
    Country("Mozambique", "MZ", "MOZ", "8"),
    Country("Myanmar", "MM", "MMR", "4"),
    Country("Namibia", "NA", "NAM", "6"),
    Country("Nauru", "NR", "NRU", "0"),
    Country("Nepal", "NP", "NPL", "4"),
    Country("Netherlands", "NL", "NLD", "8"),
    Country("New Caledonia", "NC", "NCL", "0"),
    Country("New Zealand", "NZ", "NZL", "4"),
    Country("Nicaragua", "NI", "NIC", "8"),
    Country("Niger", "NE", "NER", "2"),
    Country("Nigeria", "NG", "NGA", "6"),
    Country("Niue", "NU", "NIU", "0"),
    Country("Norfolk Island", "NF", "NFK", "4"),
    Country("North Macedonia", "MK", "MKD", "7"),
    Country("Northern Mariana Islands", "MP", "MNP", "0"),
    Country("Norway", "NO", "NOR", "8"),
    Country("Oman", "OM", "OMN", "2"),
    Country("Pakistan", "PK", "PAK", "6"),
    Country("Palau", "PW", "PLW", "5"),
    Country("Palestine, State of", "PS", "PSE", "5"),
    Country("Panama", "PA", "PAN", "1"),
    Country("Papua New Guinea", "PG", "PNG", "8"),
    Country("Paraguay", "PY", "PRY", "0"),
    Country("Peru", "PE", "PER", "4"),
    Country("Philippines", "PH", "PHL", "8"),
    Country("Pitcairn", "PN", "PCN", "2"),
    Country("Poland", "PL", "POL", "6"),
    Country("Portugal", "PT", "PRT", "0"),
    Country("Puerto Rico", "PR", "PRI", "0"),
    Country("Qatar", "QA", "QAT", "4"),
    Country("Réunion", "RE", "REU", "8"),
    Country("Romania", "RO", "ROU", "2"),
    Country("Russian Federation", "RU", "RUS", "3"),
    Country("Rwanda", "RW", "RWA", "6"),
    Country("Saint Barthélemy", "BL", "BLM", "2"),
    Country("Saint Helena, Ascension and Tristan da Cunha", "SH", "SHN", "4"),
    Country("Saint Kitts and Nevis", "KN", "KNA", "9"),
    Country("Saint Lucia", "LC", "LCA", "2"),
    Country("Saint Martin (French part)", "MF", "MAF", "3"),
    Country("Saint Pierre and Miquelon", "PM", "SPM", "6"),
    Country("Saint Vincent and the Grenadines", "VC", "VCT", "0"),
    Country("Samoa", "WS", "WSM", "2"),
    Country("San Marino", "SM", "SMR", "4"),
    Country("Sao Tome and Principe", "ST", "STP", "8"),
    Country("Saudi Arabia", "SA", "SAU", "2"),
    Country("Senegal", "SN", "SEN", "6"),
    Country("Serbia", "RS", "SRB", "8"),
    Country("Seychelles", "SC", "SYC", "0"),
    Country("Sierra Leone", "SL", "SLE", "4"),
    Country("Singapore", "SG", "SGP", "2"),
    Country("Sint Maarten (Dutch part)", "SX", "SXM", "4"),
    Country("Slovakia", "SK", "SVK", "3"),
    Country("Slovenia", "SI", "SVN", "5"),
    Country("Solomon Islands", "SB", "SLB", "0"),
    Country("Somalia", "SO", "SOM", "6"),
    Country("South Africa", "ZA", "ZAF", "0"),
    Country("South Georgia and the South Sandwich Islands", "GS", "SGS", "9"),
    Country("South Sudan", "SS", "SSD", "8"),
    Country("Spain", "ES", "ESP", "4"),
    Country("Sri Lanka", "LK", "LKA", "4"),
    Country("Sudan", "SD", "SDN", "9"),
    Country("Suriname", "SR", "SUR", "0"),
    Country("Svalbard and Jan Mayen", "SJ", "SJM", "4"),
    Country("Sweden", "SE", "SWE", "2"),
    Country("Switzerland", "CH", "CHE", "6"),
    Country("Syrian Arab Republic", "SY", "SYR", "0"),
    Country("Taiwan, Province of China", "TW", "TWN", "8"),
    Country("Tajikistan", "TJ", "TJK", "2"),
    Country("Tanzania, United Republic of", "TZ", "TZA", "4"),
    Country("Thailand", "TH", "THA", "4"),
    Country("Timor-Leste", "TL", "TLS", "6"),
    Country("Togo", "TG", "TGO", "8"),
    Country("Tokelau", "TK", "TKL", "2"),
    Country("Tonga", "TO", "TON", "6"),
    Country("Trinidad and Tobago", "TT", "TTO", "0"),
    Country("Tunisia", "TN", "TUN", "8"),
    Country("Turkey", "TR", "TUR", "2"),
    Country("Turkmenistan", "TM", "TKM", "5"),
    Country("Turks and Caicos Islands", "TC", "TCA", "6"),
    Country("Tuvalu", "TV", "TUV", "8"),
    Country("Uganda", "UG", "UGA", "0"),
    Country("Ukraine", "UA", "UKR", "4"),
    Country("United Arab Emirates", "AE", "ARE", "4"),
    Country(
      "United Kingdom of Great Britain and Northern Ireland",
      "GB",
      "GBR",
      "6"
    ),
    Country("United States Minor Outlying Islands", "UM", "UMI", "1"),
    Country("Uruguay", "UY", "URY", "8"),
    Country("Uzbekistan", "UZ", "UZB", "0"),
    Country("Vanuatu", "VU", "VUT", "8"),
    Country("Venezuela (Bolivarian Republic of)", "VE", "VEN", "2"),
    Country("Viet Nam", "VN", "VNM", "4"),
    Country("Virgin Islands (British)", "VG", "VGB", "2"),
    Country("Virgin Islands (U.S.)", "VI", "VIR", "0"),
    Country("Wallis and Futuna", "WF", "WLF", "6"),
    Country("Western Sahara", "EH", "ESH", "2"),
    Country("Yemen", "YE", "YEM", "7"),
    Country("Zambia", "ZM", "ZMB", "4"),
    Country("Zimbabwe", "ZW", "ZWE", "6")
  )

end ISO3166
