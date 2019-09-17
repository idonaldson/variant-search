package variant.search

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class VariantSpec extends Specification implements DomainUnitTest<Variant> {

    void "testing validation"() {
        when: 'Saving invalid data'
        Gene gene = new Gene(id: null, name: '')
        gene.save()

        then: 'errors were found, nothing saved'
        gene.hasErrors()
        gene.errors.getFieldError('id')
        gene.errors.getFieldError('name')
        Gene.count() == 0

        when: 'Saving valid data'
        gene.id = 1
        gene.name = 'CDKL5'
        gene.save()

        then: 'Gene saved'
        Gene.count() == 1
        Gene.first().id == 1
    }
}
