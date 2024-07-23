package co.spaceshelf.spaceshelfdemo.controllers

import co.spaceshelf.spaceshelfdemo.TestcontainersConfiguration
import co.spaceshelf.spaceshelfdemo.repositories.WebhookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestcontainersConfiguration::class)
class WebhooksControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var repository: WebhookRepository

    @Test
    fun `onCreateOrder must reply with a greeting message`() {
        mockMvc.perform(
            post("/webhooks/on-create-order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """{"id": 820982911946154508, "admin_graphql_api_id": "gid://shopify/Order/820982911946154508"}"""
                )
        ).andExpect(status().isOk).andExpect(content().string("Hello, World!"))

        assertEquals(1, repository.count())
        assertEquals(820982911946154508, repository.findAll().first().webhookId)
    }
}