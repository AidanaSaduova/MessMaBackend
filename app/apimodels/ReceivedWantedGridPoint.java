package apimodels;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

public class ReceivedWantedGridPoint {

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("ReceivedSignals")
    private List<ReceivedAccessPoint> signals;


}

