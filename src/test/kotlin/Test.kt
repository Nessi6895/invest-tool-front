import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

fun main(args: Array<String>) {
    val mapper = ObjectMapper().registerModule(KotlinModule())
    val person = mapper.readValue("{\"id\":1, \"name\":\"Artyom\"}", Person::class.java)
    println("Default toString function:")
    println(person)
    println("Jackson style:")
    println(mapper.writeValueAsString(person))
}

data class Person(val id: Int, val name: String) {
    override fun toString(): String {
        return "Person [ id=$id, name=$name]"
    }
}
