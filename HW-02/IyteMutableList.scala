/**
* Created by basar.ozenboy on 08.11.2014.
*/

class IyteMutableList
{
  var aMutableList : List[Int] = IyteMutableList.MutableList   // constructs an empty list!

  def add(x: Int): List[Int] =
  {
    aMutableList = aMutableList :+ x
    return aMutableList
  }

  def toStringL: String =
  {
    var resultStr = "";
    for (i <- (0 to aMutableList.length - 1)) {
      resultStr = resultStr + aMutableList(i);
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

object IyteMutableList
{
  var MutableList : List[Int] = Nil   // constructs an empty list!
}

