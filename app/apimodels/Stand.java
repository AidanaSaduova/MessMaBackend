package apimodels;

import apimodels.GridPoint;
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
 * Stand
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-01-12T15:21:03.989+01:00")


@Entity
@Table(name="stands")
@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class Stand   extends Model {

  public static final Finder<Long, Stand> find = new Finder<>(Stand.class);

  @JsonProperty("id")
  @Id
  @Column(name="_id_stand", nullable = true)
  private Integer id = null;

  @JsonProperty("name")
  @Column(name="name", nullable = true)
  private String name = null;

  @JsonProperty("description")
  @Column(name = "description", nullable = true)
  private String description = null;

  @JsonProperty("logo")
  @Column(name="logo", nullable = true)
  private String logo = null;


  @Column(name="fk_id_grid_point")
  private String fk_id_grid_point;

  @JsonProperty("GridPoint")
  private GridPoint gridPoint = null;

  public Stand id(Integer id) {
    this.id = id;
    return this;
  }


  public static List<Stand> getStands(){
    List<Stand> standList = Stand.find.all();

    for (Stand stand: standList) {
      stand.gridPoint = GridPoint.getByID(stand.fk_id_grid_point);
    }

    return standList;
  }

  public String getFk_id_grid_point(){
    return this.fk_id_grid_point;
  }

   /**
   * Get id
   * @return id
  **/
  @NotNull
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Stand name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Stand description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Stand logo(String logo) {
    this.logo = logo;
    return this;
  }

   /**
   * Get logo
   * @return logo
  **/
    public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public Stand gridPoint(GridPoint gridPoint) {
    this.gridPoint = gridPoint;
    return this;
  }

   /**
   * Get gridPoint
   * @return gridPoint
  **/
  @Valid
  public GridPoint getGridPoint() {
    return gridPoint;
  }

  public void setGridPoint(GridPoint gridPoint) {
    this.gridPoint = gridPoint;
  }


  public String getFkGridPointId(){return fk_id_grid_point;}

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stand stand = (Stand) o;
    return Objects.equals(id, stand.id) &&
        Objects.equals(name, stand.name) &&
        Objects.equals(description, stand.description) &&
        Objects.equals(logo, stand.logo) &&
        Objects.equals(gridPoint, stand.gridPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, logo, gridPoint);
  }

  @SuppressWarnings("StringBufferReplaceableByString")
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stand {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
    sb.append("    gridPoint: ").append(toIndentedString(gridPoint)).append("\n");
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

