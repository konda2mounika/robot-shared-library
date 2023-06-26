def lintcheck() {
   sh '''
        echo starting lint checks ${COMPONENT}
        #pylint *.py        # lint checks
        echo lint checks completed FOR  ${COMPONENT}
    ''' 
}

def call() {
     pipeline {
        agent any 
        stages {
             stage('lint checks ') {
                 steps {
                     script { 
                        lintcheck()
                }
            }
        }    // end of statges 
    }
}

// call is the default function which will be called when you call the fileName 