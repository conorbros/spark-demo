import org.apache.spark.sql.SparkSession

object SparkDemo {
  def main(args: Array[String]){
    val logFile = "/opt/spark/README.md"

    val spark = SparkSession.builder.appName("Spark Demo").config("spark.master", "local").getOrCreate()

    val logData = spark.read.textFile(logFile).cache()

    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()

    println(s"Lines with a: $numAs, Lines with b: $numBs")

    spark.stop()
  }
}