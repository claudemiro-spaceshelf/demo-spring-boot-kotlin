package co.spaceshelf.spaceshelfdemo.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("webhooks")
data class Webhook(
    @Id val id: Long?,
    val webhookId: Long
)