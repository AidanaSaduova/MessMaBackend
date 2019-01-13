package apimodels;

import apimodels.AccessPoint;
import apimodels.GridPoint;
import com.fasterxml.jackson.annotation.*;
import io.ebean.Finder;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;
/**
 * GridAccessPoint
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-01-12T15:21:03.989+01:00")

@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
@Entity
@Table(name="grid_has_accespoints")
public class GridAccessPoint   {
  public static final Finder<Long, GridAccessPoint> find = new Finder<>(GridAccessPoint.class);

  @JsonProperty("signal")
  @Column(name="signal_power")
  private Integer signal = null;

  @JsonProperty("gridPoint")
  @Column(name="fk_id_gridPoint")

  private Integer gridPoint = null;

  @JsonProperty("accessPoint")
  @Column(name="fk_id_mac")

  private String accessPoint = null;


  public GridAccessPoint signal(Integer signal) {
    this.signal = signal;
    return this;
  }

  public static List<GridAccessPoint> getGridAccessPoints(){
    List<GridAccessPoint> gridAccessPointList = GridAccessPoint.find.all();

    return gridAccessPointList;
  }

   /**
   * Get signal
   * @return signal
  **/
    public Integer getSignal() {
    return signal;
  }

  public void setSignal(Integer signal) {
    this.signal = signal;
  }

  public GridAccessPoint gridPoint(Integer gridPoint) {
    this.gridPoint = gridPoint;
    return this;
  }

   /**
   * Get gridPoint
   * @return gridPoint
  **/
  @Valid
  public Integer getGridPoint() {
    return gridPoint;
  }

  public void setGridPoint(Integer gridPoint) {
    this.gridPoint = gridPoint;
  }

  public GridAccessPoint accessPoint(String accessPoint) {
    this.accessPoint = accessPoint;
    return this;
  }

   /**
   * Get accessPoint
   * @return accessPoint
  **/
  @Valid
  public String getAccessPoint() {
    return accessPoint;
  }

  public void setAccessPoint(String accessPoint) {
    this.accessPoint = accessPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GridAccessPoint gridAccessPoint = (GridAccessPoint) o;
    return Objects.equals(signal, gridAccessPoint.signal) &&
        Objects.equals(gridPoint, gridAccessPoint.gridPoint) &&
        Objects.equals(accessPoint, gridAccessPoint.accessPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signal, gridPoint, accessPoint);
  }

  @SuppressWarnings("StringBufferReplaceableByString")
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GridAccessPoint {\n");
    
    sb.append("    signal: ").append(toIndentedString(signal)).append("\n");
    sb.append("    gridPoint: ").append(toIndentedString(gridPoint)).append("\n");
    sb.append("    accessPoint: ").append(toIndentedString(accessPoint)).append("\n");
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

