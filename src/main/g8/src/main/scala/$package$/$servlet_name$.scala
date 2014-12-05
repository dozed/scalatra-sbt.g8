package $package$

import org.scalatra._
import org.scalatra.scalate.ScalateSupport

class $servlet_name$ extends ScalatraServlet with ScalateSupport {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

  notFound {
    // remove content type in case it was set through an action
    contentType = null
    // Try to render a scalate template if no route matched, fallback to static resource and then not found
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }

}
