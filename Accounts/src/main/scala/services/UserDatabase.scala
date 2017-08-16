package services

import models.Users

import scala.collection.mutable

object UserDatabase {

  val userMap: mutable.Map[Long, Users] = scala.collection.mutable.Map(8130212805L -> Users("Divya", "Dua", 8130212805L, "divyadua", "divya1") )

  val userAccessToken: mutable.Map[Long, String] = scala.collection.mutable.Map(8130212805L -> "divyadua8130212805")

}
