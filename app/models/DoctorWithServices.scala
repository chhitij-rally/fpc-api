package models

import play.api.libs.json.{Format, Json}

case class DoctorWithServicesAndSpecialities(doctor: User, services: Seq[Service], specialities: Seq[Speciality])

object DoctorWithServicesAndSpecialities {
  implicit val format: Format[DoctorWithServicesAndSpecialities] = Json.format[DoctorWithServicesAndSpecialities]
}
