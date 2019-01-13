
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Christoph/IdeaProjects/MessMaBackend/conf/routes
// @DATE:Sun Jan 13 12:40:09 CET 2019


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
