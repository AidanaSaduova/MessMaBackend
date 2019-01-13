package apimodels;

import com.fasterxml.jackson.annotation.*;
import io.ebean.Finder;
import io.ebean.Model;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;

public class ReceivedAccessPoint extends Model{
    public String getMac() {
        return mac;
    }

    public Integer getPower() {
        return power;
    }

    @JsonProperty("mac")
    private String mac = null;

    @JsonProperty("power")
    private Integer power = null;




}
