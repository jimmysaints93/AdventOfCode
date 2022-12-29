object Day4 extends App {

  val input = InputHelper.getInput(4,false)
//part1
//  val zz = input.map(_.split(",").map { pair =>
//    val aa = pair.split("-").toList
//    aa.head.toInt to aa.last.toInt
//  }.toList).toList map { case x @ (part1 :: part2 :: Nil) =>
////    val part1 = x.head //(6 to 6)
////    val part2 = x.last //(4 to 6)
//    val intersection = part1 intersect part2
//
//    x.map { a =>
//      if (a == intersection) true else false
//    }.reduce(_ | _)
//  }

//part2
  val zz = input.map(_.split(",").map { pair =>
    val aa = pair.split("-").toList
    aa.head.toInt to aa.last.toInt
  }.toList).toList map { case x@(part1 :: part2 :: Nil) =>
    val intersection = part1 intersect part2

    x.map { a =>
      if (intersection.nonEmpty) true else false
    }.reduce(_ | _)
  }


  println(zz.count(_ == true))
}
