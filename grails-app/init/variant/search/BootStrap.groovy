package variant.search

import org.grails.io.support.ClassPathResource
import static com.xlson.groovycsv.CsvParser.parseCsv


class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        if (Gene.count() == 0) {
            def filePath = "resources/variants.tsv"
            def text = grailsApplication.getParentContext().getResource("classpath:$filePath").getInputStream().getText()

            def data = parseCsv(text, separator: '\t')

            for (geneData in data) {
                if (geneData["Gene"].toString().length() > 0){
                    def gene = new Gene(name: geneData["Gene"]).save(failOnError: true);
                }
            }
        }

    }
    def destroy = {
    }
}
