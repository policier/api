def build(String currentContext){
    if(currentContext=='minikube') {
        bat """
                SET DOCKER_TLS_VERIFY=1
                SET DOCKER_HOST=tcp://192.168.99.100:2376
                SET DOCKER_CERT_PATH=C:\\Users\\mougoueo\\.minikube\\certs
                SET DOCKER_API_VERSION=1.35
                
                cd productservice && mvn install docker:build
                
                
                cd discountservice && mvn install docker:build && cd ..
            """

        bat """
                SET DOCKER_TLS_VERIFY=1
                SET DOCKER_HOST=tcp://192.168.99.100:2376
                SET DOCKER_CERT_PATH=C:\\Users\\mougoueo\\.minikube\\certs
                SET DOCKER_API_VERSION=1.35
                
                cd discountservice && mvn install docker:build && cd ..
            """
    }

}


def deployDataApp(String currentContext,  boolean isHelm) {
    this.config = [:]
    def currentContexts = currentContext
    bat """
                
              kubectl config get-contexts 
    
              kubectl config use-context  aks-kube-test-admin
    
              kubectl get nodes     
       """
     if (isHelm) {


         bat """
                                  
                 helm ls
                 
                 helm del --purge demo-release
                 
                 helm install api-dyt --name demo-release --namespace api
         """

     } else {
         bat """
              
              kubectl create -f deployment.yaml

              kubectl create -f deployment1.yaml

         """
     }
}

return this