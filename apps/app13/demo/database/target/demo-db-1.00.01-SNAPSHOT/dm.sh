#!/bin/sh
CP=".";
for i in $(find lib -name \*.jar); do
CP="$CP:$i"
done
echo $CP
$JAVA_HOME/bin/java -classpath $CP ru.diasoft.fa.platform.database.DatabaseManager $* 
