package variant.search

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.testing.web.controllers.ControllerUnitTest
import org.grails.testing.GrailsUnitTest
import spock.lang.Specification

class GeneControllerSpec extends Specification implements ControllerUnitTest<GeneController> {

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    void setup() {
        Gene.saveAll(
                new Gene(id: 1, geneName: 'CDKL5'),
                new Gene(id: 2, geneName: 'PGAM4'),
                new Gene(id: 3, geneName: 'WDR25'),
                new Gene(id: 4, geneName: 'RHD'),
                new Gene(id: 5, geneName: 'AMY1A')
        )
    }

    void 'test the search endpoint finds a result'() {
        when: 'A user submits a query that has results'
        controller.search('CD', 10)

        then: 'The response is correct'
        response.json.size() == 1
        response.json[0].geneName == 'CDKL5'
    }
}