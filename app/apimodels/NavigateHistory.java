package apimodels;

import io.ebean.Ebean;
import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "navigate_history")
public class NavigateHistory {

    public static final Finder<String, NavigateHistory> find = new Finder<>(NavigateHistory.class);


    @Id
    @Column(name = "pk_start_end")
    private String historyId = null;

    @Column(name =  "start_point")
    private String startPoint = null;

    @Column(name =  "end_point")
    private String endPoint = null;

    @Column(name = "count")
    private int count;

    //Constructor
    public NavigateHistory() {

    }

    public NavigateHistory(String startPoint, String endPoint) {

        this.historyId = startPoint +"-"+endPoint;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    //Methoden
    public static List<NavigateHistory> getNavigationHistoryList(){
        List<NavigateHistory> navigateHistoryList = find.all();
        return navigateHistoryList;
    }

    public void updateNavigationHistory(){

        NavigateHistory temp = Ebean.find(NavigateHistory.class, historyId);
        if(temp!=null)
        {
            setCount(temp.getCount()+1);
            Ebean.update(this);
        }else
            setCount(1);
            Ebean.save(this);

    }





    //Getter --- Setter
    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
