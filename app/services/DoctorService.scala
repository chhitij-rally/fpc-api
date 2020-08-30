package services

import database.dao.{DoctorDao, ServiceDao, SpecialityDao}
import javax.inject.Inject
import models.{DoctorWithServicesAndSpecialities, UserWithAddresses}

import scala.concurrent.{ExecutionContext, Future}

class DoctorService @Inject()(doctorDao: DoctorDao, serviceDao: ServiceDao, specialityDao: SpecialityDao)
                             (implicit ec: ExecutionContext) {

  def getDoctors(name: Option[String]): Future[Seq[UserWithAddresses]] =
    doctorDao.getDoctors(name)

  def getDoctorWithServicesAndSpecialities(doctorId: Long): Future[Option[DoctorWithServicesAndSpecialities]] = {
    for {
      userEntity <- doctorDao.getDoctorById(doctorId)
      services <- serviceDao.getServicesByDoctorId(doctorId)
      specialities <- specialityDao.getSpecialitiesByDoctorId(doctorId)
    } yield userEntity.map(u => DoctorWithServicesAndSpecialities(u.toUser, services, specialities))
  }
}
