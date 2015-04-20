JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = $(wildcard ./*.java)

TESTFILES = uf_2000.union \
						uf_4000.union \
						uf_8000.union \
						uf_16000.union \
						uf_32000.union \
						uf_64000.union \
						uf_128000.union \
						uf_256000.union \
						uf_512000.union \
						uf_1024000.union

.PHONY: clean testfiles test rm_tests

default: classes

test: classes testfiles
	./test

testfiles: rm_tests $(TESTFILES)

rm_tests:
	rm *.union *.connected

%.union:
	./generateN -n $(patsubst uf_%.union, %, $@)

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
