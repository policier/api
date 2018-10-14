node {
 def currentContext = 'minikube'
  stage('Checkout Source') {
    checkout scm
  }

  def azureUtil = load './jenkins/jenkinsUtils.groovy'

  stage('Build') {
    azureUtil.build(currentContext)
  }


   stage('Deploy') {
      // Deploy function app dd
          //bat("az aks list -g AKS-Kube-Test ")
          //az aks get-credentials --resource-group AKS-Kube-Test --name aks-kube-test
          //az aks list -g AKS-Kube-Test

           azureUtil.deployDataApp(currentContext, true)
   }
}