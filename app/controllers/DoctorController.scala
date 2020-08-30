package controllers

import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._
import services.DoctorService

import scala.concurrent.ExecutionContext

@Singleton
class DoctorController @Inject()(val controllerComponents: ControllerComponents,
                                 doctorService: DoctorService)(implicit ec: ExecutionContext)
  extends BaseController {

  def getDoctors(name: Option[String]) = Action.async {
    doctorService.getDoctors(name).map(doctors => Ok(Json.toJson(doctors)))
  }

  def getDoctorById(doctorId: Long) = Action.async {
    doctorService.getDoctorWithServicesAndSpecialities(doctorId).map(services => Ok(Json.toJson(services)))
  }
}
