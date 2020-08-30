package models

import formatters.TimestampFormatter
import play.api.libs.json.Json

case class DoctorSpeciality(doctorId: Long,
                            specialityId: Long)

object DoctorSpeciality extends TimestampFormatter {
  implicit val doctorSpecialityFormat = Json.format[DoctorSpeciality]
}
