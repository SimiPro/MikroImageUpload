package com.belongo.services.image.models

import java.util.Date
import javax.persistence._

import com.cloudinary.StoredFile

import scala.beans.BeanProperty

/**
 * Created by Simon on 23.06.2015.
 */
@Entity
class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @BeanProperty
    var id:String = _

    @BeanProperty
    var userId:String = _

    @BeanProperty
    var title:String = _

    @BeanProperty
    var image:String = _

    @BeanProperty
    var createdAt = new Date

    @BeanProperty
    var url:String = _






    def getUpload():StoredFile = {
        val file = new StoredFile
        file.setPreloadedFile(image)
        return file
    }
    def setUpload(storedFile: StoredFile) = this.image = storedFile.getPreloadedFile

}

