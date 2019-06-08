package apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReceivedProjects {


    @JsonProperty("projects")
    private List<Project> projectList;

    public ReceivedProjects() {

    }

    public ReceivedProjects(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
