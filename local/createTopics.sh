#! /bin/bash

for topicName in $(cat kafka-topics.txt | sort | uniq);
do
  echo 'trying create topic: '$topicName;
  docker exec kafka-tools kafka-topics --create --topic "$topicName" --if-not-exists --zookeeper localhost:2181 --replication-factor 1 --partitions 1;
done
