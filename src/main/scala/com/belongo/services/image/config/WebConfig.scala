package com.belongo.services.image.config

import java.util


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by Simon on 25.06.2015.
 */
@Configuration
class WebConfig  extends  WebMvcConfigurerAdapter {
  @Autowired
  var userIdResolver:CurrentUserIdResolver = _

  override def addArgumentResolvers(argumentResolvers: util.List[HandlerMethodArgumentResolver]): Unit = {
    argumentResolvers.add(userIdResolver)
  }
}
