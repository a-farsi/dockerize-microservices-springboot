# microservices-springboot-springcloud

In this project we explain how to dockerize the developed microservices based on springboot.

In the previous project we developed three functional microservice: a first one for customer management, a second for book management, and a third for borrowing management.

In addition, we developed three technical microservices:

- A microservice for the automatic registration of microservice instances.
- A microservice for centralized configuration management of the microservices.
- A microservice acting as a gateway or proxy.

The following figure illustrates the overall architecture of our microservice application.

<p align="center">
<img src="figures/1.architecture_microservices.png" width=100%>
</p>
<p align="center">
Figure 1: Architecture of our application based-on microservices 
</p>

### Microservices Startup Order
We must follow a specific startup order for the microservices to ensure they are properly configured at launch and correctly registered with the discovery service.
Therefore, we start with the discovery-service, followed by the config-service.
The startup order of the following application microservices is not critical: customer-service, book-service, and borrowing-service.
Finally, we launch the gateway-service.

