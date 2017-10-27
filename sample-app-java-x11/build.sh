docker build -t x11 .
docker run -ti --rm -v $(pwd):/home/src -v $(pwd)/../comparison:/home/comparison -v /tmp/.X11-unix:/tmp/.X11-unix x11 bash