docker build -t fulano .
docker run -ti --rm -v /tmp/.X11-unix:/tmp/.X11-unix -v $(pwd):/home/ fulano firefox