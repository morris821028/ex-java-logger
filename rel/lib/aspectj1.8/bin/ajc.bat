@echo off
REM This file generated by AspectJ installer
REM Created on Mon Feb 26 20:46:25 CST 2018 by User

if "%JAVA_HOME%" == "" set JAVA_HOME=C:\Program Files\Java\jre1.8.0_151
if "%ASPECTJ_HOME%" == "" set ASPECTJ_HOME=c:\aspectj1.8

if exist "%JAVA_HOME%\bin\java.exe" goto haveJava
if exist "%JAVA_HOME%\bin\java.bat" goto haveJava
if exist "%JAVA_HOME%\bin\java" goto haveJava
echo java does not exist as %JAVA_HOME%\bin\java
echo please fix the JAVA_HOME environment variable
:haveJava
"%JAVA_HOME%\bin\java" -classpath "%ASPECTJ_HOME%\lib\aspectjtools.jar;%JAVA_HOME%\lib\tools.jar;%CLASSPATH%" -Xmx64M org.aspectj.tools.ajc.Main %1 %2 %3 %4 %5 %6 %7 %8 %9
