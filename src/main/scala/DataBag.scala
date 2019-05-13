sealed trait DataBag extends Product with Serializable

case class StringBag(s: String) extends DataBag

case class NumberBag(i: Int) extends DataBag
