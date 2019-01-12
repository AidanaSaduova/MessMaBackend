
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/aidan/Documents/Aidana/Fh/5thSemester/SmartCity/MessMa/MessMaBackendCode/conf/routes
// @DATE:Sat Jan 12 15:56:27 CET 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseApiDocController ApiDocController = new controllers.ReverseApiDocController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAdminsApiController AdminsApiController = new controllers.ReverseAdminsApiController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDevelopersApiController DevelopersApiController = new controllers.ReverseDevelopersApiController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseApiDocController ApiDocController = new controllers.javascript.ReverseApiDocController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAdminsApiController AdminsApiController = new controllers.javascript.ReverseAdminsApiController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDevelopersApiController DevelopersApiController = new controllers.javascript.ReverseDevelopersApiController(RoutesPrefix.byNamePrefix());
  }

}
