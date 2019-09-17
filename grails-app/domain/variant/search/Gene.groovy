package variant.search

class Gene {

    Long id
    String geneName
    String nucleotideChange
    String proteinChange
    String otherMappings
    String alias
    String transcripts
    String region
    String reportedClassification
    String inferredClassification
    String source
    String   lastEvaluated
    String   lastUpdated
    String url
    String submitterComment
    String assembly
    Long chr
    Long genomicStart
    Long genomicStop
    String ref
    String alt
    String accession
    String reportedRef
    String reportedAlt

    static constraints = {
        geneName (nullable: false)
        nucleotideChange (nullable: true)
        proteinChange (nullable: true)
        otherMappings (nullable: true, sqlType:'text')
        alias (nullable: true)
        transcripts (nullable: true, sqlType:'text')
        region (nullable: true)
        reportedClassification (nullable: true)
        inferredClassification (nullable: true)
        source (nullable: true)
        lastEvaluated (nullable: true)
        lastUpdated (nullable: true)
        url (nullable: true)
        submitterComment (nullable: true, sqlType:'text')
        assembly (nullable: true)
        chr (nullable: true)
        genomicStart (nullable: true)
        genomicStop (nullable: true)
        ref (nullable: true)
        alt (nullable: true)
        accession (nullable: true)
        reportedRef (nullable: true)
        reportedAlt (nullable: true)
    }
}
