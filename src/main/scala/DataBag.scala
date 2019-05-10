sealed trait DataBag

case class StringBag(s: String) extends DataBag

case class NumberBag(i: Int) extends DataBag
