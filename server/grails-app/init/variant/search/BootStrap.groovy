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

                    def gene = new Gene()
                    gene.geneName = row["Gene"]
                    gene.nucleotideChange = row["Nucleotide Change"] ?: ""
                    gene.proteinChange = row["Protein Change"] ?: ""
                    gene.otherMappings = row["Other Mappings"] ?: ""
                    gene.alias = row["Alias"] ?: ""
                    gene.transcripts = row["Transcripts"] ?: ""
                    gene.region = row["Region"] ?: ""
                    gene.reportedClassification = row["Reported Classification"] ?: ""
                    gene.inferredClassification = row["Inferred Classification"] ?: ""
                    gene.source = row["Source"] ?: ""
                    gene.lastEvaluated = row["Last Evaluated"] ?: ""
                    gene.lastUpdated = row["Last Updated"] ?: ""
                    gene.url = row["URL"] ?: ""
                    gene.submitterComment = row["Submitter Comment"] ?: ""
//                    gene.assembly = row["Assembly"] ?: ""
//                    gene.chr = row["Chr"] ?: ""
//                    gene.genomicStart = row["Genomic Start"] ?: ""
//                    gene.genomicStop = row["Genomic Stop"] ?: ""
//                    gene.ref = row["Ref"] ?: ""
//                    gene.alt = row["Alt"] ?: ""
//                    gene.accession = row["Accession"] ?: ""
//                    gene.reportedRef = row["Reported Ref"] ?: ""
//                    gene.reportedAlt = row["Reported Alt"] ?: ""
                    gene.save(failOnError: true);
                }
            }
                println "Total records loaded: ${count}"
        }

    }
    def destroy = {
    }
}
