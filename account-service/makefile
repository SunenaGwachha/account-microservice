make-jar:
	mvn clean install
	@echo "DOne!"
    

dockerize:
	mvn com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/$$GOOGLE_CLOUD_PROJECT/accounts:v1
	gcloud container clusters get-credentials ea-cluster-1 --zone us-central1-a
	kubectl run accounts --image=gcr.io/$$GOOGLE_CLOUD_PROJECT/accounts:v1 --port=9090
	kubectl expose deployment accounts --type=LoadBalancer 

scale:
	kubectl scale deployment accounts --replicas=3 

connect-db:
	kubectl exec -it some-mysql -- mysql -uroot -pexample-password 

make-all: make-jar dockerize scale
