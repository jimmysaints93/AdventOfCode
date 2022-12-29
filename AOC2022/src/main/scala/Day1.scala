import scala.io.Source

object Day1 extends App {

  val input = InputHelper.getInput(1,false)
  val zzz = input.foldLeft((0, 0, 0), 0, 0, 0) { case ((max, acc, ctr, maxCtr), i) =>
    if (i == "") {
      if (acc > max._1 || acc > max._2 || acc > max._3) {
        val sorted = List(acc, max._1, max._2, max._3).sorted.reverse
        val newMax = (sorted.head, sorted(1), sorted(2))
        (newMax, 0, ctr+1, ctr)
      } else
        (max, 0, ctr+1, maxCtr)
    } else {
      val a = (max, acc + i.trim.toInt, ctr, maxCtr)
      println(a)
      a
    }
  }

  val ((max1, max2, max3), acc, ctr, maxCtr) = zzz

//  val zoink = if (max3 > acc) (max3, maxCtr) else (acc, ctr)
  val zoink = if (max3 > acc) max3 else acc
  val sum = max1 + max2 + zoink


  println(zzz)
  println(sum)
}
