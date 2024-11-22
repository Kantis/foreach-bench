## Context
I was curious whether the Detekt rule [ForEachOnRange](https://detekt.dev/docs/rules/performance/#foreachonrange)
is still relevant. The rule was introduced with references to a 7 year old blog article, and I was hoping that there 
might have been performance optimizations either in the language or the compiler which made the rule irrelevant by now.

Given the results below, it seems that the rule is still relevant.


## Running the benchmark

`./gradlew mainBenchmark` will run the benchmark

## Benchmark results (M1 Max, 64GB)

```
main summary:
Benchmark                i             (iterationsPerForEach)   Mode  Cnt          Score          Error  Units
RangeVsForLoopBenchmark.forLoop                            10  thrpt    5  449993800,059 ± 26032787,135  ops/s
RangeVsForLoopBenchmark.forLoop                           100  thrpt    5  123058934,812 ±   803845,361  ops/s
RangeVsForLoopBenchmark.rangedForEach                      10  thrpt    5  212422928,653 ±  2200979,906  ops/s
RangeVsForLoopBenchmark.rangedForEach                     100  thrpt    5   20090642,098 ±  1329771,102  ops/s
```
