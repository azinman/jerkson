package com.codahale.jerkson.ser

import com.codahale.jerkson.AST._
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.{SerializerProvider, JsonSerializer}

class RawSerializer extends JsonSerializer[JsonSerialized] {
  def serialize(value: JsonSerialized, json: JsonGenerator, provider: SerializerProvider) {
    json.writeRawValue(value.toString)
  }
}
