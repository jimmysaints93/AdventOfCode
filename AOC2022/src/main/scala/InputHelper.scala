import scala.io.Source

object InputHelper {

  def getInput(day: Int, isDemo: Boolean): Iterator[String] = {
    val path: Int => String = day => if (isDemo) s"src/main/resources/demo/day${day}.txt" else s"src/main/resources/day${day}.txt"
    val bufferedSource = Source.fromFile(path(day))
    bufferedSource.getLines().map(a => a)
  }


}
