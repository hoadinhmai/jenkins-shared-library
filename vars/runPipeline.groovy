def call(String environment = 'nonprod') {
    @Library('JenkinsLibrary@develop') _

    def appConfig = [
        projectFile     : 'example.xcodeproj',
        sourceDir       : 'exampleDir'
    ]

    pipeline {
        agent any
        
        environment{
            ENV = 'dev'
            environment = 'HOA'
            REPO_NAME = 'hdm-common-repo'
        }

        stages {
            stage("Deploy") {
                steps{
                    script{
                        log.info "${env.ENV}"
                        log.error 'World'
                        log "${env.ENV}"
                        log()
                        log.config([region: AWS_DEFAULT_REGION, repo: "$REPO_NAME"])
                        log.config(appConfig)
                    }
                }
            }
        }
    }

}