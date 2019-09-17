package variant.search

class Variant {

    static belongsTo = [gene: Gene]

    String nucleotideChange
    String proteinChange
    String otherMappings
    String alias
    String transcripts
    String region
    String reportedClassification
    String inferredClassification
    String source
    Date   lastEvaluated
    Date   lastUpdated
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
    }
}
