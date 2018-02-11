@echo Clean install of application
call mvn clean install
cd target
if [%1]==[] goto withOutInput

call java -jar parking-lot-1.0-SNAPSHOT-jar-with-dependencies.jar %1
goto :eof

:withOutInput
@echo running application
call java -jar parking-lot-1.0-SNAPSHOT-jar-with-dependencies.jar