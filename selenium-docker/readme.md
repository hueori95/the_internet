
use IntelliJ IDE to open project

use port 7080 to run server
run server: docker run -d -p 7080:5000 --platform linux/amd64 gprestes/the-internet

make sure installed maven
run test mvn clean package -DskipTests //compile source code, package into jar file
mvn clean install // run test and compile

Case1: You can run test by run xlm file in the folder src/test/resources/test-suites and righ-click to run xml file
Case2: enter "mvn test" to run all test by command line
Case3: mvn test -Dtest=YourTestClassName
Case4: compile code, packare into jar file and run by


View report at target/test-output


How to run test with selenium grid, set
<selenium.grid.enable>true</selenium.grid.enable>
docker-compose up
run testcase normally
