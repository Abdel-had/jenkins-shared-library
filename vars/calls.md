# Voici comment appeler, dans les Jenkinsfiles, les fonctions partagées :

pushImage(REGISTRY_DOMAIN, COMPANY_NAME, IMAGE_NAME, IMAGE_TAG)

slackNotifier(currentBuild.result)
