package com.yhsi.avro;

import org.apache.avro.Schema;
import org.apache.avro.SchemaValidationException;
import org.apache.avro.SchemaValidator;
import org.apache.avro.SchemaValidatorBuilder;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ValidatorTest {

  @Test(expectedExceptions = SchemaValidationException.class)
  public void testUnionBackwardsCompatibility() throws SchemaValidationException {
    final SchemaValidator backwardValidator = new SchemaValidatorBuilder().canReadStrategy().validateLatest();

    final Schema schema1 = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"rec1\",\"fields\":[{\"name\":\"age\",\"type\":\"long\"}]}");
    final Schema schema2 = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"rec1\",\"fields\":[{\"name\":\"age\",\"type\":\"long\"}, {\"name\":\"address\",\"type\":\"string\"}]}");

    backwardValidator.validate(schema2, Arrays.asList(schema1));
  }

  @Test(expectedExceptions = SchemaValidationException.class)
  public void testUnionBackwardsCompatibility2() throws SchemaValidationException {

    final SchemaValidator backwardValidator = new SchemaValidatorBuilder().canReadStrategy().validateLatest();
    final Schema schema1 = new Schema.Parser().parse("[{\"type\":\"record\",\"name\":\"rec1\",\"fields\":[{\"name\":\"age\",\"type\":\"long\"}]}]");
    final Schema schema2 = new Schema.Parser().parse("[{\"type\":\"record\",\"name\":\"rec1\",\"fields\":[{\"name\":\"age\",\"type\":\"long\"},{\"name\":\"address\",\"type\":\"string\"}]}]");

    backwardValidator.validate(schema2, Arrays.asList(schema1));
  }
}
