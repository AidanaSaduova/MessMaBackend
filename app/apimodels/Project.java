package apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="project")
public class Project extends Model {


    public static final Finder<Integer, Project> find = new Finder<>(Project.class);

    @JsonProperty("id")
    @Id
    @Column(name="_id_project")
    private Integer id = null;

    @JsonProperty("title")
    @Column(name="title")
    private String title = null;

    @JsonProperty("description")
    @Column(name="description")
    private String description = null;

    @JsonProperty("buildingInfo")
    @Column(name="buildingInfo")
    private String buildingInfo = null;

    @JsonProperty("shemes")
    @Column(name="shemes")
    private List<Sheme> shemeList = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBuildingInfo() {
        return buildingInfo;
    }

    public void setBuildingInfo(String buildingInfo) {
        this.buildingInfo = buildingInfo;
    }

    public List<Sheme> getShemeList() {
        return shemeList;
    }

    public void setShemeList(List<Sheme> shemeList) {
        this.shemeList = shemeList;
    }

    public static Project getByID(Integer ID){
        return find.byId(ID);
    }


    public Project id(Integer id) {
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




    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project gridPoint = (Project) o;
        return Objects.equals(id, gridPoint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Project {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
