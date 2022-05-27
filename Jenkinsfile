pipeline {
    agent {
        kubernetes {
            yaml """
        kind: Pod
        spec:
          containers:
          - name: kaniko
            image: gcr.io/kaniko-project/executor:debug
            imagePullPolicy: Always
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

            environment {
                POM_VERSION = "latest"
            }

            steps {
                container(name: 'maven') {

                    withEnv(["POM_VERSION=0.0.1-SNAPSHOT"]) {}

                    sh 'mvn -version'
                    sh 'mvn clean package -DskipTests'
                    sh 'ls -last'
                }
            }
        }
        stage('Build container image with Kaniko') {

            steps {

                container(name: 'kaniko', shell: '/busybox/sh') {
                    sh '''#!/busybox/sh
            /kaniko/executor --context `pwd` --destination hakktastic/car-service:${env.POM_VERSION} --customPlatform=linux/arm64
          '''
                    sh 'ls -last'
                }
            }
        }
    }
}
