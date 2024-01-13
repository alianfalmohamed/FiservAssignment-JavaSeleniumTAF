pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from version control (e.g., Git)
                // You might need to configure your SCM credentials here
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Use Maven to build your Java project
                sh 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                // Execute your TestNG tests using Maven
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Archive test results for Jenkins to display
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
