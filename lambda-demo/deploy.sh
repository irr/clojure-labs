#!/bin/bash
aws lambda delete-function --function-name clj-demo &>/dev/null
aws lambda create-function \
  --function-name clj-demo \
  --handler example.lambda.MyLambdaFn \
  --runtime java8 \
  --memory 512 \
  --timeout 60 \
  --role arn:aws:iam::940851196820:role/clj-demo \
  --zip-file fileb://./target/my-lambda-project.jar