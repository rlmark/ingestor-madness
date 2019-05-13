import cats.Traverse
import cats.effect._
import cats.temp.par.Par
import cats.implicits._

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = program[IO]

  def program[F[_] : Sync : ConcurrentEffect : ContextShift : Timer : Par]: F[ExitCode] = {
    val res = new JobRunner[F].result
    for {
      r <- res
      _ = println(r)
    } yield ExitCode.Success
  }
}
