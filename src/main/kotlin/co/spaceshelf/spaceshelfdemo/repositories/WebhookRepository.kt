package co.spaceshelf.spaceshelfdemo.repositories

import co.spaceshelf.spaceshelfdemo.entities.Webhook
import org.springframework.data.repository.CrudRepository

interface WebhookRepository : CrudRepository<Webhook, Long>