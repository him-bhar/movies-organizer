java -Dlogs.dir=C:\himanshu_work\temp -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044 -jar movies-organizer-web-1.0.0-SNAPSHOT.jar

# suspend=y (it will wait for debugger to attach before starting the actual app)
# suspend=n (it will *not* wait for debugger to attach before starting the actual app)