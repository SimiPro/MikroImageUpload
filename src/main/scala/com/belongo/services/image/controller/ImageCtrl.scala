package com.belongo.services.image.controller


import java.io.File
import com.belongo.services.image.models.{PhotoRepository, Photo, PhotoUpload}
import com.cloudinary.Singleton
import com.cloudinary.utils.ObjectUtils
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.{ResponseBody, RestController}
import org.springframework.web.bind.annotation._
import org.springframework.web.multipart.MultipartFile
import collection.JavaConversions._



/**
 * Created by Simon on 22.06.2015.
 */
@RestController
@RequestMapping(Array("/image"))
@EnableOAuth2Resource
class ImageCtrl {

  @Value("${api_key}")
  var api_key:String = _

  @Autowired
  var photoRepo:PhotoRepository = _

  @RequestMapping(value = Array("/test"), method = Array(RequestMethod.GET))
  @ResponseBody
  def test():String = {
    return "It worked"
  }

  @RequestMapping(value = Array("/upload"))
  @RequestBody
  def cloudy (@RequestParam("file") file: MultipartFile) : Any = {
    val photoUpload:PhotoUpload = new PhotoUpload
    photoUpload.setFile(file)
    PhotoUploadValidator.validate(photoUpload)


    if (photoUpload.getFile != null && !photoUpload.getFile.isEmpty) {
      val uploadResult = Singleton.getCloudinary.uploader().
        upload(photoUpload.getFile.getBytes, ObjectUtils.asMap("resource_type", "auto"))
      photoUpload.setPublicId(uploadResult.get("public_id").asInstanceOf[String])
      photoUpload.setSignature(uploadResult.get("signature").asInstanceOf[String])
      photoUpload.setFormat(uploadResult.get("format").asInstanceOf[String])
      photoUpload.setResourceType(uploadResult.get("resource_type").asInstanceOf[String])
      uploadResult.get("version") match {
        case x1:Integer => photoUpload.setVersion(x1.longValue())
        case x2:Long => photoUpload.setVersion(x2)
      }

      val photo = new Photo()
      photo.setTitle(photoUpload.getTitle)
      photo.setUpload(photoUpload)
      photoRepo.save(photo)

      return uploadResult
    }
    return "NOK"

  }

}
