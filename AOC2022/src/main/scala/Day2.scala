import scala.util.{Failure, Success, Try}

object Day2 extends App {

  val won = Map("A" -> "Y", "B" -> "Z", "C" -> "X")
//  val draw = Map("A" -> "X", "B" -> "Y", "C" -> "Z")
  val score2 = Map("X" -> 1, "Y" -> 2, "Z" -> 3)
  val score = Map("A" -> 1, "B" -> 2, "C" -> 3)
  val draw = Map("A" -> "X", "B" -> "Y", "C" -> "Z")
  val lose = Map("A" -> "Y", "B" -> "Z", "C" -> "X") //matatalo sa
  val win = Map("A" -> "Z", "B" -> "X", "C" -> "Y") //matatalo ang

  val input = InputHelper.getInput(2,false)
  val phil = input.map { i =>
    val str  = i.split(' ')
    val opponent = str.head
    val you = str.last

//    part 1
//    (opponent, you) match {
//      case (o, y) if won(o) == y => score(y) + 6 //won
//      case (o, y) if draw(o) == y => score(y) + 3 //draw
//      case (_, y) => score(y) + 0 //lose
//    }

//    part 2
    (opponent, you) match {
      case (o, y) if y == "X" => println(score2(win(o)) + 0); score2(win(o)) + 0 //lose
      case (o, y) if y == "Y" => println(score2(draw(o)) + 3); score2(draw(o)) + 3 //draw
      case (o, y) if y == "Z" => println(score2(lose(o)) + 6); score2(lose(o)) + 6 //win
      case _ => 0
    }
  }

  println(phil.toList.sum)

//  println(phil.toList.sum)
//  13143
//  pt2 12732 too high
}


