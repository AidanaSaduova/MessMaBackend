
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/aidan/Documents/Aidana/Fh/5thSemester/SmartCity/MessMa/MessMaBackendCode/conf/routes
// @DATE:Sun Jan 13 14:42:53 CET 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  ApiDocController_2: controllers.ApiDocController,
  // @LINE:9
  AdminsApiController_0: controllers.AdminsApiController,
  // @LINE:13
  DevelopersApiController_3: controllers.DevelopersApiController,
  // @LINE:23
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    ApiDocController_2: controllers.ApiDocController,
    // @LINE:9
    AdminsApiController_0: controllers.AdminsApiController,
    // @LINE:13
    DevelopersApiController_3: controllers.DevelopersApiController,
    // @LINE:23
    Assets_1: controllers.Assets
  ) = this(errorHandler, ApiDocController_2, AdminsApiController_0, DevelopersApiController_3, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApiDocController_2, AdminsApiController_0, DevelopersApiController_3, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api""", """controllers.ApiDocController.api"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/saveAccessPoint""", """controllers.AdminsApiController.addNewAccessPoint()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/saveGridPoint""", """controllers.AdminsApiController.addNewGridPoint()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/getAccessPoint/byMac/""" + "$" + """mac<[^/]+>""", """controllers.DevelopersApiController.findAccessPointsbyMac(mac:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/getGridPoint/byId/""" + "$" + """id<[^/]+>""", """controllers.DevelopersApiController.findGridPointbyId(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/getStand/byId/""" + "$" + """id<[^/]+>""", """controllers.DevelopersApiController.findStandbyId(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/getAllAccessPoints""", """controllers.DevelopersApiController.getAllAccessPoints()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/getAllGridPoints""", """controllers.DevelopersApiController.getAllGridPoints()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/getAllStands""", """controllers.DevelopersApiController.getAllStands()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/getAllVektors""", """controllers.DevelopersApiController.getAllVektors()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/getAllGridAcessPoints""", """controllers.DevelopersApiController.getAllGridAccessPoints()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """versionedAssets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_ApiDocController_api0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api")))
  )
  private[this] lazy val controllers_ApiDocController_api0_invoker = createInvoker(
    ApiDocController_2.api,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiDocController",
      "api",
      Nil,
      "GET",
      this.prefix + """api""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_AdminsApiController_addNewAccessPoint1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/saveAccessPoint")))
  )
  private[this] lazy val controllers_AdminsApiController_addNewAccessPoint1_invoker = createInvoker(
    AdminsApiController_0.addNewAccessPoint(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminsApiController",
      "addNewAccessPoint",
      Nil,
      "POST",
      this.prefix + """api/saveAccessPoint""",
      """Functions for Admins API""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AdminsApiController_addNewGridPoint2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/saveGridPoint")))
  )
  private[this] lazy val controllers_AdminsApiController_addNewGridPoint2_invoker = createInvoker(
    AdminsApiController_0.addNewGridPoint(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminsApiController",
      "addNewGridPoint",
      Nil,
      "POST",
      this.prefix + """api/saveGridPoint""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_DevelopersApiController_findAccessPointsbyMac3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/getAccessPoint/byMac/"), DynamicPart("mac", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DevelopersApiController_findAccessPointsbyMac3_invoker = createInvoker(
    DevelopersApiController_3.findAccessPointsbyMac(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevelopersApiController",
      "findAccessPointsbyMac",
      Seq(classOf[java.util.UUID]),
      "GET",
      this.prefix + """api/getAccessPoint/byMac/""" + "$" + """mac<[^/]+>""",
      """Functions for Developers API""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_DevelopersApiController_findGridPointbyId4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/getGridPoint/byId/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DevelopersApiController_findGridPointbyId4_invoker = createInvoker(
    DevelopersApiController_3.findGridPointbyId(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevelopersApiController",
      "findGridPointbyId",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/getGridPoint/byId/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_DevelopersApiController_findStandbyId5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/getStand/byId/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DevelopersApiController_findStandbyId5_invoker = createInvoker(
    DevelopersApiController_3.findStandbyId(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevelopersApiController",
      "findStandbyId",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """api/getStand/byId/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_DevelopersApiController_getAllAccessPoints6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/getAllAccessPoints")))
  )
  private[this] lazy val controllers_DevelopersApiController_getAllAccessPoints6_invoker = createInvoker(
    DevelopersApiController_3.getAllAccessPoints(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevelopersApiController",
      "getAllAccessPoints",
      Nil,
      "GET",
      this.prefix + """api/getAllAccessPoints""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_DevelopersApiController_getAllGridPoints7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/getAllGridPoints")))
  )
  private[this] lazy val controllers_DevelopersApiController_getAllGridPoints7_invoker = createInvoker(
    DevelopersApiController_3.getAllGridPoints(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevelopersApiController",
      "getAllGridPoints",
      Nil,
      "GET",
      this.prefix + """api/getAllGridPoints""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_DevelopersApiController_getAllStands8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/getAllStands")))
  )
  private[this] lazy val controllers_DevelopersApiController_getAllStands8_invoker = createInvoker(
    DevelopersApiController_3.getAllStands(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevelopersApiController",
      "getAllStands",
      Nil,
      "GET",
      this.prefix + """api/getAllStands""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_DevelopersApiController_getAllVektors9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/getAllVektors")))
  )
  private[this] lazy val controllers_DevelopersApiController_getAllVektors9_invoker = createInvoker(
    DevelopersApiController_3.getAllVektors(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevelopersApiController",
      "getAllVektors",
      Nil,
      "GET",
      this.prefix + """api/getAllVektors""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_DevelopersApiController_getAllGridAccessPoints10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/getAllGridAcessPoints")))
  )
  private[this] lazy val controllers_DevelopersApiController_getAllGridAccessPoints10_invoker = createInvoker(
    DevelopersApiController_3.getAllGridAccessPoints(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevelopersApiController",
      "getAllGridAccessPoints",
      Nil,
      "GET",
      this.prefix + """api/getAllGridAcessPoints""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Assets_at11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at11_invoker = createInvoker(
    Assets_1.at(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Assets_versioned12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("versionedAssets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned12_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """versionedAssets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_ApiDocController_api0_route(params@_) =>
      call { 
        controllers_ApiDocController_api0_invoker.call(ApiDocController_2.api)
      }
  
    // @LINE:9
    case controllers_AdminsApiController_addNewAccessPoint1_route(params@_) =>
      call { 
        controllers_AdminsApiController_addNewAccessPoint1_invoker.call(AdminsApiController_0.addNewAccessPoint())
      }
  
    // @LINE:10
    case controllers_AdminsApiController_addNewGridPoint2_route(params@_) =>
      call { 
        controllers_AdminsApiController_addNewGridPoint2_invoker.call(AdminsApiController_0.addNewGridPoint())
      }
  
    // @LINE:13
    case controllers_DevelopersApiController_findAccessPointsbyMac3_route(params@_) =>
      call(params.fromPath[java.util.UUID]("mac", None)) { (mac) =>
        controllers_DevelopersApiController_findAccessPointsbyMac3_invoker.call(DevelopersApiController_3.findAccessPointsbyMac(mac))
      }
  
    // @LINE:14
    case controllers_DevelopersApiController_findGridPointbyId4_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DevelopersApiController_findGridPointbyId4_invoker.call(DevelopersApiController_3.findGridPointbyId(id))
      }
  
    // @LINE:15
    case controllers_DevelopersApiController_findStandbyId5_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_DevelopersApiController_findStandbyId5_invoker.call(DevelopersApiController_3.findStandbyId(id))
      }
  
    // @LINE:16
    case controllers_DevelopersApiController_getAllAccessPoints6_route(params@_) =>
      call { 
        controllers_DevelopersApiController_getAllAccessPoints6_invoker.call(DevelopersApiController_3.getAllAccessPoints())
      }
  
    // @LINE:17
    case controllers_DevelopersApiController_getAllGridPoints7_route(params@_) =>
      call { 
        controllers_DevelopersApiController_getAllGridPoints7_invoker.call(DevelopersApiController_3.getAllGridPoints())
      }
  
    // @LINE:18
    case controllers_DevelopersApiController_getAllStands8_route(params@_) =>
      call { 
        controllers_DevelopersApiController_getAllStands8_invoker.call(DevelopersApiController_3.getAllStands())
      }
  
    // @LINE:19
    case controllers_DevelopersApiController_getAllVektors9_route(params@_) =>
      call { 
        controllers_DevelopersApiController_getAllVektors9_invoker.call(DevelopersApiController_3.getAllVektors())
      }
  
    // @LINE:20
    case controllers_DevelopersApiController_getAllGridAccessPoints10_route(params@_) =>
      call { 
        controllers_DevelopersApiController_getAllGridAccessPoints10_invoker.call(DevelopersApiController_3.getAllGridAccessPoints())
      }
  
    // @LINE:23
    case controllers_Assets_at11_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_at11_invoker.call(Assets_1.at(file))
      }
  
    // @LINE:24
    case controllers_Assets_versioned12_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned12_invoker.call(Assets_1.versioned(file))
      }
  }
}
