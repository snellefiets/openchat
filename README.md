## SWAGGER

**Api Docs**
> http://localhost:8080/v2/api-docs

**Swagger**
> http://localhost:8080/swagger-ui/
    
## API

**Status**
*Request*
* GET /status/
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
* id > created user id
* message > in case status not 2xx

**User Login**
*Request*
* POST /user/login
Parameter:
* username
* password

*Response*
* 404 > not found
* 200 > ok

**Get Users**
*Request*
* GET /users

*Response*
* 200 > ok
Parameter:
* List
    * userId
    * username
    * about

**User Post**
*Request*
* POST /users/:userId/timeline
Parameter:
* text

*Response*
* 400 > inappropriate language
* 201 > created

Parameter
* postId > created id of post

*Inappropriate language*
Message contains inappropriate words
* FOUR
* ORANGE
* DUCK

**User Posts**
*Request*
* GET /users/:userId/timeline
* All posts by one user

*Response*
* 200 > ok

Parameter:
* List
    * postId
    * userId
    * text
    * dateTime

**User Wall**
*Request*
* GET /users/:userId/wall
* All posts on users wall (incl. followee posts)

*Response*
* 200 > ok

Parameter:
* List
    * postId
    * userId
    * text
    * dateTime

**Follow User**
*Request*
* POST /followings
Parameter
* followerId > userId
* followeeId > userId of followee

*Response*
* 201 > following created
* 400 > following already exists

**Get Followees**
*Request*
* GET /followings/:followerId/followees
* all followees of a user

*Response*
* 200 > ok
Parameter:
* List
    * userId
    * username
    * about


