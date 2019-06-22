package apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.Ebean;
import io.ebean.Expr;
import play.Logger;

import java.util.List;

public class ReceivedProjects {


    @JsonProperty("projects")
    private List<Project> projectList;

    public ReceivedProjects() {

    }

    public boolean saveProject(){

        if(projectList == null) return false;


        for(Project project: getProjectList()){
            if(project != null){
                Logger.debug("Save Projec to DB -> " + project.toString());

                if(Ebean.find(Project.class, project.getId()) == null)
                    Ebean.save(project);
                else
                    Ebean.update(project);

                for(Sheme sheme: project.getShemeList()){

                    sheme.setProjetct_id(project.getId());

                    if(saveSheme(sheme))
                        continue;
                    else
                        return false;
                }
            }

        }

        return true;
    }



    public boolean saveSheme(Sheme sheme){
        if (sheme == null) return false;

        Logger.debug("Save Sheme to DB -> " + sheme.toString());

        if(Ebean.find(Sheme.class, sheme.getId()) == null)
            Ebean.save(sheme);
        else
            Ebean.update(sheme);

        for(GridPoint gridPoint: sheme.getGridPoints()){
            if(gridPoint != null) gridPoint.setSheme_id(sheme.getId().toString());
                if(saveGridPoint(gridPoint))
                    continue;
                else
                    return false;
            }

        for(Vector vector: sheme.getVectors()){
            if(vector != null){

                if(saveVector(vector))
                    continue;
                else
                    return false;
            }

        }

        return true;
    }


    public boolean saveGridPoint(GridPoint gridPoint){
        if(gridPoint == null) return false;

        Logger.debug("Save GridPoint to DB -> " + gridPoint.toString());

        if(Ebean.find(GridPoint.class, gridPoint.getId()) == null)
            Ebean.save(gridPoint);
        else
            Ebean.update(gridPoint);

        if(gridPoint.getStand() != null) {
            gridPoint.getStand().setFk_id_grid_point(gridPoint.getId());
            return saveStand(gridPoint.getStand());
        }

        return true;
    }

    public boolean saveStand(Stand stand){
        if(stand == null) return false;

        Logger.debug("Save Stand to DB -> " + stand.toString());

        if(Ebean.find(Stand.class, stand.getId()) == null)
            Ebean.save(stand);
        else
            Ebean.update(stand);

        return true;
    }

    public boolean saveVector(Vector vector){
        if(vector == null) return false;

        Logger.debug("Save Vector to DB -> " + vector.toString());

        vector.createVectorId();

        Vector foundVector = Ebean.find(Vector.class, vector.getId());

        if(foundVector == null){
            Ebean.save(vector);
        }

        else{
            foundVector.setDistance(5);
            foundVector.save();
        }

        return true;
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
