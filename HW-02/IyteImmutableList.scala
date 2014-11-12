/**
* Created by basar.ozenboy on 08.11.2014.
*/

class IyteImmutableList
{
  var aImMutableList : Array[Int] = IyteImmutableList.ImMutableList   // constructs an empty list!

  def add(x: Int): Array[Int] =
  {
    val tmpArr = Array(x)
    return Array.concat(aImMutableList,tmpArr)
  }

  private def toStringL: String =
  {
    val resultStr = "";
    println(aImMutableList.mkString(","))
    return resultStr
  }

  override def toString(): String = {
    toStringL
  }
}

object IyteImmutableList
{
  var ImMutableList = new Array[Int](0)  // constructs an empty list!
}
