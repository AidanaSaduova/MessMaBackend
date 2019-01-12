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

import javax.validation.constraints.*;

@SuppressWarnings("RedundantThrows")
public interface DevelopersApiControllerImpInterface {
    void findAccessPointsbyMac(UUID mac) throws Exception;

    void findGridPointbyId(String id) throws Exception;

    void findStandbyId(Integer id) throws Exception;

    List<AccessPoint> getAllAccessPoints(AccessPoint accessPoint) throws Exception;

    List<GridPoint> getAllGridPoints(GridPoint gridPoint) throws Exception;

    List<Stand> getAllStands(Stand stand) throws Exception;

    List<Vector> getAllVektors(Vector vektor) throws Exception;

}
