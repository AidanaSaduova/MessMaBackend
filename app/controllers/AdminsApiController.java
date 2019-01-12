package controllers;

import apimodels.AccessPoint;
import apimodels.GridPoint;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
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

public class AdminsApiController extends Controller {

    private final AdminsApiControllerImpInterface imp;
    private final ObjectMapper mapper;
    private final Configuration configuration;

    @Inject
    private AdminsApiController(Configuration configuration, AdminsApiControllerImpInterface imp) {
        this.imp = imp;
        mapper = new ObjectMapper();
        this.configuration = configuration;
    }


    @ApiAction
    public Result addNewAccessPoint() throws Exception {
        JsonNode nodeaccessPoint = request().body().asJson();
        AccessPoint accessPoint;
        if (nodeaccessPoint != null) {
            accessPoint = mapper.readValue(nodeaccessPoint.toString(), AccessPoint.class);
            if (configuration.getBoolean("useInputBeanValidation")) {
                SwaggerUtils.validate(accessPoint);
            }
        } else {
            accessPoint = null;
        }
        List<AccessPoint> obj = imp.addNewAccessPoint(accessPoint);
        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (AccessPoint curItem : obj) {
                SwaggerUtils.validate(curItem);
            }
        }
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
    }

    @ApiAction
    public Result addNewGridPoint() throws Exception {
        JsonNode nodegridPoint = request().body().asJson();
        GridPoint gridPoint;
        if (nodegridPoint != null) {
            gridPoint = mapper.readValue(nodegridPoint.toString(), GridPoint.class);
            if (configuration.getBoolean("useInputBeanValidation")) {
                SwaggerUtils.validate(gridPoint);
            }
        } else {
            gridPoint = null;
        }
        List<GridPoint> obj = imp.addNewGridPoint(gridPoint);
        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (GridPoint curItem : obj) {
                SwaggerUtils.validate(curItem);
            }
        }
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
    }
}
