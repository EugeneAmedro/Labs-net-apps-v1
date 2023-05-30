import jakarta.servlet.ServletException
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@WebServlet(name = "HelloWorldServlet", value = ["/hello-servlet"])
class HelloWorldServlet : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest, res: HttpServletResponse) {
        val key = req.getParameter("key")
        val value = req.getParameter("value").toInt()
        val test = req.getParameter("test").toBoolean()

        servletContext.log(
            "Request method: ${req.method}\n" +
                    "Request Client IP: ${req.remoteAddr}\n" +
                    "Request Params: ${req.parameterMap}\n" +
                    "Request User-agent: ${req.getHeader("User-Agent")}" +
                    "Key Param: ${key}\n" +
                    "Value Param: ${value}\n" +
                    "Test Param: ${test}\n"
        )

        if (test) {
            res.contentType = "text/html"
            res.writer.println("<html><body>")
            res.writer.println("Request accepted with test checkbox")
            res.writer.println("</body></html>")
        } else {
            val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
            val line = "${key.repeat(value)}, $timestamp\n"
            val file = File("database.txt")

            FileWriter(file, true).use { it.write(line) }

            res.contentType = "text/html"
            res.writer.println("<html><body>")
            res.writer.println(file.readText())
            res.writer.println("</body></html>")
        }
    }
}