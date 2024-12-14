#!/bin/bash

# create topic
awslocal sns create-topic --name notification-topic

#create queue
awslocal sqs create-queue --queue-name notification-queue

# subscribe queue to topic
awslocal --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:notification-topic --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:notification-queue
