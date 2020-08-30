// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/phani/Repo/phanitumuluri-rally/fpc/fpc-api/conf/routes
// @DATE:Sun Aug 30 21:51:30 IST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:9
  UserController_3: controllers.UserController,
  // @LINE:12
  DoctorController_2: controllers.DoctorController,
  // @LINE:18
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:9
    UserController_3: controllers.UserController,
    // @LINE:12
    DoctorController_2: controllers.DoctorController,
    // @LINE:18
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, UserController_3, DoctorController_2, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, UserController_3, DoctorController_2, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/register""", """controllers.UserController.register"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/doctors""", """controllers.DoctorController.getDoctors(name:Option[String])"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/doctors/""" + "$" + """doctorId<[^/]+>""", """controllers.DoctorController.getDoctorById(doctorId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_register1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/register")))
  )
  private[this] lazy val controllers_UserController_register1_invoker = createInvoker(
    UserController_3.register,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "register",
      Nil,
      "POST",
      this.prefix + """api/v1/register""",
      """ Users""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_DoctorController_getDoctors2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/doctors")))
  )
  private[this] lazy val controllers_DoctorController_getDoctors2_invoker = createInvoker(
    DoctorController_2.getDoctors(fakeValue[Option[String]]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DoctorController",
      "getDoctors",
      Seq(classOf[Option[String]]),
      "GET",
      this.prefix + """api/v1/doctors""",
      """ Doctors""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_DoctorController_getDoctorById3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/doctors/"), DynamicPart("doctorId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DoctorController_getDoctorById3_invoker = createInvoker(
    DoctorController_2.getDoctorById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DoctorController",
      "getDoctorById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """api/v1/doctors/""" + "$" + """doctorId<[^/]+>""",
      """ Doctor Services""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:9
    case controllers_UserController_register1_route(params@_) =>
      call { 
        controllers_UserController_register1_invoker.call(UserController_3.register)
      }
  
    // @LINE:12
    case controllers_DoctorController_getDoctors2_route(params@_) =>
      call(params.fromQuery[Option[String]]("name", None)) { (name) =>
        controllers_DoctorController_getDoctors2_invoker.call(DoctorController_2.getDoctors(name))
      }
  
    // @LINE:15
    case controllers_DoctorController_getDoctorById3_route(params@_) =>
      call(params.fromPath[Long]("doctorId", None)) { (doctorId) =>
        controllers_DoctorController_getDoctorById3_invoker.call(DoctorController_2.getDoctorById(doctorId))
      }
  
    // @LINE:18
    case controllers_Assets_versioned4_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
