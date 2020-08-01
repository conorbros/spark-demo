import scala.util.Random
import java.io.PrintStream

object SeqDemo {

  def time[T](descr: String)(f: => T): T = {
    val start = System.nanoTime
    val r     = f
    val end   = System.nanoTime
    val time  = (end - start) / 1e6
    println(descr + ": = " + time + "ms\n")
    r
  }

  def matrix_multiply(a: Array[Array[Int]], b: Array[Array[Int]], c: Array[Array[Int]], n: Int): Array[Array[Int]] = {
    for(i <- 0 to n-1){
      for(j <- 0 to n-1){
        c(i)(j) = a(i)(j) * b(i)(j);
      }
    }
    return c
  }

  def main(args: Array[String]){

    val r = new Random(42);

    val n = args(0).toInt;

    val matrix_a = Array.ofDim[Int](n, n);
    val matrix_b = Array.ofDim[Int](n, n);
    var matrix_c = Array.ofDim[Int](n, n);

    for(i <- 0 to n-1){
      for(j <- 0 to n-1){
        matrix_a(i)(j) = r.nextInt();
        matrix_b(i)(j) = r.nextInt();
      }
    }

    matrix_c = time("\nMatrix Multiply")(matrix_multiply(matrix_a, matrix_b, matrix_c, n));
  }
}
