## SWAGGER

**Api Docs**
> http://localhost:8080/v2/api-docs

**Swagger**
> http://localhost:8080/swagger-ui/
    
## API

**Status**

*Request*
* GET /status

*Response*
Status:
* 200 > Application is up and running
* 404 > Not running 

**User Registration**
*Request*
* POST /user/register

Parameter:
* username
* password
* about

*Response*
Status:
* 201 > user successfully created
* 400 > see message parameter (e.g. 'user already in use')
Parameter:
* userId > created user id
* message > in case status not 2xx

