package de.swirtz.vertx.embedded

import io.vertx.core.*


fun main(args: Array<String>) {
    val vertx = Vertx.vertx()

    var timeCounter = 0;
    vertx.setPeriodic(4000, { timeCounter+=1; println("$timeCounter: Hello, I am your first Vertx Timer")})

    Thread.sleep(2000)

    vertx.createHttpServer().requestHandler { e -> e.response().end("answer from kotlin vertx app!") }.listen(8000)
}
