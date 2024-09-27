#!/bin/bash

# Extract the java version from the .sdkmanrc file
JAVA_VERSION=$(grep '^java=' .sdkmanrc | cut -d'=' -f2)

# Define the source and destination paths
SRC_FILE="lib/hotswap-agent-2.0.1.jar"
DEST_DIR=~/.sdkman/candidates/java/$JAVA_VERSION/lib/hotswap
DEST_FILE="$DEST_DIR/hotswap-agent.jar"

# Create the destination directory if it doesn't exist
mkdir -p "$DEST_DIR"

# Copy the file to the destination
cp "$SRC_FILE" "$DEST_FILE"

echo "$SRC_FILE copied to $DEST_FILE"
