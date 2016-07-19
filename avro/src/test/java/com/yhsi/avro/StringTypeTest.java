package com.yhsi.avro;

import com.yshi.avro.TestRecord;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificDatumWriter;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class StringTypeTest {

  private Schema schema;

  @BeforeClass
  public void setUp() {
    schema = TestRecord.getClassSchema();
  }

  @Test
  public void testDeepCopy() throws IOException {
    TestRecord campaign = TestRecord.newBuilder().
        setRecordId("test102").
        build();

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
    DatumWriter<TestRecord> datumWriter = new SpecificDatumWriter<TestRecord>(schema);
    datumWriter.write(campaign, encoder);
    encoder.flush();

    Schema.Parser parser = new Schema.Parser();
    Schema fromParser = parser.parse(
        this.getClass().getClassLoader().getResourceAsStream("TestRecord.avsc"));
    Schema classSchema = TestRecord.getClassSchema();

    ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
    Decoder decoder = DecoderFactory.get().binaryDecoder(in, null);
    GenericDatumReader<GenericRecord> reader
        = new GenericDatumReader<GenericRecord>(fromParser);
    GenericRecord recordFromReader = reader.read(null, decoder);

    TestRecord recordFromDeepCopy = (TestRecord) SpecificData.get().deepCopy(
        TestRecord.getClassSchema(), recordFromReader);

    Assert.assertEquals(recordFromDeepCopy, campaign);
  }
}
