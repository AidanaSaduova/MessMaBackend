package apimodels;

import com.fasterxml.jackson.annotation.*;
import io.ebean.Finder;
import io.ebean.Model;

import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;
/**
 * AccessPoint
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-01-12T15:21:03.989+01:00")

@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})

@Entity
@Table(name="accesspoints")
public class AccessPoint  extends Model {

    public static final Finder<Long, AccessPoint> find = new Finder<>(AccessPoint.class);
  @JsonProperty("mac")
  @Id
//  @OneToMany(mappedBy = "fk_id_mac", cascade = CascadeType.ALL)
  @Column(name="_id_mac")
  private String mac = null;

  @JsonProperty("type")
  @Column(name="type")
  private Integer type = null;

  @JsonProperty("activity")
  @Column(name="activity")
  private Boolean activity = null;





    public static List<AccessPoint> getAccespoints(){
        List<AccessPoint> accespointList = AccessPoint.find.all();
        return accespointList;
    }


  public AccessPoint mac(String mac) {
    this.mac = mac;
    return this;
  }

   /**
   * Get mac
   * @return mac
  **/
  @NotNull
  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }

  public AccessPoint type(Integer type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
    public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public AccessPoint activity(Boolean activity) {
    this.activity = activity;
    return this;
  }

   /**
   * Get activity
   * @return activity
  **/
    public Boolean isActivity() {
    return activity;
  }

  public void setActivity(Boolean activity) {
    this.activity = activity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessPoint accessPoint = (AccessPoint) o;
    return Objects.equals(mac, accessPoint.mac) &&
        Objects.equals(type, accessPoint.type) &&
        Objects.equals(activity, accessPoint.activity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mac, type, activity);
  }

  @SuppressWarnings("StringBufferReplaceableByString")
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessPoint {\n");
    
    sb.append("    mac: ").append(toIndentedString(mac)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    activity: ").append(toIndentedString(activity)).append("\n");
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

