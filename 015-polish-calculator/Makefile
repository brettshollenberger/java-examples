JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Expr.java \
        ArithmeticExpr.java \
        NumericExpr.java \
        Stack.java \
        Polish.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
