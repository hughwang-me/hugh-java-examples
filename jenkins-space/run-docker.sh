#https://github.com/jenkinsci/docker/blob/master/README.md
docker run --restart=always -d -v /root/jenkins_data_space:/var/jenkins_home -p 9090:8080 -p 9091:50000 jenkins/jenkins:lts

#chown -R 1000:1000 /root/jenkins_data_space
