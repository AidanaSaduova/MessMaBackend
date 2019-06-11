package apimodels;

import play.Logger;

import java.util.HashMap;
import java.util.List;

public class StandNavigationHistory {

    private List<Stand> standsList;
    private List<NavigateHistory> navigateHistoryList;
    private HashMap<String,TargetAs> standNavigation;

    //HelperClass for HashMap
    class TargetAs{
        public int startCount;
        public int targetCount;
    }


    public StandNavigationHistory(){
        this.standsList = Stand.getStands();
        this.navigateHistoryList = NavigateHistory.getNavigationHistoryList();
        this.createTheStandNavigationList();
    }



    //Methods
    private void createTheStandNavigationList(){
        this.standNavigation = new HashMap<>();

        for(Stand stand:standsList){
            if(!standNavigation.containsKey(stand.getFk_id_grid_point())){
                Logger.debug("New Stand fk =" +stand.getFk_id_grid_point());
                standNavigation.put(Integer.toString(stand.getFk_id_grid_point()), new TargetAs());
            }

            for(NavigateHistory navigateHistory:navigateHistoryList){
                //Logger.debug("navigateHistory StartPoint =" +navigateHistory.getStartPoint());
                //Logger.debug(("compare to Stand.getFK = " +stand.getFk_id_grid_point()));
                if(navigateHistory.getStartPoint().equals(stand.getFk_id_grid_point())){
                    Logger.debug("---- StartPoint and FK are the Same ----");
                    standNavigation.get(stand.getFk_id_grid_point()).startCount+=navigateHistory.getCount();
                }

                Logger.debug("navigateHistory EndPoint =" +navigateHistory.getEndPoint());
                Logger.debug(("compare to Stand.getFK" +stand.getFk_id_grid_point()));
                if(navigateHistory.getEndPoint().equals(stand.getFk_id_grid_point())){
                    Logger.debug("---- EndPoint and FK are the Same ----");
                    standNavigation.get(stand.getFk_id_grid_point()).targetCount+=navigateHistory.getCount();
                }
            }
        }



    }


    public int getStartCountForStandAtGridPointId(int gridPointId){
        return standNavigation.get(gridPointId).startCount;
    }

    public int getTargetCountForStandAtGridPointId(int gridPointId){
       return standNavigation.get(gridPointId).targetCount;
    }




    //Getter --- Setter
    public List<Stand> getStandsList() {
        return standsList;
    }

    public void setStandsList(List<Stand> standsList) {
        this.standsList = standsList;
    }

    public List<NavigateHistory> getNavigateHistoryList() {
        return navigateHistoryList;
    }

    public void setNavigateHistoryList(List<NavigateHistory> navigateHistoryList) {
        this.navigateHistoryList = navigateHistoryList;
    }

    public HashMap<String, TargetAs> getStandNavigation() {
        return standNavigation;
    }

    public void setStandNavigation(HashMap<String, TargetAs> standNavigation) {
        this.standNavigation = standNavigation;
    }
}
