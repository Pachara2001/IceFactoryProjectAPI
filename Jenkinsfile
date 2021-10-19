pipeline {
     agent {
          label 'master'
     }
      environment {
     
          DATABASE_URL = 'postgres://armbxehckruaxn:e5c4ab104fb70d1b2dbaaecaf93ddacd9da2d68aa499b91d9a3d5ebf6c09819a@ec2-52-205-45-219.compute-1.amazonaws.com:5432/dfg65d0u5tej0j'
          DB_DB = 'dfg65d0u5tej0j'
          DB_HOST = 'ec2-52-205-45-219.compute-1.amazonaws.com'
          DB_PASSWORD = 'e5c4ab104fb70d1b2dbaaecaf93ddacd9da2d68aa499b91d9a3d5ebf6c09819a'
          DB_PORT = '5432'
          DB_USERNAME = 'armbxehckruaxn'
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
