FROM bde2020/hadoop-base:2.0.0-hadoop3.2.1-java8

COPY HadoopJob-0.1.0.jar /opt/hadoop/applications/HadoopJob-0.1.0.jar
COPY s1 /opt/hadoop/s1
COPY s2 /opt/hadoop/s2

ENV JAR_FILEPATH="/opt/hadoop/applications/HadoopJob-0.1.0.jar"
ENV CLASS_TO_RUN="HadoopDriver"
ENV PARAMS="/tmp/s1 /tmp/s2 /tmp/output"

ADD run.sh /run.sh
RUN chmod a+x /run.sh

CMD ["/run.sh"]
