pipeline {   
     agent any
     
    tools {   
     maven 'Maven3'   // Make sure Maven is configured in Jenkins  
   }
    stages {
	
        stage('Checkout Code') {   
         steps {             
                git branch: 'main', url: 'https://github.com/pujakohale/DataDrivenProject.git'           
               }   
                    }
        stage('Build') {    
            steps {              
                bat 'mvn clean compile'     
                     }     
                  }
        stage('Run Tests (Data Driven)') {    
            steps {          
                bat 'mvn test'       
                  }    
               }
        stage('Generate Reports') {  
             steps {          
            echo 'Generating reports...'         
         }    
           }   
        }
    post {    
    always {        
    junit '**/target/surefire-reports/*.xml'    
    }
        success {           
          echo 'Build Successful '   
               }
        failure {        
    echo 'Build Failed '     
   } 
    }
  }