pipeline {
  agent any
  triggers {
      cron('0 20 * * *')
  }
  stages {
    stage('Test') {
      when {
        branch 'main'
      }
      steps {
        echo 'Running API automation tests'

        slackSend(channel: 'jenkins-build-status', color: 'good', message: "The pipeline healthyuae-api-automation ${GIT_BRANCH} branch commit ${GIT_COMMIT} has started.", notifyCommitters: true, teamDomain: 'g42-healthcare', tokenCredentialId: 'slack-login', username: 'Jenkins')

        sh 'echo $JAVA_HOME'

        sh 'echo $MAVEN_HOME'

        withMaven(jdk: 'JDK 9.0.4', maven: 'maven 3.8.2') {
          sh 'mvn clean install test'
        }
      }
    }
  }

  post {
    always {
            echo 'Generating Allure Report'
            script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            report: 'target/allure-reports',
                            results: [[path: 'allure-results']]
                    ])
            }
         }
    success {
      slackSend channel: 'jenkins-build-status',
      tokenCredentialId: 'slack-login',
      teamDomain: 'g42-healthcare',
      username: 'Jenkins',
      color: 'good',
      message: "The nightly execution of healthyuae automated API test passed successfully. Please look at the allure report in jenkins for more details"
    }
    failure {
      slackSend channel: 'jenkins-build-status',
      tokenCredentialId: 'slack-login',
      teamDomain: 'g42-healthcare',
      username: 'Jenkins',
      color: 'danger',
      message: "The nightly execution of healthyuae automated API test cases failed. Please look at the allure report in jenkins for more details"
      mail to: 'rahul.srivastava@g42.ai',
                   subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                   body: "Something is wrong with ${env.BUILD_URL}"
    }
  }
}