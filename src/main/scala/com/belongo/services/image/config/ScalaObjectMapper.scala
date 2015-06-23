package com.belongo.services.image.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

/**
 * Created by Simon on 23.06.2015.
 */
class ScalaObjectMapper extends ObjectMapper {
  registerModule(DefaultScalaModule)

}

