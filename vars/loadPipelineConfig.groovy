def call(Map parameters = [:]) {
    try {
        String data = libraryResource 'config/nonprod.yaml'
        Map config = readYaml text: data
        return config
    } catch (Exception e) {
        echo "Exception: ${e.getMessage()}"
    }
    return ''
}
