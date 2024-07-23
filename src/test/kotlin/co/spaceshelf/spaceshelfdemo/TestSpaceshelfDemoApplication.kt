package co.spaceshelf.spaceshelfdemo

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<SpaceshelfDemoApplication>().with(TestcontainersConfiguration::class).run(*args)
}
