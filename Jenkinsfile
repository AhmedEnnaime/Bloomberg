pipeline {
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
    }

}