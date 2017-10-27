docker build -t xvfb .
docker run -ti --rm -v $(pwd):/home/src -v $(pwd)/../comparison:/home/comparison xvfb bash