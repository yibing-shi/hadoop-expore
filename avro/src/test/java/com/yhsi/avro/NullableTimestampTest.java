package com.yhsi.avro;

import com.yshi.avro.NullableTimestamp;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;

public class NullableTimestampTest {

  @Test
  public void testNullableTimestamp() throws Exception {
    final DateTime dt = DateTime.parse("2016-07-29T10:15:30.00Z");
    NullableTimestamp orgRecord = NullableTimestamp.newBuilder().setFirst(dt).build();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
    Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
    DatumWriter<NullableTimestamp> writer
        = new SpecificDatumWriter<NullableTimestamp>(NullableTimestamp.getClassSchema());
    writer.write(orgRecord, encoder);
  }
}
