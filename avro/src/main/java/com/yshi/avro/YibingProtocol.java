/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.yshi.avro;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public interface YibingProtocol {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"YibingProtocol\",\"namespace\":\"com.yshi.avro\",\"types\":[{\"type\":\"record\",\"name\":\"TestRecord\",\"fields\":[{\"name\":\"recordId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"boolField\",\"type\":\"boolean\",\"default\":true},{\"name\":\"longField\",\"type\":\"long\",\"default\":-1},{\"name\":\"intField\",\"type\":\"int\",\"default\":1},{\"name\":\"floatField\",\"type\":\"float\",\"default\":1.1},{\"name\":\"doubleField\",\"type\":\"double\",\"default\":2.2},{\"name\":\"bytesField\",\"type\":\"bytes\",\"default\":\"\\u0001\\u0002\\u0003\"},{\"name\":\"dateField\",\"type\":{\"type\":\"int\",\"logicalType\":\"date\"},\"default\":16801},{\"name\":\"timeField\",\"type\":{\"type\":\"int\",\"logicalType\":\"time-millis\"},\"default\":46800000},{\"name\":\"tsField\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"},\"default\":1451606400000},{\"name\":\"decField\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":7,\"scale\":2},\"default\":\"09\"},{\"name\":\"intArrayField\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"dateArrayField\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"int\",\"logicalType\":\"date\"}}}]},{\"type\":\"enum\",\"name\":\"Status\",\"symbols\":[\"OK\",\"FAILED\"]}],\"messages\":{\"send\":{\"request\":[{\"name\":\"request\",\"type\":\"TestRecord\"}],\"response\":\"Status\"}}}");
  /**
   */
  com.yshi.avro.Status send(com.yshi.avro.TestRecord request) throws org.apache.avro.AvroRemoteException;

  @SuppressWarnings("all")
  public interface Callback extends YibingProtocol {
    public static final org.apache.avro.Protocol PROTOCOL = com.yshi.avro.YibingProtocol.PROTOCOL;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void send(com.yshi.avro.TestRecord request, org.apache.avro.ipc.Callback<com.yshi.avro.Status> callback) throws java.io.IOException;
  }
}