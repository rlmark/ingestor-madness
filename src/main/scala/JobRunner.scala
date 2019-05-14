import cats.{Monad, Traverse}
import cats.implicits._
import cats.temp.par._
import cats.instances._
import cats.syntax._

class JobRunner[F[_]: Monad: Par ] {
  val stringIngestor: Ingestor[F, StringBag] = new StringIngestorImpl[F]
  val numberIngestor: Ingestor[F, NumberBag] = new NumberIngestorImpl[F]

  // This is the actual "business logic." Take all the data ingestors,
  // and call their read functions in parallel to get a collection of their respective DataBag types
  val dataPipes: Seq[Ingestor[F, _ >:  DataBag]] = Vector(stringIngestor, numberIngestor)

//  val result: F[Vector[Vector[DataBag]]] = dataPipes.parTraverse(d => d.read())
  val result: F[Vector[Vector[DataBag]]] = dataPipes.parTraverse((i: Ingestor[F, _ >:  DataBag]) => i.read())
}
