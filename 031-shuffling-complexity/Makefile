JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
					Range.java \
					Stopwatch.java \
					NSquaredShuffler.java \
					KnuthShuffler.java \
					NSquaredRandomQueue.java \
					KnuthRandomQueue.java \
					Main.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
