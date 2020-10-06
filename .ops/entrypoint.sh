#!/usr/bin/env bash

echo "Running app with PROFILE = $PROFILE"

if [ $PROFILE != 'dev' ]; then
  sh env-configurer.sh
  java $JVM_XMS $JVM_XMX -jar $JAR
else
  java -Xms64m -Xmx256m -jar $JAR
fi
