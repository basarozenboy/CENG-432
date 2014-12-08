/**
 * Created by basar.ozenboy on 03.12.2014.
 */

trait RandomStuffTrait {
  def transform(list: List[Int], op: (Int) => Int) : List[Int]
  def allValid(list: List[Int], op: (Int) => Boolean) : Boolean
  def executeWithRetry(retryCount: Int, op: => Int) : Option[Int]
}

object RandomStuff extends RandomStuffTrait {

  case class RetryObj(var IntValue: Int, var BoolValue: Boolean)

  def transform(list: List[Int], op: (Int) => Int): List[Int] =
  {
    var newList: List[Int] = List()
    var tmpI: Int = 0
    for(i <- 0 to list.length - 1)
    {
      tmpI = op(list(i))
      newList = insert(tmpI ,newList)
    }
    return newList
  }

  private def insert(x: Int, xs: List[Int]): List[Int] = {
    xs:+ x
  }

  def executeWithRetry(retryCount: Int, op: => Int): Option[Int] =
  {
    var tmpRetryObj = tryCatchOp(op)
    if (tmpRetryObj.BoolValue == true)
      return Option(tmpRetryObj.IntValue)
    else
    {
      for(i <- 0 to retryCount - 1)
      {
        tmpRetryObj = tryCatchOp(op)
        if (tmpRetryObj.BoolValue == true)
          return Option(tmpRetryObj.IntValue)
      }
        return None
    }
  }

  def tryCatchOp( op: => Int ): RetryObj =
  {
    var aReturnValue = RetryObj(0, false)
    try {
      aReturnValue.IntValue = op
      aReturnValue.BoolValue = true
      return aReturnValue
    }
    catch {
      case e: Exception =>
        aReturnValue.IntValue = 0
        aReturnValue.BoolValue = false
        return aReturnValue
    }
  }

  def allValid(list: List[Int], op: (Int) => Boolean): Boolean =
  {
    var tmpResult: Boolean = true
    try
    {
      for(i <- 0 to list.length - 1) {
        tmpResult = op(list(i))
        if(tmpResult == false)
          return false
      }
      return tmpResult
    }
    catch
    {
      case e: Exception => return false
    }
  }
}
