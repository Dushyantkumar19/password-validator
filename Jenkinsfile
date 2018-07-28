pipeline {
        agent any
        stages {
            stage('Compile stage') {
                steps {
                    maven(maven : 'Maven_3.5.2'){
                        bat "mvn clean compile"
                }
            }
        }

             stage('testing stage') {
                 steps {
                    maven(maven : 'Maven_3.5.2'){
                        bat "mvn test"
                }
            }
        }

              stage('deployment stage') {
                  steps {
                    maven(maven : 'Maven_3.5.2'){
                        bat "mvn deploy"
                }
            }
        }

      }

    }
