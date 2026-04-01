# microservicios-common

`microservicios-common` is the shared library used by the Tikitakas backend. It contains the common abstractions that keep the microservice landscape consistent, especially around generic CRUD controllers, service contracts, and reusable persistence helpers. Instead of duplicating boilerplate in every domain service, this module centralizes the infrastructure that all the Football API services build on top of.

This repository is not intended to run as an independent HTTP application. Its main responsibility is to be compiled and installed as a Maven dependency so that the business microservices can inherit the same behavior and conventions. That is why this project participates in CI like the rest of the backend, but it is normally not deployed as a Docker container.

The project is built with Java 21, Spring Boot, Maven Wrapper, and the same coding conventions used in the rest of the platform. In CI, the module is compiled, tested, and installed into the local Maven cache so downstream services can resolve it during their builds.

Typical local usage:

```bash
./mvnw clean install
```

If you update public interfaces here, remember that several microservices depend on them. A change in `microservicios-common` usually implies rebuilding the domain services afterward. In short, this repository is the technical backbone of the backend and should stay small, stable, and intentionally generic.
