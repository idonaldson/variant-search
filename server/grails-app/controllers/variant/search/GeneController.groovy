package variant.search


import grails.rest.*
import grails.converters.*
import org.grails.web.json.JSONArray

class GeneController extends RestfulController {
    static responseFormats = ['json', 'xml']
    GeneController() {
        super(Gene)
    }

    def results(String geneName, Integer max) {
        println(geneName)
        if (geneName) {
            def geneQuery = Gene.where {
                geneName == "${geneName}"
            }
            respond geneQuery.list(max: Math.min( max ?: 10, 100))
        } else {
            respond([])
        }
    }

    def suggestion(String value, Integer max) {
        if (value) {
            def c = Gene.createCriteria()
            def results = c.list (max: Math.min( max ?: 10, 100), offset: 10) {
                like("geneName", "${value}%")
                order("geneName", "asc")
            }
            respond results
        } else {
            respond([])
        }
    }
}
