object Day3 extends App {

  val az = (('a' to 'z') ++ ('A' to 'Z')).zipWithIndex.map {
    case (k,v) => Map(k -> (v+1))
  }.reduce(_++_)


  val input = InputHelper.getInput(3,false)
//  part1
//  val values = input map  { i =>
//    val size = i.length / 2
//    val part1 = i.substring(0, size)
//    val part2 = i.substring(size, i.length)
//
//
//    val intersection = part1.intersect(part2)
//    println(intersection.toCharArray.head)
//    az(intersection.toCharArray.head)
////    println(part1, part2, intersection.distinct)
//
//  }

//  part2
    val values = input.grouped(3).toList.map(b =>
    b.foldLeft("") { case (acc, a) =>
      val seed = if (acc.isEmpty) a else acc
      seed.intersect(a)
    }).map { l => az(l.toCharArray.head) }
    println(values.sum)


}
