package hello

import org.jgrapht.graph.SimpleGraph

fun main(vararg args: String) {
    run {
        val adjacencyList = mapOf(
            "a" to listOf("b", "d", "d", "e"),
            "b" to listOf("c", "a"),
            "c" to listOf("b", "d"),
            "d" to listOf("a", "a", "c"),
            "e" to listOf("a")
        )

        val graph = buildGraph(adjacencyList)

        println(graph)
        println(graph.vertexSet())
        println(graph.edgesOf("a"))
        println(graph.edgesOf("b"))

        traverse(graph)
    }
}

fun <V, E> traverse(graph: SimpleGraph<V, E>) {
    val visitedSet = mutableSetOf<V>()

    val queue = mutableListOf<V>()
    queue += graph.vertexSet().first()

    while (queue.size > 0) {
        val vertex = queue.removeAt(0)

        if (vertex !in visitedSet) {
            println(vertex)
            visitedSet += vertex

            val edges = graph.edgesOf(vertex)
            for (edge in edges) {
                queue += graph.getEdgeTarget(edge)
            }
        }
    }
}
