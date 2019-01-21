package controllers;

import apimodels.StandNavigationHistory;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import play.mvc.Result;
import swagger.SwaggerUtils;
import views.html.index;


public class NaviagtionHistoryController extends Controller {

    @Inject
    FormFactory formFactory;  //To wrap a class you have to inject a play.data.FormFactory into your Controller


    public Result index(){

        StandNavigationHistory standNavigationHistory = new StandNavigationHistory();

        return ok(index.render(standNavigationHistory));
    }


}
