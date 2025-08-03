#!/bin/bash

# Script pour exécuter l'application JavaFX

# Configurer Java 24
export JAVA_HOME=/Users/vladlukyanov/Library/Java/JavaVirtualMachines/openjdk-24.0.1/Contents/Home

echo "Configuration Java:"
echo "JAVA_HOME = $JAVA_HOME"
$JAVA_HOME/bin/java -version

echo ""
echo "Compilation et exécution de l'application JavaFX..."
mvn clean javafx:run 