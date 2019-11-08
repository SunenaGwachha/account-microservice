make-jar:
	mvn clean install
	@echo "DOne!"
    

dockerize:
	mvn com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/$$GOOGLE_CLOUD_PROJECT/docker-name11:v1
	gcloud container clusters get-credentials standard-cluster-1 --zone us-central1-a
	kubectl run docker-name11 --image=gcr.io/$$GOOGLE_CLOUD_PROJECT/docker-name11:v1 --port=9090
	kubectl expose deployment docker-name11 --type=LoadBalancer 

scale:
	kubectl scale deployment docker-name11 --replicas=3 

connect-db:
	kubectl exec -it some-mysql -- mysql -uroot -pexample-password 

make-all: make-jar dockerize scale