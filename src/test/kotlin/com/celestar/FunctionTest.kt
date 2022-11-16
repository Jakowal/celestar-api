package com.celestar

import com.microsoft.azure.functions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*
import java.util.Optional
import java.util.logging.Logger
import kotlin.collections.HashMap

/**
 * Unit test for Function class.
 */
class FunctionTest {

    inline fun <reified T : Any> mock() = mock(T::class.java)

    private fun testHttpTrigger(httpMethod: HttpMethod) {
    }

    /**
     * Unit test for HttpTrigger GET method.
     */
    @Test
    @Throws(Exception::class)
    fun testHttpTriggerGET() {
        testHttpTrigger(HttpMethod.GET)
    }

    /**
     * Unit test for HttpTrigger POST method.
     */
    @Test
    @Throws(Exception::class)
    fun testHttpTriggerPOST() {
        testHttpTrigger(HttpMethod.POST)
    }

}
