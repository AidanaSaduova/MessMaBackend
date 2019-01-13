package controllers;

import apimodels.AccessPoint;
import apimodels.GridPoint;
import apimodels.Stand;

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


        List<AccessPoint> accessPointList = AccessPoint.getAccespoints();
        return ok(Json.toJson(accessPointList));
    }


    @ApiAction
    public Result getAllGridPoints() throws Exception {

       List<GridPoint> gridPointList = GridPoint.getGridPoints();
       return ok(Json.toJson(gridPointList));
    }

    @ApiAction
    public Result getAllStands() throws Exception {

        List<Stand> standList = Stand.getStands();
        return ok(Json.toJson(standList));
    }

    @ApiAction
    public Result getAllVektors() throws Exception {

        return ok();
    }
}
