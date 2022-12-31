object Day6 extends App{

  val input = InputHelper.getInput(6,false).toList

  val zod = input foreach { i =>
//    part1
//    val min = 4
    
//    part2
    val min = 14

    val zod = i.zipWithIndex.filter { case (_, idx) =>
      i.slice(idx, idx + min).distinct.length >= min
    }.map(a => a._2 + min).head

    println(zod)
  }


}
