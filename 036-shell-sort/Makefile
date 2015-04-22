JC           = javac
JFLAGS       = -g
TESTDIR      = test
BENCHDIR     = bench
CLASSFILES   = $(patsubst %.java, %.class, $(wildcard ./*.java))
TESTFILES    = $(patsubst %.java, %.class, $(wildcard $(TESTDIR)/*.java))
BENCHFILES   = $(patsubst %, %.bench, $(BENCHNUMBERS))
BENCHNUMBERS = 2000 \
							 4000 \
							 8000 \
							 16000 \
							 32000 \
							 64000 \
							 128000 \
							 256000 \
							 512000 \
							 1024000

default: classes

classes: $(CLASSFILES)

test_classes: $(TESTFILES)

benchfiles: rm_bench $(BENCHFILES)

bench: benchfiles
	./bench.rb

rm_bench:
	rm -f $(BENCHDIR)/*

%.bench:
	./genbench -n $*

%.class: %.java
	$(JC) $(JFLAGS) $<

test: classes test_classes
	CLASSPATH=$(CLASSPATH):./test java org.junit.runner.JUnitCore $(patsubst %.class,%,$(notdir $(TESTFILES))) 
