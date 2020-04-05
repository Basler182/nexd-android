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

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ConvertedHelpRequestDto
 */

public class ConvertedHelpRequestDto {
  public static final String SERIALIZED_NAME_HELP_REQUEST_ID = "helpRequestId";
  @SerializedName(SERIALIZED_NAME_HELP_REQUEST_ID)
  private Long helpRequestId;


  public ConvertedHelpRequestDto helpRequestId(Long helpRequestId) {
    
    this.helpRequestId = helpRequestId;
    return this;
  }

   /**
   * Get helpRequestId
   * @return helpRequestId
  **/
  @ApiModelProperty(required = true, value = "")

  public Long getHelpRequestId() {
    return helpRequestId;
  }


  public void setHelpRequestId(Long helpRequestId) {
    this.helpRequestId = helpRequestId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConvertedHelpRequestDto convertedHelpRequestDto = (ConvertedHelpRequestDto) o;
    return Objects.equals(this.helpRequestId, convertedHelpRequestDto.helpRequestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(helpRequestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvertedHelpRequestDto {\n");
    sb.append("    helpRequestId: ").append(toIndentedString(helpRequestId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

