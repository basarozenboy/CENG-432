/**
* Created by basar.ozenboy on 08.11.2014.
*/

class IyteImmutableList
{
//  var aImMutableList : Array[Int] = IyteImmutableList.ImMutableList   // constructs an empty list!

  var aImMutableList = new Array[Int](0)

  def add(x: Int):IyteImmutableList =
  {
    val tmpArr = Array(x)
    val tmpIyteImmutableList = new IyteImmutableList();
    tmpIyteImmutableList.aImMutableList = (Array.concat(tmpArr,aImMutableList));
    return tmpIyteImmutableList
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
//  var ImMutableList = new Array[Int](0)  // constructs an empty list!
  def apply() = new IyteImmutableList()
}
