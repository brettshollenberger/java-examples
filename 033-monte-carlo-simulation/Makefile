JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

TESTDIR = test

CLASSES = $(wildcard ./*.java)

TESTFILES = $(wildcard $(TESTDIR)/*.java)

default: classes

classes: $(CLASSES:.java=.class)

test: classes test_classes
	CLASSPATH=$(CLASSPATH):./test java org.junit.runner.JUnitCore $(patsubst %.java,%,$(notdir $(TESTFILES))) 

test_classes: $(TESTFILES:.java=.class)

clean:
	$(RM) *.class
