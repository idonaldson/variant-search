package variant.search

import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Transactional
class GeneService {

    def list() {

    }

    def geneResults(String value, Integer max) {
        def geneQuery = Gene.where {
            geneName == "${value}"
        }
        def resultList = geneQuery.list(max: Math.min( max ?: 10, 100))
    }

    def suggestions(String value, Integer max) {
        def c = Gene.createCriteria()
        def results = c.list() {
            like("geneName", "${value}%")
            order("geneName", "asc")
        }
        results.unique{it.geneName}
    }

    int count() {
        Gene.count() as int
    }
}
