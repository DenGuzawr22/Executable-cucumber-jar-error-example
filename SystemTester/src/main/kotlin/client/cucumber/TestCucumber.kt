package client.cucumber

import io.cucumber.java8.En
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TestCucumber : En {
    init {
        Given("I ask {int} id") { id: Int ->
            assertEquals(id, id)

        }
        Then("I receive {int} that is equal to input") {id: Int ->
            assertEquals(id, id)
        }
        Given("an incorrect input as {word}") { aa: String ->
            assertNotNull(aa)
        }
        Then("I have an error") {
           println("an error")
        }
    }
}