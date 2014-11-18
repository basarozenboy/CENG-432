/**
* Created by basar.ozenboy on 08.11.2014.
*/

class IyteMutableList
{
//  var aMutableList : Array[Int] = IyteMutableList.MutableList

  var aMutableList = new Array[Int](0)

  def add(x: Int): IyteMutableList =
  {
    val tmpArr = Array(x)
    aMutableList = Array.concat(aMutableList,tmpArr)
    return this
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
//  var MutableList = new Array[Int](0) // constructs an empty array!
  def apply() = new IyteMutableList()
}

