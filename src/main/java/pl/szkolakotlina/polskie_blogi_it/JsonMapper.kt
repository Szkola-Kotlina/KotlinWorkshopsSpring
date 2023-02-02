package pl.szkolakotlina.polskie_blogi_it

import com.fasterxml.jackson.databind.JsonNode

class BlogEntry(
  val name: String,
  val url: String,
  val author: String,
  val type: List<String>,
  val category: List<String>,
)

class JsonMapper {
  fun map(json: JsonNode): List<BlogEntry>{
    return json.get("records")
      .map {
        val fields = it.get("fields")
        val name = fields.get("Nazwa").asText()
        val type: List<String> = fields.get("Typ").map { it.asText() }
        val url = fields.get("WWW").asText()
        val category = getCategory(fields)
        val author = if(fields.get("Autor")!=null) fields.get("Autor").asText() else ""

        BlogEntry(name, url, author, type, category)
      }
  }

  private fun getCategory(fields: JsonNode): List<String> {
    return if(fields.get("Tematyka") != null){
      fields.get("Tematyka").map { it.asText() }
    } else {
      emptyList()
    }
  }
}

// {
//      "id": "rec3Uo4IQ68HhHSFT",
//      "createdTime": "2022-05-17T11:57:03.000Z",
//      "fields": {
//        "Typ": [
//          "Blog",
//          "Newsletter"
//        ],
//        "Dodatkowe informacje": "uxowy.dev to przede wszystkim newsletter",
//        "Approved": true,
//        "WWW": "https://uxowy.dev/",
//        "Nazwa": "uxowy.dev - developer musi znać podstawy UI/UX",
//        "RSS": "https://uxowy.dev/email/rss/  + https://uxowy.dev/blog/rss/",
//        "Tematyka": [
//          "UX",
//          "Frontend"
//        ],
//        "Autor": "Mikołaj Waśkowski",
//        "Created": "2022-05-17T11:57:03.000Z",
//        "Last Modified": "2022-05-18T18:20:27.000Z"
//      }
//    },
