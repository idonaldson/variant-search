package variant.search


import grails.rest.*
import grails.converters.*
import org.grails.web.json.JSONArray

class GeneController extends RestfulController {

    GeneService geneService

    static responseFormats = ['json', 'xml']
    GeneController() {
        super(Gene)
    }

    def suggestion(String value, Integer max) {
        if (value) {
            respond geneService.suggestions(value, max)
        } else {
            respond([])
        }
    }

    def results(String geneName, Integer max) {
        if (geneName) {
            respond geneService.geneResults(geneName, max)
        } else {
            respond([])
        }
    }
}
