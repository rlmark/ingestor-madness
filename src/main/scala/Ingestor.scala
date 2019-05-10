import cats.Applicative

// Here we have 2 implementations for the Ingestor trait.
// They read from different sources create a subtype of a DataBag
trait Ingestor[F[_], O] {
  def read(): F[Vector[O]]
  //  def read(): F[O] // Attempt 2
}

class StringIngestorImpl[F[_]: Applicative] extends Ingestor[F, StringBag] {
  // Imagine that this gets a bunch of data
  override def read(): F[Vector[StringBag]] = Applicative[F].pure(Vector(StringBag("HI")))
}

class NumberIngestorImpl[F[_]: Applicative] extends Ingestor[F, NumberBag] {
  override def read(): F[Vector[NumberBag]] = Applicative[F].pure(Vector(NumberBag(9)))
}
