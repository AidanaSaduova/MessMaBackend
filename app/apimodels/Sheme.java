package apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Stand
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-01-12T15:21:03.989+01:00")


@Entity
@Table(name="room")
@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class Sheme extends Model {


    public static final Finder<Long, Sheme> find = new Finder<>(Sheme.class);

    @JsonProperty("id")
    @Id
    @Column(name="id_sheme", nullable = true)
    private Integer id = null;

    @JsonProperty("name")
    @Column(name="name", nullable = true)
    private String name = null;

    @JsonProperty("Path")
    @Column(name="path", nullable = true)
    private String path = null;

    @JsonProperty("screenshot")
    @Column(name = "plan", nullable = true)
    private String plan = null;

    @JsonProperty("gridRows")
    @Column(name = "gridRows", nullable = true)
    private int gridRows;

    @JsonProperty("gridCols")
    @Column(name = "gridCols", nullable = true)
    private int gridCols;

    @JsonProperty("gridPoints")
    @OneToMany
    @Column(name="gridpoints", nullable = true)
    private List<GridPoint> gridPoints = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "fk_project")
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Sheme id(Integer id) {
        this.id = id;
        return this;
    }


    public static List<Sheme> getShemes(){
        List<Sheme> shemeList = Sheme.find.all();

        /**
        for (Sheme sheme: shemeList) {
            sheme.setGridPoint(GridPoint.getByID(stand.fk_id_grid_point));
        }
        */
        return shemeList;
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

    public Sheme name(String name) {
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


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getGridRows() {
        return gridRows;
    }

    public void setGridRows(int gridRows) {
        this.gridRows = gridRows;
    }

    public int getGridCols() {
        return gridCols;
    }

    public void setGridCols(int gridCols) {
        this.gridCols = gridCols;
    }

    public List<GridPoint> getGridPoints() {
        return gridPoints;
    }

    public void setGridPoints(List<GridPoint> gridPoints) {
        this.gridPoints = gridPoints;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sheme sheme = (Sheme) o;
        return Objects.equals(id, sheme.id) &&
                Objects.equals(name, sheme.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Stand {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
