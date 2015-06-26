package com.belongo.services.image.models

import org.apache.catalina.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by Simon on 25.06.2015.
 */
@Component
class PhotoDao {

  @Autowired
  var repo:PhotoRepository = _

  def findByUser(userId:String) : List[String] = {
    val list:List[Photo] = repo.findByUserId(userId)
    list match {
      case null => List()
      case _ => list.map(P => P.url)
    }
  }


}
