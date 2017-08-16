package services

import org.scalatest.AsyncFunSuite

class AccountsTest extends AsyncFunSuite with Accounts{

  test("testing add User method"){
    val result = addUser("Neha", "Dua", 9997931352L, "nehadua", "neha1", "neha1")
    result map(r => assert(r === "Successfully registered!"))
  }

  test("testing add User method for password and confirm password do nt match case"){
    val result = addUser("Neha", "Dua", 9997931351L, "nehadua", "neha1", "neha2")
    result map(r => assert(r === "Password and Confirm Password do not match"))
  }

  test("testing add User method for already registered mobile number"){
    val result = addUser("Neha", "Dua", 8130212805L, "nehadua", "neha1", "neha2")
    result map(r => assert(r === "Mobile number is already registered!"))
  }

  test("testing authenticate account method that returns an access token"){
    val result = authenticateUser("divyadua", "divya1")
    result map(r => assert(r === "divyadua8130212805"))
  }

  test("testing authenticate account method that does not return an access token"){
    val result = authenticateUser("divyadua", "div12")
    result map(r => assert(r === "\0"))
  }

}
