package variant.search

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class GeneControllerIntSpec extends Specification {
    @Shared RestBuilder rest = new RestBuilder()

    void 'Suggestions endpoint returns appropriate suggestions'() {
        when:
        RestResponse resp = rest.get("http://localhost:${serverPort}/suggestion?value=A2&max=25")

        then:
        resp.status == 200
        resp.json.size() == 11
        resp.json.find { it.geneName == 'A2ML1' }

    }

    void 'Results endpoint returns the correct model'() {
        when:
        RestResponse resp = rest.get("http://localhost:${serverPort}/results?value=A2ML1")

        then:
        resp.status == 200
        resp.json.size() == 9
        resp.json.find { it.geneName == 'A2ML1' }
    }

}
