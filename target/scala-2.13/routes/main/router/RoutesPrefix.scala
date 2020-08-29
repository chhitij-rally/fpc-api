// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/phani/Repo/phanitumuluri-rally/fpc/fpc-api/conf/routes
// @DATE:Sat Aug 29 09:37:58 IST 2020


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
