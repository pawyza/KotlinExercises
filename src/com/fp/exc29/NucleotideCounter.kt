package com.fp.exc29

object NucleotideCounter{

    fun displayNucleotides(gen : String) : String{
        require(!Regex("""[^a-zA-Z]""").containsMatchIn(gen)){"Genes cannot contain numbers"}
        val nucleotides = countNucleotides(gen)
        return String.format("A: %d\nT: %d\nC: %d\nG: %d\nother: %d",
            nucleotides.n('A'),nucleotides.n('T'),nucleotides.n('C'),nucleotides.n('G'),
            nucleotides.values.sum() - (nucleotides.n('A') + nucleotides.n('T') + nucleotides.n('C') + nucleotides.n('G')))
    }

    private fun countNucleotides(gen : String) : Map<Char,Int>{
        val result = mutableMapOf<Char,Int>()
        gen.toUpperCase().map{ c -> result.computeIfPresent(c) { _ : Char, v : Int -> v + 1 }
            result.putIfAbsent(c,1)}
        return result
    }

    private infix fun Map<Char,Int>.n(keyString : Char) : Int = this.getOrDefault(keyString,0)
}