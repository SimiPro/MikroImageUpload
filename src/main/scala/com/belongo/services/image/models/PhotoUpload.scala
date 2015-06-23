package com.belongo.services.image.models

import com.cloudinary.{Transformation, Singleton, StoredFile}
import org.springframework.web.multipart.MultipartFile

/**
 * Created by Simon on 23.06.2015.
 */
class PhotoUpload extends StoredFile {
  var title:String = _
  var file:MultipartFile = _
  def checkFile:Boolean = version != null && format != null && publicId != null

  def getUrl() : String = {
    if (checkFile) {
      Singleton.getCloudinary.url()
                .resourceType(resourceType)
                .format(format)
                .`type`(`type`)
                .version(version)
                .generate(publicId)
    } else  null
  }


  def getThumbnailUrl():String = {
    if (checkFile) {
      Singleton.getCloudinary.url()
        .format(format)
        .`type`(`type`)
        .version(version)
        .transformation(new Transformation().width(150).height(150).crop("fit"))
        .generate(publicId)
    } else null;
  }

  def getComputedSignature():String = getComputedSignature(Singleton.getCloudinary)

  def validSignature:Boolean = getComputedSignature().equals(signature)

  def setTitle(title:String) = this.title = title
  def getTitle:String = this.title
  def getFile = this.file
  def setFile(file:MultipartFile) = this.file = file

}
