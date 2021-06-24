NOTE: This instruction is valid only until the application is deployed on server that is yet to be dermined.

How to run it:

1. To run the app you'll need:
   - MySQL server with MySQL Workbench
      https://dev.mysql.com/downloads/installer/
   - Node.js and NPM
      https://phoenixnap.com/kb/install-node-js-npm-on-windows
   - Apache Tomcat server
     http://tomcat.apache.org/
2. Download/clone repository.
3. Create new connection in MySQL
      https://www.inmotionhosting.com/support/website/connect-database-remotely-mysql-workbench/
4. Run create_script from installFiles folder in MySQL Workbench
5. Find application.properties in installFiles and fill missing data. Then, place the file 
   in src/main/resources.
6. Due to the fact, that the app is using free version of Amazon S3 storage, there is a limited number of keys to be generated.
To receive credentials, send me an email to: bartlipins@gmail.com.
   Once you receive it, copy them to AmazonConfig file in installFiles. Afterwards, copy that file to /src/main/java/com.lipskii.ski_jumping_system/config/
7. To run the API run SkiJumpingSystemApplication.java
8. To run a frontend go to src/frontend folder via terminal and type npm start command. 


