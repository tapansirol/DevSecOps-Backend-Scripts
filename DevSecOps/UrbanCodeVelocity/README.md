# UrbanCode Velocity with docker-compose

## Prerequisite (Hardware minimum)
1. CPU 4 cores
2. RAM 8GB
3. Storage 8GB
4. Network: Velocity should be able to access UCD server. Jenkins should be able to send data to Velocity (RabbitMQ default port 5672)  

## Prerequisite
1. Make sure machine is up-to date

    ```sh
    sudo apt-get update        # Fetches the list of available updates
    sudo apt-get upgrade       # Strictly upgrades the current packages
    sudo apt-get dist-upgrade  # Installs updates (new ones)
    ```

2. Install Docker https://docs.docker.com/engine/installation/

    ```sh
    $ docker --version
    Docker version 17.09.0-ce, build afdb6d4  #preferred
    ```

3. Install docker-compose https://docs.docker.com/compose/install/#install-compose

    ```sh
    $ docker-compose --version
    docker-compose version 1.8.0  #preferred
    ```

## Running the project
1. Download the docker compose installer from the Releases tab for your version/OS to the server/VM where Velocity should be running.

2. Follow the prompts in the installer to set initial configuration values.

3. Run

    ```sh
    $ docker-compose up -d
    ```

## Uninstalling the release

NOTE: To Stop/Remove. (Remove if you have a new version of any of the images. Stoping or removing the container should not affect the data as long as your volume is persistent)

  ```sh
  $ docker-compose stop
  $ docker-compose rm
  ```
