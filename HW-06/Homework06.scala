/**
 * Created by basar.ozenboy on 10.12.2014.
 */

case class User(name: String, email: String, grade: Int)
trait UserManagerTrait {
  def add(name: String, email: String, grade: Int) : Option[User]
  def getUser(email: String) : Option[User]
  def getUserListForGrade(grade: Int) : List[User]
  def getCertainGrades(gradeSelector: (Int) => Boolean): List[String]
}
object UserManager extends UserManagerTrait {
  // Put your implementation here!
  var UserList: List[User] = List()


  def tryExceptListString( op: => List[String] ): List[String] =
  {
    try {
      op
    }
    catch {
      case e: Exception => return List()
    }
  }

  def tryExceptListUser( op: => List[User]  ):List[User] =
  {
    try {
      op
    }
    catch {
      case e: Exception => return List()
    }
  }

  def tryExceptNone( op: => Option[User] ): Option[User] =
  {
    try {
      op
    }
    catch {
      case e: Exception => return None
    }
  }

  def add(name: String, email: String, grade: Int): Option[User] =
  {
    tryExceptNone {
      if (UserList.find(aUser => aUser.email == email) == None) {
        val tmpUser = User(name, email, grade)
        UserList = UserList :+ tmpUser
        return Option(tmpUser)
      }
      else
        return None
    }
  }

  def getUser(email: String): Option[User] =
  {
    tryExceptNone {
      val aUser = UserList.find(aUser => aUser.email == email)
      return aUser
//      if (aUser == None)
//        return None
//      else
//        return aUser
    }
  }

  def getCertainGrades(gradeSelector: (Int) => Boolean): List[String] =
  {
    var tmpUserList: List[User] = List()
    var resList: List[String] = List()
    tryExceptListString{
      tmpUserList = UserList.filter(s => gradeSelector(s.grade))
      for (i <- 0 to tmpUserList.length - 1) {
        resList = resList :+ tmpUserList(i).name
      }
      return resList
    }
  }

  def getUserListForGrade(grade: Int): List[User] =
  {
    tryExceptListUser {
      val aUserMap: Map[Int, List[User]] = UserList.groupBy(aUser => aUser.grade).map(aMap => (aMap._1, aMap._2.map(aUser => aUser)))
      aUserMap(grade)
    }
  }
}