package pl.szkolakotlina.polskie_blogi_it

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.TextNode
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class DataServiceKotlin {
  @Value("classpath:data.json")
  val resourceFile: Resource? = null

  val mapper = JsonMapper()

  private fun readResourceData(): JsonNode {
    return try {
      ObjectMapper().readTree(resourceFile!!.file)
    } catch (e: IOException) {
      TextNode.valueOf("")
    }
  }

  fun getAll(): List<BlogEntry> {
    return mapper.map(readResourceData())
  }

  fun getNewsletters(): List<BlogEntry> {
    return getAll().filter { it.type.contains("Newsletter") }
  }

  fun getPodcasts(): List<BlogEntry> {
    return getAll().filter { it.type.contains("Podcast") }
  }

  fun getBlogs(): List<BlogEntry> {
    return getAll().filter { it.type.contains("Blog") }
  }
}
