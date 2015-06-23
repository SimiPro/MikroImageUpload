package com.belongo.services.image

import com.belongo.services.image.config.ScalaObjectMapper
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.{Primary, Bean, ComponentScan, Configuration}

/**
 * Created by Simon on 22.06.2015.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
class ImageConfig {

    /*
  This mapper does all the magic to convert scala case classes to json and back :)
   */
  @Bean
  @Primary
  def scalaObjectMapper() = new ScalaObjectMapper

}
