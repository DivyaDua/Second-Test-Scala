package services

import models.Item
import org.scalatest.AsyncFunSuite

class InventoryServiceTest extends AsyncFunSuite with InventoryService{

  test("testing search items by category method"){
    val item1 = Item(1L, "Tubelight1", "Electronics", 20, 100.0, "Vendor1", 4)
    val item2 = Item(2L, "Tubelight2", "Electronics", 20, 50.0, "Vendor1", 2)
    val result = searchItemsByCategory("Electronics")
    result map(r => assert(r === List(item1, item2)))
  }

  test("testing search items by category for category that does not exist"){
    val result = searchItemsByCategory("Mobile")
    result map(r => assert(r === List()))
  }

}
