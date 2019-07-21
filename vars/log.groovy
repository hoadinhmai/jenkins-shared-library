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