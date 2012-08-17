package com.codahale.jerkson.ser

import scala.collection.JavaConversions._
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.{SerializerProvider, JsonSerializer}

class MapWrapperSerializer extends JsonSerializer[MapWrapper[_ ,_]] {
  def serialize(map: MapWrapper[_,_], json: JsonGenerator, provider: SerializerProvider) {
    json.writeStartObject()

    for (entry <- map.entrySet.iterator) {
      provider.defaultSerializeField(entry.getKey.toString, entry.getValue, json)
    }
    json.writeEndObject()
  }
}
