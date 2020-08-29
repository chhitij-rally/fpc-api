package models

import java.sql.Timestamp

import formatters.TimestampFormatter
import play.api.libs.json._

case class User(id: Long,
                email: String,
                password: String,
                apiKey: String,
                createdAt: Timestamp,
                updatedAt: Timestamp)

object User extends TimestampFormatter {
  implicit val userFormat = Json.format[User]
}
