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

import sun.rmi.runtime.Log;
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
        List<Vector> vectorsList = Vector.getVectors();

        return ok(vectorsList.toString());
    }



    /// ---- NavigationLogik ----////

    @ApiAction
    public Result getPosition() throws Exception {
        //region Variablendeklaration
            Logger.debug("lets look for your Position... ");
    List<Node> navigationList = new LinkedList<>();
    JsonNode nodebody = request().body().asJson();
    ReceivedWantedGridPoint body;
    HashMap<String, Integer> counterMap = new HashMap<>();
    Integer counter = 1;
    String position = "", destination = "";

    Integer upperVal = 0, lowerVal = 0;
    List<String> navigation = new LinkedList<>();
    //endregion

    //region Body auslesen
        List<GridAccessPoint> gridAccessPoints = GridAccessPoint.getGridAccespoints();
        //Logger.debug("oh... a List of gridAccesPoints ->" + gridAccessPoints.toString());
        if (nodebody != null) {
            body = mapper.readValue(nodebody.toString(), ReceivedWantedGridPoint.class);

        } else {
            Logger.debug("land in throw new...");
            throw new IllegalArgumentException("'body' parameter is required");

        }

        JsonNode result = mapper.valueToTree(body);
        ObjectReader reader = mapper.readerFor(new TypeReference<List<ReceivedAccessPoint>>() {
        });
        List<ReceivedAccessPoint> receivedSignals = reader.readValue(result.get("ReceivedSignals"));
        destination = result.get("destination").textValue();
        //endregion

        //region Positionsbestimmung
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
                position = entry.getKey().toString();
            }

        }
        //endregion
        position = "4M";
        destination = "10AS";
    //region Navigation
    navigationList = Navigate(new Node("4M"), new Node("10AS"));

    //endregion
        for(Node n: navigationList){
            Logger.debug("Node for NaviagtionList -> " + n.getName() +" - :" + n.getDistance());
        navigation.add(n.getName());
    }
        Logger.debug("NavigationList -> " + navigationList.toString());
        return ok(Json.toJson(navigation));

}

    public List<Node> Navigate (Node start, Node destination){

        //Liste der Punkte die an Navigations-App gesendet werden
        List<Node> path = new LinkedList<>();

        //Anlegen der Nodes
        List<Node> nodeList = new LinkedList<>();
        List<GridPoint> gridPoints = GridPoint.getGridPoints();


        for(GridPoint gp : gridPoints) {
            nodeList.add(new Node(gp.getId()));
        }


        //Graph mit Nodes befüllen
        Graph graph = new Graph();
        //Ein Graph stellt in unserem Fall das gesamte Grid dar. Die Punkte werden hier hinzugefügt
        for(Node n : nodeList){
            graph.addNode(n);
        }

        //Vectoren für GraphNode finden
        List<Vector> vectorList = Vector.getVectors();

        for(Node n : graph.getNodes()){
            //Logger.debug("graph.getNodes  step1 -> " + n.getName() +  " - : " + n.getDistance());
            for(Vector v : vectorList){

                if(n.getName().equals(v.getStartPoint())){
                    //Logger.debug("Node Name -> " + n.getName()+" "+"Node Name -> " +v.getStartPoint() +" distanze -> " + v.getDistance());
                    n.addDestination(graph.getNodeByName(v.getEndPoint()), v.getDistance());
                }
            }
            //Logger.debug("graph.getNodes step2 -> " + n.getName() +  " - : " + n.getDistance());
        }

        //Start und Endpunkt der Navigationsanfrage
        Node startNode, destinationNode;

        //Hier werden Daten von der Navigations-App empfangen
        startNode = start;
        destinationNode = destination;

        // ToDO wieso wird der StartPunkt aus dem Graphen gezogen und nicht aus der GridPointListe
        //Startpunkt wird mit einem Punkt im Grid gematcht
        for(Node n : graph.getNodes()){
            if(startNode.getName().equals(n.getName()))
                startNode = n;
        }

        // ToDO wieso wird der EndPunkt aus dem Graphen gezogen und nicht aus der GridPointListe
        //Endpunkt wird mit einem Punkt im Grid gematcht
        for(Node n : graph.getNodes()){
            //Logger.debug("Node from Graph -> " + n.getName() +" - :"+n.getName());
            if(destinationNode.getName().equals(n.getName()))
                destinationNode = n;
        }
        Logger.debug("StartNode = " + startNode.getName() );
        Logger.debug("DestinationNode = " + destinationNode.getName() );
        Logger.debug("DestinationNode shortestPath = " + destinationNode.getShortestPath().subList(1,destination.getShortestPath().size()) );

        //Startpunkt ist der zweite Parameter
        graph = Dijkstra.calculateShortestPathFromSource(graph, startNode);

        for (Node n : graph.getNodes()) {
            //Logger.debug("node shortestPath " + n.getShortestPath().toString());
            if(n.getName().equals(destinationNode.getName())) {
                for (Node n1 : n.getShortestPath()) {
                    path.add(n1);

                    //System.out.println("Abgegangene Punkte: " + n1.getName());
                }
                path.add(destinationNode);

                //System.out.println("Endpunkt: " + destinationNode.getName());
                //System.out.println("Distanz gesamt: " + n.getDistance());
            }
        }

        return path;
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
