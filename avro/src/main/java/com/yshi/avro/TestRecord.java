/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.yshi.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class TestRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6508768456554304163L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TestRecord\",\"namespace\":\"com.yshi.avro\",\"fields\":[{\"name\":\"recordId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"boolField\",\"type\":\"boolean\",\"default\":true},{\"name\":\"longField\",\"type\":\"long\",\"default\":-1},{\"name\":\"intField\",\"type\":\"int\",\"default\":1},{\"name\":\"floatField\",\"type\":\"float\",\"default\":1.1},{\"name\":\"doubleField\",\"type\":\"double\",\"default\":2.2},{\"name\":\"bytesField\",\"type\":\"bytes\",\"default\":\"\\u0001\\u0002\\u0003\"},{\"name\":\"dateField\",\"type\":{\"type\":\"int\",\"logicalType\":\"date\"},\"default\":16801},{\"name\":\"timeField\",\"type\":{\"type\":\"int\",\"logicalType\":\"time-millis\"},\"default\":46800000},{\"name\":\"tsField\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"},\"default\":1451606400000},{\"name\":\"decField\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":7,\"scale\":2},\"default\":\"09\"},{\"name\":\"intArrayField\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"dateArrayField\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"int\",\"logicalType\":\"date\"}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String recordId;
  @Deprecated public boolean boolField;
  @Deprecated public long longField;
  @Deprecated public int intField;
  @Deprecated public float floatField;
  @Deprecated public double doubleField;
  @Deprecated public java.nio.ByteBuffer bytesField;
  @Deprecated public org.joda.time.LocalDate dateField;
  @Deprecated public org.joda.time.LocalTime timeField;
  @Deprecated public org.joda.time.DateTime tsField;
  @Deprecated public java.nio.ByteBuffer decField;
  @Deprecated public java.util.List<java.lang.Integer> intArrayField;
  @Deprecated public java.util.List<org.joda.time.LocalDate> dateArrayField;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TestRecord() {}

  /**
   * All-args constructor.
   * @param recordId The new value for recordId
   * @param boolField The new value for boolField
   * @param longField The new value for longField
   * @param intField The new value for intField
   * @param floatField The new value for floatField
   * @param doubleField The new value for doubleField
   * @param bytesField The new value for bytesField
   * @param dateField The new value for dateField
   * @param timeField The new value for timeField
   * @param tsField The new value for tsField
   * @param decField The new value for decField
   * @param intArrayField The new value for intArrayField
   * @param dateArrayField The new value for dateArrayField
   */
  public TestRecord(java.lang.String recordId, java.lang.Boolean boolField, java.lang.Long longField, java.lang.Integer intField, java.lang.Float floatField, java.lang.Double doubleField, java.nio.ByteBuffer bytesField, org.joda.time.LocalDate dateField, org.joda.time.LocalTime timeField, org.joda.time.DateTime tsField, java.nio.ByteBuffer decField, java.util.List<java.lang.Integer> intArrayField, java.util.List<org.joda.time.LocalDate> dateArrayField) {
    this.recordId = recordId;
    this.boolField = boolField;
    this.longField = longField;
    this.intField = intField;
    this.floatField = floatField;
    this.doubleField = doubleField;
    this.bytesField = bytesField;
    this.dateField = dateField;
    this.timeField = timeField;
    this.tsField = tsField;
    this.decField = decField;
    this.intArrayField = intArrayField;
    this.dateArrayField = dateArrayField;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return recordId;
    case 1: return boolField;
    case 2: return longField;
    case 3: return intField;
    case 4: return floatField;
    case 5: return doubleField;
    case 6: return bytesField;
    case 7: return dateField;
    case 8: return timeField;
    case 9: return tsField;
    case 10: return decField;
    case 11: return intArrayField;
    case 12: return dateArrayField;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  protected static final org.apache.avro.data.TimeConversions.DateConversion DATE_CONVERSION = new org.apache.avro.data.TimeConversions.DateConversion();
  protected static final org.apache.avro.data.TimeConversions.TimeConversion TIME_CONVERSION = new org.apache.avro.data.TimeConversions.TimeConversion();
  protected static final org.apache.avro.data.TimeConversions.TimestampConversion TIMESTAMP_CONVERSION = new org.apache.avro.data.TimeConversions.TimestampConversion();

  private final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      DATE_CONVERSION,
      TIME_CONVERSION,
      TIMESTAMP_CONVERSION,
      null,
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: recordId = (java.lang.String)value$; break;
    case 1: boolField = (java.lang.Boolean)value$; break;
    case 2: longField = (java.lang.Long)value$; break;
    case 3: intField = (java.lang.Integer)value$; break;
    case 4: floatField = (java.lang.Float)value$; break;
    case 5: doubleField = (java.lang.Double)value$; break;
    case 6: bytesField = (java.nio.ByteBuffer)value$; break;
    case 7: dateField = (org.joda.time.LocalDate)value$; break;
    case 8: timeField = (org.joda.time.LocalTime)value$; break;
    case 9: tsField = (org.joda.time.DateTime)value$; break;
    case 10: decField = (java.nio.ByteBuffer)value$; break;
    case 11: intArrayField = (java.util.List<java.lang.Integer>)value$; break;
    case 12: dateArrayField = (java.util.List<org.joda.time.LocalDate>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'recordId' field.
   * @return The value of the 'recordId' field.
   */
  public java.lang.String getRecordId() {
    return recordId;
  }

  /**
   * Sets the value of the 'recordId' field.
   * @param value the value to set.
   */
  public void setRecordId(java.lang.String value) {
    this.recordId = value;
  }

  /**
   * Gets the value of the 'boolField' field.
   * @return The value of the 'boolField' field.
   */
  public java.lang.Boolean getBoolField() {
    return boolField;
  }

  /**
   * Sets the value of the 'boolField' field.
   * @param value the value to set.
   */
  public void setBoolField(java.lang.Boolean value) {
    this.boolField = value;
  }

  /**
   * Gets the value of the 'longField' field.
   * @return The value of the 'longField' field.
   */
  public java.lang.Long getLongField() {
    return longField;
  }

  /**
   * Sets the value of the 'longField' field.
   * @param value the value to set.
   */
  public void setLongField(java.lang.Long value) {
    this.longField = value;
  }

  /**
   * Gets the value of the 'intField' field.
   * @return The value of the 'intField' field.
   */
  public java.lang.Integer getIntField() {
    return intField;
  }

  /**
   * Sets the value of the 'intField' field.
   * @param value the value to set.
   */
  public void setIntField(java.lang.Integer value) {
    this.intField = value;
  }

  /**
   * Gets the value of the 'floatField' field.
   * @return The value of the 'floatField' field.
   */
  public java.lang.Float getFloatField() {
    return floatField;
  }

  /**
   * Sets the value of the 'floatField' field.
   * @param value the value to set.
   */
  public void setFloatField(java.lang.Float value) {
    this.floatField = value;
  }

  /**
   * Gets the value of the 'doubleField' field.
   * @return The value of the 'doubleField' field.
   */
  public java.lang.Double getDoubleField() {
    return doubleField;
  }

  /**
   * Sets the value of the 'doubleField' field.
   * @param value the value to set.
   */
  public void setDoubleField(java.lang.Double value) {
    this.doubleField = value;
  }

  /**
   * Gets the value of the 'bytesField' field.
   * @return The value of the 'bytesField' field.
   */
  public java.nio.ByteBuffer getBytesField() {
    return bytesField;
  }

  /**
   * Sets the value of the 'bytesField' field.
   * @param value the value to set.
   */
  public void setBytesField(java.nio.ByteBuffer value) {
    this.bytesField = value;
  }

  /**
   * Gets the value of the 'dateField' field.
   * @return The value of the 'dateField' field.
   */
  public org.joda.time.LocalDate getDateField() {
    return dateField;
  }

  /**
   * Sets the value of the 'dateField' field.
   * @param value the value to set.
   */
  public void setDateField(org.joda.time.LocalDate value) {
    this.dateField = value;
  }

  /**
   * Gets the value of the 'timeField' field.
   * @return The value of the 'timeField' field.
   */
  public org.joda.time.LocalTime getTimeField() {
    return timeField;
  }

  /**
   * Sets the value of the 'timeField' field.
   * @param value the value to set.
   */
  public void setTimeField(org.joda.time.LocalTime value) {
    this.timeField = value;
  }

  /**
   * Gets the value of the 'tsField' field.
   * @return The value of the 'tsField' field.
   */
  public org.joda.time.DateTime getTsField() {
    return tsField;
  }

  /**
   * Sets the value of the 'tsField' field.
   * @param value the value to set.
   */
  public void setTsField(org.joda.time.DateTime value) {
    this.tsField = value;
  }

  /**
   * Gets the value of the 'decField' field.
   * @return The value of the 'decField' field.
   */
  public java.nio.ByteBuffer getDecField() {
    return decField;
  }

  /**
   * Sets the value of the 'decField' field.
   * @param value the value to set.
   */
  public void setDecField(java.nio.ByteBuffer value) {
    this.decField = value;
  }

  /**
   * Gets the value of the 'intArrayField' field.
   * @return The value of the 'intArrayField' field.
   */
  public java.util.List<java.lang.Integer> getIntArrayField() {
    return intArrayField;
  }

  /**
   * Sets the value of the 'intArrayField' field.
   * @param value the value to set.
   */
  public void setIntArrayField(java.util.List<java.lang.Integer> value) {
    this.intArrayField = value;
  }

  /**
   * Gets the value of the 'dateArrayField' field.
   * @return The value of the 'dateArrayField' field.
   */
  public java.util.List<org.joda.time.LocalDate> getDateArrayField() {
    return dateArrayField;
  }

  /**
   * Sets the value of the 'dateArrayField' field.
   * @param value the value to set.
   */
  public void setDateArrayField(java.util.List<org.joda.time.LocalDate> value) {
    this.dateArrayField = value;
  }

  /**
   * Creates a new TestRecord RecordBuilder.
   * @return A new TestRecord RecordBuilder
   */
  public static com.yshi.avro.TestRecord.Builder newBuilder() {
    return new com.yshi.avro.TestRecord.Builder();
  }

  /**
   * Creates a new TestRecord RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TestRecord RecordBuilder
   */
  public static com.yshi.avro.TestRecord.Builder newBuilder(com.yshi.avro.TestRecord.Builder other) {
    return new com.yshi.avro.TestRecord.Builder(other);
  }

  /**
   * Creates a new TestRecord RecordBuilder by copying an existing TestRecord instance.
   * @param other The existing instance to copy.
   * @return A new TestRecord RecordBuilder
   */
  public static com.yshi.avro.TestRecord.Builder newBuilder(com.yshi.avro.TestRecord other) {
    return new com.yshi.avro.TestRecord.Builder(other);
  }

  /**
   * RecordBuilder for TestRecord instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TestRecord>
    implements org.apache.avro.data.RecordBuilder<TestRecord> {

    private java.lang.String recordId;
    private boolean boolField;
    private long longField;
    private int intField;
    private float floatField;
    private double doubleField;
    private java.nio.ByteBuffer bytesField;
    private org.joda.time.LocalDate dateField;
    private org.joda.time.LocalTime timeField;
    private org.joda.time.DateTime tsField;
    private java.nio.ByteBuffer decField;
    private java.util.List<java.lang.Integer> intArrayField;
    private java.util.List<org.joda.time.LocalDate> dateArrayField;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.yshi.avro.TestRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.recordId)) {
        this.recordId = data().deepCopy(fields()[0].schema(), other.recordId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.boolField)) {
        this.boolField = data().deepCopy(fields()[1].schema(), other.boolField);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.longField)) {
        this.longField = data().deepCopy(fields()[2].schema(), other.longField);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.intField)) {
        this.intField = data().deepCopy(fields()[3].schema(), other.intField);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.floatField)) {
        this.floatField = data().deepCopy(fields()[4].schema(), other.floatField);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.doubleField)) {
        this.doubleField = data().deepCopy(fields()[5].schema(), other.doubleField);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.bytesField)) {
        this.bytesField = data().deepCopy(fields()[6].schema(), other.bytesField);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.dateField)) {
        this.dateField = data().deepCopy(fields()[7].schema(), other.dateField);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.timeField)) {
        this.timeField = data().deepCopy(fields()[8].schema(), other.timeField);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.tsField)) {
        this.tsField = data().deepCopy(fields()[9].schema(), other.tsField);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.decField)) {
        this.decField = data().deepCopy(fields()[10].schema(), other.decField);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.intArrayField)) {
        this.intArrayField = data().deepCopy(fields()[11].schema(), other.intArrayField);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.dateArrayField)) {
        this.dateArrayField = data().deepCopy(fields()[12].schema(), other.dateArrayField);
        fieldSetFlags()[12] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing TestRecord instance
     * @param other The existing instance to copy.
     */
    private Builder(com.yshi.avro.TestRecord other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.recordId)) {
        this.recordId = data().deepCopy(fields()[0].schema(), other.recordId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.boolField)) {
        this.boolField = data().deepCopy(fields()[1].schema(), other.boolField);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.longField)) {
        this.longField = data().deepCopy(fields()[2].schema(), other.longField);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.intField)) {
        this.intField = data().deepCopy(fields()[3].schema(), other.intField);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.floatField)) {
        this.floatField = data().deepCopy(fields()[4].schema(), other.floatField);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.doubleField)) {
        this.doubleField = data().deepCopy(fields()[5].schema(), other.doubleField);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.bytesField)) {
        this.bytesField = data().deepCopy(fields()[6].schema(), other.bytesField);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.dateField)) {
        this.dateField = data().deepCopy(fields()[7].schema(), other.dateField);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.timeField)) {
        this.timeField = data().deepCopy(fields()[8].schema(), other.timeField);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.tsField)) {
        this.tsField = data().deepCopy(fields()[9].schema(), other.tsField);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.decField)) {
        this.decField = data().deepCopy(fields()[10].schema(), other.decField);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.intArrayField)) {
        this.intArrayField = data().deepCopy(fields()[11].schema(), other.intArrayField);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.dateArrayField)) {
        this.dateArrayField = data().deepCopy(fields()[12].schema(), other.dateArrayField);
        fieldSetFlags()[12] = true;
      }
    }

    /**
      * Gets the value of the 'recordId' field.
      * @return The value.
      */
    public java.lang.String getRecordId() {
      return recordId;
    }

    /**
      * Sets the value of the 'recordId' field.
      * @param value The value of 'recordId'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setRecordId(java.lang.String value) {
      validate(fields()[0], value);
      this.recordId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'recordId' field has been set.
      * @return True if the 'recordId' field has been set, false otherwise.
      */
    public boolean hasRecordId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'recordId' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearRecordId() {
      recordId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'boolField' field.
      * @return The value.
      */
    public java.lang.Boolean getBoolField() {
      return boolField;
    }

    /**
      * Sets the value of the 'boolField' field.
      * @param value The value of 'boolField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setBoolField(boolean value) {
      validate(fields()[1], value);
      this.boolField = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'boolField' field has been set.
      * @return True if the 'boolField' field has been set, false otherwise.
      */
    public boolean hasBoolField() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'boolField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearBoolField() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'longField' field.
      * @return The value.
      */
    public java.lang.Long getLongField() {
      return longField;
    }

    /**
      * Sets the value of the 'longField' field.
      * @param value The value of 'longField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setLongField(long value) {
      validate(fields()[2], value);
      this.longField = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'longField' field has been set.
      * @return True if the 'longField' field has been set, false otherwise.
      */
    public boolean hasLongField() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'longField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearLongField() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'intField' field.
      * @return The value.
      */
    public java.lang.Integer getIntField() {
      return intField;
    }

    /**
      * Sets the value of the 'intField' field.
      * @param value The value of 'intField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setIntField(int value) {
      validate(fields()[3], value);
      this.intField = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'intField' field has been set.
      * @return True if the 'intField' field has been set, false otherwise.
      */
    public boolean hasIntField() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'intField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearIntField() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'floatField' field.
      * @return The value.
      */
    public java.lang.Float getFloatField() {
      return floatField;
    }

    /**
      * Sets the value of the 'floatField' field.
      * @param value The value of 'floatField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setFloatField(float value) {
      validate(fields()[4], value);
      this.floatField = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'floatField' field has been set.
      * @return True if the 'floatField' field has been set, false otherwise.
      */
    public boolean hasFloatField() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'floatField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearFloatField() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'doubleField' field.
      * @return The value.
      */
    public java.lang.Double getDoubleField() {
      return doubleField;
    }

    /**
      * Sets the value of the 'doubleField' field.
      * @param value The value of 'doubleField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setDoubleField(double value) {
      validate(fields()[5], value);
      this.doubleField = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'doubleField' field has been set.
      * @return True if the 'doubleField' field has been set, false otherwise.
      */
    public boolean hasDoubleField() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'doubleField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearDoubleField() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'bytesField' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getBytesField() {
      return bytesField;
    }

    /**
      * Sets the value of the 'bytesField' field.
      * @param value The value of 'bytesField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setBytesField(java.nio.ByteBuffer value) {
      validate(fields()[6], value);
      this.bytesField = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'bytesField' field has been set.
      * @return True if the 'bytesField' field has been set, false otherwise.
      */
    public boolean hasBytesField() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'bytesField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearBytesField() {
      bytesField = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'dateField' field.
      * @return The value.
      */
    public org.joda.time.LocalDate getDateField() {
      return dateField;
    }

    /**
      * Sets the value of the 'dateField' field.
      * @param value The value of 'dateField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setDateField(org.joda.time.LocalDate value) {
      validate(fields()[7], value);
      this.dateField = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'dateField' field has been set.
      * @return True if the 'dateField' field has been set, false otherwise.
      */
    public boolean hasDateField() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'dateField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearDateField() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'timeField' field.
      * @return The value.
      */
    public org.joda.time.LocalTime getTimeField() {
      return timeField;
    }

    /**
      * Sets the value of the 'timeField' field.
      * @param value The value of 'timeField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setTimeField(org.joda.time.LocalTime value) {
      validate(fields()[8], value);
      this.timeField = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'timeField' field has been set.
      * @return True if the 'timeField' field has been set, false otherwise.
      */
    public boolean hasTimeField() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'timeField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearTimeField() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'tsField' field.
      * @return The value.
      */
    public org.joda.time.DateTime getTsField() {
      return tsField;
    }

    /**
      * Sets the value of the 'tsField' field.
      * @param value The value of 'tsField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setTsField(org.joda.time.DateTime value) {
      validate(fields()[9], value);
      this.tsField = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'tsField' field has been set.
      * @return True if the 'tsField' field has been set, false otherwise.
      */
    public boolean hasTsField() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'tsField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearTsField() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'decField' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getDecField() {
      return decField;
    }

    /**
      * Sets the value of the 'decField' field.
      * @param value The value of 'decField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setDecField(java.nio.ByteBuffer value) {
      validate(fields()[10], value);
      this.decField = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'decField' field has been set.
      * @return True if the 'decField' field has been set, false otherwise.
      */
    public boolean hasDecField() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'decField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearDecField() {
      decField = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'intArrayField' field.
      * @return The value.
      */
    public java.util.List<java.lang.Integer> getIntArrayField() {
      return intArrayField;
    }

    /**
      * Sets the value of the 'intArrayField' field.
      * @param value The value of 'intArrayField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setIntArrayField(java.util.List<java.lang.Integer> value) {
      validate(fields()[11], value);
      this.intArrayField = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'intArrayField' field has been set.
      * @return True if the 'intArrayField' field has been set, false otherwise.
      */
    public boolean hasIntArrayField() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'intArrayField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearIntArrayField() {
      intArrayField = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'dateArrayField' field.
      * @return The value.
      */
    public java.util.List<org.joda.time.LocalDate> getDateArrayField() {
      return dateArrayField;
    }

    /**
      * Sets the value of the 'dateArrayField' field.
      * @param value The value of 'dateArrayField'.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder setDateArrayField(java.util.List<org.joda.time.LocalDate> value) {
      validate(fields()[12], value);
      this.dateArrayField = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'dateArrayField' field has been set.
      * @return True if the 'dateArrayField' field has been set, false otherwise.
      */
    public boolean hasDateArrayField() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'dateArrayField' field.
      * @return This builder.
      */
    public com.yshi.avro.TestRecord.Builder clearDateArrayField() {
      dateArrayField = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    @Override
    public TestRecord build() {
      try {
        TestRecord record = new TestRecord();
        record.recordId = fieldSetFlags()[0] ? this.recordId : (java.lang.String) defaultValue(fields()[0]);
        record.boolField = fieldSetFlags()[1] ? this.boolField : (java.lang.Boolean) defaultValue(fields()[1]);
        record.longField = fieldSetFlags()[2] ? this.longField : (java.lang.Long) defaultValue(fields()[2]);
        record.intField = fieldSetFlags()[3] ? this.intField : (java.lang.Integer) defaultValue(fields()[3]);
        record.floatField = fieldSetFlags()[4] ? this.floatField : (java.lang.Float) defaultValue(fields()[4]);
        record.doubleField = fieldSetFlags()[5] ? this.doubleField : (java.lang.Double) defaultValue(fields()[5]);
        record.bytesField = fieldSetFlags()[6] ? this.bytesField : (java.nio.ByteBuffer) defaultValue(fields()[6]);
        record.dateField = fieldSetFlags()[7] ? this.dateField : (org.joda.time.LocalDate) defaultValue(fields()[7]);
        record.timeField = fieldSetFlags()[8] ? this.timeField : (org.joda.time.LocalTime) defaultValue(fields()[8]);
        record.tsField = fieldSetFlags()[9] ? this.tsField : (org.joda.time.DateTime) defaultValue(fields()[9]);
        record.decField = fieldSetFlags()[10] ? this.decField : (java.nio.ByteBuffer) defaultValue(fields()[10]);
        record.intArrayField = fieldSetFlags()[11] ? this.intArrayField : (java.util.List<java.lang.Integer>) defaultValue(fields()[11]);
        record.dateArrayField = fieldSetFlags()[12] ? this.dateArrayField : (java.util.List<org.joda.time.LocalDate>) defaultValue(fields()[12]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
