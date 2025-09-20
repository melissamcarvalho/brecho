pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3.9.11"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/melissamcarvalho/brecho'


                // Run Maven on a Windows agent.
                bat "cd brecho/src/test/java && mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit 'brecho/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'brecho/target/*.jar'
                }
            }
        }
    }
}