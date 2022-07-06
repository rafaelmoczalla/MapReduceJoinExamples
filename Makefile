DOCKER_NETWORK = docker-hadoop_default
ENV_FILE = hadoop.env
version = 2.0.0-hadoop3.2.1-java8

submitRepartitionJoinJob:
	@if [ -f "./repartition-join/build/libs/HadoopJob-0.1.0.jar" ]; then cp "./repartition-join/build/libs/HadoopJob-0.1.0.jar" "./submit/"; fi
	docker build -t hadoop-job ./submit
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} hadoop-job

submitBroadcastJoinJob:
	@if [ -f "./broadcast-join/build/libs/HadoopJob-0.1.0.jar" ]; then cp "./broadcast-join/build/libs/HadoopJob-0.1.0.jar" "./submit/"; fi
	docker build -t hadoop-job ./submit
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} hadoop-job