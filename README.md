# 

## Model
www.msaez.io/#/487999/storming/civilapplication

## frontend
node -v : 18.17.0
npm -v : 9.9.4


```
cd front
npm install
npm run dev
```


## Before Running Services
### Make sure there is a Kafka server running
```
cd infra
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- UserManagement
- ApplicationProcessing
- documentandnotification


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- UserManagement
```
 http :8088/users userId="userId"UserCredential := '{"username": username, "password": password}'
```
- ApplicationProcessing
```
 http :8088/applications applicationId="applicationId"applicantId="applicantId"minwonType="minwonType"applicationReason="applicationReason"issuedNumber="issuedNumber"UserId := '{"userId": userId}'File := '{"fileName": fileName, "file": file}'
```
- documentandnotification
```
 http :8088/notifications notificationId="notificationId"applicationNumber="applicationNumber"sentDate="sentDate"ApplicationId := '{"applicationId": applicationId}'recipient="recipient"notificationMethod="notificationMethod"Status = "SENT"
 http :8088/resultDocuments documentId="documentId"applicationNumber="applicationNumber"recipient="recipient"Status = "ISSUED"
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
