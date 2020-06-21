/*
 * Nexd API
 * Swagger API description
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.nexd.android.api.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets AvailableLanguages
 */
@JsonAdapter(AvailableLanguages.Adapter.class)
public enum AvailableLanguages {
  
  DE("de"),
  
  EN("en");

  private String value;

  AvailableLanguages(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static AvailableLanguages fromValue(String value) {
    for (AvailableLanguages b : AvailableLanguages.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<AvailableLanguages> {
    @Override
    public void write(final JsonWriter jsonWriter, final AvailableLanguages enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public AvailableLanguages read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return AvailableLanguages.fromValue(value);
    }
  }
}
