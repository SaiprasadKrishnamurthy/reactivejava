## Reactive Java (With a few toy problems)


### Implemented using

* Java JDK 8 
* RX Java (From Netflix)


## Reactive Streams using Observables ##
 * I've tried to play around with reactive streams (using java rx) using a toy problem.
 
##The toy problem: Person Search.##
 *  We have a person database with their names, emails and countries.
 *  We have 2 person apis (1. Reactive 2, Non Reactive) 
 
This was quite useful to feel the benefits of reactive streams how this transpires to an efficient, responsive way of processing requests.

To run this code, client.Client is the main entry point.
 
## To run the client ##
 mvn clean install exec:java -Dexec.mainClass="client.Client"

## A Sample output ##   
```
########################################### Person search  #################################################


Enter the country names (part of) separated by commas (For example: ndia, ger, america)	:	dia

Enter how many records you want to retrieve max	:	100

Do you want the server to stream the results? (Y|N)	:	n

{ 'name': 'Patrick', 'email': 'lorem@dignissimmagnaa.edu', 'country': 'British Indian Ocean Territory' }
{ 'name': 'Kim', 'email': 'massa.Quisque.porttitor@iaculisnec.ca', 'country': 'British Indian Ocean Territory' }
{ 'name': 'Dakota', 'email': 'nibh.vulputate@mi.net', 'country': 'British Indian Ocean Territory' }
{ 'name': 'Rama', 'email': 'luctus.ut@Integervitae.ca', 'country': 'Cambodia' }
{ 'name': 'Yoko', 'email': 'ut@Fuscefermentum.org', 'country': 'British Indian Ocean Territory' }
{ 'name': 'Fleur', 'email': 'enim.Nunc.ut@lorem.net', 'country': 'Cambodia' }
{ 'name': 'Judah', 'email': 'tellus.eu@utodio.net', 'country': 'Cambodia' }
{ 'name': 'Brenna', 'email': 'nunc.nulla@auctorvitae.edu', 'country': 'Cambodia' }
{ 'name': 'Colin', 'email': 'congue@Suspendisse.com', 'country': 'British Indian Ocean Territory' }
{ 'name': 'Boris', 'email': 'consectetuer.adipiscing@nuncsitamet.edu', 'country': 'India' }
{ 'name': 'Hilda', 'email': 'ac@tellusidnunc.ca', 'country': 'India' }
{ 'name': 'Yardley', 'email': 'euismod.in.dolor@luctuslobortisClass.com', 'country': 'Cambodia' }

```
## Help
* https://www.youtube.com/watch?v=3bAQXTVsEiQ



