pipeline {
   agent any

   tools {
       maven 'Maven3'
      
   }

   stages {
       stage('Checkout') {
           steps {
               git branch: 'main', url: 'https://github.com/pujakohale/DataDrivenProject.git'
           }
       }

       stage('Build') {
           steps {
               bat  'mvn clean compile'
           }
       }

       stage('Test') {
           steps {
                 bat 'mvn test'
           }
       }

       stage('Package') {
           steps {
                 bat 'mvn package'
           }
       }
   }

   post {
       always {
           junit '**/target/surefire-reports/*.xml'
           archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
       }
   }
}
