# Define a variable for the Java compiler
JCC = javac

# Define a variable for compilation flags
# The -g flag compiles with debugging information
JFLAGS = -g

# Clear the default suffixes
.SUFFIXES: .java .class

# Here, redefine the suffixes as .java and .class
# This allows us to use make's implicit rules for Java compilation
.java.class:
    $(JCC) $(JFLAGS) $*.java

# Define a variable for the Java source files
# This will find all .java files in the controller, model, and view directories
SOURCES = $(wildcard controller/*.java model/*.java view/*.java)

# Define a variable for the class files
# This uses the sources list, but replaces the .java extension with .class
CLASSES = $(SOURCES:.java=.class)

# The default make target entry
default: classes

# This target entry builds the .class files
# It depends on the .java files
classes: $(CLASSES)

# The clean target removes .class files
# This is a phony target, meaning it's not a file name
clean:
    $(RM) controller/*.class model/*.class view/*.class

# The run target executes the main class
# You can add the arguments if required after the class name
run: classes
    java main.Main

# Define a phony target to avoid problems with files named clean and run
.PHONY: default classes clean run
