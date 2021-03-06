package com.codahale.jerkson.ser

import scala.collection.JavaConversions._
import org.joda.time.DateTime
import com.codahale.jerkson.AST._
import com.fasterxml.jackson.databind._
import com.fasterxml.jackson.databind.ser.Serializers

class ScalaSerializers extends Serializers.Base {
  override def findSerializer(config: SerializationConfig, javaType: JavaType, beanDesc: BeanDescription) = {
    val ser: Object = if (classOf[Option[_]].isAssignableFrom(beanDesc.getBeanClass)) {
      new OptionSerializer
    } else if (classOf[JsonSerialized].isAssignableFrom(beanDesc.getBeanClass)) {
      new RawSerializer
    } else if (classOf[DateTime].isAssignableFrom(beanDesc.getBeanClass)) {
      new DateTimeSerializer
    } else if (classOf[StringBuilder].isAssignableFrom(beanDesc.getBeanClass)) {
      new StringBuilderSerializer
    } else if (classOf[MapWrapper[_,_]].isAssignableFrom(beanDesc.getBeanClass)) {
      new MapWrapperSerializer
    } else if (classOf[MutableMapWrapper[_,_]].isAssignableFrom(beanDesc.getBeanClass)) {
      new MutableMapWrapperSerializer
    } else if (classOf[collection.Map[_,_]].isAssignableFrom(beanDesc.getBeanClass)) {
      new MapSerializer
    } else if (classOf[Range].isAssignableFrom(beanDesc.getBeanClass)) {
      new RangeSerializer
    } else if (classOf[IterableWrapperTrait[_]].isAssignableFrom(beanDesc.getBeanClass)) {
      new IterableWrapperSerializer
    } else if (classOf[Iterable[_]].isAssignableFrom(beanDesc.getBeanClass)) {
      new IterableSerializer
    } else if (classOf[Iterator[_]].isAssignableFrom(beanDesc.getBeanClass)) {
      new IteratorSerializer
    } else if (classOf[JValue].isAssignableFrom(beanDesc.getBeanClass)) {
      new JValueSerializer
    } else if (classOf[Either[_,_]].isAssignableFrom(beanDesc.getBeanClass)) {
      new EitherSerializer
    } else if (classOf[Product].isAssignableFrom(beanDesc.getBeanClass)) {
      new CaseClassSerializer(beanDesc.getBeanClass)
    } else {
      null
    }
    ser.asInstanceOf[JsonSerializer[Object]]
  }
}
