/**
 * Created by basar.ozenboy on 01.11.2014.
 */

object simple {
  def main(args: Array[String]) =
  {
    val multArray = (A: Array[Integer]) =>
    {
      for (int <- A)
      {
        if ((int % 2) == 0)
          println(int * 2)
        else
          println(int * 3)
      }
    }
    val intArray:Array[Integer] = Array(10, 25, 30)
    multArray(intArray)
  }
}