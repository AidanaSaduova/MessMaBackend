
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/aidan/Documents/Aidana/Fh/5thSemester/SmartCity/MessMa/MessMaBackendCode/conf/routes
// @DATE:Sun Jan 13 14:42:53 CET 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.javascript {

  // @LINE:5
  class ReverseApiDocController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def api: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiDocController.api",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api"})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
    // @LINE:24
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "versionedAssets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAdminsApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def addNewAccessPoint: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminsApiController.addNewAccessPoint",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/saveAccessPoint"})
        }
      """
    )
  
    // @LINE:10
    def addNewGridPoint: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminsApiController.addNewGridPoint",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/saveGridPoint"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseDevelopersApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def findGridPointbyId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevelopersApiController.findGridPointbyId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/getGridPoint/byId/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:17
    def getAllGridPoints: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevelopersApiController.getAllGridPoints",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/getAllGridPoints"})
        }
      """
    )
  
    // @LINE:19
    def getAllVektors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevelopersApiController.getAllVektors",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/getAllVektors"})
        }
      """
    )
  
    // @LINE:15
    def findStandbyId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevelopersApiController.findStandbyId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/getStand/byId/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:18
    def getAllStands: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevelopersApiController.getAllStands",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/getAllStands"})
        }
      """
    )
  
    // @LINE:16
    def getAllAccessPoints: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevelopersApiController.getAllAccessPoints",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/getAllAccessPoints"})
        }
      """
    )
  
    // @LINE:13
    def findAccessPointsbyMac: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevelopersApiController.findAccessPointsbyMac",
      """
        function(mac0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/getAccessPoint/byMac/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[java.util.UUID]].javascriptUnbind + """)("mac", mac0))})
        }
      """
    )
  
    // @LINE:20
    def getAllGridAccessPoints: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevelopersApiController.getAllGridAccessPoints",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/getAllGridAcessPoints"})
        }
      """
    )
  
  }


}
