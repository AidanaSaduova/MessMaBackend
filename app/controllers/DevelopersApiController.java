package controllers;

import apimodels.*;

import java.io.IOException;
import java.util.*;

import apimodels.Vector;
import com.fasterxml.jackson.databind.ObjectReader;

import io.ebean.Ebean;
import play.Logger;


import play.db.Databases;
import play.db.evolutions.Evolutions;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;

import com.fasterxml.jackson.core.type.TypeReference;


import play.Configuration;

import swagger.SwaggerUtils.ApiAction;

import javax.sql.DataSource;

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
    public Result setProject() throws Exception{

        //region Variablendeklaration
        Logger.debug("- - - lets set this Projects - - -");
        Logger.debug("you send me ");
        Logger.debug(request().body().asJson().toString());

        JsonNode nodebody = request().body().asJson();
        ReceivedProjects projectsList;

        if (nodebody != null) {
            try {
            Logger.debug("lets mapp the JSON ProjectsList to our ReceivedProjectsList ");
                projectsList = mapper.readValue(nodebody.toString(), ReceivedProjects.class);
                if(projectsList.saveProject())
                    return ok("New Project saved");
                else
                    return ok("Could not Save Project -> " + projectsList.toString());
            } catch (IOException e) {
                Logger.debug("- - - IOException in  setProject() projectsList = mapper.readValue()  - - -");
                e.printStackTrace();
            }

        } else {
            Logger.debug("no information you have give to me ( -.- )");
            throw new IllegalArgumentException("'body' parameter is required");

        }

        return ok("you send me the project");
    };

    @ApiAction
    public Result findAccessPointsbyMac(UUID mac) throws Exception {
        Logger.debug("Somebody need data for AccessPoint with mac:\t" + mac);
        imp.findAccessPointsbyMac(mac);
        return ok();
    }

    @ApiAction
    public Result findGridPointbyId(String id) throws Exception {
        Logger.debug("Somebody need data for GridPoint with id:\t" + id);
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
        return ok("Don't worry... we are still alive ! ( ).( ) !");
    }


    @ApiAction
    public Result needFreshDB() throws Exception {

        Logger.info("Somebody requested a fresh DB");

        List<Vector> vectorList = Vector.getAllVectors();
        if(!vectorList.isEmpty()){
            Ebean.deleteAll(vectorList);
        }

        List<Stand> standList = Stand.getStands();
        if(!standList.isEmpty()){
            Ebean.deleteAll(standList);
        }

        List<GridPoint> gridPointList = GridPoint.getGridPoints();
        if(!gridPointList.isEmpty()){
            Ebean.deleteAll(gridPointList);
        }

        List<Sheme> shemeList = Sheme.getShemes();
        if(shemeList.isEmpty()){
            Ebean.deleteAll(shemeList);
        }

        List<Project> projectList = Project.find.all();
        if (!projectList.isEmpty()){
            Ebean.deleteAll(projectList);
        }

        /**
        Databases.inMemory("jdbc:h2:mem:play").getDataSource();

        javax.sql.DataSource dataSource = Databases.inMemory("jdbc:h2:mem:play").getDataSource();

        Evolutions.cleanupEvolutions(dataSource);

        Databases.inMemory("jdbc:h2:mem:play").getDataSource();

        Databases.inMemoryWith("url","jdbc:h2:mem:play");
        */

        Logger.info("DB has been cleaned");

        return ok("DB has been cleand :)");
    }

    @ApiAction
    public Result getAllAccessPoints() throws Exception {
        Logger.debug("Somebody wants to know all available AccessPoints ");
        List<AccessPoint> accessPointList = AccessPoint.getAccespoints();

        String jsonString = "{\"startIndex\": 0, \"data\":" + Json.toJson(accessPointList).toString() + "}";
        if (jsonString.length() > 50) {
            Logger.debug("JSON done and ready for send");
        }

        return ok(jsonString);

    }


    @ApiAction
    public Result getAllGridPoints() throws Exception {
        Logger.debug("Somebody wants to know all available GridPoints ");
        List<GridPoint> gridPointList = GridPoint.getGridPoints();

        //String jsonString = "{\"startIndex\": 0, \"data\":" + Json.toJson(gridPointList).toString() + "}";
        return ok(Json.toJson(gridPointList));
        //return ok(jsonString);
    }

    @ApiAction
    public Result getAllStands() throws Exception {
        Logger.debug("Somebody wants to know all available Stands ");
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

        //region Variablendeklaration
        Logger.debug("- - - Let's do some navigation stuff - - -");
        Logger.debug("your Position first i have to find... ");

        List<Node> navigationList = new LinkedList<>();
        JsonNode nodebody = request().body().asJson();
        ReceivedWantedGridPoint body;
        HashMap<String, Integer> counterMap = new HashMap<>();
        Integer counter = 1;
        String position = "", destination = "";

        Integer upperVal = 0, lowerVal = 0;
        List<GridPoint> navigation = new LinkedList<>();
        //endregion


        //region Body auslesen
        List<GridAccessPoint> gridAccessPoints = GridAccessPoint.getGridAccespoints();
        //Logger.debug("oh... a List of gridAccesPoints from DB->\n" + gridAccessPoints.toString());


        if (nodebody != null) {
            Logger.debug("this information you have give to me... hmmm\n" + nodebody.toString());
            body = mapper.readValue(nodebody.toString(), ReceivedWantedGridPoint.class);

        } else {
            Logger.debug("no information you have give to me ( -.- )");
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
                    upperVal = gap.getSignal() + 4;
                    lowerVal = gap.getSignal() - 4;
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
        if(position != null){
            Logger.debug("at this Position i think you are -> "+position);
            Logger.debug("and there you wana go -> " + destination);
        }

        //region Navigation
        //position = "4D";
        //destination = "7M";
        navigationList = Navigate(new Node(position), new Node(destination));

        //endregion
        for(Node n: navigationList){
            navigation.add(GridPoint.getByID(n.getName()));
        }


        Logger.debug("By the Power of Greyskull...\n\t ...I will lead you throw this rout!\n\t"+Json.toJson(navigation).toString());

        NavigateHistory navigateHistory = new NavigateHistory(position,destination);
        navigateHistory.updateNavigationHistory();

        String jsonString = "{\"startIndex\": 0, \"data\":" + Json.toJson(navigation).toString() + "}";
        return ok(jsonString);

    }

    public List<Node> Navigate (Node start, Node destination){

        //Liste der Punkte die an Navigations-App gesendet werden
        List<Node> path = new LinkedList<>();
        List<Node> nodeList = new LinkedList<>();
        //Ein Graph stellt in unserem Fall das gesamte Grid dar. Die Punkte werden hier hinzugefügt


        //Start und Endpunkt der Navigationsanfrage
        Node startNode, destinationNode;

        List<Vector> vectorList = Vector.getVectors();
        List<GridPoint> gridPoints = GridPoint.getGridPoints();

        Graph graph = new Graph();

        //Anlegen der Nodes
        for(GridPoint gp : gridPoints) {
            nodeList.add(new Node(Integer.toString(gp.getId())));
        }

        for(Node n : nodeList){
            graph.addNode(n);
        }
        Logger.debug("a list of Vectors and and one of GridPoints i have found (^_^)");

        Logger.debug("-> Flash drawe the Graph and take Dijkstra with you to count the Paths...");
        for(Node n : graph.getNodes()){
            for(Vector v : vectorList){
                if(n.getName().equals(v.getStartPoint())){
                    n.addDestination(graph.getNodeByName(Integer.toString(v.getEndPoint())), v.getDistance());
                }
            }
        }

        //Hier werden Daten von der Navigations-App empfangen
        startNode = start;
        destinationNode = destination;

        //Startpunkt wird mit einem Punkt im Grid gematcht
        for(Node n : graph.getNodes()){
            if(startNode.getName().equals(n.getName()))
                startNode = n;
        }

        //Endpunkt wird mit einem Punkt im Grid gematcht
        for(Node n : graph.getNodes()){
            if(destinationNode.getName().equals(n.getName()))
                destinationNode = n;
        }


        //Startpunkt ist der zweite Parameter
        graph = Dijkstra.calculateShortestPathFromSource(graph, startNode);

        for (Node n : graph.getNodes()) {
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
        Logger.debug("Oh my friends, it's good to see you arrived well back...\n\twhat is the result i can give to this young adventurers...");



        List<Node> tester = new LinkedList<>(graph.getNodes());
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

            Logger.debug("for each AccessPoint in receivedSignals...");
            for (ReceivedAccessPoint tempPoint: receivedSignals) {

                GridAccessPoint tempACS = new GridAccessPoint();
                //tempACS.setGridPoint(reader.readValue(result.get("destination")));
                tempACS.setGridPoint(gridPoint);
                tempACS.setAccessPoint(tempPoint.getMac());
                tempACS.setSignal(tempPoint.getPower());

                tempACS.updateGridAccessPoint();
            }
            Logger.debug("-> Update the DataBase");

            return ok(Json.toJson("ok"));
        }




        return ok("updateAccespointGrindpoint");
    }





}
