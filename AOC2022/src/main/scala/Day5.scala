import scala.collection.mutable
import scala.collection.mutable._

object Day5 extends App {

  val input = InputHelper.getInput(5,true).toList

  val counter = input.filter(_.startsWith(" 1"))

  val stax = counter.last.last.toString.toInt

  val zz = (1 to stax).foldLeft(List[Int](), 1) { case ((acc, in), n) =>
    if (n == 1) (acc :+ in, in) else (acc :+ (in + 4), in + 4)
  }

  val indexes = zz._1.map(_+0)

  val stacks: List[mutable.Stack[String]] = (1 to stax).map(_ => new Stack[String]()).toList


  val zod = input.indexWhere(_.startsWith(" 1"))
  (0 until zod) foreach { inputIndex =>
    indexes.zipWithIndex foreach { case (crateIndex, stackIndex) =>
      input(zod-inputIndex-1).toList.lift(crateIndex) match {
        case Some(' ') => ""
        case Some(crate) => stacks(stackIndex).push(crate.toString)
        case None => ""
      }
    }
  }

//  stacks.foreach(println)

//  val one: mutable.Stack[String] = Stack("N", "Z")
//  val two = Stack("D", "C", "M")
//  val three = Stack("P")
//  val listz = List(one, two, three)
//
//
//  val instructions = List(
//    "move 1 from 2 to 1",
//    "move 3 from 1 to 3",
//    "move 2 from 2 to 1",
//    "move 1 from 1 to 2"
//  )

  val instructions = input.slice(stax+1, input.length)

//  part1
//  val cleaner: String => String = _.replace("move ", "").replace("from ", "").replace("to ", "")
//  instructions.map(cleaner) foreach { instruction =>
//    val (count, from, to) = instruction.split(" ") match {
//      case Array(c, f, t) => (c.toInt, f.toInt-1, t.toInt-1)
//    }
//    (1 to count) foreach { i =>
//      val popped = stacks(from).pop
//      stacks(to).push(popped)
//    }
//  }

//  part2
  val cleaner: String => String = _.replace("move ", "").replace("from ", "").replace("to ", "")
  instructions.map(cleaner) foreach { instruction =>
    val (count, from, to) = instruction.split(" ") match {
      case Array(c, f, t) => (c.toInt, f.toInt - 1, t.toInt - 1)
    }
    val orderedPopped = (1 to count) map { i =>
      stacks(from).pop
    }
    orderedPopped.toList.reverse.foreach(stacks(to).push)
  }





  stacks.map(_.head).foreach(print)

}
