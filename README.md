This project is used to reinforce the material learned a wonderful [udemy](https://www.udemy.com/) course - 
Hibernate and Spring Data JPA: Beginner to Guru.

This project is intended to demonstrate the following:

1. Using PostgreSQL as the database
2. Using Liquibase as the database migration tool
3. Using H2 for testing
4. Having a test and prod profiles
5. A documented pdf file with step-by-step instructions (once done).


BRANCHES:
01_adding_profiles: 
* We add a test and prod profile and get Liquibase ready so the application can run. 
* We set up Liquibase to create the customer table as the initial sql file to execute
* The assumption we make is that our test profile will use H2 and the prod will be our PostgreSQL database.

02_adding_jpa_and_test_case (for H2)
* Add Entity class for customer (extends BaseEntity)
* Add H2 test case 

