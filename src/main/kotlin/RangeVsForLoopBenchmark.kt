package dev.databoss.foreach.bench

import kotlinx.benchmark.*

@State(Scope.Benchmark)
class RangeVsForLoopBenchmark {
    @Param("10", "100")
    var iterationsPerForEach = 0

    // Just a dummy counter so that the loop actually does something..
    private var counter = 0L

    @Setup
    fun prepare() {
    }

    @TearDown
    fun cleanup() {
        counter = 0L
    }

    @Benchmark
    fun rangedForEach(bh: Blackhole) {
        (0..iterationsPerForEach).forEach {
            bh.consume(it)
        }
    }

    @Benchmark
    fun forLoop(bh: Blackhole) {
        for (i in 0..iterationsPerForEach) {
            bh.consume(i)
        }
    }
}
