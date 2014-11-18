/**
 * Created by basar.ozenboy on 12.11.2014.
 */

import util.control.Breaks._

class IyteMutableSet
{
  private var aMutableSet = new Array[Int](0)
  private var aUnOrderedMutableSet = new Array[Int](0)

  def add(x: Int): IyteMutableSet =
  {
    val tmpImMutableSet = new IyteMutableSet()
    if  (contains(x) != true)
    {
      aMutableSet = addArrayWithOrder(aMutableSet,x)
      aUnOrderedMutableSet = (Array.concat(aUnOrderedMutableSet,Array(x)));;
    }
    return this
  }

  def addArrayWithOrder(aArary: Array[Int],IntX: Int): Array[Int] =
  {
    val i = 0
    val j = 0
    var newArrItemIndex = 0
    val newArrLength = aArary.length + 1

    val newArr = new Array[Int](newArrLength)

    if (aArary.length == 0 )
    {
      newArr(newArrItemIndex) = IntX;
      newArrItemIndex = newArrItemIndex + 1;
    }
    else
    {
      breakable {
        for (i <- 0 to (aArary.length - 1))
        {
          if (aArary(i) < IntX) {
            newArr(newArrItemIndex) = aArary(i);
            newArrItemIndex = newArrItemIndex + 1;
            if (i == (aArary.length - 1)) {
              newArr(newArrItemIndex) = IntX;
              newArrItemIndex = newArrItemIndex + 1;
            }
          }
          else
          if (aArary(i) > IntX) {
            newArr(newArrItemIndex) = IntX;
            newArrItemIndex = newArrItemIndex + 1;
            for (j <- i to (aArary.length - 1)) {
              newArr(newArrItemIndex) = aArary(j);
              newArrItemIndex = newArrItemIndex + 1;
            }
            break();
          }
          else
          if (aArary(i) == IntX) {
            newArr(newArrItemIndex) = aArary(i);
            newArrItemIndex = newArrItemIndex + 1;
            for (j <- i + 1 to (aArary.length - 1)) {
              newArr(newArrItemIndex) = aArary(j);
              newArrItemIndex = newArrItemIndex + 1;
            }
            break();
          }
        }
      }
    }
    aMutableSet = newArr
    return aMutableSet
  }

  def contains(x: Int): Boolean =
  {
    return searchElement(aMutableSet,x) > -1
  }

  def searchElement(aArary: Array[Int], Element: Int): Int = {
    var left = 0
    var right = aArary.length-1
    while (left<=right)
    {
      val mid = left + (right - left) / 2

      if (aArary(mid) == Element)
        return mid
      else
      if (aArary(mid) > Element)
        right = mid-1
      else
        left = mid+1
    }
    return -1
  }

  private def toStringL: String =
  {
    val resultStr = "";
    println(aUnOrderedMutableSet.mkString(","))
    return resultStr
  }

  override def toString(): String = {
    toStringL
    //    aUnOrderedMutableSet.mkString(",")
  }
}

object IyteMutableSet
{
  def apply() = new IyteMutableSet()
}
