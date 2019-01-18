package apimodels;

import apimodels.GridPoint;
import com.fasterxml.jackson.annotation.*;
import io.ebean.Finder;
import io.ebean.Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;

public class ReceivedWantedGridPoint {

    @JsonProperty("destination")
    private Integer destination;

    @JsonProperty("ReceivedSignals")
    private List<ReceivedAccessPoint> signals;




}

