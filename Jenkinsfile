pipeline {
    environment {
        registry = "ahmedennaime/kingsleague_team-service"
        registryCredential = 'DOCKER_CRED'
        dockerImage = ''
    }
    agent any
    stages {
        stage("Clone project") {
            steps {
                git branch: 'master', url: 'https://github.com/AhmedEnnaime/Bloomberg.git'
            }
        }

        stage("Testing") {
            steps {
                 sh " mvn -f ./pom.xml test"
            }
        }

        stage("Publish code coverage") {
            steps {
                dir("./") {
                    jacoco(
                        execPattern: '**/*.exec',
                        sourcePattern: 'src/main/java/com/progress/bloomberg/services',
                        exclusionPattern: 'src/test*'
                    )
                }

            }
        }

        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }

}