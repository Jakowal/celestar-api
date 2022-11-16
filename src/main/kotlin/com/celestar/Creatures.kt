package com.celestar

import com.celestar.models.Attack
import com.celestar.models.Creature
import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*
import java.util.*

/**
 * Azure Functions with HTTP Trigger.
 */
class Creatures {

    /**
     * This function listens at endpoint "/api/HttpTrigger-Java". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTrigger-Java&code={your function key}
     * 2. curl "{your host}/api/HttpTrigger-Java?name=HTTP%20Query&code={your function key}"
     * Function Key is not needed when running locally, it is used to invoke function deployed to Azure.
     * More details: https://aka.ms/functions_authorization_keys
     */
    @FunctionName("Creatures")
    fun run(
        @HttpTrigger(
            name = "req",
            methods = [HttpMethod.GET],
            authLevel = AuthorizationLevel.FUNCTION) request: HttpRequestMessage<Optional<String>>,
        context: ExecutionContext): HttpResponseMessage {

        context.logger.info("HTTP trigger processed a ${request.httpMethod} request.")


        // Parse query parameter
        val query = request.queryParameters["name"]
        val name = request.body.orElse(query)
        val testAttack = Attack("Test", "nothing", "bad")
        val namedCreature = Creature(UUID.randomUUID().toString(), name, 13, 12, listOf(testAttack), "")

        return request
            .createResponseBuilder(HttpStatus.BAD_REQUEST)
            .body(namedCreature)
            .build()
    }

}
