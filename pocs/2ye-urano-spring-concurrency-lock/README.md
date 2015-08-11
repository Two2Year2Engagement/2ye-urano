#Spring Boot with concurrency

-This repo is a study of a Concurrnecy where the READ  operation has to occur everytime, and when the WRITE operation start it lock the critical session.

##Requirements:

The read operation must be executed everytime.

The system shall be able to execute multiples read operations in the same time.

When the write operation is called, only this operation shall be executed, stopping every other operations that is trying to access the same memory space.

This project uses the following tech:

-Hazelcast for cache

-H2

-Hibernate


Projects base:
[All your base are belong to us]( http://ilkinbalkanay.blogspot.com.br/2008/01/readwritelock-example-in-java.html ) (08/2015)

Reference:

[Hazelcast]( http://hazelcast.org/getting-started/ )
