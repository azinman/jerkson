package com.codahale.jerkson.ser

import scala.collection.JavaConversions._
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.{SerializerProvider, JsonSerializer}

class IterableWrapperSerializer extends JsonSerializer[IterableWrapperTrait[_]] {
  def serialize(value: IterableWrapperTrait[_], json: JsonGenerator, provider: SerializerProvider) {
    json.writeStartArray()
    for (element <- asScalaIterator(value.iterator)) {
      provider.defaultSerializeValue(element, json)
    }
    json.writeEndArray()
  }
}
