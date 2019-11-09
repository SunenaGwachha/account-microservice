make-jar:
	mvn clean install
	@echo "DOne!"
    

dockerize:
	mvn com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/$$GOOGLE_CLOUD_PROJECT/product:v1
	gcloud container clusters get-credentials ea-cluster-1 --zone us-central1-a
	kubectl run product --image=gcr.io/$$GOOGLE_CLOUD_PROJECT/product:v1 --port=9090
	kubectl expose deployment product --type=LoadBalancer 

scale:
	kubectl scale deployment product --replicas=3 

connect-db:
	kubectl exec -it account-db-mysql -- mysql -uroot -proot 

make-all: make-jar dockerize scale