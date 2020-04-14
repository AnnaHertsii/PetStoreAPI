pipeline {
   agent none
  
   stages {
      stage('Run docker') {
         agent { label 'slave-docker' }
         steps {
            sh "sudo docker start e17503094443"
         }
      }
      stage('Run tests') {
         agent { label 'slave-maven' }
         tools {maven 'maven 3.6.3'}
         steps {
             script {
                git 'https://github.com/AnnaHertsii/PetStoreAPI.git'
                sh "mvn -f /home/ubuntu/workspace/Pipeline/Rest_Demo/pom.xml clean test"
            }
        }
      }
      stage('Stop docker') {
         agent { label 'slave-docker' }
         steps {
            sh "sudo docker stop e17503094443"
            }
       }
      stage('Allure reports') {
         agent { label 'slave-maven' }
         steps {
            allure includeProperties: false, jdk: '', results: [[path: 'Rest_Demo/target/allure-results']]
            }
       }
   }
}
