pipeline {
     agent {
          label 'master'
     }
      environment {
     
          DATABASE_URL = 'postgres://bsrpkeilwqtcve:65ab685b62b45fe5330d75dea53f5c8e26ac957fb5e0f678cadc3b9697a6b76b@ec2-107-23-135-132.compute-1.amazonaws.com:5432/d6gc1vhaafklo2'
          DB_DB = 'd6gc1vhaafklo2'
          DB_HOST = 'ec2-107-23-135-132.compute-1.amazonaws.com'
          DB_PASSWORD = '65ab685b62b45fe5330d75dea53f5c8e26ac957fb5e0f678cadc3b9697a6b76b'
          DB_PORT = '5432'
          DB_USERNAME = 'bsrpkeilwqtcve'
      }
     stages {
          stage('Source') {
               steps {
                    git branch: 'master',
                        url: 'https://github.com/Pachara2001/IceFactoryProjectAPI'
               }
          }
          stage('Build') {
               steps {
                    bat 'mvn package -DskipTests'
               }
          }
          stage('Test') {
               steps {
                    echo 'testing...'
                    //bat 'mvn test'
               }
          }
          stage('Deploy') {
               steps {
                    bat 'java -jar ./target/IceFactory-0.0.1-SNAPSHOT.jar'
               }
          }
     }
}
