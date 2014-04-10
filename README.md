# ollo java exam #1 - Convert dollar and cents to cheque text

The goal of this exam is to implement a way to convert a dollars and cents amount to the text that would appear on a cheque.

This will require implementing an interface and passing the associated tests.  

## Instructions

1. Install the required tools
1. Clone this repository
1. Push the clone to your own public git hosting account (i.e. Bitbucket, Github etc)
1. Implement the requirements stated in this document on the develop branch
1. Pass all the tests
1. Merge the changes to the master branch
1. Send us a link to the repository

We will not accept any merge requests for this repository or any files outside of a Git repository.


## Requirements

A cheque is a payment order from a bank account.  The cheque contains the dollar and cents amount written out in text form as follows:

* $10.05 would be "Ten dollars and five cents."
* $0.00 would be "No dollars and no cents." 
* $1234.56 would be "One thousand two hundred and thirty four dollars and fifty six cents."

Your implementation should return these strings for any given input value (not just the ones listed above).

To keep things simple we will only accept dollar values between $0.00 and $10,000,000.00.  Any input outside of these values should throw the ChequeException.

## Installing required tools

We are using Maven 3 and Java 1.6+ for this project.  You will need to install these tools to complete this exam.

Installation instructions can be found here:

1. [Maven in 5 Minutes](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
1. [Java](http://www.java.com/en/download/manual.jsp)

Note you can install Java 7 or 8 if necessary without changing the pom.xml file.

## Implementation

You will be implementing your code in the MyCheque class.  Place your code in the inWords method.

Please do not change the Cheque interface.  All of your changes should be within the MyCheque class.

There is a MyChequeTest class that contains the tests for MyCheque.  Feel free to add your own tests where appropriate.

Note that we will be adding more tests after you have completed your implementation.

## Executing the tests

To execute the tests you will run:

```
$ mvn clean test
```

You will see in the output text BUILD SUCCESS if you have passed all the tests.
