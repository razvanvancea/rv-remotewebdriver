pipeline {
    agent any
    stages {
        stage("Start grid") {
            steps {
                sh "docker-compose up"
            }
        }
        stage("Run test") {
            steps {
                sh "mvn clean test -Pparallel"
            }
        }
        stage('Stop Grid') {
            steps {
                sh "docker-compose down"
            }
        }
    }
}
