package apimodels;

import javax.persistence.Column;
import java.io.Serializable;

@javax.persistence.Embeddable
public class Embeddable implements Serializable {

    @Column(name = "_id_mac")
    public String mac;

    @Column(name = "_id_grid_point")
    public Integer id;
}
