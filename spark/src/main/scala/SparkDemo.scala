import org.apache.spark._
import org.apache.spark.mllib.linalg.{Vector}
import org.apache.spark.mllib.linalg.distributed.{RowMatrix}
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.random.RandomRDDs

object SparkDemo {
  import Util._

  def main(args: Array[String]){

    val conf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("SquareMatrixMultiply")

    val sc = new SparkContext(conf)

    val n = args(0).toInt

    val dm  = randomDenseMatrix(n, n)
    val dv = toDensityVector(dm)
    val rdd: RDD[Vector] = sc.parallelize(dv)

    val b  = randomDenseMatrix(n, n) // This matrix exists in local memory
    val a = new RowMatrix(rdd, n, n) // This matrix is an RDD

    // Multiply A by B
    val resultRDD = time("\n\n\nMatrix Multiply")(a.multiply(b))
  }
}
