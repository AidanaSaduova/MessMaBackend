
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/aidan/Documents/Aidana/Fh/5thSemester/SmartCity/MessMa/MessMaBackendCode/conf/routes
// @DATE:Sun Jan 13 14:42:53 CET 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
