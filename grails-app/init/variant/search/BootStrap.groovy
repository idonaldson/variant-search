package variant.search

import org.grails.io.support.ClassPathResource
import static com.xlson.groovycsv.CsvParser.parseCsv


class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        if (Gene.count() == 0) {
            def count = 0
            def filePath = "resources/variants.tsv"
            def text = grailsApplication.getParentContext().getResource("classpath:$filePath").getInputStream().getText()

            def data = parseCsv(text, separator: '\t')

            for (row in data) {
                if (row["Gene"].toString().length() > 0){
                    count++
                    def gene = new Gene(
                            geneName: row["Gene"],
                            nucleotideChange: row["Nucleotide Change"],
                            proteinChange: row["Protein Change"],
                            otherMappings: row["Other Mappings"],
                            alias: row["Alias"],
                            transcripts: row["Transcripts"],
                            region: row["Region"],
                            reportedClassification: row["Reported Classification"],
                            inferredClassification: row["Inferred Classification"],
                            source: row["Source"],
                            lastEvaluated: row["Last Evaluated"],
                            lastUpdated: row["Last Updated"],
                            url: row["URL"],
                            submitterComment: row["Submitter Comment"],
//                            assembly: row["Assembly"],
//                            chr: row["Chr"],
//                            genomicStart: row["Genomic Start"],
//                            genomicStop: row["Genomic Stop"]
//                            ref: row["Ref"],
//                            alt: row["Alt"],
//                            accession: row["Accession"],
//                            reportedRef: row["Reported Ref"],
//                            reportedAlt: row["Reported Alt"]
                    ).save(failOnError: true);
                }
            }
                println "Total records loaded: ${count}"
        }

    }
    def destroy = {
    }
}
