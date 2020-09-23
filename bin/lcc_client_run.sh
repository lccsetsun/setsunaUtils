#!/usr/bin/env bash

CURRENT_DIR=$(cd `dirname -- "$0"`; pwd)

cd $CURRENT_DIR

cmd=$1

if [[ -z "$cmd" ]];then
    echo "Invalid input params"
    Usage
    exit -1
fi

function start() {
    source ../conf/base_conf.sh

    SERVICE_LIB_PATH="$CURRENT_DIR/../lib"

    if [[ -z "$JAVA_HOME" ]];then
        JAVA_HOME=`which java`
    fi

    if [[ -z "$SERVICE_VERSION" ]];then
        echo "No valid service version specified in conf or env"
        exit -1
    fi

   nohup  $JAVA_HOME -jar ../lib/spoperate-${SERVICE_VERSION}.jar \
       --spring.config.location="../conf/application.properties" > ../logs/spoperate_service.log 2>&1&
    if [[ $? -eq 0 ]];then 
        echo "start operate service SUCCESS"
    else
        echo "start operate service FAILED!"
    fi
}

function stop() {
    pid=$(ps -ef | grep -v 'grep' | egrep spoperate | awk '{printf $2 " "}')
    if [ "$pid" != "" ];then
       echo "killed operate service process - $pid"
       kill -9 $pid
    else
        echo "boot is stopped"
    fi
    
}

function status()
{
    pid=$(ps -ef | grep -v 'grep' | egrep imagesearchservice| awk '{printf $2 " "}')
    #echo "$pid"
    if [ "$pid" != "" ];then
        echo "boot is running,pid is $pid"
    else
        echo "boot is stopped"
    fi
}

function Usage() {
    echo "Usage:\n\t./$0 <cmd(start|stop|restart|status)>"
}

if [ "$cmd" = "start" ];then
mkdir -p $CURRENT_DIR/../logs/
    start 
elif [ "$cmd" = "stop" ];then
    stop
elif [ "$cmd" = "restart" ];then
    stop
    start
elif [ "$cmd" = "status" ];then
    status
else
    echo "Invalid input cmd params: $cmd"
    Usage
    exit -1
fi

