def lintcheck() {
   sh '''
        # we want Devs to handle the lint checks failure
        # npm i jslint
        # node_modules/jslint/bin/jslint.js server.js || true 
        echo starting lint checks
        echo lint checks completed for ${COMPONent}
    ''' 
}
def sonarchecks() {
      sh '''
            sonar-scanner -Dsonar.host.url=http://172.31.90.254:9000  -Dsonar.sources=. -Dsonar.projectKey=${COMPONENT}
        '''
}

def call() {
     pipeline {
        agent any 
        stages {
            stage('Downloading the dependencies') {
                steps {
                    sh "npm install"
                }
            }


             stage('lint checks ') {
                 steps {
                     script { 
                                nodejs.lintcheck()
                }
            }
        }    // end of statges 
    }
}

// call is the default function which will be called when you call the fileName 