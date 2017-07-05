package com.yhsi.avro;

import com.yshi.avro.Avro1927;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;

public class Avro1927Test {

  @Test
  public void testNullable() throws Exception {
    Avro1927 testObj = Avro1927.newBuilder().setMyField(null).build();
    Assert.assertNull(testObj.getMyField());

    ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
    Encoder encoder = EncoderFactory.get().binaryEncoder(os, null);
    SpecificDatumWriter<Avro1927> writer = new SpecificDatumWriter<Avro1927>(Avro1927.getClassSchema());
    writer.write(testObj, encoder);
  }
}
