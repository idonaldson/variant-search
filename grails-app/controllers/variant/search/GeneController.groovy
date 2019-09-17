package variant.search


import grails.rest.*
import grails.converters.*

class GeneController extends RestfulController {
    static responseFormats = ['json', 'xml']
    GeneController() {
        super(Gene)
    }

    def search(String query, Integer max) {
        if (query) {
            def geneQuery = Gene.where {
                geneName ==~ "%${query}%"
            }

            respond geneQuery.list(max: Math.min( max ?: 10, 100))
        } else {
            respond([])
        }
    }
}
