#!/usr/bin/groovy

def call(config) {
  echo 'Create ECR repo if it does not exist'
  sh "aws ecr create-repository --repository-name ${config.repo} || echo 'Repo already exists!'"
}
