package com.belongo.services.image.controller

import org.springframework.web.bind.annotation.{ResponseBody, RequestMapping, RestController}

/**
 * Created by Simon on 22.06.2015.
 */
@RestController
@RequestMapping(Array("/test"))
class TestCtrl {

  @RequestMapping("/notSecure")
  @ResponseBody
  def notSecured():String = {
    return "Im not secure"
  }

}
