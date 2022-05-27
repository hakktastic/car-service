def TAG_SELECTOR = "UNINTIALIZED"

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
                    sh 'mvn -version'
                    sh 'mvn clean package -DskipTests'
                    sh 'ls -last'

                    script {
                        TAG_SELECTOR = readMavenPom().getVersion()
                    }
                    echo("TAG_SELECTOR=${TAG_SELECTOR}")
                }
            }
        }
        stage('Build container image with Kaniko') {

            steps {

                container(name: 'kaniko', shell: '/busybox/sh') {

                    sh '''#!/busybox/sh
            /kaniko/executor --context `pwd` --destination hakktastic/car-service:${TAG_SELECTOR} --customPlatform=linux/arm64
          '''
                    sh 'ls -last'
                }
            }
        }
    }
}
