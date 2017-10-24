.SUFFIXES: .class .java

TARG=Test
JC=javac -g
JM=java -ea -jar
JR=jar -cfe

OBJ=Date.class \
    Time.class \
    Test.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

test: Test.class
	$(JM) Test.jar

build: 	$(OBJ)
	$(JR) $(TARG).jar $.Test $(OBJ)

clean:
	$(RM) *.class
	$(RM) *.jar


