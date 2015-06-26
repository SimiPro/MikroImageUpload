package com.belongo.services.image.config

import com.belongo.services.image.main.CurrentUserId
import org.springframework.core.MethodParameter
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.{ModelAndViewContainer, HandlerMethodArgumentResolver}



/**
 * Created by Simon on 25.06.2015.
 */

@Component
class CurrentUserIdResolver extends HandlerMethodArgumentResolver {
  override def resolveArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer, webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory): AnyRef ={
    val auth = SecurityContextHolder.getContext.getAuthentication
    val user = auth.asInstanceOf[OAuth2Authentication].getUserAuthentication
    val userprincipals = user.getDetails.asInstanceOf[java.util.LinkedHashMap[_,_]].get("principal")
    val userId =  userprincipals.asInstanceOf[java.util.LinkedHashMap[_,_]].get("id")
    userId.asInstanceOf[AnyRef]
  }

  override def supportsParameter(parameter: MethodParameter): Boolean = {
    parameter.getParameterAnnotation(classOf[CurrentUserId]) != null &&
    parameter.getParameterType.equals(classOf[String])
  }
}