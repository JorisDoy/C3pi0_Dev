#!/bin/bash

cd $CATALINA_HOME/bin/

./shutdown.sh; ./startup.sh

cd $CATALINA_HOME/webapps/

rm -fr reverseB*

cd /root/reverseB/masterbuild

ant deploy

cd $CATALINA_HOME/bin/

./shutdown.sh; ./startup.sh

sleep 20

mv /usr/local/tomcat/webapps/reverseB/WEB-INF/classes/java/restapp.xml /usr/local/tomcat/webapps/reverseB/WEB-INF/classes

./shutdown.sh; ./startup.sh

tail -f $CATALINA_HOME/logs/catalina.out

tcpdump -Ai eth0 -s 0 port 8090
