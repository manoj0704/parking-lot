@echo Clean install of application
call mvn clean install
cd target
@echo running application
call java -jar parking-lot-1.0-SNAPSHOT-jar-with-dependencies.jar