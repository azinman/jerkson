package com.codahale.jerkson.ser

import org.joda.time.DateTime
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.{SerializerProvider, JsonSerializer}

class DateTimeSerializer extends JsonSerializer[DateTime] {
  def serialize(value: DateTime, json: JsonGenerator, provider: SerializerProvider) {
    json.writeString(value.toString())
  }
}
