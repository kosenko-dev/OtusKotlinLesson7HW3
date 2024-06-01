import kotlin.properties.Delegates

data class HttpRequest(val method: String, val url: String, val headers: Map<String, String>, val body: String?)

class HttpRequestDSL {
    lateinit var method: String
    lateinit var url: String
    lateinit var headers: Map<String, String>
    var body: String by Delegates.notNull<String>()

    fun toHttpRequest(): HttpRequest = HttpRequest(this.method, this.url, this.headers, this.body)
}

fun post(config: HttpRequestDSL.() -> Unit): HttpRequest {
    return HttpRequestDSL().apply(config).toHttpRequest()
}

fun get(config: HttpRequestDSL.() -> Unit): HttpRequest {
    return HttpRequestDSL().apply(config).toHttpRequest()
}

fun put(config: HttpRequestDSL.() -> Unit): HttpRequest {
    return HttpRequestDSL().apply(config).toHttpRequest()
}

fun delete(config: HttpRequestDSL.() -> Unit): HttpRequest {
    return HttpRequestDSL().apply(config).toHttpRequest()
}

fun main() {
    val request = post {
        method("POST")
        url("https://example.com/api")
        header {
            contentType("application/json")
            authorization("Bearer token")
        }
        body("""{"name": "John", "age": 30}""")
    }
}

fun authorization(s: String) {

}

fun contentType(s: String) {
    TODO("Not yet implemented")
}

fun body(s: String) {
    TODO("Not yet implemented")
}

fun header(function: () -> Unit) {
    TODO("Not yet implemented")
}

fun url(s: String) {
    TODO("Not yet implemented")
}

fun method(s: String) {
    TODO("Not yet implemented")
}
