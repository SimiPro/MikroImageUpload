package com.belongo.services.image.main

import com.belongo.services.image.ImageConfig
import org.springframework.boot.SpringApplication

object Application {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[ImageConfig], args:_*)
  }
}