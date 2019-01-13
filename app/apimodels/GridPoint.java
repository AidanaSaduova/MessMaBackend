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
 * GridPoint
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-01-12T15:21:03.989+01:00")

@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
@Entity
@Table(name="gridpoints")
public class GridPoint  extends Model {

  public static final Finder<Long, GridPoint> find = new Finder<>(GridPoint.class);
  @JsonProperty("id")
  @Id
//  @OneToMany(mappedBy = "fk_id_gridPoint", cascade = CascadeType.ALL)
  @Column(name="_id_grid_point")
  private Integer id = null;

  @JsonProperty("posX")
  @Column(name="pos_x", nullable = true)
  private Integer posX = null;

  @JsonProperty("posY")
  @Column(name="pos_y", nullable = true)
  private Integer posY = null;

  @OneToOne
  @JoinColumn(name = "_id_grid_point")
  private Stand stand;







  public static List<GridPoint> getGridPoints(){
    List<GridPoint> gridPointList = GridPoint.find.all();

    return gridPointList;
  }


  public GridPoint id(Integer id) {
    this.id = id;
    return this;
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

  public GridPoint posX(Integer posX) {
    this.posX = posX;
    return this;
  }

   /**
   * Get posX
   * @return posX
  **/
  @NotNull
  public Integer getPosX() {
    return posX;
  }

  public void setPosX(Integer posX) {
    this.posX = posX;
  }

  public GridPoint posY(Integer posY) {
    this.posY = posY;
    return this;
  }

   /**
   * Get posY
   * @return posY
  **/
  @NotNull
  public Integer getPosY() {
    return posY;
  }

  public void setPosY(Integer posY) {
    this.posY = posY;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GridPoint gridPoint = (GridPoint) o;
    return Objects.equals(id, gridPoint.id) &&
        Objects.equals(posX, gridPoint.posX) &&
        Objects.equals(posY, gridPoint.posY);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, posX, posY);
  }

  @SuppressWarnings("StringBufferReplaceableByString")
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GridPoint {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    posX: ").append(toIndentedString(posX)).append("\n");
    sb.append("    posY: ").append(toIndentedString(posY)).append("\n");
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

