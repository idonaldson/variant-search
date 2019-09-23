package variant.search

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class GeneSpec extends Specification implements DomainUnitTest<Gene> {

    void "testing validation"() {
        when: 'Saving invalid data'
        Gene gene = new Gene(geneName: null)
        gene.save()

        then: 'errors were found, nothing saved'
        gene.hasErrors()
        gene.errors.getFieldError('geneName')
        Gene.count() == 0

        when: 'Saving a valid gene'
        gene.geneName = 'CDKL5'
        gene.save()

        then: 'Gene saved'
        Gene.count() == 1
        Gene.first().id == 1
    }
}
