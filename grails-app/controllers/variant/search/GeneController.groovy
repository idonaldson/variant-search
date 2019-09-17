package variant.search


import grails.rest.*
import grails.converters.*
import org.grails.web.json.JSONArray

class GeneController extends RestfulController {
    static responseFormats = ['json', 'xml']
    GeneController() {
        super(Gene)
    }

    def search(String query, Integer max) {
        if (query) {
            //first method of finding objects is by using a where clause, the double equal tilde is a match operator similar to find
            def geneQuery = Gene.where {
                geneName ==~ "%${query}%"
            }

            respond geneQuery.list(max: Math.min( max ?: 10, 100))
        } else {
            respond([])
        }
    }

    def suggestion(String term) {
        if (term) {
            // second method to finding objects is using the built in findAll/findOne etc methods
            def foundItems = Gene.findAllByGeneNameLike(term + "%", params)
            List suggestions = new ArrayList()
            foundItems.each {
                suggestions.add(it.geneName)
            }
            respond suggestions
        } else {
            respond([])
        }
    }
}
