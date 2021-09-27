pipeline {
  agent any
  stages {
    stage('Test') {
      when {
        branch 'main'
      }
      steps {
        echo 'Running API automation tests'
        
        slackSend(channel: 'jenkins-build-status', color: 'good', message: "The pipeline healthyuae-api-automation ${GIT_BRANCH} branch commit ${GIT_COMMIT} has started.", notifyCommitters: true, teamDomain: 'g42-healthcare', tokenCredentialId: 'slack-login', username: 'Jenkins')

        sh 'echo $JAVA_HOME'
        sh 'echo $M2_HOME'
        sh 'echo $PATH'
        sh 'mvn clean install test'
      }
    }
  }
  
  post {
    success {
      slackSend channel: 'jenkins-build-status',
      tokenCredentialId: 'slack-login',
      teamDomain: 'g42-healthcare',
      username: 'Jenkins',
      color: 'good',
      message: "The pipeline healthyuae-api-automation ${GIT_BRANCH} branch commit ${GIT_COMMIT} completed successfully."
    }
    failure {
      slackSend channel: 'jenkins-build-status',
      tokenCredentialId: 'slack-login',
      teamDomain: 'g42-healthcare',
      username: 'Jenkins',
      color: 'danger',
      message: "The pipeline healthyuae-api-automation ${GIT_BRANCH} branch commit ${GIT_COMMIT} failed."
    }
  }
}