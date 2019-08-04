@Library('JenkinsLibrary') _

agent('Build') {
    stage("checkout") {
        gitCheckout()
    }

    stage("Release") {
        android.gradle "assembleRelease"
    }

    stage('Upload') {
        withCredentials(
            [usernamePassword(credentialsId: 'example-token', 
                                passwordVariable: 'TOKEN',
                                usernameVariable: 'USER')]) {
            android.gradle "upload -Ptoken=$TOKEN"
        }
    }
}