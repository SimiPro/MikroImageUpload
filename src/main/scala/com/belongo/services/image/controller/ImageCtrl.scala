package com.belongo.services.image.controller

import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.web.bind.annotation.{ResponseBody, RestController}
import org.springframework.web.bind.annotation._

/**
 * Created by Simon on 22.06.2015.
 */
@RestController
@RequestMapping(Array("/image"))
@EnableOAuth2Resource
class ImageCtrl {

  @RequestMapping(value = Array("/test"), method = Array(RequestMethod.GET))
  @ResponseBody
  def test():String = {
    return "It worked"
  }

}
