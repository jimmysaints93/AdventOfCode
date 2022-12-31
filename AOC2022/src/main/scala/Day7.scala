import scala.util.{Failure, Success, Try}

object Day7 extends App {

  val input = InputHelper.getInput(7,true).toList

  input.foldLeft(List[String]()){ case (acc, i) =>
//    i match {
//      case "\t" =>
//    }

//    println(i.split("  ").toList.last, i.split("  ").size-1)
//    println(i.split("  ").toList.mkString("t"), i.split("  ").size-1)
    val level = i.split("  ").size-1


    print(acc)

    acc
  }

  def loop(input: String, acc: List[AnyVal]) = {
    val level = input.split("  ").length - 1
    
  }

}


