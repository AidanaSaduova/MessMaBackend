package controllers;

import apimodels.AccessPoint;
import apimodels.GridPoint;
import apimodels.Stand;
import java.util.UUID;
import apimodels.Vector;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileInputStream;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-01-12T15:21:03.989+01:00")

public class DevelopersApiControllerImp implements DevelopersApiControllerImpInterface {
    @Override
    public void findAccessPointsbyMac(UUID mac) throws Exception {
        //Do your magic!!!
    }

    @Override
    public void findGridPointbyId(String id) throws Exception {
        //Do your magic!!!
    }

    @Override
    public void findStandbyId(Integer id) throws Exception {
        //Do your magic!!!
    }

    @Override
    public List<AccessPoint> getAllAccessPoints(AccessPoint accessPoint) throws Exception {
        //Do your magic!!!
        return new ArrayList<AccessPoint>();
    }

    @Override
    public List<GridPoint> getAllGridPoints(GridPoint gridPoint) throws Exception {
        //Do your magic!!!
        return new ArrayList<GridPoint>();
    }

    @Override
    public List<Stand> getAllStands(Stand stand) throws Exception {
        //Do your magic!!!
        return new ArrayList<Stand>();
    }

    @Override
    public List<Vector> getAllVektors(Vector vektor) throws Exception {
        //Do your magic!!!
        return new ArrayList<Vector>();
    }

}
