package controllers;

import apimodels.AccessPoint;
import apimodels.GridPoint;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.constraints.*;

@SuppressWarnings("RedundantThrows")
public interface AdminsApiControllerImpInterface {
    List<AccessPoint> addNewAccessPoint(AccessPoint accessPoint) throws Exception;

    List<GridPoint> addNewGridPoint(GridPoint gridPoint) throws Exception;

}
