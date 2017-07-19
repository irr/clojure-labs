#!/bin/bash
tf=`mktemp`; aws lambda invoke --function-name clj-demo --invocation-type RequestResponse --payload '{"test":true}' $tf &> /dev/null && cat $tf; rm -rf $tf;echo