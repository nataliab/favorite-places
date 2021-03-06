/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.0.1-dev
 * apidoc:0.11.25 http://www.apidoc.me/natalia/favorite-places/0.0.1-dev/play_2_x_json
 */
package natalia.favorite.places.v0.models {

/**
 * Describes a place
 */
case class Place(
                  id: String,
                  name: String,
                  imageUrl: String
                  )

}

package natalia.favorite.places.v0.models {

package object json {
  import play.api.libs.json.__
  import play.api.libs.json.JsString
  import play.api.libs.json.Writes
  import play.api.libs.functional.syntax._
  import natalia.favorite.places.v0.models.json._

  private[v0] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

  private[v0] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
    def writes(x: java.util.UUID) = JsString(x.toString)
  }

  private[v0] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
    import org.joda.time.format.ISODateTimeFormat.dateTimeParser
    dateTimeParser.parseDateTime(str)
  }

  private[v0] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
    def writes(x: org.joda.time.DateTime) = {
      import org.joda.time.format.ISODateTimeFormat.dateTime
      val str = dateTime.print(x)
      JsString(str)
    }
  }

  implicit def jsonReadsFavoritePlacesPlace: play.api.libs.json.Reads[Place] = {
    (
      (__ \ "id").read[String] and
        (__ \ "name").read[String] and
        (__ \ "imageUrl").read[String]
      )(Place.apply _)
  }

  def jsObjectPlace(obj: natalia.favorite.places.v0.models.Place) = {
    play.api.libs.json.Json.obj(
      "id" -> play.api.libs.json.JsString(obj.id),
      "name" -> play.api.libs.json.JsString(obj.name),
      "imageUrl" -> play.api.libs.json.JsString(obj.imageUrl)
    )
  }

  implicit def jsonWritesFavoritePlacesPlace: play.api.libs.json.Writes[Place] = {
    new play.api.libs.json.Writes[natalia.favorite.places.v0.models.Place] {
      def writes(obj: natalia.favorite.places.v0.models.Place) = {
        jsObjectPlace(obj)
      }
    }
  }
}
}

package natalia.favorite.places.v0 {

object Bindables {

  import play.api.mvc.{PathBindable, QueryStringBindable}
  import org.joda.time.{DateTime, LocalDate}
  import org.joda.time.format.ISODateTimeFormat
  import natalia.favorite.places.v0.models._

  // Type: date-time-iso8601
  implicit val pathBindableTypeDateTimeIso8601 = new PathBindable.Parsing[org.joda.time.DateTime](
    ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: _root_.java.lang.Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
  )

  implicit val queryStringBindableTypeDateTimeIso8601 = new QueryStringBindable.Parsing[org.joda.time.DateTime](
    ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: _root_.java.lang.Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
  )

  // Type: date-iso8601
  implicit val pathBindableTypeDateIso8601 = new PathBindable.Parsing[org.joda.time.LocalDate](
    ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: _root_.java.lang.Exception) => s"Error parsing date $key. Example: 2014-04-29"
  )

  implicit val queryStringBindableTypeDateIso8601 = new QueryStringBindable.Parsing[org.joda.time.LocalDate](
    ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: _root_.java.lang.Exception) => s"Error parsing date $key. Example: 2014-04-29"
  )



}

}