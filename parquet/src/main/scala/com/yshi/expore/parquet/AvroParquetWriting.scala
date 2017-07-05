package com.yshi.explore.parquet

import parquet.avro.AvroParquetOutputFormat

object AvroParquetWriting {
  def main(args: Array[String]): Unit = {
    val of = new AvroParquetOutputFormat[String]
    println("Hello, world!")
  }
}
