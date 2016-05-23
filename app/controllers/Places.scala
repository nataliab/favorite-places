package controllers

import natalia.favorite.places.v0.models.json._
import play.api.mvc._
import natalia.favorite.places.v0.models._
import play.api.libs.json.Json
import scala.collection.mutable.ListBuffer

object Places extends Controller {

  var places = ListBuffer[Place] (
    Place("51b2504c498e537d84ee84c3", "The Beerhouse", "https://irs2.4sqi.net/img/general/640/5293444_GBJkT8dTt_lCCu2qbwK5vm6uX64LWoDUzvMh6tG3kxY"),
    Place("4ba3a0b7f964a5208c4d38e3", "Gravity Bar", "https://irs0.4sqi.net/img/general/612/180816_Dfv_ZUNDcHqU3fvp66sBvE229n6ezUDnN7dlB15ngE8.jpg"),
    Place("4b05d950f964a52056e422e3", "Toners Pub", "https://irs3.4sqi.net/img/general/3861/56450212_N8hPQZpKN9KlouUpbb4npq8YSwvU9uUmvJTX6KLVPHI.jpg")
  )

  def get = Action {
    Ok(Json.toJson(places))
  }

  def put =  Action(parse.json[Place]) { request =>
    val newPlace = request.body
    if (places.filter(_.id.equals(newPlace.id)).size == 0) {
      places += request.body
    }
    Created
  }

}