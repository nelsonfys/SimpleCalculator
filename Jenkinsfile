pipeline {
    agent any
    // docker agent
    /*agent {
        docker {
            image '21-alpine3.23-jdk'
        }
    }*/

    stages {
        stage('Environment Check') {
            steps {
                bat 'java -version'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                //sh 'java -version'
            }
        }
        stage('Clean') {
            steps {
                bat 'gradlew clean'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh 'gradlew clean'
            }
        }
        stage('Build') {
            steps {
                bat 'gradlew build'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh 'gradlew build'
            }
        }
        stage('Test') {
            steps {
                bat 'gradlew test'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh 'gradlew test'
            }
        }
        stage('Checkstyle') {
            steps {
                bat 'gradlew checkstyleMain'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh 'gradlew checkstyleMain'
            }
        }
        stage('Shadow Jar') {
            when {
                branch 'main'
            }
            steps {
                bat 'gradlew shadowJar'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh 'gradlew shadowJar'
            }
        }
    }

    post {
        always {
            echo 'Build pipeline completed. Check if it was a success or if the build failed'
        }
        failure {
            echo 'Build failed. Please check the logs for details.'
        }
        success {
            echo 'Build succeeded. All tests passed and checkstyle checks are clear.'
        }
    }
}
