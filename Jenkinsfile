pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK17'
    }
    stages {
        stage('Checkout') {
            steps {
                   git branch: 'main', url: 'https://github.com/bkrajiv/pipe0.git'

           }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.build('myapp:latest')
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    bat 'docker rm -f myapp || exit /b 0'
                    bat 'docker run -d -p 8080:8080 --name myapp myapp:latest'
                }
            }
        }
    }
}
