JC         = javac
JFLAGS     = -g
TESTDIR    = test
CLASSFILES = $(patsubst %.java, %.class, $(wildcard ./*.java))
TESTFILES  = $(patsubst %.java, %.class, $(wildcard $(TESTDIR)/*.java))

default: classes

classes: $(CLASSFILES)

test_classes: $(TESTFILES)

%.class: %.java
	$(JC) $(JFLAGS) $<

test: classes test_classes
	CLASSPATH=$(CLASSPATH):./test java org.junit.runner.JUnitCore $(patsubst %.class,%,$(notdir $(TESTFILES))) 
