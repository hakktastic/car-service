def TAG_SELECTOR = "UNINTIALIZED"
def ARTIFACT_ID = "UNINTIALIZED"

pipeline {
    agent {
        kubernetes {
            yaml """
        kind: Pod
        spec:
          containers:
          - name: kaniko
            image: gcr.io/kaniko-project/executor:debug
            imagePullPolicy: IfNotPresent
            command:
            - sleep
            args:
            - 9999999
            volumeMounts:
              - name: jenkins-docker-cfg
                mountPath: /kaniko/.docker
          - name: maven
            image: maven:3.8.5-openjdk-11-slim
            command:
            - cat
            tty: true
          volumes:
          - name: jenkins-docker-cfg
            projected:
              sources:
              - secret:
                  name: docker-credentials
                  items:
                    - key: .dockerconfigjson
                      path: config.json
        """
        }
    }
    stages {
        stage('Build and test with Maven') {

            steps {
                container(name: 'maven') {

                    sh 'mvn clean package -DskipTests'

                    script {
                        TAG_SELECTOR = readMavenPom().getVersion()
                        ARTIFACT_ID = readMavenPom().getArtifactId()
                        IMG_TAG = readMavenPom().getVersion()
                    }
                }
            }
        }
        stage('Build container image with Kaniko') {


            //environment {
              //  IMG_TAG = "${TAG_SELECTOR}"
            //}
            steps {

                echo("TAG_SELECTOR=${TAG_SELECTOR}")
                echo("ARTIFACT_ID=${ARTIFACT_ID}")
                echo("TEST=${IMG_TAG}")

                container(name: 'kaniko', shell: '/busybox/sh') {

                    sh '''#!/busybox/sh
                        /kaniko/executor --context `pwd` --destination hakktastic/car-service:${IMG_TAG} --customPlatform=linux/arm64
                    '''
                }
            }
        }
    }
}
