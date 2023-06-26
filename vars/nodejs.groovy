def lintcheck() {
   sh '''
        echo starting lint checks
        echo lint checks completed
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