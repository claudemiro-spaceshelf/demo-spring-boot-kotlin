package co.spaceshelf.spaceshelfdemo.controllers

import co.spaceshelf.spaceshelfdemo.entities.Webhook
import co.spaceshelf.spaceshelfdemo.repositories.WebhookRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebhooksController(val repository: WebhookRepository) {
    @PostMapping("/webhooks/on-create-order")
    fun onCreateOrder(@RequestBody input: CreateOrderInput): String {
        val id = input.id ?: 0
        repository.save(Webhook(null, id))
        return "Hello, World!"
    }
}

data class CreateOrderInput(
    val id: Long?,
    val adminGraphQlApiId: Long?
)