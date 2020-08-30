// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/phani/Repo/phanitumuluri-rally/fpc/fpc-api/conf/routes
// @DATE:Sun Aug 30 21:51:30 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:12
  class ReverseDoctorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getDoctorById(doctorId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/doctors/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("doctorId", doctorId)))
    }
  
    // @LINE:12
    def getDoctors(name:Option[String]): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/doctors" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Option[String]]].unbind("name", name)))))
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:18
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:9
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def register(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/register")
    }
  
  }


}
