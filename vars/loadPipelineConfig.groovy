def call(Map parameters = [:]) {
    try {
        configFile = 'resources/config/nonprod.yaml'
        Map config = readYaml file: configFile
        return config
    } catch (Exception e) {
        echo "WARNING: Could not load data from config file at ${configFile}. Exception: ${e.getMessage()}"
    }
    return ''
}
