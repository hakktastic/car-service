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
            steps {
                container(name: 'maven') {
                    sh 'mvn -version'
                    sh 'mvn clean package'
                    sh 'ls -last'
                }
            }
        }
        stage('Build container image with Kaniko') {

            steps {
                container(name: 'kaniko', shell: '/busybox/sh') {
                    pom = readMavenPom(file: 'pom.xml')
                    def pom_version = pom.version
                    sh '''#!/busybox/sh
            echo "FROM jenkins/inbound-agent:latest" > Dockerfile
            /kaniko/executor --context `pwd` --destination hakktastic/car-service:${pom.version} --customPlatform=linux/arm64
          '''
                    sh 'ls -last'
                }
            }
        }
    }
}
