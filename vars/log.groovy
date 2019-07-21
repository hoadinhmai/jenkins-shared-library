def call(String environment = 'nonprod') {
    echo "Hello, ${environment}!"
    sh 'echo "${environment}"'
}

def info(message) {
    echo "Info: ${message}"
}

def error(message) {
    echo "Error: ${message}"
}

def config(config) {
  sh "echo Region: ${config.region} ECR repo: ${config.repo}"
  sh "echo Project File: ${config.projectFile} Source Directory: ${config.sourceDir}"
}