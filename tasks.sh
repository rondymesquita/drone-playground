#!/bin/bash
clear

help(){
    RED=`tput setaf 1`
    GREEN=`tput setaf 2`
    YELLOW=`tput setaf 3`
    WHITE=`tput setaf 7`
    echo "Help"
    echo "${GREEN}init:       ${YELLOW}Remove old data and configure environment. (Execute this will remove all existing drone and gogs data)"
    echo "${GREEN}up:         ${YELLOW}Start services"
    echo "${GREEN}down:       ${YELLOW}Stop services"
    echo "${GREEN}inspect:    ${YELLOW}Show IPAddress and port from services"
    echo "${WHITE}"
}

init(){
  echo "*** Configuring services"
  down
  _cleanup
  _init
}

up(){
  echo "*** Setting up services"
  docker-compose build
  docker-compose up
}

down(){
  echo "*** Shutting down services"
  docker-compose down
}

inspect(){
  echo "*** Information"
  _inspect_container "drone-server" "8000"
  _inspect_container "gogs" "3000"
  _inspect_container "postgresql" "5432"
  _inspect_container "portainer" "9000"
}

#
# Private functions
#
_cleanup(){
  echo "*** Cleaning up old data"
  sudo rm -rf /var/drone
  sudo rm -rf /var/gogs

  docker rm -f drone-server drone-agent gogs postgresql portainer
}

_init(){
  echo "*** Initializing new data"
  sudo mkdir -p /var/drone
  sudo mkdir -p /var/gogs/gogs/conf
  sudo cp ./app.ini /var/gogs/gogs/conf/
}

_inspect_container(){
  address="$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $1)"
  port="$(docker port $1)"

  echo "Container:      $1"
  echo "Address:        $address:$2"
  echo
}

_ask_for_confirmation(){
  read -p "Continue (y/n)?" CHOICE
  case "$CHOICE" in
    y|Y ) OPTION=1;;
    n|N ) OPTION=0;;
    * ) echo "Invalid option!";;
  esac

  return $OPTION
}

# Execute the tasks
for TASK in "$@"
do
 $TASK
done

# If nothing, run default
if [ "$1" = "" ]; then
  help
fi
