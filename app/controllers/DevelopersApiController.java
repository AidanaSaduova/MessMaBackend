package controllers;

import apimodels.*;

import java.util.*;

import apimodels.Vector;
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
        imp.findAccessPointsbyMac(mac);
        return ok();
    }

    @ApiAction
    public Result findGridPointbyId(String id) throws Exception {
        imp.findGridPointbyId(id);
        return ok();
    }

    @ApiAction
    public Result findStandbyId(Integer id) throws Exception {
        imp.findStandbyId(id);
        return ok();
    }

    @ApiAction
    public Result getAllAccessPoints() throws Exception {
        /*JsonNode nodeaccessPoint = request().body().asJson();
        AccessPoint accessPoint;
        if (nodeaccessPoint != null) {
            accessPoint = mapper.readValue(nodeaccessPoint.toString(), AccessPoint.class);
            if (configuration.getBoolean("useInputBeanValidation")) {
                SwaggerUtils.validate(accessPoint);
            }
        } else {
            accessPoint = null;
        }
        List<AccessPoint> obj = imp.getAllAccessPoints(accessPoint);
        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (AccessPoint curItem : obj) {
                SwaggerUtils.validate(curItem);
            }
        }
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);*/

        List<AccessPoint> accessPointList = AccessPoint.getAccespoints();
        return ok(Json.toJson(accessPointList));
    }


    @ApiAction
    public Result getAllGridPoints() throws Exception {
       /* JsonNode nodegridPoint = request().body().asJson();
        GridPoint gridPoint;
        if (nodegridPoint != null) {
            gridPoint = mapper.readValue(nodegridPoint.toString(), GridPoint.class);
            if (configuration.getBoolean("useInputBeanValidation")) {
                SwaggerUtils.validate(gridPoint);
            }
        } else {
            gridPoint = null;
        }
        List<GridPoint> obj = imp.getAllGridPoints(gridPoint);
        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (GridPoint curItem : obj) {
                SwaggerUtils.validate(curItem);
            }
        }
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);*/
       List<GridPoint> gridPointList = GridPoint.getGridPoints();
       return ok(Json.toJson(gridPointList));
    }

    @ApiAction
    public Result getAllStands() throws Exception {

/*JsonNode nodestand = request().body().asJson();
        Stand stand;
        if (nodestand != null) {
            stand = mapper.readValue(nodestand.toString(), Stand.class);
            if (configuration.getBoolean("useInputBeanValidation")) {
                SwaggerUtils.validate(stand);
            }
        } else {
            stand = null;
        }
        List<Stand> obj = imp.getAllStands(stand);
        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (Stand curItem : obj) {
                SwaggerUtils.validate(curItem);
            }
        }
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);*/
        List<Stand> standList = Stand.getStands();
        return ok(Json.toJson(standList));
    }

    @ApiAction
    public Result getAllGridAccessPoints() throws Exception {


        List<GridAccessPoint> gridAccessPointList = GridAccessPoint.getGridAccespoints();
        return ok(Json.toJson(gridAccessPointList));
    }



    @ApiAction
    public Result getAllVektors() throws Exception {
        JsonNode nodevektor = request().body().asJson();
        Vector vektor;
        if (nodevektor != null) {
            vektor = mapper.readValue(nodevektor.toString(), Vector.class);
            if (configuration.getBoolean("useInputBeanValidation")) {
                SwaggerUtils.validate(vektor);
            }
        } else {
            vektor = null;
        }
        List<Vector> obj = imp.getAllVektors(vektor);
        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (Vector curItem : obj) {
                SwaggerUtils.validate(curItem);
            }
        }
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
    }
}
