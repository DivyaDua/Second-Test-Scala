package services

import models.Users
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait Accounts {

  def addUser(firstName: String, lastName: String, mobileNumber: Long, userName: String, password: String, confirmPassword: String): Future[String] = Future{
    if(password != confirmPassword){
      s"Password and Confirm Password do not match"
    }
    else if (UserDatabase.userMap.contains(mobileNumber)){
      s"Mobile number is already registered!"
    }
    else{
      UserDatabase.userMap += (mobileNumber -> Users(firstName, lastName, mobileNumber, userName, password))
      s"Successfully registered!"
    }
  }

  def authenticateUser(userName: String, password: String): Future[String] = Future{

    val listForValidation = for{(key, user) <- UserDatabase.userMap
      bool = if (user.userName == userName && user.password == password) true else false
    }yield (key,bool)

    val booleanList = listForValidation.values.toList

    if(booleanList.contains(true)){
      val positon = booleanList.indexOf(true)
      val mobileNumber = listForValidation.toList(positon)._1
      userName + mobileNumber.toString
    }
    else{
      "\0"
    }
  }
}
