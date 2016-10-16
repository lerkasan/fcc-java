#!/bin/bash
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections
echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections
sudo apt-get -qq -y --force-yes install oracle-java8-set-default

echo 'JAVA_HOME="/usr/lib/jvm/java-8-oracle"' >> /etc/environment
source /etc/environment

sudo apt-get -qq -y --force-yes install \
mc \
git \
maven \
postgresql

echo 'M2_HOME="/usr/share/maven"' >> /etc/environment
source /etc/environment

curl -sL https://deb.nodesource.com/setup | sudo bash -
sudo apt-get -qq -y --force-yes install \
nodejs \
build-essential

sudo npm install gulp -g
sudo npm install bower -g

#sudo service postgresql start

sudo echo '<?xml version="1.0" encoding="UTF-8"?>
  <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <pluginGroups>
    <pluginGroup>org.eclipse.jetty</pluginGroup>
  </pluginGroups>
</settings>' > /usr/share/maven/conf/settings.xml

#sudo -u postgres psql < ~/brdo/create_db.sql
sudo -u postgres psql < /home/vagrant/brdo/vagrant/create_db.sql

echo "*********** INSTALLATION FINISHED ***********."
