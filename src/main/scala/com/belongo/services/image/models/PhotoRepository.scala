package com.belongo.services.image.models

import org.springframework.data.jpa.repository.JpaRepository


/**
 * Created by Simon on 23.06.2015.
 */

trait PhotoRepository  extends JpaRepository[Photo,String]{

  def findByUserId(userId:String):List[Photo]

}
