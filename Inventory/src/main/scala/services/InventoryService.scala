package services

import models.Item

import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait InventoryService {

  val inventory: mutable.Map[String, List[Item]] = scala.collection.mutable.Map("Electronics" ->
    List(Item(1L, "Tubelight1", "Electronics", 20, 100.0, "Vendor1", 4),
    Item(2L, "Tubelight2", "Electronics", 20, 50.0, "Vendor1", 2)),
    "Clothes" -> List(Item(1L, "T-shirt1", "Clothes", 20, 100.0, "Vendor1", 4),Item(2L, "T-shirt2", "Clothes", 20, 200.0, "Vendor1", 5),
      Item(3L, "T-shirt3", "Clothes", 20, 150.0, "Vendor1", 2)))

  def searchItemsByCategory(category: String): Future[List[Item]] = Future{
    if(inventory.contains(category)){
      inventory(category)
    }
    else{
      Nil
    }
  }

  def sortItems(category: String, priceOrRating: String, filterByLowOrHigh: String): Future[List[Item]] = Future{

    val sortedItemList: List[Item] = priceOrRating match {
      case "price" => if (filterByLowOrHigh.equalsIgnoreCase("low")) {
        inventory(category).sortBy(_.price)
      }
      else {
        inventory(category).sortBy(_.price).reverse
      }
      case "rating" => if (filterByLowOrHigh.equalsIgnoreCase("low")) {
        inventory(category).sortBy(_.rating)
      }
      else {
        inventory(category).sortBy(_.rating).reverse
      }
    }
    sortedItemList
  }

}
