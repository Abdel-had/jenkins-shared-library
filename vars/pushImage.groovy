#!/usr/bin/env groovy

def call(String registryDomain, String companyName, String imageName, String imageTag) {
    try {
        withCredentials([string(credentialsId: 'private_registry_pass', variable: 'DOCKER_PASSWORD')]) {
            sh """
                docker image tag ${imageName}:${imageTag} ${registryDomain}/${companyName}/${imageName}:${imageTag}
                docker login ${registryDomain} -u ${companyName} -p ${DOCKER_PASSWORD}
                docker push ${registryDomain}/${companyName}/${imageName}:${imageTag}
            """
        }
        echo "Successfully pushed image to Docker registry ${registryDomain}"
    } catch(Exception e) {
        echo "Failed to push image to Docker registry ${registryDomain}: ${e.getMessage()}"
        throw e
    }
}
