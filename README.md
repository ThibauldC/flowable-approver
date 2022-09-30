# Flowable approver example application
## Run application

This application pulls in open tasks from the BPMN process exposed by the instance of the Flowable REST application and approves/rejects them.

Create jar:
```
mvn clean install
```

Run
```
java -jar flowable-approver-0.0.1-SNAPSHOT.jar --flowable.url=10.10.10.6 --flowable.assignee=snr
```


### Arguments

- flowable.url: Host of Flowable REST instance
- flowable.assignee: assignee for which you want to pull in open tasks
