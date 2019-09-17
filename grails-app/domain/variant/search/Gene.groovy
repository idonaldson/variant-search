package variant.search

class Gene {

    Long id
    String name
    static hasMany = [variants: Variant]

    static constraints = {
        id (nullable:false)
        name (nullable: false)
    }
}
