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

  public static final Finder<String, GridPoint> find = new Finder<>(GridPoint.class);
  @JsonProperty("id")
  @Id
  @Column(name="_id_grid_point")
  private int id;

  @JsonProperty("name")
  @Column(name = "name")
  private String name;

  @JsonProperty("posX")
  @Column(name="pos_x", nullable = true)
  private Integer posX = null;

  @JsonProperty("posY")
  @Column(name="pos_y", nullable = true)
  private Integer posY = null;

  @JsonProperty("stand")
  private Stand stand;


  @Column(name = "fk_id_sheme")
  private String sheme_id;


  public static List<GridPoint> getGridPoints(){
    List<GridPoint> gridPointList = GridPoint.find.all();

    return gridPointList;
  }

  public static GridPoint getGridPointById(String id){
    return find.byId(id);
  }

  public static GridPoint getByID(String ID){
    return find.byId(ID);
  }


  public GridPoint id(int id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @NotNull
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


  public Stand getStand() {
    return stand;
  }

  public void setStand(Stand stand) {
    this.stand = stand;
  }

  public String getSheme_id() {
    return sheme_id;
  }

  public void setSheme_id(String sheme_id) {
    this.sheme_id = sheme_id;
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

