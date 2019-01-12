
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/aidan/Documents/Aidana/Fh/5thSemester/SmartCity/MessMa/MessMaBackendCode/conf/routes
// @DATE:Sat Jan 12 15:56:27 CET 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseApiDocController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def api(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api")
    }
  
  }

  // @LINE:22
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def at(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:23
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "versionedAssets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:9
  class ReverseAdminsApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def addNewAccessPoint(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/saveAccessPoint")
    }
  
    // @LINE:10
    def addNewGridPoint(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/saveGridPoint")
    }
  
  }

  // @LINE:13
  class ReverseDevelopersApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def findGridPointbyId(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/getGridPoint/byId/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:17
    def getAllGridPoints(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/getAllGridPoints")
    }
  
    // @LINE:19
    def getAllVektors(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/getAllVektors")
    }
  
    // @LINE:15
    def findStandbyId(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/getStand/byId/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:18
    def getAllStands(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/getAllStands")
    }
  
    // @LINE:16
    def getAllAccessPoints(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/getAllAccessPoints")
    }
  
    // @LINE:13
    def findAccessPointsbyMac(mac:java.util.UUID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/getAccessPoint/byMac/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("mac", mac)))
    }
  
  }


}
