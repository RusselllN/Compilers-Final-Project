# .PHONY: build run clean

# name = assignment_3

# CLASSPATH = /antlr-4.11.1-complete.jar:./target
# JAVAC = javac -cp $(CLASSPATH)
# ANTLR = java -jar /antlr-4.11.1-complete.jar -no-visitor -no-listener
# TESTRIG = java -cp $(CLASSPATH) org.antlr.v4.gui.TestRig

# build:
# 	mkdir -p ./target
# 	kotlinc -cp $(CLASSPATH) -d ./target ./src/backend/*.kt
# 	$(ANTLR) -o ./target/ ./src/*.g4
# 	$(JAVAC) -d ./target ./target/src/*.java

# run:
# 	@jupyter nbconvert \
# 		--to notebook --execute worksheet.ipynb --output output.ipynb 2>&1 | \
# 		grep -v '\[main\]' | grep -v '\[IOPUB\]' | grep -v '\[Thread-' | \
# 	       	grep -v '\[NbConvertApp\]'

# get:
# 	cp -R -T ~/public/$(name) ~/work/$(name)/

# clean:
# 	rm -rf ./target
# 	rm -f ./output.ipynb

# Example Makefile for building Kotlin with ANTLR

# Define the Kotlin source and target directories
SRC_DIR = ./src/backend
TARGET_DIR = ./target
ANTLR_SRC = ./src
ANTLR_TARGET = $(TARGET_DIR)

# Define the path to the ANTLR jar
ANTLR_JAR = /usr/local/lib/antlr-4.11.1-complete.jar

# Create the target directory if it doesn't exist
$(TARGET_DIR):
	mkdir -p $(TARGET_DIR)

# Compile Kotlin files
compile_kotlin: $(TARGET_DIR)
	kotlinc -cp $(ANTLR_JAR):$(TARGET_DIR) -d $(TARGET_DIR) $(SRC_DIR)/*.kt

# Generate source files from ANTLR grammars
generate_antlr_sources: $(TARGET_DIR)
	java -jar $(ANTLR_JAR) -no-visitor -no-listener -o $(ANTLR_TARGET) $(ANTLR_SRC)/*.g4

# Default target to build everything
build: compile_kotlin generate_antlr_sources

# Clean up the target directory
clean:
	rm -rf $(TARGET_DIR)

.PHONY: build compile_kotlin generate_antlr_sources clean
