@Library('JenkinsLibrary') _

def config = log.config([
    projectFile     : 'example.xcodeproj',
    sourceDir       : 'exampleDir',
    testScheme      : 'exampleScheme',
    configuration   : 'Debug',
    archivePattern  : '**/*.framework.zip',
    verbose         : true,
    gemsToInstall   : [
        'danger-swiftlint',
        'danger-xcode_summary',
        'danger-jira',
    ],
    useDangerReports: true,
])

def preBuild = {
    sh 'sh bootstrap.sh'
}

log.config(config, preBuild)