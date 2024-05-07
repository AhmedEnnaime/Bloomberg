
# Bloomberg

Bloomberg is a technical assignment to manage FX deals

## API Reference

#### Send a deal

```http
  POST /api/deals
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Required**. id of the deal |
| `fromCurrencyIsoCode` | `string` | **Required**. From Ordering currency iso code |
| `toCurrencyIsoCode` | `string` | **Required**. To Ordering currency iso code |
| `dealAmount` | `double` | **Required**. Amount of the deal |


## Deployment

To deploy this project run, you can make use of the Makefile commands to facilitate test of the app.

First to test the application run

```bash
  make test
```

You can see the coverage of the app that was performed using Jacoco Plugin under the target folder inside site folder in an index.html file. The code coverage reached 100% for the service layer.

run the docker compose file to run the spring app, postgreSql database, grafana, and prometheus servers using

```bash
  make run
```

To shut down your containers run

```bash
  make down
```

You can run the jenkins server running the following commands:

```bash
  make run-dind
```

```bash
  make build-jenkins
```

```bash
  make run-jenkins
```

## Tech Stack

**Server:** Springboot, Jpa

**Unit Testing:** JUnit 5, Mockito

**Database:** PostgreSql

**Containerization:** Docker, Docker compose

**Pipeline CI/CD** Jenkins

**Monitoring** Prometheus, Grafana

## PORTS

Springboot App : 8084

PostgreSql Database: 5432

Jenkins: 8080

Grafana: 3000

Proemetheus: 9090

## Support

For support, email ahmedennaime20@gmail.com .

