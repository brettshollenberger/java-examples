JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Deque.java \
				Main.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
