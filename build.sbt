lazy val common = Seq(version := "1.0",
  scalaVersion := "2.12.2",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test")

lazy val Accounts = project.settings(common)

lazy val Api = project.dependsOn(Accounts, Checkout, Inventory, Notification).settings(common)

lazy val Checkout = project.settings(common)

lazy val Inventory = project.settings(common)

lazy val Notification = project.settings(common)

lazy val Dashboard = project.dependsOn(Api).settings(common)

lazy val root = (project in file(".")).
  aggregate(Accounts, Api, Checkout, Inventory, Notification, Dashboard).settings(common)
.dependsOn(Accounts, Api, Checkout, Inventory, Notification, Dashboard)
        