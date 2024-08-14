pipeline {
    agent any
    environment {
            SCANNER_SERVER = 'sonarqube' // Name of the SonarQube server configured in Jenkins
            SCANNER_HOME = tool 'Sonar-Scanner' // Name of the SonarQube Scanner configured in Jenkins
            PATH = "/usr/local/bin:$PATH"
    }
    stages {
        stage('git checkout') {
                steps {
                    git branch: 'main', changelog: false, poll: false, url: 'https://github.com/wajidali123/jenkins-pipeline-demo.git'
                }
        }
        stage('Build') {
            steps {
                // Build your project (e.g., Maven, Gradle, etc.)
                sh '/usr/local/bin/mvn clean install' // Replace with your build command
            }
        }

        stage('Sonar Analysis') {
                steps {
                    sh "${SCANNER_HOME}/bin/Sonar-Scanner -Dsonar.java.binaries=target/classes -Dsonar.host.url=http://172.22.75.224:9000/ -Dsonar.login=${SUNAR_QUBE_TOKEN} -Dsonar.projectName=to-do-app -Dsonar.projectKey=to-do-app -Dsonar.sources=."
                }
            }

        stage('Dependency-Checking') {
            steps {
                dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'dependency-check'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t wajidse102/todoapp:latest .'
                }
            }
        }
    }
}