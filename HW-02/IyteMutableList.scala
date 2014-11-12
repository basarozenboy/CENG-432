import jdk.nashorn.internal.ir.LiteralNode.ArrayLiteralNode.ArrayUnit

/**
* Created by basar.ozenboy on 08.11.2014.
*/

class IyteMutableList
{
  var aMutableList : Array[Int] = IyteMutableList.MutableList

  def add(x: Int): Array[Int] =
  {
    val tmpArr = Array(x)
    aMutableList = Array.concat(aMutableList,tmpArr)
    return aMutableList
  }

  private def toStringL: String =
  {
    val resultStr = "";
    println(aMutableList.mkString(","))
    return resultStr
  }

  override def toString(): String = {
    toStringL
  }
}

object IyteMutableList
{
  var MutableList = new Array[Int](0) // constructs an empty array!
}

