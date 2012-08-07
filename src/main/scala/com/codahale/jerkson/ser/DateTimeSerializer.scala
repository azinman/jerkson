package com.codahale.jerkson.ser

import org.joda.time.{DateTime, DateTimeZone}
import org.joda.time.format.ISODateTimeFormat
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.{SerializerProvider, JsonSerializer}

class DateTimeSerializer extends JsonSerializer[DateTime] {
  def serialize(value: DateTime, json: JsonGenerator, provider: SerializerProvider) {
    json.writeString(DateTimeSerializer.asString(value))
  }
}

object DateTimeSerializer {
  val fmt = ISODateTimeFormat.dateTime.withZone(DateTimeZone.UTC)
  def asString(dateTime:DateTime) = fmt.print(dateTime)
}
