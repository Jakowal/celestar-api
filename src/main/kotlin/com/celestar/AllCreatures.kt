package com.celestar

import com.celestar.models.Attack
import com.celestar.models.Creature
import java.util.*
import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*

/**
 * Azure Functions with HTTP Trigger.
 */
class AllCreatures {

    /**
     * This function listens at endpoint "/api/HttpTrigger-Java". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTrigger-Java&code={your function key}
     * 2. curl "{your host}/api/HttpTrigger-Java?name=HTTP%20Query&code={your function key}"
     * Function Key is not needed when running locally, it is used to invoke function deployed to Azure.
     * More details: https://aka.ms/functions_authorization_keys
     */
    @FunctionName("AllCreatures")
    fun run(
        @HttpTrigger(
            name = "",
            methods = [HttpMethod.GET],
            authLevel = AuthorizationLevel.FUNCTION) request: HttpRequestMessage<Optional<String>>,
        context: ExecutionContext): HttpResponseMessage {

        context.logger.info("HTTP trigger processed a ${request.httpMethod} request.")

        val testAttack = Attack("Test", "nothing", "bad")
        val aarakocra = Creature(UUID.randomUUID().toString(), "Aaracokra", 13, 12, listOf(testAttack), "")
        val aboleth = Creature(UUID.randomUUID().toString(), "Aboleth", 17, 135, listOf(testAttack), "")

        val testResponse = listOf(aarakocra,aboleth)

        return request
            .createResponseBuilder(HttpStatus.BAD_REQUEST)
            .body(testResponse)
            .build()
    }

}
