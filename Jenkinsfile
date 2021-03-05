pipeline {
    agent any
    parameters {

        string(name: 'IMAGE_NAME', defaultValue:'java-calculator', description:'Name of the Image')

        string(name: 'JAR_NAME', defaultValue:'calculadora', description:'Name of the .jar file')

        string(name: 'BUILD_NUMBER', defaultValue: "1.0", description: 'Build Number')

        //string(name: 'CONTAINER_NAME', defaultValue: 'java-mvn', description:'Docker Container Name')

        //string(name: 'DOCKER_PORT', defaultValue: '3000', description:'Docker Container Host Port')
    }
        
    stages{

        stage("Build Jar"){
            steps{
                sh 'javac *.java'
                sh 'jar cfe "$JAR_NAME".jar Calculator *.class'

        }
    }   

        stage("SonarQube analysis") {

            steps {
        script {
            sonarScanner('category-service')
        }
    }
}      

        stage("store artifact on Nexus") {
            steps{
                withCredentials([usernameColonPassword(credentialsId: 'curl-jenkinsfile-uploadArt-nexus', variable: 'USERPASS')]) {
                sh 'curl -v -u "$USERPASS" --upload-file /var/jenkins_home/workspace/java-calculator-nexus/"$JAR_NAME".jar http://nexus:8081/repository/my-raw/'
            }
        }
    }

        stage('Create Docker Image') {
            steps {
                sh 'docker build -t "$IMAGE_NAME":v1.0 .'
            }
        }

        stage('Push Image to Nexus') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-login-nexus', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                sh 'docker login -u "$USERNAME" -p "$PASSWORD" localhost:8082'
                sh 'docker tag "$IMAGE_NAME":v1.0 localhost:8082/"$IMAGE_NAME":v1.0'
                sh 'docker push localhost:8082/"$IMAGE_NAME":v1.0'

            }
        }
    }
                stage('Clear WorkSpace') {
            steps {
                cleanWs()
            }
        }
    } 
}



        def sonarScanner(projectKey) {
        def scannerHome = tool 'sonarqube-scanner'
          withSonarQubeEnv("sonarqube") {
              if(fileExists("sonar-project.properties")) {
                  sh "${scannerHome}/bin/sonar-scanner"
        }
              else {
                withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR')]){
                  sh "${scannerHome}/bin/sonar-scanner -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=$SONAR -Dsonar.projectKey=java-calculator -Dsonar.java.binaries=/var/jenkins_home/workspace/java-calculator-nexus -Dsonar.java.libraries=**/*.jar -Dsonar.projectVersion=${BUILD_NUMBER}"
        }
    }
}
   // timeout(time: 10, unit: 'MINUTES') {
     //   waitForQualityGate abortPipeline: true
    //}
}
