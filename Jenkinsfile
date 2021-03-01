pipeline {
    agent any
    parameters {

        string(name: 'IMAGE_NAME', defaultValue:'java-calculator', description:'Name of the Image')

        string(name: 'JAR_NAME', defaultValue:'calculadora', description:'Name of the .jar file')

        //string(name: 'CONTAINER_NAME', defaultValue: 'java-mvn', description:'Docker Container Name')

        //string(name: 'DOCKER_PORT', defaultValue: '3000', description:'Docker Container Host Port')
    }
        
    stages{
        

        //stage("build & SonarQube analysis") {
            //steps {
              //withSonarQubeEnv('sonarqube') {
                //sh 'mvn clean package sonar:sonar -Dsonar.host.url=http://sonarqube:9000'
            //}
        //}
        //}

        stage("Build Jar"){
            steps{
                sh 'javac *.java'
                sh 'jar cfe "$JAR_NAME".jar exercicio6.class *.class'

            }
        }

        stage("store artifact on Nexus") {
            steps{
                //archiveArtifacts artifacts: '/var/jenkins_home/workspace/java-calculator-nexus/"$JAR_NAME".jar'
                sh 'curl -v -u admin:admin --upload-file /var/jenkins_home/workspace/java-calculator-nexus/"$JAR_NAME".jar http://nexus:8081/repository/my-raw/'
            }
        }


        stage('Create Docker Image') {
            steps {
                sh 'docker build -t "$IMAGE_NAME":v1.0 .'
            }
        }

        stage('Push Image to Nexus') {
            steps {
                sh 'docker login -u admin -p admin localhost:8082'
                sh 'docker tag "$IMAGE_NAME":v1.0 localhost:8082/"$IMAGE_NAME":v1.0'
                sh 'docker push localhost:8082/"$IMAGE_NAME":v1.0'

            }
        }
        
                stage('Clear WorkSpace') {
            steps {
                cleanWs()
            }
        }
    } 
}