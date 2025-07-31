# 1. Package the function
mvn package

# 2. Deploy to GCP Cloud Functions
gcloud functions deploy hello-function \
  --entry-point com.example.cloudfunction.HelloFunction \
  --runtime java17 \
  --trigger-http \
  --allow-unauthenticated \
  --memory 512MB \
  --source target/gcp-cloud-functions-api-gateway-1.0-SNAPSHOT-shaded.jar

# 3. Deploy API Gateway using openapi.yaml
gcloud api-gateway api-configs create hello-config \
  --api=hello-api \
  --openapi-spec=openapi.yaml \
  --project=YOUR_PROJECT_ID \
  --backend-auth-service-account=YOUR_SERVICE_ACCOUNT

gcloud api-gateway gateways create hello-gateway \
  --api=hello-api \
  --api-config=hello-config \
  --location=REGION