package apimodels;

import apimodels.GridPoint;
import com.fasterxml.jackson.annotation.*;
import java.util.Set;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;
/**
 * Vector
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-01-12T15:21:03.989+01:00")

@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class Vector   {
  @JsonProperty("distance")
  private Integer distance = null;

  @JsonProperty("startPoint")
  private GridPoint startPoint = null;

  @JsonProperty("endPoint")
  private GridPoint endPoint = null;

  public Vector distance(Integer distance) {
    this.distance = distance;
    return this;
  }

   /**
   * Get distance
   * @return distance
  **/
    public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public Vector startPoint(GridPoint startPoint) {
    this.startPoint = startPoint;
    return this;
  }

   /**
   * Get startPoint
   * @return startPoint
  **/
  @Valid
  public GridPoint getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(GridPoint startPoint) {
    this.startPoint = startPoint;
  }

  public Vector endPoint(GridPoint endPoint) {
    this.endPoint = endPoint;
    return this;
  }

   /**
   * Get endPoint
   * @return endPoint
  **/
  @Valid
  public GridPoint getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(GridPoint endPoint) {
    this.endPoint = endPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vector vector = (Vector) o;
    return Objects.equals(distance, vector.distance) &&
        Objects.equals(startPoint, vector.startPoint) &&
        Objects.equals(endPoint, vector.endPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(distance, startPoint, endPoint);
  }

  @SuppressWarnings("StringBufferReplaceableByString")
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vector {\n");
    
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    startPoint: ").append(toIndentedString(startPoint)).append("\n");
    sb.append("    endPoint: ").append(toIndentedString(endPoint)).append("\n");
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

