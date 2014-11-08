/**
* Created by basar.ozenboy on 08.11.2014.
*/

class IyteImmutableList
{
  var aImMutableList : List[Int] = IyteImmutableList.ImMutableList   // constructs an empty list!

  def add(x: Int): List[Int] =
  {
    aImMutableList :+ x
//    aImMutableList ::: List(x)
  }

  def toStringL: String =
  {
    var resultStr = "";
    for (i <- (0 to aImMutableList.length - 1)) {
      resultStr = resultStr + aImMutableList(i);
      resultStr = resultStr + ",";
    }
    resultStr = resultStr.dropRight(1)
    println(resultStr)
    return resultStr
  }

  override def toString(): String = {
    toStringL
  }
}

object IyteImmutableList
{
  var ImMutableList : List[Int] = Nil   // constructs an empty list!
}
