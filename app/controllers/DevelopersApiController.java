package controllers;

import apimodels.*;

import java.util.*;

import apimodels.Vector;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import java.io.File;
import swagger.SwaggerUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.validation.constraints.*;
import play.Configuration;

import swagger.SwaggerUtils.ApiAction;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-01-12T15:21:03.989+01:00")
public class DevelopersApiController extends Controller {

    private final DevelopersApiControllerImpInterface imp;
    private final ObjectMapper mapper;
    private final Configuration configuration;

    @Inject
    private DevelopersApiController(Configuration configuration, DevelopersApiControllerImpInterface imp) {
        this.imp = imp;
        mapper = new ObjectMapper();
        this.configuration = configuration;
    }


    @ApiAction
    public Result findAccessPointsbyMac(UUID mac) throws Exception {
        Logger.debug("Somebody called findAccessPointsbyMac -> " + mac);
        imp.findAccessPointsbyMac(mac);
        return ok();
    }

    @ApiAction
    public Result findGridPointbyId(String id) throws Exception {
        Logger.debug("Somebody called findGridPointbyId -> " + id);
        imp.findGridPointbyId(id);
        return ok();
    }

    @ApiAction
    public Result findStandbyId(Integer id) throws Exception {
        imp.findStandbyId(id);
        return ok();
    }

    @ApiAction
    public Result getTestAPI() throws Exception {

        Logger.debug("Somebody called the TestAPI ! ( ).( ) !");
        return ok("Hy");
    }

    @ApiAction
    public Result getAllAccessPoints() throws Exception {
        Logger.debug("Somebody called getAllAccessPoints ");
        List<AccessPoint> accessPointList = AccessPoint.getAccespoints();

        Logger.debug("Somebody is calling for AccessPoints");
        String jsonString = "{\"startIndex\": 0, \"data\":" + Json.toJson(accessPointList).toString() + "}";
        if (jsonString.length() > 50) {
            Logger.debug("JSON done and ready for send");
        }

        return ok(jsonString);

    }


    @ApiAction
    public Result getAllGridPoints() throws Exception {
        Logger.debug("Somebody called getAllGridPoints ");
        List<GridPoint> gridPointList = GridPoint.getGridPoints();

        String jsonString = "{\"startIndex\": 0, \"data\":" + Json.toJson(gridPointList).toString() + "}";
        return ok(jsonString);
    }

    @ApiAction
    public Result getAllStands() throws Exception {
        Logger.debug("Somebody called getAllStands ");
        List<Stand> standList = Stand.getStands();
        String jsonString = "{\"startIndex\": 0, \"data\":" + Json.toJson(standList).toString() + "}";

        return ok(jsonString);
    }


    @ApiAction
    public Result getAllGridAccessPoints() throws Exception {
        Logger.debug("Somebody called getAllGridAccessPoints ");
        List<GridAccessPoint> gridAccessPointList = GridAccessPoint.getGridAccespoints();
        String jsonString = "{\"startIndex\": 0, \"data\":" + Json.toJson(gridAccessPointList).toString() + "}";
        return ok(jsonString);
    }

    @ApiAction
    public Result getAllVectors() throws Exception {
        Logger.debug("uhhh.... getAllVektors... ");
        List<Vector> vectorsList = Vector.getAllVectors();

        return ok(vectorsList.toString());
    }



    /// ---- NavigationLogik ----////

    @ApiAction
    public Result getPosition() throws Exception {
        Logger.debug("lets look for your Position... ");
        JsonNode nodebody = request().body().asJson();
        ReceivedWantedGridPoint body;
        HashMap<String, Integer> counterMap = new HashMap<>();
        Integer counter = 1;
        String help = "";
        Integer upperVal = 0, lowerVal = 0;

        List<GridAccessPoint> gridAccessPoints = GridAccessPoint.getGridAccespoints();
        Logger.debug("oh... a List of gridAccesPoints ->" + gridAccessPoints.toString());
        if (nodebody != null) {
            body = mapper.readValue(nodebody.toString(), ReceivedWantedGridPoint.class);

           /* if (configuration.getBoolean("useInputBeanValidation")) {
                SwaggerUtils.validate(body);
            }*/

        } else {
            Logger.debug("land in throw new...");
            throw new IllegalArgumentException("'body' parameter is required");

        }



        JsonNode result = mapper.valueToTree(body);
        ObjectReader reader = mapper.readerFor(new TypeReference<List<ReceivedAccessPoint>>() {
        });
        List<ReceivedAccessPoint> receivedSignals = reader.readValue(result.get("ReceivedSignals"));

        for (ReceivedAccessPoint ap : receivedSignals) {
            String curMac = ap.getMac();
            Integer curPower = ap.getPower();

            for (GridAccessPoint gap : gridAccessPoints) {
                if (gap.getAccessPoint().equals(curMac)) {
                    upperVal = gap.getSignal() + 3;
                    lowerVal = gap.getSignal() - 3;
                    if (curPower >= lowerVal && curPower <= upperVal) {
                        if (counterMap.containsKey(gap.getGridPoint())) {
                            //Counter (=Value) muss erhöht werden, wenn es den Grid Point darin schon gibt, sonst nicht

                            counter = counterMap.get(gap.getGridPoint()) + 1;
                            counterMap.put(gap.getGridPoint(), counter);
                        }
                        counterMap.put(gap.getGridPoint(), counter);
                        //counter =1;
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            int maxValueInMap = (Collections.max(counterMap.values()));
            if (entry.getValue() == maxValueInMap) {
                help = entry.getKey().toString();
            }

        }

        return ok(Json.toJson(help));
    }



    // Update GridAccessPoint

    public Result updateGridAccessPoint() throws  Exception{
        JsonNode nodebody = request().body().asJson();
        ReceivedWantedGridPoint body;

        if (nodebody != null) {
            System.out.println("nodebody != null");
            body = mapper.readValue(nodebody.toString(), ReceivedWantedGridPoint.class);

            JsonNode result = mapper.valueToTree(body);
            ObjectReader reader = mapper.readerFor(new TypeReference<List<ReceivedAccessPoint>>(){ });
            List<ReceivedAccessPoint> receivedSignals = reader.readValue(result.get("ReceivedSignals"));
            String gridPoint = result.get("destination").textValue();

            for (ReceivedAccessPoint tempPoint: receivedSignals) {
                System.out.println("for each....");
                GridAccessPoint tempACS = new GridAccessPoint();
                //tempACS.setGridPoint(reader.readValue(result.get("destination")));
                tempACS.setGridPoint(gridPoint);
                tempACS.setAccessPoint(tempPoint.getMac());
                tempACS.setSignal(tempPoint.getPower());

                tempACS.updateGridAccessPoint();
            }


            return ok(Json.toJson("ok"));
        }




        return ok("updateAccespointGrindpoint");
    }

}
