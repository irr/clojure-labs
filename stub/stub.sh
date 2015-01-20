#!/bin/sh
# sample: 
# cat stub.sh helloworld.jar > hello.run && chmod +x helloworld.run
MYSELF=`which "$0" 2>/dev/null`
[ $? -gt 0 -a -f "$0" ] && MYSELF="./$0"
java=java
if test -n "$JAVA_HOME"; then
    java="$JAVA_HOME/bin/java"
fi
exec "$java" $JAVA_ARGS -jar $MYSELF "$@"
exit 1
