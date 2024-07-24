pipeline {
    environment{
        dockerimagename = "Dockerfile"
        dockerImage = ""
    }
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHubCredential', url: 'https://github.com/AMOUZOUK/ProjetPipeline.git']])
            }
        }
         stage('Maven Build') {
            steps {
                 sh 'mvn clean install'
            }
        }
        stage('Maven Test') {
            steps {
                 sh 'mvn test'
            }
        }
        stage('Build docker Image') {
            steps {
                script{
                    echo "Docker Image"
                }
            }
        }
    }
}
