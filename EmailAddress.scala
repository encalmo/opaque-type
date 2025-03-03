package org.encalmo.models

opaque type EmailAddress <: String = String

object EmailAddress extends SimpleOpaqueString[EmailAddress]
