package au.com.abhi

import scala.collection.mutable.ArrayBuffer

object MeetingCheck {

  def main(args: Array[String]): Unit = {
    if (!(checkIfUIDExists(args(0)) && checkIfUIDExists(args(1)))) {
      println("The UID doesnot exist!!")
      exitFromProgram
    }

    val firstUidDetails: ArrayBuffer[String] = LoadCSV.uidMaps.get(args(0)).get
    val secondUidDetails: ArrayBuffer[String] = LoadCSV.uidMaps.get(args(1)).get

    if (MeetingConditionChecker.findFloorDiff(firstUidDetails(3).toInt, secondUidDetails(3).toInt)) {
      println("The floor is different!!")
      exitFromProgram
    }

    if (MeetingConditionChecker.findTimeStampDiff(firstUidDetails(0), secondUidDetails(0))) {
      println("The timestamp is different!!")
      exitFromProgram
    }

    if (MeetingConditionChecker.findXDistance(firstUidDetails(1).toDouble, secondUidDetails(1).toDouble)) {
      println("The X is far away!!")
      exitFromProgram
    }

    if (MeetingConditionChecker.findYDistance(firstUidDetails(2).toDouble, secondUidDetails(2).toDouble)) {
      println("The Y is far away!!")
      exitFromProgram
    }

    println("The UIDs are meeting!!")
  }

  def checkIfUIDExists(uID: String): Boolean = {
    var checkIfUIDExists = false
    val uidDetails = LoadCSV.uidMaps.get(uID) match {
      case None => false
      case _ => checkIfUIDExists = true
    }
    checkIfUIDExists
  }

  def exitFromProgram() {

  }

}