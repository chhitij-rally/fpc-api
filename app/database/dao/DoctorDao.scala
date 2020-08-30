package database.dao

import database.domain.UserEntity
import database.schema.DatabaseTables.{addressTable, doctorSpecialityTable, serviceTable, specialityTable, userTable}
import javax.inject.{Inject, Singleton}
import models.UserWithAddresses
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class DoctorDao @Inject() (dbConfigProvider: DatabaseConfigProvider) (implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  import dbConfig._
  import profile.api._

  lazy val doctorQuery = userTable
    .filter(user => user.roles === UserEntity.Role.Doctor.id.toString)

  def getDoctors(name: Option[String]): Future[Seq[UserWithAddresses]] = db.run {
    val query = doctorQuery
      .filterOpt(name)((user, value) => user.firstName.toLowerCase.like(s"%${value.toLowerCase}%") || user.lastName.toLowerCase.like(s"%${value.toLowerCase}%"))
      .joinLeft(addressTable).on(_.id === _.userId)
//      .joinLeft(doctorSpecialityTable.join(specialityTable).on(_.specialityId === _.id)).on(_._1.id === _._2.id)

    query.result.statements.foreach(println)
    query.result.map(_.map(userWithAddress => UserWithAddresses(userWithAddress._1.toUser, userWithAddress._2)))
  }

  def getDoctorById(doctorId: Long): Future[Option[UserEntity]] = db.run {
    doctorQuery.filter(_.id === doctorId).result.headOption
  }

  def getByApiKey(apiKey: String): Future[Option[UserEntity]] = db.run {
    doctorQuery.filter(user => user.apiKey === apiKey).result.headOption
  }

  def getByEmail(email: String): Future[Option[UserEntity]] = db.run {
    doctorQuery.filter(user => user.email === email).result.headOption
  }
}
