package services

import models.Users

object UserDatabase {

  val userMap = scala.collection.mutable.Map(8130212805L -> Users("Divya", "Dua", 8130212805L, "divyadua", "divya1") )

  val userAccessToken = scala.collection.mutable.Map()

}
