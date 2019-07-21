#!/usr/bin/groovy

def call(String env) {
    sh '''
        aws cloudformation deploy \
            --stack-name cfn-stack-"${env}" \
            --template-file aws/lambda.yaml \
            --parameter-overrides $(cat cfn."${env}".params) \
            --capabilities CAPABILITY_NAMED_IAM \
            --no-fail-on-empty-changeset \
            --tags $(cat tags."${env}".params)
    '''
}