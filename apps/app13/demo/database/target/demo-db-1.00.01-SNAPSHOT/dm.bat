@echo off

rem construct classpath
setlocal EnableDelayedExpansion 
set CP=.
for %%L in (.\lib\*.jar ) do set CP=!CP!;%%L
set CLASSPATH=%CP%;%CLASSPATH%

rem start application
java  ru.diasoft.fa.platform.database.DatabaseManager %* 
