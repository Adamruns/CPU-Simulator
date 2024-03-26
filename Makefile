# Define the main class and the directory for source and compiled files
MAIN_CLASS = main.java.Main
SRC_DIR = src/main/java
BIN_DIR = bin

# Compile the java project
build:
	@echo "Compiling Java source files..."
	javac -d $(BIN_DIR) $(SRC_DIR)/**/*.java

# Run the compiled project
run: build
	@echo "Running the application..."
	java -cp $(BIN_DIR) $(MAIN_CLASS)

# Clean the bin directory
clean:
	@echo "Cleaning up..."
	rm -rf $(BIN_DIR)/*