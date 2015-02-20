# restfb-benchmark
Set of benchmarks to improve the restfb library

### How to run?
 * ``git clone https://github.com/restfb/restfb-benchmark.git``
 * ``cd restfb-benchmark``
 * ``mvn clean package``
 * ``./benchmark.sh``
 
When you call the ``benchmark.sh`` script, you simply call a wrapper that's implemented around the JMH execution.

At the moment there are 3 different options:

run the benchmark with ``default`` settings
--------------------------------------------

```
./benchmark.sh 
```
run the benchmark with ``quick`` settings
--------------------------------------------

```
./benchmark.sh quick
```
run the benchmark with ``medium`` settings
--------------------------------------------

```
./benchmark.sh medium
```