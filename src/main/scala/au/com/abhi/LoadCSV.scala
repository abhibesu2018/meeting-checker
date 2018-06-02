package au.com.abhi

import scala.io.Source
import java.io.InputStream
import scala.collection.mutable.ArrayBuffer

object LoadCSV {
  //  println("timestamp| x| y| floor|uid")
  val uidMaps = scala.collection.mutable.Map[String, ArrayBuffer[String]]()
  val inputStream: InputStream = getClass.getResourceAsStream("/meeting-checker.csv")
  for (line <- Source.fromInputStream(inputStream).getLines.drop(1)) {
    val cols = line.split(",").map(_.trim)
    //println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}|${cols(4)}")
    var valuesUid = ArrayBuffer[String]()
    valuesUid += s"${cols(0)}"
    valuesUid += s"${cols(1)}"
    valuesUid += s"${cols(2)}"
    valuesUid += s"${cols(3)}"
    uidMaps += (s"${cols(4)}" -> valuesUid)
  }
  /*val arrayBuffer = uidMaps.get("600dfbe2") match {
    case None => "There is no UID exists"
    case Some(a: ArrayBuffer[String]) => println(a(2))
  }*/
  inputStream.close
}

object TestCSV {
  def main(args: Array[String]): Unit = {
    LoadCSV
  }
}