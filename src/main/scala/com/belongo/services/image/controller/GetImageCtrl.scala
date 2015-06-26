package com.belongo.services.image.controller

import java.security.Principal


import com.belongo.services.image.main.CurrentUserId
import com.belongo.services.image.models.{PhotoDao, PhotoRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

/**
 * Created by Simon on 25.06.2015.
 */
@RestController
@RequestMapping(Array("/getimage"))
@EnableOAuth2Resource
class GetImageCtrl {

  @Autowired
  var photoDao:PhotoDao = _

  @RequestMapping(Array("/all"))
  def findAllByCurrentUser(@CurrentUserId userId:String): List[String] = {
      photoDao.findByUser(userId)
  }


  @RequestMapping(Array("/all/{id}"))
  def findAllByUser(): List[String] ={
    null
  }


}
